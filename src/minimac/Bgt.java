package minimac;

public class Bgt extends MiniMacParser implements Instruction{
    int loc;
    int offset;
    public Bgt(int loc, int offset) {
        this.loc = loc;
        this.offset = offset;
    }
    @Override
    public void execute(MiniMac m) {
        if (0 < m.memory[loc]) {
            m.ip += offset;
        }
    }

    @Override
    public String toString() {
        return "bgt " + loc + " " + offset;
    }
}
