import java.util.Scanner;

// MODEL
class Model {

    public String getData(int id) {

        // Simulating data obtained from database
        if (id == 101) {
            return "ID: 101, Name: Arun, Email: arun@gmail.com";
        }

        if (id == 102) {
            return "ID: 102, Name: Priya, Email: priya@gmail.com";
        }

        return "User not found";
    }
}

// VIEW
class View {

    public void display(String data) {

        System.out.println("\n----- USER DETAILS -----");
        System.out.println(data);
    }
}

// CONTROLLER
class Controller {

    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View();
    }

    public void processRequest(int id) {

        // Controller requests data from Model
        String data = model.getData(id);

        // Controller sends data to View
        view.display(data);
    }
}

// MAIN APPLICATION
public class MVCExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        int id = sc.nextInt();

        // Create Controller
        Controller controller = new Controller();

        // Send request to Controller
        controller.processRequest(id);

        sc.close();
    }
}