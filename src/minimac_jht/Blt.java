package minimac_jht;

public class Blt implements Instruction{
    int m_loc=0;
    int m_offset=0;
    private String text = new String();
    @Override
    public String getText(){return text;}
    public Blt(int loc,int offset){
        m_loc = loc;
        m_offset = offset;
        text = "blt: "+ m_loc +' '+ m_offset ;
    }
    public void execute(MiniMac mac)
    {
        if(0>mac.memory[m_loc])
        {
            mac.offset(m_offset);
        }
    }
}
