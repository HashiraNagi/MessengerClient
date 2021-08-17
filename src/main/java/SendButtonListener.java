import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendButtonListener implements ActionListener {

    static final SendButtonListener sendButtonListener = new SendButtonListener();

    GUI mainwindow = GUI.getWindow();

    public static SendButtonListener getSendButtonListener(){
        return sendButtonListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String temp = mainwindow.inputTextField.getText();
            if(!temp.equals("")) {
                synchronized (TempDataHolder.lock) {
                    TempDataHolder.outputData = (mainwindow.name + " SAYS: " + temp + "\n");
                    TempDataHolder.lock.notify();
                    mainwindow.inputTextField.setText("");
                }
            }

    }
}
