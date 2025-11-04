// Archivo: Main.java
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        
        // 1. CREA EL PRIMER CONTADOR (de 1 en 1)
        View view = new View("1ST");
        view.initialize(model);
        
        // 2. CREA EL SEGUNDO CONTADOR (de 2 en 2, con lógica especial)
        View view2 = new TwiceView("2ND"); 
        view2.initialize(model);
    }
}