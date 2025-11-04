// Archivo: Main.java
import javax.swing.SwingUtilities; // <-- IMPORTANTE

public class Main {
    public static void main(String[] args) {
        
        // --- INICIO: CORRECCIÓN DE HILO (EDT) ---
        // Todo código de Swing (UI) debe correr en el "Event Dispatch Thread".
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // El código original ahora va aquí dentro
                Model model = new Model();
        
                // 1. CREA EL PRIMER CONTADOR (de 1 en 1)
                View view = new View("1ST");
                view.initialize(model);
                
                // 2. CREA EL SEGUNDO CONTADOR (de 2 en 2)
                View view2 = new TwiceView("2ND"); 
                view2.initialize(model);
            }
        });
        // --- FIN: CORRECCIÓN DE HILO (EDT) ---
    }
}