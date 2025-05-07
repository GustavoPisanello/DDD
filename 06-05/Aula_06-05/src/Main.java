import controller.UsuarioController;
import view.UsuarioView;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UsuarioView view = new UsuarioView();
        UsuarioController controller = new UsuarioController(view);

        controller.cadastrarUsuario();
    }
}