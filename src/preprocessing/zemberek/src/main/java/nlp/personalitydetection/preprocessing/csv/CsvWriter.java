package nlp.personalitydetection.preprocessing.csv;

import nlp.personalitydetection.preprocessing.model.DatasetRow;

public class CsvWriter {

    private String createRowString(DatasetRow row){
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s",
                row.getUser(), row.getEntry(), row.getType(), row.getTypeClass(),
                row.getIEStatus(), row.getSNStatus(), row.getTFStatus(), row.getJPStatus());
    }
}
