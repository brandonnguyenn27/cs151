package minimac;

import tools.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MiniMacView extends JPanel implements Subscriber {
    private MiniMac mac;
    private MiniMacComponent macComponent;
    public MiniMacView(MiniMac mac) {
        this.mac = mac;
        this.mac.subscribe(this);
        setLayout(new BorderLayout());
        macComponent = new MiniMacComponent(mac);
        add(macComponent, BorderLayout.CENTER);
    }

    @Override
    public void update() {
        macComponent.updateMemory(mac.memory);
    }


    public void clearInstruction() {
        macComponent.clearInstructionModel();
    }

    public void setInstructions(List<Instruction> instructions) {
        macComponent.updateInstructionModel(instructions);
    }

    public void setMac(MiniMac newMac) {
        mac.unsubscribe(this);
        mac = newMac;
        mac.subscribe(this);

    }

    public void setMac(MiniMac newMac, List<Instruction> instructions) {
        mac = newMac;
        mac.instructions = instructions;
    }

}
