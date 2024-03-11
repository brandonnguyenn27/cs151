package mvc;

import java.awt.*;
import java.io.Serializable;
import tools.Publisher;
public abstract class Model extends Publisher implements Serializable {
    private String fName;
    private Boolean unsavedChanges = false;
    public boolean getUnsavedChanges() {
        return unsavedChanges; //temporary code to get rid of error lines
    }

    public String getFileName() {
        return ""; //temporary code to get rid of error lines
    }

    public void setFileName(String fName) {
    }

    public void setUnsavedChanges(boolean b) {
        unsavedChanges = b;
    }
    public abstract int getStatus();
    public abstract Color getColor();

}
