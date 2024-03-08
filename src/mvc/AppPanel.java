package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
  AppPanel is the main panel for the application.
  It contains the ControlPanel, View, Model, and AppFactory.
 */
public class AppPanel extends JPanel implements ActionListener, Subscriber {
    private ControlPanel controls;
    private Model model;
    private View view;
    private AppFactory factory;
    /*
      Constructor for the AppPanel class.
      Creates a JFrame and adds the AppPanel to it.
      @param factory the factory to be used
     */
    public AppPanel(AppFactory factory) {
        this.model = new Model();
        this.view = new View(model); //add model parameter?
        this.controls = new ControlPanel();
        this.factory = factory;
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(view);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(800, 500);
        frame.setVisible(true);

    }
    /*
      actionPerformed method for the AppPanel class.
      Executes the command for the given ActionEvent.
      Gets the command from the factory.
      @param e the ActionEvent to be used
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        Command command = factory.makeEditCommand(cmmd);
        if (command != null) {
            command.execute();
        }
    }
    /*
      createMenuBar method for the AppPanel class.
      Creates a JMenuBar for the AppPanel.
      Contains File, Edit, and Help commands from the factory.
      @return the JMenuBar to be used
     */
    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", factory.getEditCommands(), this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", factory.getHelp(), this);
        result.add(helpMenu);
        return result;
    }

    public void update() {
        view.update();
    }
/*
    ControlPanel class for the AppPanel class.
 */
    class ControlPanel extends JPanel {
        /*
          Constructor for the ControlPanel class.
          Sets the layout for the ControlPanel.
         */
        public ControlPanel() {
            setLayout(new FlowLayout());
            JPanel p = new JPanel();
        }
    }
}
