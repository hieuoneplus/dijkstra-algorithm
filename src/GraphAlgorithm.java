import javax.swing.JPanel;
import java.awt.BorderLayout;

public class GraphAlgorithm extends JPanel {
    GraphCanvas graphcanvas = new GraphCanvas(this); //Graphics Dijkstra
    Options options = new Options(this); //Option
    Documentation documentation = new Documentation(); //document instruction

    // Hàm khởi tạo
    public GraphAlgorithm() {
        setLayout(new BorderLayout(10, 10));
        add(graphcanvas, BorderLayout.CENTER);
        add(documentation, BorderLayout.NORTH);
        add(options, BorderLayout.EAST);
    }

    // Hàm Lock
    public void lock() {
        graphcanvas.lock();
        options.lock();
    }

    // Hàm Unlock
    public void unlock() {
        graphcanvas.unlock();
        options.unlock();
    }
}
