package minimac_jht;

public class Move implements Instruction {
    private int m_src=0;
    private int m_des=0;
    private String text = new String();
    @Override
    public String getText(){return text;}
    public Move(int src,int des)
    {
        m_src = src;
        m_des = des;
        text = "mov: "+ m_src +' '+ m_des ;
    }
    @Override
    public void execute(MiniMac mac)
    {
        mac.memory[m_des] = mac.memory[m_src];
    }
}
