/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukk_spp;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JDesktopPane;
/**
 *
 * @author MyPC
 */
public class background extends JDesktopPane {
    private Image image;
    
    public background(){
    
}

@Override
    protected void paintComponent(Graphics g){
        try{
            image = new javax.swing.ImageIcon(getClass().getResource("bg2.jpg")).getImage();
            
            if(g !=null){
                g.drawImage(image,
                        (this.getSize().width - image.getWidth(null))/2,
                        (this.getSize().height - image.getHeight(null))/2,
                        null);
            }
        }catch(NullPointerException npe){
            System.out.println("Can't find images !!");
        }
    }
    
}