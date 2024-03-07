package minimac_jht;

import tools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MiniMacPanel extends JPanel implements ActionListener {
    private ControlPanel controls;
    private MiniMacView miniMacView;
    private MiniMac miniMac;
    public MiniMacPanel(){
        miniMac = new MiniMac();
        miniMacView = new MiniMacView(miniMac);
        controls = new ControlPanel();
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(miniMacView);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("MiniMac");
        frame.setSize(720, 1000);
        frame.setVisible(true);

    }
    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New","Open","Save", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"Parse","Run","Clear"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"Help"}, this);
        result.add(helpMenu);
        return result;
    }
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {

            switch (cmmd) {
                case "Save":
                {
                    String fName = Utilities.getFileName((String)null,false);
                    if(null != fName)
                    {
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                        os.writeObject(this.miniMac);
                        os.close();
                    }
                    break;
                }
                case "New":{
                    miniMac = new MiniMac();
                    miniMacView.setMiniMac(miniMac);
                    break;
                }
                case "Quit":
                {
                    System.exit(0);
                    break;
                }
                case "Open":
                {
                    try {
                        String fName = Utilities.getFileName((String) null, true);
                        if(null != fName)
                        {
                            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                            miniMac = (MiniMac)is.readObject();
                            is.close();
                            miniMacView.setMiniMac(miniMac);
                        }

                    } catch (Exception err) {
                        Utilities.error(err);
                    }
                    break;
                }
                case "Parse":
                {
                    String fName = Utilities.getFileName((String) null, true);
                    if(null != fName)
                    {
                        String program_contents = Files.readString(Paths.get(fName));
                        miniMac = new MiniMac(program_contents);
                        miniMacView.setMiniMac(miniMac);
                    }
                    break;
                }
                case "Run":
                {
                    miniMac.execute();
                    break;
                }
                case "Clear":
                {
                    miniMac.clear();
                    break;
                }
                case "Help":{
                    Utilities.inform(
                            "load ::= “load” ~ location ~ value // memory[location] = value\n" +
                            "halt ::= “halt” // terminates the program\n" +
                            "Move ::= “mov”~ src ~ dest // memory[dest] = memory[src1]\n" +
                            "add ::= “add” ~ src1 ~ src2 ~ dest // memory[dest] = memory[src1] + memory[src2]\n" +
                            "mul ::= “mul” ~ src1 ~ src2 ~ dest // memory[dest] = memory[src1] * memory[src2]\n" +
                            "bgt ::= “bgt” ~ location ~ offset // if 0 < memory[location] ip += offset\n" +
                            "blt ::= “blt” ~ location ~ offset // if memory[location] < 0 ip += offset\n" +
                            "loop ::= “loop ~ count ~ instruction // executes instruction count times");
                    break;
                }
                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }

        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }

    class ControlPanel extends JPanel{
        public ControlPanel()
        {
            JPanel p = new JPanel();
            JButton change = new JButton("Parse");
            JButton Run = new JButton("Run");
            JButton Clear = new JButton("Clear");

            change.addActionListener(MiniMacPanel.this);
            Run.addActionListener(MiniMacPanel.this);
            Clear.addActionListener(MiniMacPanel.this);
            p.setLayout(new GridLayout(3,1));
            p.add(change);
            p.add(Run);
            p.add(Clear);

            add(p);
        }
    }

    public static void main(String[] args) {
        MiniMacPanel app = new MiniMacPanel();
    }

}
