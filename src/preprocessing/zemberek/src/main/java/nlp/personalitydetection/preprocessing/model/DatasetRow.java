package nlp.personalitydetection.preprocessing.model;

public class DatasetRow {
    private String user;
    private String entry;
    private String type;
    private String typeClass;
    private String iEStatus;
    private String sNStatus;
    private String tFStatus;
    private String jPStatus;

    public DatasetRow(){}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(String typeClass) {
        this.typeClass = typeClass;
    }

    public String getIEStatus() {
        return iEStatus;
    }

    public void setIEStatus(String iEStatus) {
        this.iEStatus = iEStatus;
    }

    public String getSNStatus() {
        return sNStatus;
    }

    public void setSNStatus(String sNStatus) {
        this.sNStatus = sNStatus;
    }

    public String getTFStatus() {
        return tFStatus;
    }

    public void setTFStatus(String tFStatus) {
        this.tFStatus = tFStatus;
    }

    public String getJPStatus() {
        return jPStatus;
    }

    public void setJPStatus(String jPStatus) {
        this.jPStatus = jPStatus;
    }
}
