
import java.awt.Button;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Panel;

public class Options extends Panel {
    private static final long serialVersionUID = 1L;
    // Dat cac Options ben trai man hinh ung dung
    Button b1 = new Button("Clear");
    Button b2 = new Button("Run");
    Button b3 = new Button("Step");
    Button b4 = new Button("Reset");
    Button b5 = new Button("Example");
    Button b6 = new Button("Exit");
    Button b7 = new Button("About");
    GraphAlgorithm parent;
    boolean Locked=false;

    Options(GraphAlgorithm myparent) {
        parent = myparent;
        setLayout(new GridLayout(7, 1, 0, 10));
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b7);
        add(b6);
    }
    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Button) {
            //Neu la JButton "Step" va Unlock thi thuc hien buoc dau tien va hien thi "Nextstep" len JButton,
            //nguoc lai thi khong thuc hien
            if (((String)arg).equals("Step")) {
                if (!Locked) {
                    b3.setLabel("Next step");
                    parent.graphcanvas.stepalg();
                }
                else parent.documentation.doctext.showline("locked");
            }

            //Neu la JButton "Nextstep" thi thuc hien buoc tiep thep
            if (((String)arg).equals("Next step")){
                parent.graphcanvas.nextstep();
            }

            //Neu la JButton "Reset" thi thuc hien reset
            if (((String)arg).equals("Reset")) {
                parent.graphcanvas.reset();
                b3.setLabel("Step");
                parent.documentation.doctext.showline("all items");
            }

            //Neu la JButton "Clear" thi xoa graphics
            if (((String)arg).equals("Clear")) {
                parent.graphcanvas.clear();
                b3.setLabel("Step");
                parent.documentation.doctext.showline("all items");
            }

            //Neu la JButton "Run" va Unlock thi thuc hien tung buoc mac dinh
            //nguoc lai thi khong thuc hien
            if (((String)arg).equals("Run")) {
                if (!Locked)
                    parent.graphcanvas.runalg();
                else parent.documentation.doctext.showline("locked");
            }

            //Neu la JButton "Example" va Unlock thi thuc hien default graphics
            //nguoc lai thi khong thuc hien
            if (((String)arg).equals("Example")) {
                if (!Locked)
                    parent.graphcanvas.showexample();
                else parent.documentation.doctext.showline("locked");
            }

            //Neu la JButton "About" thi hien thi dialog About
            if(((String)arg).equals("About")){
                dialog dig = new dialog();
            }

            //Neu la JButton "Exit" thi thoat khoi chuong trinh
            if (((String)arg).equals("Exit")) {
                System.exit(0);
            }
        }
        return true;
    }

    public void lock() {
        Locked=true;
    }
    public void unlock() {
        Locked=false;
        b3.setLabel("Step");
    }
}
