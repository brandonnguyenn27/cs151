package life;

import CALab.CAPanel;
import mvc.AppFactory;
import mvc.AppPanel;

public class LifePanel extends CAPanel {
    public LifePanel(AppFactory factory){
        super(factory);
    }
    public static void main(String[] args) {
        AppFactory factory = new LifeFactory();
        AppPanel panel = new LifePanel(factory);
        panel.display();
    }
}
