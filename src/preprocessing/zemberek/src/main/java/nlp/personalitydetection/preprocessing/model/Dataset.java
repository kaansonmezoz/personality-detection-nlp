package nlp.personalitydetection.preprocessing;

import java.util.ArrayList;

public class Dataset {
    private ArrayList<DatasetRow> rows;
    private ArrayList<String> columnNames;

    public Dataset(){}

    public ArrayList<DatasetRow> getRows() {
        return rows;
    }

    public void setRows(ArrayList<DatasetRow> rows) {
        this.rows = rows;
    }

    public ArrayList<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(ArrayList<String> columnNames) {
        this.columnNames = columnNames;
    }
}
