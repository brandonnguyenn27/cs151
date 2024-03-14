package mvc;

import java.awt.*;
import java.io.Serializable;
public abstract class Model extends Publisher implements Serializable {
    private String fName="";
    private Boolean unsavedChanges=false;

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public void setUnsavedChanges(boolean b) {
        unsavedChanges = b;
    }
    public String getFileName() {
        return fName;
    }

    public void setFileName(String name) {
        fName = name;
    }
}
