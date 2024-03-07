package minimac_jht;

public class Add implements Instruction {
    private int m_src1 = 0;
    private int m_src2 = 0;
    private int m_des = 0;
    private String text = new String();

    @Override
    public String getText(){return text;}
    public Add(int src1,int src2,int des)
    {
        m_src1 = src1;
        m_src2 = src2;
        m_des = des;
        text = "add: "+ m_src1 +' '+ m_src2 +' '+m_des;
    }

    @Override
    public void execute(MiniMac mac)
    {
        mac.memory[m_des] = mac.memory[m_src1] + mac.memory[m_src2];
    }

}
