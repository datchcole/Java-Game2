import java.awt.*;
import java.util.*;
import java.lang.*;

public abstract class animal implements iMoveable{  //imoving//////////

   protected Color myColor;
   protected int x;          //x location
   protected int y;          //y location
   protected final int size;
   protected int speed = 5;      //might be floating point
   protected int direction;  //might be delta x/y

   public animal (int x, int y, int size, Color myColor){
      this.x = x;
      this.y = y;
      this.size = size;
      this.myColor = myColor;
      Random myRand = new Random();
      direction = myRand.nextInt(360);
   }
   
   public abstract void paint(Graphics g);
     
   public int getX(){
      return x;
   }
   
   public int getY(){
   
      return y;
   }
   
   public int getSize(){
      return size;
   }   
   
   public abstract animal Collision(animal a);
      
      
   
   
   public void move(){

      boolean outOfBounds = true;
      Random rand = new Random();
      int newX=0;
      int newY=0; 
      while (outOfBounds){
           // System.out.println("Animal Move");  
            //System.out.println(speed);    
      double angleInRadians = (Math.toRadians((double)direction));
      double sinOfDirection = Math.sin(angleInRadians);
      double cosOfDirection = Math.cos(angleInRadians);
      double deltaX = (double)speed * cosOfDirection;
      double deltaY = (double)speed * sinOfDirection; 
      newX = (int)((double)x + deltaX);
      newY = (int)((double)y + deltaY);  
     //System.out.println(newX +" " + newY+ " " + x + " " + y);
           
      outOfBounds = ((newX < 50) || (newX > 754))||((newY < 50) || (newY > 685));
      if (outOfBounds){
         direction = rand.nextInt(360);
      }
      
    }
    x = newX;
    y = newY;  
    //System.out.println("In AnimalMove" + "X: "+ x + "Speed: "+  speed);  
   
   }               
}    