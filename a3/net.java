import java.awt.*;
import javax.swing.*;
import java.util.*;


public class net extends catcher{
   
      boolean capture = false;
   
   public net(int x, int y){
   
      super(x, y, 100, Color.BLACK);  
      
   }
   
   public void guide(int dir){
     int newY = y;
     int newX = x;
   System.out.println("Guide: " + x + " " + y + " " + newX + " " + newY);
     
     System.out.println(dir);
      if(dir == 0){  //up
         newY = y - 10;
      }else if(dir == 1){ //east
         newX = x +10;
      }else if (dir == 2){ //down
         newY = y + 10;
      }else if (dir == 3){ //west
         newX = x -10;
      }else{
         System.out.println(dir);
      }   
      //outOfBounds = (((newY - size/2) < 0 )|| ((newY + size/2) > 685) || ((newX - size/2) <0) || ((newX + size/2) > 700));
      if(newY < 0){
         newY = 0;
      }else if ((newY + size )>700){
         newY = 700 - size;
      }
      if(newX  <0){
         newX = 0;
      }else if ((newX + size )>685){
         newX = 685 - size;
      }
      x = newX;
      y = newY;
      System.out.println("Guide: " + x + " " + y + " " + newX + " " + newY);
    }
    
    public void captured(){
      capture =true;
      
    }
    
    public int getX(){
      return x;
    }
    public int getY(){
      return y;
      
    }
    
    public int getSize(){
      return size;
    }
         
      
   
   
   public void setSize(int size){
   
       this.size = size;
   }  
   
   public void paint(Graphics g){
      
      g.setColor(myColor);
      g.fillRect(x, y, size, size);
      
      if(capture){
         Graphics2D g2 = (Graphics2D)g;
         g2.setStroke(new BasicStroke(10));
         g.drawLine(x,y,x-(x/2),y -(y/2) );
         g.drawLine(x + size,y ,x+size + ((600 - x)/2),y -(y/2) );
         g.drawLine(x,y + size,x-(x/2),y + size + (600 -y)/2);
         g.drawLine(x+size,y + size,x+size+(600 -x)/2,y +size +(600 - y)/2 );

         capture = false;
      } 
      
      
   }
 }  