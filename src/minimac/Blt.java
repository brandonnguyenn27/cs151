package minimac;

public class Blt extends MiniMacParser implements Instruction {
    int loc;
    int offset;
    public Blt(int loc, int offset) {
        this.loc = loc;
        this.offset = offset;
    }
    @Override
    public void execute(MiniMac m) {
        if (m.memory[loc] < 0) {
            m.ip += offset;
        }
    }
    @Override
    public String toString() {
        return "blt " + loc + " " + offset;
    }
}
