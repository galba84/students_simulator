package CODE;

import static java.lang.System.exit;

public class Controller {

    static Services services = new Services();

    public void execute(int option) {
        switch (option) {
            case 1:
                intitializeUniver();
                break;
            case 2:
                printUniwStructure();
                break;
            case 3:
                performElection();
                break;
            case 4:
                rollCall();
                break;
            case 5:
                System.out.println("Good bye!");
                exit(0);
        }
    }

    private void intitializeUniver() {
        services.setUniver();
    }

    private void printUniwStructure() {
        if (services.isUnivFound()) {
            services.printUnivStructure();
        } else {
            System.out.println("Univer is not found yet. Please establish it first");
            System.out.println("");
        }
    }

    private void performElection() {
        if (services.isUnivFound()) {
            services.orginizeElection();
        } else {
            System.out.println("Univer is not found yet. Please establish it first");
            System.out.println("");
        }
    }

    private void rollCall() {
        if (services.isUnivFound()) {
            services.studentsRollCall();
        } else {
            System.out.println("Univer is not found yet. Please establish it first");
            System.out.println("");
        }
    }
}




