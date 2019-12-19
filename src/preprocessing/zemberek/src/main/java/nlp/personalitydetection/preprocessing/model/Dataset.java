package nlp.personalitydetection.preprocessing.model;

import java.util.List;

public class Dataset {
    private List<DatasetRow> rows;
    private List<String> columnNames;

    public Dataset(List<DatasetRow> rows, List<String> columnNames) {
        this.rows = rows;
        this.columnNames = columnNames;
    }

    public List<DatasetRow> getRows() {
        return rows;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }
}
