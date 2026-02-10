import javax.swing.*;
import java.awt.*;

public class VentanaLoginAdmin extends JFrame {
    public VentanaLoginAdmin() {
        setTitle("Acceso Administrativo - Club Constitución");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        JLabel lblLogin = new JLabel("INGRESAR AL PANEL");
        lblLogin.setFont(new Font("Arial", Font.BOLD, 20));
        lblLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField txtUser = new JTextField();
        txtUser.setMaximumSize(new Dimension(300, 35));
        JPasswordField txtPass = new JPasswordField();
        txtPass.setMaximumSize(new Dimension(300, 35));

        JButton btnEntrar = new JButton("LOGUEAR");
        btnEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEntrar.addActionListener(e -> {
            String user = txtUser.getText().trim();
            String pass = new String(txtPass.getPassword()).trim();

            if (user.equalsIgnoreCase("CANARIO") && pass.equalsIgnoreCase("CONSTITUCION")) {
                new AdminPanel().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            }
        });

        panel.add(lblLogin);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(new JLabel("Usuario:"));
        panel.add(txtUser);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtPass);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnEntrar);

        add(panel);
    }
}