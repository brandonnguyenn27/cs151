package mvc;

import java.io.Serializable;

public class Model extends Publisher implements Serializable {
    private String fName;

    public boolean getUnsavedChanges() {
        return false; //temporary code to get rid of error lines
    }

    public String getFileName() {
        return ""; //temporary code to get rid of error lines
    }

    public void setFileName(String fName) {
    }

    public void setUnsavedChanges(boolean b) {
    }
}
