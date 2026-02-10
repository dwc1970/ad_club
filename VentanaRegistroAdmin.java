import javax.swing.*;
import java.awt.*;

public class VentanaRegistroAdmin extends JFrame {
    public VentanaRegistroAdmin() {
        setTitle("Configuración de Seguridad - AD_CLUB");
        setSize(450, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel titulo = new JLabel("Alta de Autoridad");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Campos de texto simplificados para evitar errores
        JTextField txtUsuario = new JTextField();
        txtUsuario.setMaximumSize(new Dimension(350, 35));
        JPasswordField txtClave = new JPasswordField();
        txtClave.setMaximumSize(new Dimension(350, 35));
        JPasswordField txtClave2 = new JPasswordField();
        txtClave2.setMaximumSize(new Dimension(350, 35));
        JPasswordField txtMasterKey = new JPasswordField();
        txtMasterKey.setMaximumSize(new Dimension(350, 35));

        JButton btnGuardar = new JButton("ESTABLECER SEGURIDAD");
        btnGuardar.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnGuardar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "✅ Seguridad establecida.");
            new VentanaLoginAdmin().setVisible(true); // Abre la siguiente ventana
            this.dispose(); // Cierra esta
        });

        panel.add(titulo);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(new JLabel("Usuario:"));
        panel.add(txtUsuario);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtClave);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(new JLabel("Confirmar Contraseña:"));
        panel.add(txtClave2);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(new JLabel("Llave Maestra:"));
        panel.add(txtMasterKey);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(btnGuardar);

        add(panel);
    }
}