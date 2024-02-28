package minimac;

import tools.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MiniMacView extends JPanel implements Subscriber {
    private MiniMac mac;
    private MiniMacComponent macComponent;
    private List<Instruction> instructions;
    public MiniMacView(MiniMac mac, List<Instruction> instructions) {
        this.mac = mac;
        this.mac.subscribe(this);
        this.instructions = instructions;
        setLayout(new BorderLayout());
        macComponent = new MiniMacComponent(mac);
        add(macComponent, BorderLayout.CENTER);
    }

    @Override
    public void update() {
        macComponent.updateMemory(mac.memory);
        macComponent.updateInstructionModel(instructions);
    }


    public void clearInstruction() {
        macComponent.clearInstructionModel();

    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
        macComponent.updateInstructionModel(instructions);
    }

    public void setMac(MiniMac newMac) {
        mac.unsubscribe(this);
        mac = newMac;
        mac.subscribe(this);

    }

}
