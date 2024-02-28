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

}
