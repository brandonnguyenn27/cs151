package mvc;

public abstract class Command {
    Model model;
    public Command(Model m)
    {
        model=m;
    }
    public abstract void execute();
    public abstract void undo();
}
