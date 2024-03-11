package CALab;

import mvc.Command;
import mvc.Model;

public class Run extends Command {
    private int runTimes = 1;

    public Run(Model m,int times) {
        super(m);
        runTimes = times;
    }

    @Override
    public void execute()
    {

    }

    @Override
    public void undo() {

    }
}
