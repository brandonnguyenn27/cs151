package minimac_jht;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Block implements Instruction{
    private List<Instruction> body = new ArrayList<>();
    private String text = new String();
    @Override
    public String getText(){return text;}

    public int getBlockSize(){return body.size();}
    public Instruction get(int i){return body.get(i);}
    public Block(List<Instruction> l)
    {
        body = l;
    }

    @Override
    public void execute(MiniMac mac)
    {
        int blockIp = mac.getBlockIp();
        Instruction inc = body.get(blockIp);
        inc.execute(mac);
        if(blockIp == 0)
        {
            text = "{ " + inc.getText();
        }
        else text = inc.getText();
    }
}
