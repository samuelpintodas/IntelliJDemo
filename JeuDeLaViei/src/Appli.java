//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Appli extends JFrame {
    public Appli2 p = new Appli2();
    private JPanel container = new JPanel();
    private JTextField jtf;
    public Thread t;

    public Appli() {
        this.setTitle("Jeu de La Vie");
        this.setSize(410, 430);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.container.setBackground(Color.white);
        this.container.setLayout(new BorderLayout());
        this.container.add(this.p, "Center");
        this.jtf = new JTextField();
        JPanel south = new JPanel();
        south.add(this.jtf);
        this.jtf.setPreferredSize(new Dimension(0, 0));
        this.jtf.addKeyListener(new Appli.ClavierListener());
        this.container.add(south, "South");
        this.setContentPane(this.container);
        this.setVisible(true);
    }

    public void game() {
        while(true) {
            this.p.repaint();
            this.dort();
            this.p.remet();
        }
    }

    public void dort() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Appli();
    }

    class ClavierListener implements KeyListener {
        ClavierListener() {
        }

        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == 65) {
                for(int i = 0; i < 20; ++i) {
                    for(int j = 0; j < 20; ++j) {
                        Appli.this.p.t[i][j] = 0;
                        Appli.this.p.repaint();
                    }
                }
            }

            if (event.getKeyCode() == 66) {
                Appli.this.t = new Thread(Appli.this.new P());
                Appli.this.t.start();
            }

            if (event.getKeyCode() == 67) {
                Appli.this.t.stop();
            }

        }

        public void keyReleased(KeyEvent event) {
        }

        public void keyTyped(KeyEvent event) {
        }
    }

    class P implements Runnable {
        P() {
        }

        public void run() {
            Appli.this.game();
        }
    }
}
