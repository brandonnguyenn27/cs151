package minimac;

public class Loop extends MiniMacParser implements Instruction {
    int count;
    Instruction instruction;
    public Loop(int count, Instruction instruction) {
        this.count = count;
        this.instruction = instruction;
    }
    @Override
    public void execute(MiniMac m) {
        for (int i = 0; i < count; i++) {
            instruction.execute(m);
        }
    }

    @Override
    public String toString() {
        return "loop " + count + " " + instruction;
    }
}
