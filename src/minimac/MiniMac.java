package minimac;

import tools.Publisher;
import tools.Utilities;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class MiniMac extends Publisher implements Serializable {
    int size = 32;
    Integer[] memory = new Integer[size];
    boolean halt = false;
    int ip = 0;
    String fName;
    List<Instruction> instructions = null;

    public MiniMac() {
        Arrays.fill(memory, 0);
        this.fName = "MiniMacFile";
    }

    public void execute(List<Instruction> instruction) {
        while(ip < instruction.size() && !halt) {
            Instruction next = instruction.get(ip++);
            next.execute(this);
            notifySubscribers();
        }
    }
    public void clear() {
        Arrays.fill(memory, 0);
        halt = false;
        ip = 0;
        notifySubscribers();
    }


    public String getFileName() {
        return this.fName;
    }

    public void setFileName(String fName) {
        this.fName = fName;
    }


    public void setUnsavedChanges(boolean b) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
            os.writeObject(this);
            os.close();
        } catch (Exception err) {
            Utilities.error(err);
        }
    }
}
