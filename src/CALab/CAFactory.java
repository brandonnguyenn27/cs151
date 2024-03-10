package CALab;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class CAFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return null;
        //return Grid();
    }

    @Override
    public View makeView(Model model) {
        return null;
    }

    @Override
    public String getTitle() {
        return "CA Lab";
    }

    @Override
    public String[] getHelp() {
        return new String[0];
    }

    @Override
    public String about() {
        return "The CA lab Program";
    }

    @Override
    public String[] getEditCommands() {
        return new String[0];
    }

    @Override
    public Command makeEditCommand(String type) {
        return null;
    }
}
