package CALab;

import mvc.Command;
import mvc.Model;

public class UpdateLoop extends Command {
    private final int runTimes;
    public UpdateLoop(Model m,int times) {
        super(m);
        this.runTimes = times;
    }

    @Override
    public void execute()
    {
        Grid g = (Grid)getModel();
        g.updateLoop(runTimes);
    }
}
