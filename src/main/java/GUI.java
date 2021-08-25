import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class GUI {

    String name;
    JTextArea inputTextField = new JTextArea();
    JTextArea outputTextField = new JTextArea();
    static JButton sendButton = new JButton();

    private static final GUI mainwindow = new GUI();


    public static GUI getWindow(){

            return mainwindow;

    }

    // Setting listener to a button
    public static void setSendButtonListener(){
        sendButton.addActionListener(SendButtonListener.getSendButtonListener());
    }

    private GUI() {

        //Output text field
        outputTextField.setPreferredSize(new Dimension(500,400));
        outputTextField.setEditable(false);
        outputTextField.setBackground(Color.lightGray);

        //Input text field
        inputTextField.setPreferredSize(new Dimension(400,65));
        inputTextField.setAlignmentY(JTextField.TOP);
        inputTextField.setBackground(Color.white);

        //Dialog window
        name = JOptionPane.showInputDialog("Input your nickname");

        // Buttons
        sendButton.setText("SEND");
        sendButton.setSize(100,100);
        sendButton.setBounds(400,400,100,100);
        sendButton.setLayout(new BorderLayout());



        //Panels
        JPanel outputtextpanel = new JPanel();
        JPanel inputpanel = new JPanel();
        JPanel buttonpanel = new JPanel();

        //Output text panel
        outputtextpanel.setBackground(Color.RED);
        outputtextpanel.setSize(500,400);
        outputtextpanel.setBounds(0,0,500,400);
        inputpanel.setLayout(new BorderLayout());
        outputtextpanel.add(outputTextField);



        //Input panel
        inputpanel.setBackground(Color.BLUE);
        inputpanel.setSize(500,100);
        inputpanel.setBounds(0,400,400,100);
        inputpanel.setLayout(new BorderLayout());
        inputpanel.add(inputTextField);


        //Button panel
        buttonpanel.setBackground(Color.GREEN);
        buttonpanel.setSize(100,100);
        buttonpanel.setBounds(400,400,100,73);
        buttonpanel.setLayout(new BorderLayout());
        buttonpanel.add(sendButton);



        //Main frame
        JFrame frame = new JFrame("messanger");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    NetConection.conectionSocet.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                finally {
                    frame.dispose();
                    System.exit(0);
                }


            }
        });
        frame.setResizable(false);
        frame.add(outputtextpanel);
        frame.add(inputpanel);
        frame.add(buttonpanel);

    }

}
