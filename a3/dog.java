import java.awt.*;
import javax.swing.*;
import java.util.*;

public class dog extends animal{
   
  static  ArrayList<Color> dogColors =new ArrayList<Color>(); 
   int colorIndex = 0;
   Random myRand = new Random();
   int moveToggle = 1;
   public dog(int x, int y, int size){
   
      super(x, y, size, Color.YELLOW);  
      dogColors.add(Color.YELLOW);
      dogColors.add(Color.BLUE);
      dogColors.add(Color.DARK_GRAY);
   }
   
public animal Collision(animal a){
      
      direction = myRand.nextInt(360);
    
      
      
      a.direction = direction - 180;
      if( a.direction < 0){
         a.direction += 360;
      }
               move();
         move();
         move();
         a.move();
         a.move();
         a.move();


      if(a.getClass().getName().equals("cat")){
     if(colorIndex < dogColors.size()){
       
       myColor = dogColors.get(colorIndex);
      ++colorIndex;
      
      
     }
      return null;//change points
   }
   
   

   return null;
}
   
   public void paint(Graphics g){
      moveToggle =- moveToggle;
      g.fillOval(x, y, size, size);
      g.fillOval((int)(x+ .3*size +moveToggle*(.1*size) - .5 *size), (int)(y+ .3*size- .5 *size), (int)(.4*size) , (int)(.4 * size) ); //top left foot
      g.fillOval((int)(x+ .3*size -moveToggle*(.1*size) + .5 *size), (int)(y+ .3*size- .5 *size), (int)(.4*size) , (int)(.4 * size) );  //top right foot
      g.fillOval((int)(x+ .3*size +moveToggle*(.1*size) - .5 *size), (int)(y+ .3*size + .5 *size), (int)(.4*size) , (int)(.4 * size) );  //bottom left foot
      g.fillOval((int)(x+ .3*size -moveToggle*(.1*size) + .5 *size), (int)(y+ .3*size  + .5 *size), (int)(.4*size) , (int)(.4 * size) );  //bottom right foot
      g.fillRect((int)(x+ .3*size - .7*size),(int)( y+ .3*size),(int)( .4*size), (int)(.4*size));  //head
      g.setColor(myColor);
   }
 }  