
import java.awt.*;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

class dialog extends JDialog implements ActionListener {
        //tao Button OK
        JButton jb=new JButton("OK");
        //tao JPanel
        JPanel jp1=new JPanel();
        JPanel jp2=new JPanel(new GridLayout(3,1));
        JPanel jp3=new JPanel();
        ImageIcon img=new ImageIcon(this.getClass().getResource("/anime-3d-23.jpg"));
        //tao JLabel
        JLabel jlb1=new JLabel(img);
        JLabel jlb2=new JLabel("************Program Java to************");
        JLabel jlb3=new JLabel("****Dijkstra Algorithm Program Demo****");
        JLabel jlb4=new JLabel("***CopyWrite @2023 Edit by HieuOneplus***");
        //Tao Layout
        GridBagLayout gb=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
        private static final long serialVersionUID = 1L;
        public dialog(){
            setSize(300,200);
            setLayout(gb);
            jp1.add(jlb1);
            jp2.add(jlb2);
            jp2.add(jlb3);
            jp2.add(jlb4);
            jb.addActionListener(this);
            jp3.add(jb);
            gbc.fill=GridBagConstraints.EAST;
            addComponent(jp1,0,0,4,10);
            gbc.fill=GridBagConstraints.NORTHWEST;
            addComponent(jp2,0,10,3,15);
            gbc.fill=GridBagConstraints.NORTHWEST;
            addComponent(jp3,3,15,1,5);
            this.setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
            if(e.getSource()==jb){
                this.dispose();
            }
        }
        public void addComponent(Component c,int row,int col,int nrow,int ncol){
            gbc.gridy=row;// toa do y
            gbc.gridx=col;// toa do x
            gbc.gridheight=nrow;// so dong chiem
            gbc.gridwidth=ncol;// so cot chiem
            gb.setConstraints(c,gbc);
            add(c);
        }

    }
