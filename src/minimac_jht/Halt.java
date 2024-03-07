package minimac_jht;

public class Halt implements Instruction{
    private String text = new String("halt");
    @Override
    public String getText(){return text;}
    @Override
    public void execute(MiniMac mac)
    {
        mac.terminate();
    }
}
