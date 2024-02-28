package minimac;

public class Halt extends MiniMacParser implements Instruction {
    @Override
    public void execute(MiniMac m) {
        m.halt = true;
    }

    @Override
    public String toString() {
        return "halt";
    }
}
