package minimac;

public class Load extends MiniMacParser implements Instruction {
    int loc;
    int value;
    public Load(int loc, int value) {
        this.loc = loc;
        this.value = value;
    }
    @Override
    public void execute(MiniMac m) {
        m.memory[loc] = value;
    }

    @Override
    public String toString() {
        return "load " + loc + " " + value;
    }
}
