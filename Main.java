public class Main {

    // Ya no necesitamos este método, la lógica pasa al main.
    // public static void startEventProcessing(View view) { ... }

    public static void main(String[] args) {
        // 1. Crear
        Model model = new Model(); // <-- Esto imprime [Model] 0
        View view1 = new View("1ST");
        View view2 = new View("2ND");
        Controller controller1 = new Controller("1ST");
        Controller controller2 = new Controller("2ND");

        // 2. "Cablear"
        view1.setController(controller1);
        view2.setController(controller2);
        
        view1.setModel(model);
        view2.setModel(model);

        controller1.setModel(model);
        controller2.setModel(model);

        // 3. Registrar observadores
        // El orden sigue siendo CRUCIAL
        model.addObserver(view1);
        model.addObserver(view2);
        model.addObserver(controller2);
        model.addObserver(controller1);

        // 4. Iniciar (EL GRAN CAMBIO ESTÁ AQUÍ)
        // Reemplazamos startEventProcessing(view1) por la secuencia explícita:

        // Evento 1
        view1.onIncreaseTap(); // -> Imprime [View/Controller] 1
        model.printCurrentState(); // -> Imprime [Model] 1

        // Evento 2
        view1.onIncreaseTap(); // -> Imprime [View/Controller] 2
        model.printCurrentState(); // -> Imprime [Model] 2

        // Evento 3
        view1.onDecreaseTap(); // -> Imprime [View/Controller] 1
        model.printCurrentState(); // -> Imprime [Model] 1

        // Evento 4
        view1.onIncreaseTap(); // -> Imprime [View/Controller] 2
        model.printCurrentState(); // -> Imprime [Model] 2

        // Evento 5
        view1.onIncreaseTap(); // -> Imprime [View/Controller] 3
        // NO llamamos a printCurrentState() después del último evento.
    }
}