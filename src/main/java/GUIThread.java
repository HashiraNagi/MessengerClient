public class GUIThread implements Runnable{

    @Override
    public void run() {
        GUI mainwindow = GUI.getWindow();
        GUI.setSendButtonListener();
    }
}
