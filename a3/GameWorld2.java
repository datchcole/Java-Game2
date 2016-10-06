import java.awt.*;
import java.util.*;
import javax.swing.*;

class GameWorld2 extends Observable {
   mapView myMapView;
   
   public GameWorld2(mapView mv){
   
      myMapView = mv;
      
   }
   

           public void expandNet(){
            System.out.println("Expanding the net");
            //connect to actionlistener, for assn 2 just have it display message on gui
            
         }     
         public void contractNet(){
            System.out.println("Contracting the net");
         }
         public void scoop(){
            System.out.println("Scooping");
         }
         public void rightNet(){
            System.out.println("Moving net right");
            myMapView.guide(1);
         }
         public void leftNet(){
            System.out.println("Moving net left");
            myMapView.guide(3);
            
         }
         public void upNet(){
           // System.out.println("Moving net up");
            myMapView.guide(0);
         }
         public void downNet(){
            System.out.println("Moving net down");
            myMapView.guide(2);
         }
     
         public void kittens(){
            System.out.println("Creating kittens");
         }
    
         public void fight(){
            System.out.println("Fight!");
         }

         public void tick(){
            
            System.out.println("Time ticked");
         }
 
         public void printPoints(){
            System.out.println("Print Points");
         }
  
         public void map(){
            System.out.println("Display Map");
         }

         public void quit(){
            System.out.println("Quit");
         }
    
    
    
}