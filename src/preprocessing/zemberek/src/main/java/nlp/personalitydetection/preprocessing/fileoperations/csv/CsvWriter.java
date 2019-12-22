package nlp.personalitydetection.preprocessing.fileoperations.csv;

import nlp.personalitydetection.preprocessing.model.Dataset;
import nlp.personalitydetection.preprocessing.model.DatasetRow;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public void write(String filePath, Dataset dataset) throws IOException {
        FileWriter csvWriter = new FileWriter(filePath);

        String row = createColumnNamesRowString(dataset.getColumnNames());
        csvWriter.write(row);

        System.out.println("Preprocessed dataset has being written to a file !");

        for(DatasetRow datasetRow : dataset.getRows()){
            row = createDataRowString(datasetRow);
            csvWriter.append(row);
        }

        System.out.println(dataset.getRows().size() + " entries have been written to a file !");

        csvWriter.flush();
        csvWriter.close();
    }

    private String createDataRowString(DatasetRow row){
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s\n",
                row.getUser(), row.getEntry(), row.getType(), row.getTypeClass(),
                row.getIEStatus(), row.getSNStatus(), row.getTFStatus(), row.getJPStatus());
    }

    private String createColumnNamesRowString(List<String> columnNames){
        StringBuilder row = new StringBuilder();

        for(int i = 0; i < columnNames.size() - 1; i++){
            row.append(columnNames.get(i)).append(";");
        }

        row.append(columnNames.get(columnNames.size() - 1)).append("\n");

        return row.toString();
    }
}
