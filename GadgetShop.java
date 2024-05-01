import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShop implements ActionListener {
    private JFrame frame;

    private JLabel modelLabel;
    private JLabel priceLabel;
    private JLabel weightLabel;
    private JLabel sizeLabel;
    private JLabel memoryLabel;
    private JLabel creditLabel;
    private JLabel displayNumberLabel;
    private JLabel phoneNumberLabel;
    private JLabel durationLabel;

    private JTextField modelTextField;
    private JTextField priceTextField;
    private JTextField weightTextField;
    private JTextField sizeTextField;
    private JTextField memoryTextField;
    private JTextField creditTextField;
    private JTextField displayNumberTextField;
    private JTextField phoneNumberTextField;
    private JTextField durationTextField;

    private JButton addMobileButton;
    private JButton addMP3Button;
    private JButton makeACallButton;
    private JButton viewAllButton;
    private JButton clearButton;

    private ArrayList<Gadget> items = new ArrayList<>();

    public static void main(String arg[]) {
        GadgetShop gadgetShop = new GadgetShop();
    }

    public GadgetShop() {
        makeFrame();
    }

    private void makeFrame() {
        frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(6, 2));
        frame.getContentPane().setBackground(new Color(255, 255, 255));

        modelLabel = new JLabel("Model:");
        priceLabel = new JLabel("Price (£):");
        weightLabel = new JLabel("Weight (g):");
        sizeLabel = new JLabel("Size:");
        memoryLabel = new JLabel("Memory (GB):");
        creditLabel = new JLabel("Credit:");
        displayNumberLabel = new JLabel("Display Number:");
        phoneNumberLabel = new JLabel("Phone Number:");
        durationLabel = new JLabel("Duration (mins):");

        modelTextField = new JTextField();
        priceTextField = new JTextField();
        weightTextField = new JTextField();
        sizeTextField = new JTextField();
        memoryTextField = new JTextField();
        creditTextField = new JTextField();
        displayNumberTextField = new JTextField();
        phoneNumberTextField = new JTextField();
        durationTextField = new JTextField();

        addMobileButton = new JButton("Add Mobile");
        addMobileButton.addActionListener(this);
        addMP3Button = new JButton("Add MP3");
        addMP3Button.addActionListener(this);
        makeACallButton = new JButton("Make a Call");
        makeACallButton.addActionListener(this);
        viewAllButton = new JButton("View All");
        viewAllButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        addComponentsToFrame();
        frame.setVisible(true);
    }

    private void addComponentsToFrame() {
        frame.add(modelLabel);
        frame.add(modelTextField);
        frame.add(priceLabel);
        frame.add(priceTextField);
        frame.add(weightLabel);
        frame.add(weightTextField);
        frame.add(sizeLabel);
        frame.add(sizeTextField);
        frame.add(memoryLabel);
        frame.add(memoryTextField);
        frame.add(creditLabel);
        frame.add(creditTextField);
        frame.add(displayNumberLabel);
        frame.add(displayNumberTextField);
        frame.add(phoneNumberLabel);
        frame.add(phoneNumberTextField);
        frame.add(durationLabel);
        frame.add(durationTextField);
        frame.add(addMobileButton);
        frame.add(addMP3Button);
        frame.add(makeACallButton);
        frame.add(viewAllButton);
        frame.add(clearButton);
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        switch (command) {
            case "Add Mobile":
                addMobile();
                break;
            case "Add MP3":
                addMP3();
                break;
            case "Make a Call":
                makeACall();
                break;
            case "View All":
                viewAll();
                break;
            case "Clear":
                clear();
                break;
            default:
                break;
        }
    }

    public void addMobile() {
        Mobile newMobile = new Mobile(Integer.parseInt(creditTextField.getText()), modelTextField.getText(),
                Double.parseDouble(priceTextField.getText()), Integer.parseInt(weightTextField.getText()),
                sizeTextField.getText());
        items.add(newMobile);
        JOptionPane.showMessageDialog(frame, "A new mobile is saved");
    }

    public void addMP3() {
        MP3 newMP3 = new MP3(Double.parseDouble(memoryTextField.getText()), modelTextField.getText(),
                Double.parseDouble(priceTextField.getText()), Integer.parseInt(weightTextField.getText()),
                sizeTextField.getText());
        items.add(newMP3);
        JOptionPane.showMessageDialog(frame, "A new MP3 is added");
    }

    public void makeACall() {
        int displayNumber = Integer.parseInt(displayNumberTextField.getText());
        if (displayNumber >= 0 && displayNumber < items.size()) {
            Gadget gadget = items.get(displayNumber);
            if (gadget instanceof Mobile) {
                Mobile mobile = (Mobile) gadget;
                mobile.makeCall(phoneNumberTextField.getText(), Integer.parseInt(durationTextField.getText()));
            } else {
                JOptionPane.showMessageDialog(frame, "This is not a mobile");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid display number");
        }
    }

    public void viewAll() {
        for (Gadget gadget : items) {
            System.out.print(items.indexOf(gadget) + 1);
            gadget.display();
        }
    }

    public void clear() {
        modelTextField.setText(null);
        priceTextField.setText(null);
        weightTextField.setText(null);
        sizeTextField.setText(null);
        memoryTextField.setText(null);
        creditTextField.setText(null);
        displayNumberTextField.setText(null);
        phoneNumberTextField.setText(null);
        durationTextField.setText(null);
    }
}
