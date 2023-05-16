
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

class Documentation extends Panel {
    DocOptions docopt = new DocOptions(this);
    DocText doctext = new DocText();

    Documentation() {
        setLayout(new BorderLayout(10, 10));
        add("West", docopt);
        add("Center", doctext);
    }
}

class DocOptions extends Panel {
    //Tao Choice huong dan ben trai man hinh ung dung
    Choice doc = new Choice();
    Documentation parent;

    DocOptions(Documentation myparent) {
        setLayout(new GridLayout(2, 1, 5, 0));
        parent = myparent;
        add(new Label("DOCUMENTATION:"));
        doc.addItem("Draw Nodes");
        doc.addItem("Remove Nodes");
        doc.addItem("Move Nodes");
        doc.addItem("The Startnode");
        doc.addItem("Draw Arrows");
        doc.addItem("Change Weights");
        doc.addItem("Remove Arrows");
        doc.addItem("Clear / Reset");
        doc.addItem("Run Algorithm");
        doc.addItem("Step Through");
        doc.addItem("Example");
        doc.addItem("About");
        doc.addItem("Exit");
        doc.addItem("All Items");
        add(doc);
    }

    public boolean action(Event evt, Object arg) {
        //Ham xu ly Choice
        if (evt.target instanceof Choice) {
            String str = doc.getSelectedItem();
            parent.doctext.showline(str);
        }
        return true;
    }
}

class DocText extends TextArea {
    //TextDocumentation huong dan cho cac Choice va JButton
    final String drawnodes = """
            DRAWING NODES:
            Draw a node by clicking the mouse on the screen application.

            """;

    final String rmvnodes = """
            REMOVE NODES:
            To remove a node press <ctrl> and click on the node.
            You can not remove the startnode.
            Select another startnode, then you can remove the node.

            """;

    final String mvnodes = """
            MOVING NODES
            To move a node press <Shift>, click on the node,
            and drag it  to its new position.

            """;

    final String startnode = """
            STARTNODE:
            The startnode is blue, other nodes are grey.
            The first node you draw on the screen will be the startnode.
            To select another startnode press <ctrl>, click on the startnode,
            and drag the mouse to another node.
            To delete the startnode, first select another startnode, and then
            remove the node the usual way.

            """;

    final String drawarrows = """
            DRAWING ARROWS:
            To draw an arrow click mouse in a node,and drag it to another node.

            """;

    final String weight = """
            CHANGING WEIGHTS:
            To change the weight of an arrow, click on the arrowhead and drag
            it along the arrow.

            """;

    final String rmvarrows = """
            REMOVE ARROWS:
            To remove an arrow, change its weight to 0.

            """;

    final String clrreset = """
            <CLEAR> BUTTON: Remove the current graph from the screen.
            <RESET> BUTTON: Remove the results of the algorithm from the graph,
             and unlock screen.

            """;

    final String runalg = """
            <RUN> BUTTON: Run the algorithm on the graph, there will be a time
            delay of +/- 1 second between steps.
            To run the algorithm slower, use <STEP>.
            """;

    final String step = "<STEP> BUTTON: " +
            "An opportunity to step through the algorithm.\n";

    final String example = """
            <EXAMPLE> BUTTON: Displays a default graph on the screen for you.
            You can then use <STEP> or <RUN>
            """;

    final String exitbutton = "<EXIT> BUTTON: " +
            "Only works if applet is run with appletviewer.\n";

    final String aboutbutton = "<ABOUT> BUTTON: " +
            "Show about Dijkstra program information.\n";

    final String toclose = "ERROR: " +
            "This position is to close to another node/arrow.\n";

    final String done = """
            Algorithm has finished, follow green arrows from startnode to any node to get
            the shortest path to the node. The length of the path is written in the node.
            press <RESET> to reset the graph, and unlock the screen.""";

    final String some = """
            Algorithm has finished, follow green arrows from startnode to any node to get
            the shortest path to the node. The length of the path is written in the node.
            There are no paths from the startnode to any gray node.
            press <RESET> to reset the graph, and unlock the screen.""";
    final String none = "Algorithm has finished, " +
            "there are no nodes reachable from the start node.\n" +
            "press <RESET> to reset the graph, and unlock the screen.";

    final String maxnodes = """
            ERROR: Maximum number of nodes reached!

            """;

    final String info = """
            DOCUMENTATION:
            You can scroll through the documentation or get documentation
            on a specific item by selecting the item on the left.
            Selecting <All items> brings you back  to the scrolling text.

            """;

    final String locked = """
            ERROR: Keyboard/mouse locked for this action.
            Either press <NEXT STEP> or <RESET>.
            """;
    final String doc = info + drawnodes + rmvnodes + mvnodes +
            startnode + drawarrows + weight + rmvarrows +
            clrreset + runalg + step + example + aboutbutton +
            exitbutton;

    DocText() {
        super(5, 2);
        setEditable(false);
        setText(doc);
    }

    public void showline(String str) {
        switch (str) {
            case "Draw Nodes" -> setText(drawnodes);
            case "Remove Nodes" -> setText(rmvnodes);
            case "Move Nodes" -> setText(mvnodes);
            case "The Startnode" -> setText(startnode);
            case "Draw Arrows" -> setText(drawarrows);
            case "Change Weights" -> setText(weight);
            case "Remove Arrows" -> setText(rmvarrows);
            case "Clear / Reset" -> setText(clrreset);
            case "Run Algorithm" -> setText(runalg);
            case "Step Through" -> setText(step);
            case "Example" -> setText(example);
            case "Exit" -> setText(exitbutton);
            case "About" -> setText(aboutbutton);
            case "All Items" -> setText(doc);
            case "toclose" -> setText(toclose);
            case "done" -> setText(done);
            case "locked" -> setText(locked);
            case "maxnodes" -> setText(maxnodes);
            case "none" -> setText(none);
            case "some" -> setText(some);
            default -> setText(str);
        }
    }
}
