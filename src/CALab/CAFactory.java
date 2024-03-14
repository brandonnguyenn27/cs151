package CALab;
import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public abstract class CAFactory implements AppFactory {
    @Override
    public abstract Model makeModel();

    @Override
    public abstract View makeView(Model model);

    @Override
    public String getTitle() {
        return "CA Lab";
    }

    @Override
    public String[] getHelp() {
        return new String[]{"CA Lab Help List","1.xxx","2.xxx"};
    }

    @Override
    public String about() {
        return "The CA lab Program";
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"RUN1","RUN50","POPULATE","CLEAR"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        Command cmd = null;
        if(type=="RUN1")
        {
            cmd = new UpdateLoop(model,1);
        }
        else if(type=="RUN50")
        {
            cmd = new UpdateLoop(model,50);
        }
        else if(type=="POPULATE")
        {
            cmd = new Populate(model);
        }
        else if (type=="CLEAR")
        {
            cmd = new Clear(model);
        }
        return cmd;
    }
}
