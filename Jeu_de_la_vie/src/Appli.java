import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;




public class Appli extends JFrame{
	public Appli2 p  = new Appli2() ;
	
	private JPanel container = new JPanel();
	private JTextField jtf  ;
	public Thread t ;
	
	public Appli(){
		this.setTitle("Jeu de La Vie");
	    this.setSize(410, 430);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    // this.setResizable(false); 
	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	    container.add(p, BorderLayout.CENTER);
	    
	    
	   // setIconImage(new ImageIcon(this.getClass().getResource("images/BlackKnight.png")).getImage());
	    jtf = new JTextField();
	    
	    JPanel south = new JPanel();
	    south.add(jtf);
       
	    jtf.setPreferredSize(new Dimension(0, 0));
	    jtf.addKeyListener(new ClavierListener());
	    container.add(south , BorderLayout.SOUTH);
	     this.setContentPane(container);
	     this.setVisible(true);
	   //  game();
	}
	
	public void game (){
		while(true){
			p.repaint() ;
			dort() ;
			p.remet();
			
		}
	}
	public void dort(){
		 try {
	            Thread.sleep(100);
	          } catch (InterruptedException e) {
	            e.printStackTrace();
	          }	
	}
	
	class ClavierListener implements KeyListener{
		   
	    public void keyPressed(KeyEvent event) {
	     if(event.getKeyCode() == 65){
	    	 for(int i = 0 ; i < 20 ; i++){
	    		 for(int j = 0 ; j < 20 ; j++){
	    			p.t[i][j]  = 0 ;
	    			p.repaint() ;
	    		 } 
	    	 }
	     }
	     if(event.getKeyCode() == 66){
	    	  t = new Thread (new P());
	    	  t.start();
	     }
	     if(event.getKeyCode() == 67){
	    	 t.stop();
	    	 
	     }
	     
	           
	     //System.out.println("Code touche pressée : " + event.getKeyCode() + " - caractère touche pressée : " + event.getKeyChar());
	      
	    }

	          public void keyReleased(KeyEvent event) {
	     /* System.out.println("Code touche relâchée : " + event.getKeyCode() + " - caractère touche relâchée : " + event.getKeyChar());         
	      pause();*/           
	    } 

	    public void keyTyped(KeyEvent event) {
	     /* System.out.println("Code touche tapée : " + event.getKeyCode() + " - caractère touche tapée : " + event.getKeyChar());
	      pause();*/   
	    }   	
	  } 
	
	class P implements Runnable {
		public void run(){
			game() ;
		}
	}
	
	
	public static void main(String[] args) {
	Appli a = new Appli() ;
	}

}
