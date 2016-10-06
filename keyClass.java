 import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
 
  public class keyClass extends JPanel implements Runnable{        
         scoreView sv;
         mapView mv;
         AL myAL;
      public class AL implements KeyListener{ 
         
         
         public void  keyPressed(KeyEvent e){
         //scoreView sv = new scoreView(0 ,0 ,0,4,5,true);
         //mapView mv = new mapView(4,5,sv);
         int keyCode = e.getKeyCode();             //user key pressed stored in keycode, used to compare with desired key
         
         if(keyCode == e.VK_LEFT){                 //if user presses left
          
            mv.guide(3);
            System.out.println("LEFT");
         }
         
          if(keyCode == e.VK_RIGHT){
          
            
            mv.guide(1); 
            System.out.println("RIGHT");
         }
         
          if(keyCode == e.VK_UP){
            
            mv.guide(0);
            System.out.println("UP");
                 
         }
         
          if(keyCode == e.VK_DOWN){
            
            mv.guide(2);
            System.out.println("DOWN");
         }
         
         
      }
      
      public void keyReleased(KeyEvent e){
                    //sets when key is released and stops movement (sets to 0) 
      }
         public void keyTyped(KeyEvent e){
         //System.out.println("Key Typed: " + e);
      }
   }
    public keyClass(mapView myMap, scoreView myScore){ 
        // System.out.println("In key constructor");
         mv= myMap;
         sv= myScore;
         myAL = new AL();
         addKeyListener(myAL);
         //getContentPane().add(myAL);
    }
    
       public void run(){
         //System.out.println("In run in keyclass");
      try {
         while(true){
          // System.out.println("In run in keyclass while loop");
           move(); 
            
            Thread.sleep(5);
         }
      }
      
      catch(Exception e){
         System.out.println("Error");
      }
   }
   
   public AL getAL(){
   
      return myAL;
   }
   
   public void move(){
   
      
   }
    }
    
    
      