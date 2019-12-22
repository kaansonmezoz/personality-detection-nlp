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
import java.util.Iterator;
import java.util.List;

public class Zemberek {
    private final TurkishMorphology morphology;
    private final TurkishSentenceNormalizer normalizer;
    private List<String> stopWords;

    public Zemberek() throws IOException {
        this.morphology = TurkishMorphology.builder()
                .setLexicon(RootLexicon.getDefault())
                .useInformalAnalysis()
                .build();

        this.normalizer = initializeNormalizer();
        this.stopWords = readStopWords();
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
        for(Iterator<DatasetRow> iterator = rows.iterator(); iterator.hasNext(); ) {
            System.out.println(String.format("Entry count: %d    Total entries: %d", entryCount, rows.size()));

            DatasetRow row = iterator.next();

            String entry = row.getEntry();

            entry = entry.toLowerCase();

            entry = removePunctuations(entry);
            entry = removeExtraWhiteSpaces(entry);
            entry = removeStopWords(entry);
            entry = removePunctuations(entry);
            entry = removeDigits(entry);
            entry = removeExtraWhiteSpaces(entry);

            if(entry != null && !entry.equals("") && !entry.equals(" ")) {
                entry = normalizeEntry(entry);
                entry = lemmatizeEntry(entry);
                row.setEntry(entry);
            }
            else {
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
            for (String lemma : analysis.getLemmas()) {
                lemmatizedEntry.append(" ").append(lemma);
            }
        }

        return lemmatizedEntry.toString().trim();
    }

    private String removeStopWords(String entry) {
        for (String stopWord : stopWords) {
            entry = entry.replaceAll(String.format("\\b%s\\b", stopWord), "");
        }

        return entry;
    }

    private List<String> readStopWords() throws IOException {
        TextReader reader = new TextReader();
        return reader.readFile(FilePath.STOP_WORDS_PATH);
    }

    private String removePunctuations(String entry) {
        return entry.replaceAll("\\p{Punct}", " ");
    }

    private String removeDigits(String entry) {
        return entry.replaceAll("\\d", "");
    }
}
