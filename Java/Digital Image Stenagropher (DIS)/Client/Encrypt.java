import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;

public class Encrypt extends JFrame implements ActionListener {
    private static long serialVersUID = 1L; //Subject to changes
   
    private JLabel codeJLabel;
    private JLabel encryptedInforJLabel;
    private JTextField codeJTextField;
    private JTextField encryptedInfoJTextField;
    private JButton loadJButton;
    private JButton homeJButton;

    String filepath = "";
    String code = "";
    String encryptedInfo = "";
    String userKey = "";
    Container container;

    Encrypt(){
        super("Encrypt");
        container = getContentPane();
        container.setLayout(null);

        codeJLabel = new JLabel("Security Code");
        codeJLabel.setBounds(230, 100, 150, 50);

    }
}