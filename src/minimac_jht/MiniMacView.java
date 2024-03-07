package minimac_jht;

import tools.Subscriber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MiniMacView extends JPanel implements Subscriber {
    private MiniMac miniMac;
    private JList<String> memoryList;
    DefaultListModel<String> memoryList_model = new DefaultListModel<>();
    private JList<String> instructionList;
    DefaultListModel<String> instructionList_model = new DefaultListModel<>();
    public MiniMacView(MiniMac mac)
    {
        this.miniMac = mac;
        for(int i=0; i<miniMac.getMemorySize();i++)
        {
            memoryList_model.addElement("memory["+i+"] = "+miniMac.memory[i]);
        }
        memoryList = new JList<String>(memoryList_model);
        instructionList = new JList<String>(instructionList_model);
        miniMac.subscribe(this);


        Border blackline = BorderFactory.createLineBorder(Color.black);
        memoryList.setBorder(blackline);
        memoryList.setBackground(Color.LIGHT_GRAY);
        instructionList.setBorder(blackline);
        instructionList.setBackground(Color.white);
        JScrollPane scrollPaneMemeory = new JScrollPane(memoryList);
        JScrollPane scrollPaneInstructions = new JScrollPane(instructionList);
        this.setLayout(new GridLayout(2,1));
        this.add(scrollPaneMemeory);
        this.add(scrollPaneInstructions);

    }

    public void setMiniMac(MiniMac newMac) {
        miniMac.unsubscribe(this);
        miniMac = newMac;
        miniMac.subscribe(this);
        miniMac.notifySubscribers();
        //refresh MiniMacview list
    }

    @Override
    public void update() {
        //display updated Jlist in view
        memoryList_model.clear();
        for(int i=0; i<miniMac.getMemorySize();i++)
        {
            memoryList_model.addElement("memory["+i+"] = "+miniMac.memory[i]);
        }
        if(miniMac.isHalted() && miniMac.getIp()==0)
        {
            instructionList_model.clear();
        }
        else {
            instructionList_model.addElement(miniMac.getLastInstruct());
        }
        memoryList.repaint();
        instructionList.repaint();
    }
}
