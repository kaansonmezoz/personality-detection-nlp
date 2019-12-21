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

        List<DatasetRow> rows = dataset.getRows();
        int iterationCount = 0;

        for (DatasetRow row : rows) {
            iterationCount++;

            String entry = row.getEntry();

            entry = entry.toLowerCase();

            entry = removeDigits(entry);
            entry = removePunctuations(entry);
            entry = removeExtraWhiteSpaces(entry);

            entry = normalizeEntry(entry);
            entry = removeStopWords(entry);
            entry = lemmatizeEntry(entry);
            entry = removeExtraWhiteSpaces(entry);

            row.setEntry(entry);

            System.out.println(String.format("Entry count: %d    Total entries: %d", iterationCount, rows.size()));
        }
    }


    private String normalizeEntry(String entry) {
        return normalizer.normalize(entry);
    }

    private String removeExtraWhiteSpaces(String entry) {
        return entry.replaceAll("\\s+", " ");
    }


    private String lemmatizeEntry(String entry) {
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
            entry = entry.replaceAll(stopWord, "");
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
