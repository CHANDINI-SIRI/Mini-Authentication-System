import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle("Authentication System");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Background Panel
        JPanel background = new JPanel();
        background.setBackground(new Color(230, 240, 255));
        background.setLayout(new GridBagLayout());

        // Card Panel
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(300, 300));
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Welcome Label
        JLabel welcome = new JLabel("Welcome Back!");
        welcome.setFont(new Font("Arial", Font.BOLD, 20));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Please login to continue");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField usernameField = new JTextField();
        usernameField.setMaximumSize(new Dimension(250, 30));
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(250, 30));
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));

        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);

        JButton registerButton = new JButton("Create Account");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel messageLabel = new JLabel(" ");
        messageLabel.setForeground(Color.RED);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components
        card.add(welcome);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(subtitle);
        card.add(Box.createRigidArea(new Dimension(0, 20)));
        card.add(usernameField);
        card.add(Box.createRigidArea(new Dimension(0, 15)));
        card.add(passwordField);
        card.add(Box.createRigidArea(new Dimension(0, 15)));
        card.add(loginButton);
        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(registerButton);
        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(messageLabel);

        background.add(card);
        add(background);

        // Login Action
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (UserService.login(username, password)) {
                messageLabel.setForeground(new Color(0, 128, 0));
                messageLabel.setText("Login Successful!");
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Invalid username or password");
            }
        });

        // Navigate to Register
        registerButton.addActionListener(e -> {
            new RegisterFrame();
            dispose();
        });

        setVisible(true);
    }
}