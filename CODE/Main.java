package CODE;


public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Controller controller = new Controller();
        for (int i = 0; i <1 ; i=0) {
            int option = menu.getOption();
            controller.execute(option);
            menu.promptEnterKey();
        }
    }
}
