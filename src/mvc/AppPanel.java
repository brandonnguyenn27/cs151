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
    public static int FRAME_WIDTH = 800;
    public static int FRAME_HEIGHT = 600;
    /*
      Constructor for the AppPanel class.
      Creates a JFrame and adds the AppPanel to it.
      @param factory the factory to be used
     */
    public AppPanel(AppFactory factory) {
        this.model = factory.makeModel();
        this.view =  factory.makeView(model);
        controlPanel = new JPanel();

        this.factory = factory;
        this.setLayout((new GridLayout(1, 3)));
        this.add(controlPanel);
        this.add(view);
        model.subscribe(this);

        frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model newModel) {
        this.model.unsubscribe(this);
        this.model = newModel;
        view.setModel(this.model);
        model.subscribe(this);
        model.changed();
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
        if (cmmd.equals("Save")) {
            Utilities.save(model, false);
        } else if (cmmd.equals("SaveAs")) {
            Utilities.save(model, true);
        } else if (cmmd.equals("Open")) {
            Model newModel = Utilities.open(model);
            if (newModel != null) {
                view.setModel(newModel);
            }
        } else if (cmmd.equals("New")) {
            Utilities.saveChanges(model);
            setModel(factory.makeModel());
            model.setUnsavedChanges(false);
        } else if (cmmd.equals("Quit")) {
            Utilities.saveChanges(model);
            System.exit(1);
        }
        else if (cmmd.equals("About")) {
            Utilities.inform(factory.about());
        }
        else if (cmmd.equals("Help")) {
            Utilities.inform(factory.getHelp());
        }
        else {
            Command command = factory.makeEditCommand(model, cmmd, this);
            command.execute();
        }
    }
    /*
      createMenuBar method for the AppPanel class.
      Creates a JMenuBar for the AppPanel.
      Contains File, Edit, and Help commands from the factory.
      @return the JMenuBar to be used
     */
        protected JMenuBar createMenuBar () {
            JMenuBar result = new JMenuBar();
            JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "SaveAs", "Open", "Quit"}, this);
            result.add(fileMenu);
            JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
            result.add(editMenu);
            JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"Help","About"}, this);
            result.add(helpMenu);
            return result;
        }
        protected void handleException (Exception e) {
            Utilities.error(e);

        }
        public void display () {
            frame.setVisible(true);
        }

        public void update () {
        }

    }


