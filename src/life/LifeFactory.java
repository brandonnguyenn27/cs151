package life;

import CALab.CAFactory;
import mvc.Model;
import mvc.View;

public class LifeFactory extends CAFactory {
    @Override
    public Model makeModel()
    {
        return new Model();
    }

    @Override
    public View makeView(Model model)
    {
        return new View(model);
    }
}
