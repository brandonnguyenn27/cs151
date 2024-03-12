package mvc;

import java.io.Serializable;

public class Model extends Publisher implements Serializable {
    private boolean unsavedChanges = false;
    private String fName = null;

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }

    public String getFileName() {
        return fName;
    }

    public void setFileName(String fName) {
        this.fName = fName;
    }

    public void changed() {
        unsavedChanges = true;
    }
}
