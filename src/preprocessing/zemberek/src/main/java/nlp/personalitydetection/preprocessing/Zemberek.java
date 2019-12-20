package nlp.personalitydetection.preprocessing;

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

    public Zemberek() throws IOException {
        this.morphology = TurkishMorphology.builder()
        .setLexicon(RootLexicon.getDefault())
        .useInformalAnalysis()
        .build();

        this.normalizer = initializeNormalizer();
    }

    private TurkishSentenceNormalizer initializeNormalizer() throws IOException {
        Path lookupRoot = Paths.get("/home/khan/Workspace/personality-detection-nlp/src/preprocessing/dependencies/normalization");
        Path lmFile = Paths.get("/home/khan/Workspace/personality-detection-nlp/src/preprocessing/dependencies/lm/lm.2gram.slm");

        return new TurkishSentenceNormalizer(morphology, lookupRoot, lmFile);
    }


    public void preprocess(Dataset dataset){
        normalizeDataset(dataset);

        //TODO: SpellChecker kullabilabilir...

        //TODO: Spell check olayı vardı ona en yakın olanı veriyordu falan mesela öyle bir şey yapmaya gerek var mı ?
        //TODO: Mantıken normalization dediğimiz şeyin olayı o zaten ...
        //TODO: vurucam kırbacı bu normalize edilemedi mesela spell check ile denensenydi nasıl bir sonuc verirdi ona da bakmak lazim
        //TODO: ayrıca Informal Turkish Words Analysis var onu da yapmak lazım lemmatization yaparken yani tek basına normalizasyon iyi bir sonuc vermeyebilir.
        //TODO: Informal Turkish Words Analysis olmali kesinlikle

        lemmatizeDataset(dataset);

    }

    private void normalizeDataset(Dataset dataset){
        for (DatasetRow row : dataset.getRows()) {
            String entry = row.getEntry();
            row.setEntry(normalizeEntry(entry));
        }
    }

    private String normalizeEntry(String entry){
        entry = removeExtraWhiteSpaces(entry);
        return normalizer.normalize(entry);
    }

    private String removeExtraWhiteSpaces(String entry){
        return entry.replaceAll("\\s+", " ");
    }

    private void lemmatizeDataset(Dataset dataset){
        for (DatasetRow row : dataset.getRows()) {
            String entry = row.getEntry();
            row.setEntry(lemmatizeEntry(entry));
        }
    }

    private String lemmatizeEntry(String entry){
        String lemmatizedEntry = "";
        List<SingleAnalysis> analyses =  morphology.analyzeAndDisambiguate(entry).bestAnalysis();

        for (SingleAnalysis analysis : analyses) {
            for (String lemma : analysis.getLemmas()) {
                lemmatizedEntry += " " + lemma;
            }
        }

        return lemmatizedEntry.trim();
    }
}
