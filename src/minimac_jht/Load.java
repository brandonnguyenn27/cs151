package minimac_jht;

public class Load implements Instruction{
    int m_loc=0;
    int m_value=0;
    private String text = new String();
    @Override
    public String getText(){return text;}
    public Load(int loc, int value)
    {
        m_loc = loc;
        m_value = value;
        text = "load: "+ m_loc +' '+ m_value ;
    }
    @Override
    public void execute(MiniMac mac)
    {
        mac.memory[m_loc] = m_value;
    }
}
