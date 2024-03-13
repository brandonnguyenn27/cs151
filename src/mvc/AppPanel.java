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
    protected JPanel controlPanel;
    protected Model model;
    protected View view;
    protected AppFactory factory;
    private JFrame frame;
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 300;
    /*
      Constructor for the AppPanel class.
      Creates a JFrame and adds the AppPanel to it.
      @param factory the factory to be used
     */
    public AppPanel(AppFactory factory) {
        this.model = factory.makeModel();
        this.view = new View(model); //add model parameter?
        view.setBackground(Color.GRAY);
        controlPanel = new JPanel();
        controlPanel.setBackground(Color.PINK);
        this.factory = factory;
        this.setLayout((new GridLayout(1, 2)));
        this.add(controlPanel);
        this.add(view);
        model.subscribe(this);

        frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);



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
        try {
            switch (cmmd) {
                case "Save": {
                    Utilities.save(model, false);
                }
                case "Open": {
                    Utilities.open(model);
                }
                case "New": {
                    Utilities.saveChanges(model);
                    model = this.factory.makeModel();
                    this.view = this.factory.makeView(model);
                }
                case "Quit": {
                    Utilities.saveChanges(model);
                    System.exit(0);
                }
                case "Help": {
                    Utilities.inform(factory.getHelp());
                }
                case "About": {
                    Utilities.inform(factory.about());
                }
                default: {
                    Command c = this.factory.makeEditCommand(this.model, cmmd, e.getSource());
                    c.execute();
                }
            }
        } catch (Exception exc) {
            Utilities.error(exc);
        }
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
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", factory.getHelp(), this);
        result.add(helpMenu);
        return result;
    }

    public void display() {
        frame.setVisible(true);
    }

    public void update() {
        view.update();
    }
/*
    ControlPanel class for the AppPanel class.
 */
public class ControlPanel extends JPanel {
    public JPanel buttons;

    public ControlPanel() {
        this.setBackground(Color.PINK);
        this.buttons = new JPanel();
    }

    public void add(JButton newButtons) {
        this.buttons.add(newButtons);
        this.add(this.buttons);
    }
}
}
