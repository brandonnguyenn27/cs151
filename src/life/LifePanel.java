package life;

import CALab.CAFactory;
import CALab.CAPanel;
import mvc.AppFactory;

public class LifePanel extends CAPanel {
    public LifePanel(AppFactory factory){
        super(factory);
    }
    public static void main(String[] args) {
        CAFactory factory = new LifeFactory();
        CAPanel panel  = new CAPanel(factory);
        panel.display();
    }
}
