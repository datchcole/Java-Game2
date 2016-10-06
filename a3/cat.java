import java.awt.*;
import javax.swing.*;
import java.util.*;

public class cat extends animal {
   
  Random myRand = new Random();    
   
   public cat(int x, int y, int size){
   
      super(x, y, size, Color.BLUE);  
      
   }
   
      public animal Collision(animal a){
      //System.out.println(a.getClass().getName());
      if(a.getClass().getName().equals("cat")){
         int newX = 600 - x;
         int newY = 600 - y;
         if(newX < 0){
            newX = newX + 200;
         }
         if(newY < 0){
            newY = newY + 200;
         }
         
         cat newCat = new cat(newX,newY,size);
         
         a.direction = myRand.nextInt(360);
         direction = a.direction -180;
         if(direction < 0){
            direction = direction + 360;
         }
         move();
         move();
         move();
         a.move();
         a.move();
         a.move();
         
         return newCat;
         
      }
      if(a.getClass().getName().equals("dog")){
         Random myRand = new Random();
         direction = myRand.nextInt(360);
         
      }   
      
      return null;
   }
   
   public void paint(Graphics g){
      
        
      int xpoints[] = {x, (int)(x + size * 0.86),(int)( x - size * 0.86)};
      int ypoints[] = {(y+ size),(int)(y - size * 0.5), (int)(y - size * 0.5)};
      int npoint = 3;
      g.setColor(myColor);
      g.fillPolygon(xpoints, ypoints,npoint);
      
   }
 }  
 
   //int xpoints[] = {x - size, (int)(x + size * 0.86),(int)( x + size * 0.86)};
   //int ypoints[] = {y,(int)(y - size * 0.5), (int)(y + size * 0.5)};