import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        // 1. Intentar poner un diseño más moderno al programa (Opcional)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si falla, sigue con el diseño básico de Java
        }

        // 2. CONECTAR CON FIREBASE
        // Esto usa el código que pusimos en ConexionFirebase.java
        System.out.println("Iniciando conexión con la nube...");
        ConexionFirebase.conectar();

        // 3. ABRIR EL PANEL DE ADMINISTRACIÓN
        // Usamos invokeLater para que la ventana se abra de forma segura
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminPanel frame = new AdminPanel();
                    frame.setVisible(true);
                    System.out.println("✅ Panel de Administración desplegado correctamente.");
                } catch (Exception e) {
                    System.err.println("❌ ERROR al abrir el panel: " + e.getMessage());
                }
            }
        });
    }
}