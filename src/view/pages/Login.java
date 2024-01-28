    package view.pages;

    import controller.LoginAdminController;
    import view.Spa;

    import javax.swing.*;
    import java.awt.*;
    import java.util.Objects;

    public class Login extends Spa {
        JTextField usernameField;
        JPasswordField passwordField;
        JButton loginButton;
        LoginAdminController loginAdminController = new LoginAdminController();

        private void requestLogin(){
            loginButton.addActionListener((event) -> {
                try{
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());

                    loginAdminController.requestLogin(username, password);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }

        public JPanel getComponent(String flashMessage) {
            if(!Objects.equals(flashMessage, "")) {
                JOptionPane.showMessageDialog(null, flashMessage);
            }

            JPanel form = new JPanel(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.insets = new Insets(5, 5, 5, 5);

            JLabel titleLabel = new JLabel("Login Admin");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 2;
            constraints.anchor = GridBagConstraints.CENTER;
            form.add(titleLabel, constraints);

            constraints.gridwidth = 1;

            JLabel usernameLabel = new JLabel("Username:");
            usernameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
            constraints.gridx = 0;
            constraints.gridy = 1;
            form.add(usernameLabel, constraints);

            usernameField = new JTextField(20);
            usernameField.setFont(new Font("Arial", Font.PLAIN, 15));
            usernameField.setPreferredSize(new Dimension(200, 30));
            constraints.gridx = 1;
            constraints.gridy = 1;
            form.add(usernameField, constraints);

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
            constraints.gridx = 0;
            constraints.gridy = 2;
            form.add(passwordLabel, constraints);

            passwordField = new JPasswordField(20);
            passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
            passwordField.setPreferredSize(new Dimension(200, 30));
            constraints.gridx = 1;
            constraints.gridy = 2;
            form.add(passwordField, constraints);

            loginButton = new JButton("Login");
            loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
            loginButton.setPreferredSize(new Dimension(140, 35));
            requestLogin();
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 2;
            constraints.anchor = GridBagConstraints.CENTER;
            form.add(loginButton, constraints);

            return form;
        }
    }