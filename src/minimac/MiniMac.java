package minimac;

import tools.Publisher;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class MiniMac extends Publisher implements Serializable {
    int size = 32;
    Integer[] memory = new Integer[size];
    boolean halt = false;
    int ip = 0;

    public MiniMac() {
        Arrays.fill(memory, 0);
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



}
