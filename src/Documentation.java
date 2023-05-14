
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
        doc.addItem("draw nodes");
        doc.addItem("remove nodes");
        doc.addItem("move nodes");
        doc.addItem("the startnode");
        doc.addItem("draw arrows");
        doc.addItem("change weights");
        doc.addItem("remove arrows");
        doc.addItem("clear / reset");
        doc.addItem("run algorithm");
        doc.addItem("step through");
        doc.addItem("example");
        doc.addItem("about");
        doc.addItem("exit");
        doc.addItem("all items");
        add(doc);
    }

    public boolean action(Event evt, Object arg) {
        //Ham xu ly Choice
        if (evt.target instanceof Choice) {
            String str=new String(doc.getSelectedItem());
            parent.doctext.showline(str);
        }
        return true;
    }
}
class DocText extends TextArea {
    //TextDocumentation huong dan cho cac Choice va JButton
    final String drawnodes = new String("DRAWING NODES:\n"+
            "Draw a node by clicking the mouse on the screen application.\n\n");

    final String rmvnodes = new String("REMOVE NODES:\n"+
            "To remove a node press <ctrl> and click on the node.\n"+ "You can not remove the startnode.\n"+ "Select another startnode, then you can remove the node.\n\n");

    final String mvnodes = new String("MOVING NODES\n"+
            "To move a node press <Shift>, click on the node,\nand drag it  to"+  " its new position.\n\n");

    final String startnode = new String("STARTNODE:\n"+
            "The startnode is blue, other nodes are grey.\n"+ "The first node you draw on the screen will be the startnode.\n"+ "To select another startnode press <ctrl>, click on the startnode,\n"+
            "and drag the mouse to another node.\n"+ "To delete the startnode, first select another startnode, and then"+ "\nremove the node the usual way.\n\n");

    final String drawarrows = new String("DRAWING ARROWS:\n"+
            "To draw an arrow click mouse in a node,"+
            "and drag it to another node.\n\n");

    final String weight = new String("CHANGING WEIGHTS:\n"+
            "To change the weight of an arrow, click on the arrowhead and drag\n"+ "it along the arrow.\n\n");

    final String rmvarrows = new String("REMOVE ARROWS:\n"+
            "To remove an arrow, change its weight to 0.\n\n");

    final String clrreset = new String("<CLEAR> BUTTON: "+
            "Remove the current graph from the screen.\n"+
            "<RESET> BUTTON: "+
            "Remove the results of the algorithm from the graph,\n"+
            " and unlock screen.\n\n");

    final String runalg = new String("<RUN> BUTTON: "+
            "Run the algorithm on the graph, there will be a time\n" + "delay of +/- 1 second between steps.\n"+ "To run the algorithm slower, use <STEP>.\n");

    final String step = new String("<STEP> BUTTON: " +
            "An opportunity to step through the algorithm.\n");

    final String example = new String("<EXAMPLE> BUTTON: "+
            "Displays a default graph on the screen for you.\n"+ "You can then use <STEP> or <RUN>\n");

    final String exitbutton = new String("<EXIT> BUTTON: " +
            "Only works if applet is run with appletviewer.\n");

    final String aboutbutton = new String("<ABOUT> BUTTON: " +
            "Show about Dijkstra program information.\n");

    final String toclose = new String("ERROR: "+
            "This position is to close to another node/arrow.\n");

    final String done = new String("Algorithm has finished, " +
            "follow green arrows from startnode to any node "+ "to get\nthe shortest path to " +
            "the node. The length of the path is written in the node.\n" +
            "press <RESET> to reset the graph, and unlock the screen.");

    final String some = new String("Algorithm has finished, " +
            "follow green arrows from startnode to any node "+
            "to get\nthe shortest path to " +
            "the node. The length of the path is written in the node.\n" +
            "There are no paths from the startnode to any gray node.\n" +
            "press <RESET> to reset the graph, and unlock the screen.");
    final String none = new String("Algorithm has finished, " +
            "there are no nodes reachable from the start node.\n"+
            "press <RESET> to reset the graph, and unlock the screen.");

    final String maxnodes = new String("ERROR: "+
            "Maximum number of nodes reached!\n\n");

    final String info = new String("DOCUMENTATION:\n"+
            "You can scroll through the documentation or get documentation\n"+
            "on a specific "+
            "item by selecting the item on the left.\nSelecting <All items> "+
            "brings you back "+
            " to the scrolling text.\n\n");

    final String locked = new String("ERROR: "+
            "Keyboard/mouse locked for this action.\n"+
            "Either press <NEXT STEP> or <RESET>.\n");
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
        if (str.equals("draw nodes")) setText(drawnodes);
        else if (str.equals("remove nodes")) setText(rmvnodes);
        else if (str.equals("move nodes")) setText(mvnodes);
        else if (str.equals("the startnode")) setText(startnode);
        else if (str.equals("draw arrows")) setText(drawarrows);
        else if (str.equals("change weights")) setText(weight);
        else if (str.equals("remove arrows")) setText(rmvarrows);
        else if (str.equals("clear / reset")) setText(clrreset);
        else if (str.equals("run algorithm")) setText(runalg);
        else if (str.equals("step through")) setText(step);
        else if (str.equals("example")) setText(example);
        else if (str.equals("exit")) setText(exitbutton);
        else if (str.equals("about"))
            setText(aboutbutton);
        else if (str.equals("all items")) setText(doc);
        else if (str.equals("toclose")) setText(toclose);
        else if (str.equals("done")) setText(done);
        else if (str.equals("locked")) setText(locked);
        else if (str.equals("maxnodes")) setText(maxnodes);
        else if (str.equals("none")) setText(none);
        else if (str.equals("some")) setText(some);
        else setText(str);
    }
}
