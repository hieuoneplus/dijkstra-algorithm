import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        GraphAlgorithm graphAlgorithm = new GraphAlgorithm();

        JFrame frame = new JFrame("My App");
        frame.add(graphAlgorithm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
