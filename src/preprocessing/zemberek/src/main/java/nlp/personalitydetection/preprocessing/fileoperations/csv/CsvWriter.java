package nlp.personalitydetection.preprocessing.csv;

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

        for(DatasetRow datasetRow : dataset.getRows()){
            row = createDataRowString(datasetRow);
            csvWriter.write(row);
        }

        csvWriter.flush();
        csvWriter.close();
    }

    private String createDataRowString(DatasetRow row){
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s\n",
                row.getUser(), row.getEntry(), row.getType(), row.getTypeClass(),
                row.getIEStatus(), row.getSNStatus(), row.getTFStatus(), row.getJPStatus());
    }

    private String createColumnNamesRowString(List<String> columnNames){
        String row = "";

        for(int i = 0; i < columnNames.size() - 1; i++){
            row += columnNames.get(i) + ";";
        }

        row += columnNames.get(columnNames.size()-1) + "\n";

        return row;
    }
}
