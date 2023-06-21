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
    FileDialog fDialog;

    Encrypt(){
        super("Encrypt");

        container = getContentPane();
        container.setLayout(null);
        codeJLabel = new JLabel("Security Code");
        codeJLabel.setBounds(230, 100, 150, 50);
        codeJTextField = new JTextField(200);
        codeJTextField.setBounds(400, 100, 250, 40);
        encryptedInforJLabel = new JLabel("Encrypted Information");
        encryptedInforJLabel.setBounds(230, 200, 150, 50);
        encryptedInfoJTextField = new JTextField(200);
        encryptedInfoJTextField.setBounds(400, 200, 250, 40);
        loadJButton = new JButton("Load Image");
        loadJButton.setBounds(700, 300, 150, 30);
        loadJButton.addActionListener(this);
        homeJButton = new JButton("Return Home");
        homeJButton.setBounds(700, 400, 150, 30);
        homeJButton.addActionListener(this);
        fDialog = new FileDialog(new JFrame());

        container.add(codeJLabel);
        container.add(codeJTextField);
        container.add(encryptedInforJLabel);
        container.add(encryptedInfoJTextField);
        container.add(loadJButton);
        container.add(homeJButton);
    }
    public void actionPerformed(ActionEvent a){
        //load picture
    }
}