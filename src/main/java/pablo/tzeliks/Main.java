package pablo.tzeliks;

import pablo.tzeliks.service.EstoqueService;
import pablo.tzeliks.view.ConsoleController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EstoqueService service = new EstoqueService();

        ConsoleController inicio = new ConsoleController(service);

        inicio.iniciar();
    }
}