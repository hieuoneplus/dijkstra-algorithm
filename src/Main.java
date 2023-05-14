import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        GraphAlgorithm graphAlgorithm = new GraphAlgorithm();

        JFrame frame = new JFrame("My App");
        frame.add(graphAlgorithm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Do something after the window is displayed
        doSomething();
    }

    public static void doSomething() {
        // Do something here
    }
}
