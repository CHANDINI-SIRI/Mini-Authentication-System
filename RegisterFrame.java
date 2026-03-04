import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public RegisterFrame() {

        setTitle("Register");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back to Login");

        panel.add(registerButton);
        panel.add(backButton);

        add(panel);

        // 🔹 REGISTER ACTION
        registerButton.addActionListener(e -> {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            UserService.saveUser(username, password);

            JOptionPane.showMessageDialog(this, "User Registered Successfully!");
        });

        // 🔹 BACK TO LOGIN
        backButton.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        setVisible(true);
    }
}