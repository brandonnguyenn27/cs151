package minimac_jht;
import tools.Publisher;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MiniMac extends Publisher implements Serializable{
    private int ip=0;
    private List<Integer> blockIp = new ArrayList<>();
    private Boolean halt = false;
    private boolean isBlock = false;
    private int blockLevel = 0;

    private int size = 32;
    private List<Instruction> instructions;
    public int[] memory=new int[size];
    private String last_instruct = new String();
    public MiniMac() {}
    public MiniMac(String programs) throws Exception {
        //parse input program file
        instructions = MiniMacParser.parse(programs);
    }
    public int getMemorySize(){return size;}
    public int getInstructionSize(){return instructions.size();}
    public void terminate(){halt = true;}
    public boolean isBlock(){return isBlock;}
    public boolean isHalted(){return halt;}
    public int getIp() {
        return ip;
    }
    public int getBlockIp()
    {
        return blockIp.get(blockLevel-1);
    }
    public void offset(int n)
    {
        if(isBlock)
        {
            blockIp.set(blockLevel-1,blockIp.get(blockLevel-1)+n);
        }
        else {
            ip += n;
        }
    }
    public String getLastInstruct()
    {
        return last_instruct;
    }
    public void execute() throws Exception{

        if(!halt && instructions != null && instructions.size() > 0) {
            try {
                Instruction ins = instructions.get(ip);
                if (isBlock || ins instanceof Block) {
                    if(!isBlock)
                    {
                        //first time execute block
                        isBlock = true;
                        blockLevel++;
                        blockIp.add(0);
                    }
                    ins.execute(this);
                    last_instruct = ins.getText();
                    blockIp.set(blockLevel - 1, blockIp.get(blockLevel - 1) + 1);
                    if (blockIp.get(blockLevel - 1) >= ((Block) ins).getBlockSize()) {
                        isBlock = false;
                        blockIp.remove(blockLevel-1);
                        blockLevel--;
                        last_instruct += " }";
                        ip++;
                    }
                }else {
                    last_instruct = ins.getText();
                    ip++;
                    ins.execute(this);
                }

                notifySubscribers();
            }
            catch (Exception e)
            {
                throw new Exception("Unexpected Terminate! Might Missing: Halt Instruction");
            }
        }
        else {
            throw new Exception("No Program Loaded, please parse a program first!");
        }
    }

    public void clear(){
        halt = true;
        ip = 0;
        for (int i = 0; i < memory.length; i++) {
            memory[i] = 0;
        }
        notifySubscribers();
    }
}
