package minimac_jht;

public class Bgt implements Instruction{
    private int m_loc=0;
    private int m_offset=0;
    private String text = new String();
    @Override
    public String getText(){return text;}
    public Bgt(int loc,int offset){
        m_loc = loc;
        m_offset = offset;
        text = "bgt: "+ m_loc +' '+ m_offset ;
    }
    public void execute(MiniMac mac)
    {
        if(0<mac.memory[m_loc])
        {
            mac.offset(m_offset);
        }
    }
}
