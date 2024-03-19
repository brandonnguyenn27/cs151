package life;

import CALab.CAFactory;
import mvc.Model;
import mvc.View;

public class LifeFactory extends CAFactory {

    @Override
    public Model makeModel()
    {
        return new Society();
    }

    @Override
    public View makeView(Model model)
    {
        return new LifeView((Society) model);
    }
    @Override
    public String getTitle() {
        return "CA Life Lab";
    }
    @Override
    public String about() {
        return "The Conway's Game of Life Lab Program";
    }
    @Override
    public String[] getHelp() {
        return new String[]{"CA Lab Help List","RUN1: Run model 1 time","RUN50: Run model 50 times",
                "POPULATE: Populate the grid","CLEAR: Clear the grid"};
    }
}
