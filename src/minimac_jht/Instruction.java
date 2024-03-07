package minimac_jht;
import java.io.Serializable;
public interface Instruction extends Serializable{
    public String getText();
    public void execute(MiniMac mac);
}
