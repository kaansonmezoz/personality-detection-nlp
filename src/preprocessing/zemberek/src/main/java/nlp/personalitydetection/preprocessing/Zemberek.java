package nlp.personalitydetection.preprocessing;

import nlp.personalitydetection.preprocessing.fileoperations.FilePath;
import nlp.personalitydetection.preprocessing.fileoperations.text.TextReader;
import nlp.personalitydetection.preprocessing.model.Dataset;
import nlp.personalitydetection.preprocessing.model.DatasetRow;
import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.lexicon.RootLexicon;
import zemberek.normalization.TurkishSentenceNormalizer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Zemberek {
    private final TurkishMorphology morphology;
    private final TurkishSentenceNormalizer normalizer;
    private List<String> stopWords;
    private List<String> stopWordLemmas;

    public Zemberek() throws IOException {
        this.morphology = TurkishMorphology.builder()
                .setLexicon(RootLexicon.getDefault())
                .useInformalAnalysis()
                .build();

        this.normalizer = initializeNormalizer();
        this.stopWords = readStopWords();
        this.stopWordLemmas = createStopWordLemmas();
    }

    private TurkishSentenceNormalizer initializeNormalizer() throws IOException {
        Path lookupRoot = Paths.get(FilePath.NORMALIZATION_LOOK_UP_PATH);
        Path lmFile = Paths.get(FilePath.LM_FILE_PATH);

        return new TurkishSentenceNormalizer(morphology, lookupRoot, lmFile);
    }


    public void preprocess(Dataset dataset) {
        //TODO: SpellChecker kullabilabilir...
        //TODO: Spell check olayı vardı ona en yakın olanı veriyordu falan mesela öyle bir şey yapmaya gerek var mı ?
        //TODO: Mantıken normalization dediğimiz şeyin olayı o zaten ...
        //TODO: vurucam kırbacı bu normalize edilemedi mesela spell check ile denensenydi nasıl bir sonuc verirdi ona da bakmak lazim

        System.out.println("Preprocessing started !\n");

        List<DatasetRow> rows = dataset.getRows();

        int entryCount = 1;
        for(ListIterator<DatasetRow> iterator = rows.listIterator(); iterator.hasNext(); ) {
            System.out.println(String.format("Entry count: %d    Total entries: %d", entryCount, rows.size()));

            DatasetRow row = iterator.next();

            String entry = extractEntry(row);

            entry = removeUrls(entry);
            entry = removePunctuations(entry);
            entry = removeExtraWhiteSpaces(entry);
            entry = removeStopWords(entry);
            entry = removeStopWordsLemma(entry);
            entry = removeDigits(entry);
            entry = removeExtraWhiteSpaces(entry);

            if(isValidEntry(entry)) {
                entry = normalizeEntry(entry);
                entry = lemmatizeEntry(entry);

                entry = removeStopWords(entry);
                entry = removeStopWordsLemma(entry);
                entry = removeExtraWhiteSpaces(entry);

                if(isValidEntry(entry)) {
                    row.setEntry(entry);
                }
                else {
                    System.out.println("Entry is not valid ! Entry Count: " + entryCount);
                    iterator.remove();
                }
            }
            else {
                System.out.println("Entry is not valid ! Entry Count: " + entryCount);
                iterator.remove();
            }

            entryCount++;
        }
    }


    private String normalizeEntry(String entry) {
        return normalizer.normalize(entry);
    }

    private String removeExtraWhiteSpaces(String entry) {
        return entry.replaceAll("\\s+", " ");
    }


    private String lemmatizeEntry(String entry) {
        if(entry == null || entry.equals("")){
            return entry;
        }

        StringBuilder lemmatizedEntry = new StringBuilder();
        List<SingleAnalysis> analyses = morphology.analyzeAndDisambiguate(entry).bestAnalysis();

        for (SingleAnalysis analysis : analyses) {
            lemmatizedEntry.append(analysis.getLemmas().get(0)).append(" ");
        }

        return lemmatizedEntry.toString().trim();
    }

    private String removeStopWords(String entry) {
        for (String stopWord : stopWords) {
            entry = entry.replaceAll(String.format("\\b%s\\b", stopWord), "");
        }

        return entry;
    }

    private String removeStopWordsLemma(String entry){
        for (String stopWordLemma : stopWordLemmas) {
            entry = entry.replaceAll(String.format("\\b%s\\b", stopWordLemma), "");
        }

        return entry;
    }

    private List<String> createStopWordLemmas(){
        List<String> stopWordLemmas = new ArrayList<>();

        for(String stopWord: stopWords){
            List<SingleAnalysis> analyses = morphology.analyzeAndDisambiguate(stopWord).bestAnalysis();

            for (SingleAnalysis analysis : analyses) {
                stopWordLemmas.addAll(analysis.getLemmas());
            }
        }

        return stopWordLemmas;
    }

    private List<String> readStopWords() throws IOException {
        TextReader reader = new TextReader();
        return reader.readFile(FilePath.STOP_WORDS_PATH);
    }

    private String removePunctuations(String entry) {
        return entry.replaceAll("\\p{P}", " ");
    }

    private String removeDigits(String entry) {
        return entry.replaceAll("\\d", "");
    }

    private String extractEntry(DatasetRow row){
        return row.getEntry().toLowerCase();
    }

    private boolean isValidEntry(String entry){
        return entry != null && !entry.equals("") && !entry.equals(" ");
    }

    private String removeUrls(String entry){
        return entry.replaceAll("http\\s*", " ").replaceAll("www\\s*", " ");
    }
}
