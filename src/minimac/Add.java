package minimac;

public class Add extends MiniMacParser implements Instruction {
    int dest;
    int src1;
    int src2;
    public Add(int src1, int src2, int dest) {
        this.dest = dest;
        this.src1 = src1;
        this.src2 = src2;
    }
    @Override
    public void execute(MiniMac m) {
        m.memory[dest] = m.memory[src1] + m.memory[src2];
    }

    @Override
    public String toString() {
        return "add " + src1 + " " + src2 + " " + dest;
    }
}
