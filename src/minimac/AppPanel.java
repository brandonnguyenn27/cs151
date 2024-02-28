package minimac;

import tools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AppPanel extends JPanel implements ActionListener {
    private MiniMac mac;
    private ControlPanel controls;
    private MiniMacView view;
    private static List<Instruction> instructions;

    public AppPanel() {
        mac = new MiniMac();
        view = new MiniMacView(mac);
        controls = new ControlPanel();
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(view);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("MiniMac");
        frame.setSize(800, 500);
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"Change"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "New":
                case "Clear": {
                    mac.clear();
                    view.setMac(mac);
                    view.clearInstruction();
                    instructions.clear();
                    break;
                }
                case "About": {
                    JOptionPane.showMessageDialog(this, "MiniMac Simulator\nVersion 1.0\nAuthor: Brandon Nguyen\nDate: 2024\n",
                            "About MiniMac", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                case "Help": {
                    JOptionPane.showMessageDialog(this, "This is a simple simulator for the MiniMac computer.\n" +
                                    "It supports a simple assembly language and a simple GUI.\n" +
                                    "The assembly language supports the following instructions:\n" +
                                    "add, sub, mul, div, and, or, not, bgt, block, load, store, clear, and halt.\n" +
                                    "The GUI supports the following features:\n" +
                                    "Open, Save, Parse, Run, Clear, and Quit.\n",
                            "Help", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }

                case "Save": {
                    String fName = Utilities.getFileName((String) null, false);
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.mac);
                    os.close();
                    break;
                }
                case "Open": {
                    String fName = Utilities.getFileName((String) null, true);
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                    MiniMac newMac = (MiniMac) is.readObject();
                    is.close();
                    view.setMac(newMac);
                    break;
                }
                case "Parse": {
                    String fileName = JOptionPane.showInputDialog(this, "Enter program file name",
                            "Input", JOptionPane.QUESTION_MESSAGE);
                    if (fileName != null && !fileName.trim().isEmpty()) {
                        String programString = Files.readString(Path.of(fileName));
                        System.out.print(programString);
                        instructions = MiniMacParser.parse(programString);
                        view.setInstructions(instructions);
                    }
                    else {
                        System.out.println("Error");
                    }
                    break;
                }
                case "Run": {
                    if (!instructions.isEmpty()) {

                        mac.execute(instructions);
                    }
                    else{
                        System.out.println("No more instructions to execute.");
                    }
                    break;
                }
                case "Quit":
                    System.exit(1);
                    break;
            }
        } catch (Exception ex) {
            Utilities.error(ex);
        }

    }

    class ControlPanel extends JPanel {
        public ControlPanel() {
            setLayout(new FlowLayout());
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(3, 1, 5, 5));
            JButton parse = new JButton("Parse");
            JButton run = new JButton("Run");
            JButton clear = new JButton("Clear");
            parse.addActionListener(minimac.AppPanel.this);
            run.addActionListener(minimac.AppPanel.this);
            clear.addActionListener(minimac.AppPanel.this);
            p.add(parse);
            p.add(run);
            p.add(clear);
            add(p);
        }
    }


    public static void main(String[] args) {
        new minimac.AppPanel();
    }
}
