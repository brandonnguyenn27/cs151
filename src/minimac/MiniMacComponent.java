package minimac;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MiniMacComponent extends JComponent { //should component be a subscriber?
    private JList<String> memory;
    private JList<String> instructions;
    private DefaultListModel<String> memoryModel;
    private DefaultListModel<String> instructionModel;
    private MiniMac mac;

    public MiniMacComponent(MiniMac mac) {
        this.mac = mac;
        setLayout(new GridLayout(2, 1));

        memoryModel = new DefaultListModel<>();
        updateMemory(mac.memory);
        memory = new JList<>(memoryModel);

        instructionModel = new DefaultListModel<>();
        instructions = new JList<>(instructionModel);

        add(new JScrollPane(memory));
        add(new JScrollPane(instructions));

    }

    public void updateMemory(Integer[] memory) {
        memoryModel.clear();
        for (int i = 0; i < memory.length; i++) {
            memoryModel.addElement("memory[" + i + "] = " + memory[i]);
        }
    }

    public void clearInstructionModel() {
        instructionModel.clear();
    }



    public void updateInstructionModel(List<Instruction> instructions) {
        instructionModel.clear();
        if (instructions == null) return;
        for (Instruction instruct : instructions) {
            instructionModel.addElement(instruct.toString());
        }
    }



}
