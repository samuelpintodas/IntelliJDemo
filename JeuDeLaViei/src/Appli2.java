//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class Appli2 extends JPanel {
    public int[][] t = new int[20][20];
    public int x = 0;
    public int y = 0;
    public int[][] ve = new int[20][20];
    public int voisins = 0;
    public boolean confirm = false;
    public int[] tab = new int[2];
    public int c = 0;
    public int rr = 0;
    public boolean trace = false;

    public Appli2() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Appli2.this.t[e.getY() / 20][e.getX() / 20] = 1;
                Appli2.this.repaint();
            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
            }
        });
    }

    public void affiche(int[][] t, Graphics g) {
        for(int i = 0; i < t.length; ++i) {
            for(int j = 0; j < t[0].length; ++j) {
                if (t[i][j] == 0) {
                    g.setColor(Color.black);
                    g.fillRect(this.x, this.y, 30, 30);
                    g.setColor(Color.white);
                    g.fillRect(this.x, this.y, 17, 17);
                }

                if (t[i][j] == 1) {
                    g.setColor(Color.black);
                    g.fillRect(this.x, this.y, 30, 30);
                    g.setColor(Color.blue);
                    g.fillRect(this.x, this.y, 17, 17);
                }

                this.x += 20;
            }

            this.x = 0;
            this.y += 20;
        }

        this.x = this.y = 0;
    }

    public void R() {
        for(int i = 0; i < 20; ++i) {
            for(int j = 0; j < 20; ++j) {
                this.confirm = false;
                int k;
                int h;
                if (i == 0 && j == 0 && !this.confirm) {
                    this.tab[0] = i;
                    this.tab[1] = j;
                    k = 0;

                    while(true) {
                        if (k >= 2) {
                            this.confirm = true;
                            this.eval();
                            break;
                        }

                        for(h = 0; h < 2; ++h) {
                            if (this.t[k][h] == 1) {
                                ++this.voisins;
                            }

                            if (this.t[k][h] == 1 && k == 0 && h == 0) {
                                --this.voisins;
                            }
                        }

                        ++k;
                    }
                }

                if (i == 0 && j == 19 && !this.confirm) {
                    this.tab[0] = i;
                    this.tab[1] = j;
                    k = 0;

                    while(true) {
                        if (k >= 1) {
                            this.confirm = true;
                            this.eval();
                            break;
                        }

                        for(h = 18; h < 20; ++h) {
                            if (this.t[k][h] == 1) {
                                ++this.voisins;
                            }

                            if (this.t[k][h] == 1 && h == 0 && k == 19) {
                                --this.voisins;
                            }
                        }

                        ++k;
                    }
                }

                if (i == 19 && j == 0 && !this.confirm) {
                    this.tab[0] = i;
                    this.tab[1] = j;
                    k = 18;

                    while(true) {
                        if (k >= 20) {
                            this.confirm = true;
                            this.eval();
                            break;
                        }

                        for(h = 0; h < 2; ++h) {
                            if (this.t[k][h] == 1) {
                                ++this.voisins;
                            }

                            if (this.t[k][h] == 1 && h == 0 && k == 19) {
                                --this.voisins;
                            }
                        }

                        ++k;
                    }
                }

                if (i == 19 && j == 19 && !this.confirm) {
                    this.tab[0] = i;
                    this.tab[1] = j;
                    k = 18;

                    while(true) {
                        if (k >= 20) {
                            this.confirm = true;
                            this.eval();
                            break;
                        }

                        for(h = 18; h < 20; ++h) {
                            if (this.t[k][h] == 1) {
                                ++this.voisins;
                            }

                            if (this.t[k][h] == 1 && h == 19 && k == 19) {
                                --this.voisins;
                            }
                        }

                        ++k;
                    }
                }

                if (i == 0 && !this.confirm) {
                    this.tab[0] = i;
                    this.tab[1] = j;
                    k = 0;

                    while(true) {
                        if (k >= 2) {
                            this.confirm = true;
                            this.eval();
                            break;
                        }

                        for(h = j - 1; h < j + 2; ++h) {
                            if (this.t[k][h] == 1) {
                                ++this.voisins;
                            }

                            if (this.t[k][h] == 1 && k == i && h == j) {
                                --this.voisins;
                            }
                        }

                        ++k;
                    }
                }

                if (i == 19 && !this.confirm) {
                    this.tab[0] = i;
                    this.tab[1] = j;
                    k = 18;

                    while(true) {
                        if (k >= 20) {
                            this.confirm = true;
                            this.eval();
                            break;
                        }

                        for(h = j - 1; h < j + 2; ++h) {
                            if (this.t[k][h] == 1) {
                                ++this.voisins;
                            }

                            if (this.t[k][h] == 1 && h == j && k == i) {
                                --this.voisins;
                            }
                        }

                        ++k;
                    }
                }

                if (j == 0 && !this.confirm) {
                    this.tab[0] = i;
                    this.tab[1] = j;
                    k = i - 1;

                    while(true) {
                        if (k >= i + 2) {
                            this.confirm = true;
                            this.eval();
                            break;
                        }

                        for(h = 0; h < 2; ++h) {
                            if (this.t[k][h] == 1) {
                                ++this.voisins;
                            }

                            if (this.t[k][h] == 1 && h == j && k == i) {
                                --this.voisins;
                            }
                        }

                        ++k;
                    }
                }

                if (j == 19 && !this.confirm) {
                    this.tab[0] = i;
                    this.tab[1] = j;
                    k = i - 1;

                    while(true) {
                        if (k >= i + 2) {
                            this.confirm = true;
                            this.eval();
                            break;
                        }

                        for(h = 18; h < 20; ++h) {
                            if (this.t[k][h] == 1) {
                                ++this.voisins;
                            }

                            if (this.t[k][h] == 1 && h != j && k != i) {
                                --this.voisins;
                            }
                        }

                        ++k;
                    }
                }

                if (!this.confirm) {
                    this.tab[0] = i;
                    this.tab[1] = j;

                    for(k = i - 1; k < i + 2; ++k) {
                        for(h = j - 1; h < j + 2; ++h) {
                            if (this.t[k][h] == 1) {
                                ++this.voisins;
                            }

                            if (this.t[k][h] == 1 && k == i && h == j) {
                                --this.voisins;
                            }
                        }
                    }

                    this.eval();
                    this.confirm = true;
                }
            }
        }

    }

    public void eval() {
        switch(this.voisins) {
            case 2:
                this.ve[this.tab[0]][this.tab[1]] = this.t[this.tab[0]][this.tab[1]];
                break;
            case 3:
                this.ve[this.tab[0]][this.tab[1]] = 1;
                break;
            default:
                this.ve[this.tab[0]][this.tab[1]] = 0;
        }

        this.voisins = 0;
    }

    public void thor() {
        int i;
        int j;
        for(i = 0; i < 20; ++i) {
            for(j = 0; j < 20; ++j) {
                System.out.print(this.t[i][j]);
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println("THEN");
        System.out.println();

        for(i = 0; i < 20; ++i) {
            for(j = 0; j < 20; ++j) {
                System.out.print(this.ve[i][j]);
            }

            System.out.println();
        }

    }

    public void remet() {
        for(int i = 0; i < 20; ++i) {
            for(int j = 0; j < 20; ++j) {
                this.t[i][j] = this.ve[i][j];
            }
        }

    }

    public void paintComponent(Graphics g) {
        ++this.c;
        this.affiche(this.t, g);
        this.R();
    }
}
