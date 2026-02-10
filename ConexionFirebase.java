import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;

public class ConexionFirebase {
    public static Firestore db;

    public static void conectar() {
        try {
            // El nombre exacto de tu llave maestra que vimos en la imagen
            String nombreArchivoJson = "club-constitucion-firebase-adminsdk-fbsvc-38aa55d507.json";
            
            FileInputStream serviceAccount = new FileInputStream(nombreArchivoJson);

            // Configuramos las opciones de Firebase
            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

            // Esto evita que el programa tire error si se intenta conectar más de una vez
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            
            db = FirestoreClient.getFirestore();
            System.out.println("✅ CONEXIÓN EXITOSA: Club Constitución está en la nube (Firebase).");
            
        } catch (Exception e) {
            System.out.println("❌ ERROR DE CONEXIÓN: " + e.getMessage());
            System.out.println("👉 Tip: Verifica que el archivo JSON esté en la carpeta raíz 'ad_club'.");
            e.printStackTrace();
        }
    }
}