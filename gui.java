import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static KBManipulation.KBmanipulation.capsLockRandomize;


public class gui implements ActionListener {
    private boolean trigger;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private String strButton="Start flaming";
    private SwingWorker worker;
    JButton button=new JButton(strButton);
    public gui(){
        frame=new JFrame();
        button.addActionListener(this);
        label=new JLabel();
        panel=new JPanel();

        //panel.setBorder(BorderFactory.createEmptyBorder(50,50,20,50));
        //panel.setLayout(new GridLayout(5,1));
        try {
            BufferedImage myPicture = ImageIO.read(new File("assets/main.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            //picLabel.setMinimumSize(new Dimension(500,500));
            panel.add(picLabel);
        }
        catch (IOException exception){}
        Color c = new Color(133, 23, 1);
        JPanel secondPanel = new JPanel();
        secondPanel.setBackground(c);
        secondPanel.add(button);
        panel.setBackground(c);
        frame= new JFrame();
        //frame.setLayout(new BorderLayout(50,50));
        //panel.setMinimumSize(new Dimension(500,500));

        frame.add(panel,BorderLayout.CENTER);
        frame.add(secondPanel,BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("flame keyboard");
        frame.pack();
        frame.setVisible(true);

    }
//231527
    public void jButtonActionPerformed(java.awt.event.ActionEvent evt) {
        trigger=!trigger;
        strButton=trigger?"Start flaming":"stop flaming";
        if (getWorker().getState().equals(SwingWorker.StateValue.STARTED)) {
            worker.cancel(true);
            worker = null;
        } else {
            getWorker().execute();
        }
    }
    public static void main(String[] args){
        new gui();
    }
    private SwingWorker getWorker() {
        worker = worker == null ? worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                while (true) {
                    capsLockRandomize(Math.random()<0.5);
                    //if (Math.random()<0.5)
                        //switcChar(keyTyped());
                    Thread.sleep(100);
                }
            }
        } : worker;
        return worker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jButtonActionPerformed(e);
    }
}
