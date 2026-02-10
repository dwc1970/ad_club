import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.google.cloud.firestore.*;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.api.core.ApiFuture;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AdminPanel extends JFrame {
    private JTable tablaSocios;
    private DefaultTableModel modelo;
    private JLabel lblTotal;

    public AdminPanel() {
        // --- DISEÑO ---
        setTitle("ADMINISTRACIÓN - CLUB CONSTITUCIÓN");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(Color.BLACK);
        lblTotal = new JLabel("Conectando con la nube...");
        lblTotal.setForeground(Color.YELLOW);
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
        pnlHeader.add(lblTotal);
        add(pnlHeader, BorderLayout.NORTH);

        // Tabla
        modelo = new DefaultTableModel(new String[]{"DNI", "Nombre", "Categoría", "Nº Socio", "Estado Cuota"}, 0);
        tablaSocios = new JTable(modelo);
        add(new JScrollPane(tablaSocios), BorderLayout.CENTER);

        // Botonera
        JPanel pnlBotones = new JPanel();
        JButton btnRefrescar = new JButton("ACTUALIZAR DATOS");
        btnRefrescar.addActionListener(e -> cargarSocios());
        pnlBotones.add(btnRefrescar);
        add(pnlBotones, BorderLayout.SOUTH);

        // Cargar al iniciar
        cargarSocios();
    }

    public void cargarSocios() {
        modelo.setRowCount(0);
        try {
            // Firestore usa ApiFuture para pedidos asincrónicos
            ApiFuture<QuerySnapshot> query = ConexionFirebase.db.collection("socios").get();
            
            // Obtenemos los documentos (esto puede tardar un poquito según el internet)
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            for (QueryDocumentSnapshot doc : documents) {
                // Sacamos los datos tal cual los guardamos en la Web
                String dni = doc.getId(); // El DNI es el ID del documento
                String nombre = doc.getString("nombre");
                String cat = doc.getString("categoria");
                String nro = String.valueOf(doc.get("nroSocio"));
                String estado = doc.getString("estadoCuota");

                modelo.addRow(new Object[]{dni, nombre, cat, nro, estado});
            }
            lblTotal.setText("SOCIOS ENCONTRADOS: " + documents.size());

        } catch (InterruptedException | ExecutionException e) {
            JOptionPane.showMessageDialog(this, "Error de red: " + e.getMessage());
        }
    }
}