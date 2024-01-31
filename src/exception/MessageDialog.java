package exception;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MessageDialog {

    public static void showInfoDialog(Component parent, String content, String title) {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showErrorDialog(Component parent, String content, String title) {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.ERROR_MESSAGE);
    }

    public static int showConfirmDialog(Component parent, String content, String title) {
        return JOptionPane.showConfirmDialog(parent, content, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
}
