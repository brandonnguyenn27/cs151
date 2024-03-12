package mvc;

abstract public class Command {
    Model model;
    public abstract void execute();
    public Command(Model model) {
        this.model = model;
    }
}
