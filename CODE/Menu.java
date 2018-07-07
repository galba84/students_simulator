package CODE;

import java.util.Scanner;

public class Menu {

    public int getOption() {
        printMainMenuOptions();
        int option = chooseOption();
        if (validateOptionInput(option))
            return option;
        else wrongOption(option);
        getOption();
        return 0;
    }

    private void printMainMenuOptions() {
        System.out.println("    Welcome to Univercity");
        System.out.println("1 : initialize Univercity");
        System.out.println("2 : show Univercity structure");
        System.out.println("3 : elect TeamLeader");
        System.out.println("4 : rollCall Students");
        System.out.println("5 : exit program");
    }

    private int chooseOption() {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        if (scanner.hasNextInt()) {
            result = scanner.nextInt();
        }
        return result;
    }

    private boolean validateOptionInput(int option) {
        if ((option > 0) & (option < 6))
            return true;
        else return false;
    }

    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private void wrongOption(int option) {
        if (option == 0)
            System.out.println("you have pressed a wrong key");
        else
            System.out.println("you have chose a wrong option " + option + " which is out of range 1 to 5");
    }

}
