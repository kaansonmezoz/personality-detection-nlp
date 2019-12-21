package nlp.personalitydetection.preprocessing.fileoperations.csv;

import nlp.personalitydetection.preprocessing.model.Dataset;
import nlp.personalitydetection.preprocessing.model.DatasetRow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

    public Dataset readFile(String filePath, String separator) {
        Dataset dataset = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String stringRow = reader.readLine();

            List<String> columnNames = extractColumnNames(stringRow, separator);
            List<DatasetRow> rows = new ArrayList<DatasetRow>();

            while ((stringRow = reader.readLine()) != null) {
                rows.add(extractRow(stringRow, separator));
            }

            reader.close();

            dataset = new Dataset(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }


    private List<String> extractColumnNames(String firstLine, String seperator){
        return Arrays.asList(firstLine.split(seperator));
    }

    private DatasetRow extractRow(String row, String separator){
        DatasetRow datasetRow = new DatasetRow();
        String[] data = row.split(separator);

        datasetRow.setUser(data[0]);
        datasetRow.setEntry(data[1]);
        datasetRow.setType(data[2]);
        datasetRow.setTypeClass(data[3]);
        datasetRow.setIEStatus(data[4]);
        datasetRow.setSNStatus(data[5]);
        datasetRow.setTFStatus(data[6]);
        datasetRow.setJPStatus(data[7]);

        return datasetRow;
    }
}
