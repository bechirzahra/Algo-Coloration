package Gui;

import Gui.GrapheGui.SommetGui;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
public class Coloration extends JFrame implements MouseListener {
    private static Coloration coloration = new Coloration();
    private GrapheGui graphe;
    
    
    public void mouseClicked(MouseEvent e){
	if(e.getButton()==MouseEvent.BUTTON1){
            SommetGui s=graphe.new SommetGui(graphe.size()+1,e.getPoint().x,e.getPoint().y);
	    graphe.ajouterSommet(s);
            coloration.getContentPane().add(s.dessine());
	}else if(e.getButton()==MouseEvent.BUTTON2){
	}else if(e.getButton()==MouseEvent.BUTTON3){
            graphe.colorier();
            graphe.dessine();
	}
    }
    public void 	mouseEntered(MouseEvent e){}
    public void 	mouseExited(MouseEvent e){}
    public void 	mousePressed(MouseEvent e){}
    public void 	mouseReleased(MouseEvent e){}
  
  public static void main(String s[]) {
    coloration.setResizable(false);
    coloration.addWindowListener(
			new WindowAdapter() {
            @Override
			    public void windowClosing(WindowEvent e) {
				System.exit(0);
			    }
			}
			);
    coloration.getContentPane().addMouseListener(coloration);
    coloration.setSize(new Dimension(800, 600));
    coloration.show();
    coloration.graphe=new GrapheGui(coloration.getGraphics(),coloration);
  }
}