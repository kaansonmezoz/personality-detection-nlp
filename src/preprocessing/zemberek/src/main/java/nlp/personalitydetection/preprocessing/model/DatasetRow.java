package nlp.personalitydetection.preprocessing;

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

    public String getiEStatus() {
        return iEStatus;
    }

    public void setiEStatus(String iEStatus) {
        this.iEStatus = iEStatus;
    }

    public String getsNStatus() {
        return sNStatus;
    }

    public void setsNStatus(String sNStatus) {
        this.sNStatus = sNStatus;
    }

    public String gettFStatus() {
        return tFStatus;
    }

    public void settFStatus(String tFStatus) {
        this.tFStatus = tFStatus;
    }

    public String getjPStatus() {
        return jPStatus;
    }

    public void setjPStatus(String jPStatus) {
        this.jPStatus = jPStatus;
    }
}
