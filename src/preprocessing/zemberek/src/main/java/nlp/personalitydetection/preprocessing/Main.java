package nlp.personalitydetection.preprocessing;

import nlp.personalitydetection.preprocessing.fileoperations.FilePath;
import nlp.personalitydetection.preprocessing.fileoperations.csv.CsvReader;
import nlp.personalitydetection.preprocessing.fileoperations.csv.CsvWriter;
import nlp.personalitydetection.preprocessing.model.Dataset;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvReader reader = new CsvReader();

        Dataset dataset = reader.readFile(FilePath.ELIMINATED_DATASET_PATH, ";");
        System.out.println("Total rows in the dataset: " + dataset.getRows().size());

        Zemberek zemberek = new Zemberek();
        zemberek.preprocess(dataset);


        CsvWriter writer = new CsvWriter();

        writer.write(FilePath.PREPROCESSED_DATASET_OUTPUT_PATH, dataset);
    }

}

