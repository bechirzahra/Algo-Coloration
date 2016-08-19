/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gui;

import DSatur.GrapheDSat;
import Graphe.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author bechir
 */
public class GrapheGui extends GrapheDSat{
    private Graphics graphics;
    private static boolean cliqueSurSommet=false;
    private static SommetGui sommetClique;
    public static final Color[] couleurs={Color.gray,Color.red,Color.blue,Color.yellow,Color.PINK,Color.magenta,Color.black};
    private JFrame applet;
    
    public GrapheGui(Graphics g,JFrame jf){
        applet=jf;
        graphics=g;
    }
    public void dessine(){
        
        if (this.sommets.size()==0) {
            JOptionPane.showMessageDialog(null, "Graphe vide!","Alert", JOptionPane.ERROR_MESSAGE);
    
        }
        else
        {
        
            Iterator<Sommet> itsommets=this.getSommets().iterator();
       
        
        while(itsommets.hasNext()){
            
            SommetGui sommet=(SommetGui)itsommets.next();
            sommet.jpanel.update(sommet.jpanel.getGraphics());
            
        }
        }
    }
  
    class SommetGui extends Sommet implements MouseListener{
        private int x;
        private int y;
        private JPanel jpanel=new JPanel(){
            @Override
            public void paint(Graphics g){
                g.setColor(couleurs[getCouleur()]);
                g.fillOval(0, 0, 40, 40);
                g.setColor(Color.WHITE);
                g.drawString(getNumero()+"", 0+20, 0+20);
            }

        };


        SommetGui(int nbr,int x,int y) {
            super(nbr,0);
            this.x=x;
            this.y=y;
        }
        public JPanel dessine(){
            applet.getContentPane().add(jpanel);
            jpanel.setBounds(x, y, 40, 40);
            jpanel.setOpaque(false);
            jpanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jpanel.addMouseListener(SommetGui.this);
            jpanel.paint(jpanel.getGraphics());
            return jpanel;
        }
        public void mouseClicked(MouseEvent e) {
            if(cliqueSurSommet){
                ArretGui a=new ArretGui(sommetClique, this);
                if(GrapheGui.this.ajouterArret(a))
                {
                    applet.getContentPane().add(a.dessine());
                }
                cliqueSurSommet=false;
                
            }else{
                sommetClique=this;
                cliqueSurSommet=true;
            }
        }

        public void mousePressed(MouseEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet.");
            this.setCouleur(2);
            this.jpanel.update(jpanel.getGraphics());
        }

        public void mouseReleased(MouseEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet.");
            this.setCouleur(0);
            this.jpanel.update(jpanel.getGraphics());
        }

        public void mouseEntered(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    class ArretGui extends Arret{
         private JPanel jpanel=new JPanel(){
            @Override
            public void paint(Graphics g){
                g.setColor(couleurs[0]);
                SommetGui _1=(SommetGui) ArretGui.this.get_1();
                SommetGui _2=(SommetGui) ArretGui.this.get_2();
                int w=Math.abs(_2.x-_1.x);
                int h=Math.abs(_2.y-_1.y);
                if(_1.x<_2.x){
                    if(_1.y<_2.y)
                        g.drawLine(0, 0, w, h);
                    else
                        g.drawLine(0,h,w ,0 );
                }else
                    if(_1.y>_2.y)
                        g.drawLine(0, 0, w, h);
                    else
                        g.drawLine(0,h,w ,0 );


            }

        };

        ArretGui(SommetGui _1,SommetGui _2){
            super(_1,_2);
        }
        public JPanel dessine(){
            applet.getContentPane().add(jpanel);
            jpanel.setOpaque(false);
            jpanel.paint(jpanel.getGraphics());
            SommetGui _1=(SommetGui) ArretGui.this.get_1();
            SommetGui _2=(SommetGui) ArretGui.this.get_2();
            int x,y,w=Math.abs(_2.x-_1.x),h=Math.abs(_2.y-_1.y);

             if(_1.x<_2.x){
                 x=_1.x;
                 if(_1.y<_2.y)
                     y=_1.y;
                 else
                     y=_2.y;
                }else{
                    x=_2.x;
                    if(_1.y>_2.y)
                        y=_2.y;
                    else
                        y=_1.y;
                }
            jpanel.setBounds(x+20, y+20,w, h);
            return jpanel;
        }
    }
}

