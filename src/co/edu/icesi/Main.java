package co.edu.icesi;

public class Main {

    private Controller controller;

    public static void main(String[] args) {
        Main main = new Main();
        main.runBusiness();
    }

    public void runBusiness() {
        controller = new Controller();
    }
}
