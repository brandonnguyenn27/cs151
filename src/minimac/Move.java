package minimac;

public class Move extends MiniMacParser implements Instruction {
    int src;
    int dest;
    public Move(int src, int dest){
        this.src = src;
        this.dest = dest;
    }
    public void execute(MiniMac m){
        m.memory[dest] = m.memory[src];
    }
    @Override
    public String toString() {
        return "move " + src + " " + dest;
    }
}
