package minimac_jht;

public class Loop implements Instruction{
    int m_count=0;
    private String text = new String();
    @Override
    public String getText(){return text;}
    Instruction m_instruction ;
    public Loop(int count,Instruction instruction)
    {
        m_count = count;
        m_instruction = instruction;
        text += "loop: "+ m_count + " "+m_instruction.getText();

    }
    @Override
    public void execute(MiniMac mac)
    {
        for (int i = m_count;i>0;i--)
        {
            m_instruction.execute(mac);
        }
    }
}
