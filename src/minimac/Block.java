package minimac;

import java.util.List;

public class Block extends MiniMacParser implements Instruction{
    List<Instruction> instructions;
    public Block(List<Instruction> instructions){
        this.instructions = instructions;
    }
    @Override
    public void execute(MiniMac m){
        for(Instruction i : instructions){
            i.execute(m);
        }
    }

    @Override
    public String toString() {
        String result = "{";
        int numberOfInstructions = instructions.size();
        int counter = 0;

        for (Instruction i : instructions) {
            counter++;
            if (counter < numberOfInstructions) {
                result += i.toString() + "; ";
            } else {
                // Last instruction, so don't add a semicolon after it
                result += i.toString();
            }
        }

        result += "}";
        return result;
    }

}
