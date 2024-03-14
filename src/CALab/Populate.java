package CALab;

import mvc.Command;
import mvc.Model;

public class Populate extends Command {
    public Populate(Model m)
    {
        super(m);
    }

    @Override
    public void execute() {
        Grid g = (Grid)getModel();
        g.repopulate(true);
    }

}
