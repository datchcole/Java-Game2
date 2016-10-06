import java.util.*;
import java.awt.*;
import javax.swing.*;


public class mapView extends JPanel implements Observer{
   ArrayList<animal> myAnimals = new ArrayList<animal>(); 
   ArrayList<net> myCatcher = new ArrayList<net>();
   Observer or;
   //gameObservable gObservable = new gameObservable();
   int numCats = 5;
   int numDogs = 4;
   int screenSize = 600;
     
   JPanel panel = new JPanel();
   
   public mapView(int numCats,int numDogs, JPanel panel){
   
   
      this.panel = panel;
      this.numCats = numCats;
      this.numDogs = numDogs;
      //gObservable.addObserver(or);
      //this.or = or;

       String catDogStatus = "cat = " + numCats + " Dog= " + numDogs ;
       //or.update(gObservable, (Object)catDogStatus);

   } 
     public void update(Observable obs, Object obj){
      
         repaint();
      
   }
      
       public JPanel getPanel(){
      
         return panel;
      }  
   

   
   public void initLayout(){
     
      Random myRandom = new Random();
      
      for (int i =0; i<numCats; ++i){ 
         //System.out.println(myAnimals.size());
         cat myCat = new cat(myRandom.nextInt(screenSize)+50,myRandom.nextInt(screenSize)+50, 50);
         myAnimals.add(myCat);
      }
      
      for (int i =0; i<numDogs; ++i){
      //System.out.println(myAnimals.size());
         dog myDog = new dog(myRandom.nextInt(screenSize)+50,myRandom.nextInt(screenSize)+50, 90);
         myAnimals.add(myDog);
      }
      
      net myNet = new net(myRandom.nextInt(screenSize)+50,myRandom.nextInt(screenSize)+50);
      myCatcher.add(myNet);
      
      
   }
   
   public void move(){
      
      for(animal myAnimal:myAnimals){
         //System.out.println("Moved in mapview");
         myAnimal.move();
      }
       ArrayList<animal> newAnimals = new ArrayList<animal>();
      
       for(int i =0; i < myAnimals.size(); ++i){
         animal myOtherAnimal = myAnimals.get(i);
            //System.out.println("Moved in mapview move2");

            int x = myOtherAnimal.getX();
            int y = myOtherAnimal.getY();
           
            for(int j =i; j < myAnimals.size(); ++j){
               animal myAnimal = myAnimals.get(j);
              // System.out.println("Moved in mapview move3" +i + " " + j);

               if(myAnimal != myOtherAnimal){
               int x2 = myAnimal.getX();
               int y2 = myAnimal.getY();
               double dist = Math.sqrt((double)((x - x2)*(x - x2) + (y - y2)*(y - y2)));
               int colDist = myOtherAnimal.getSize() + myAnimal.getSize();
               if(dist < colDist){
                 
                  
               animal newAnimal;   
                  newAnimal = myOtherAnimal.Collision(myAnimal);
                  if(newAnimal != null){
                     newAnimals.add(newAnimal);
                  }
                  
                  newAnimal = myAnimal.Collision(myOtherAnimal);
                  if(newAnimal != null){
                     newAnimals.add(newAnimal);
                  }
                }  
               }
            }
        }
       /* for(animal myNewAnimal:newAnimals){
         myAnimals.add(myNewAnimal);
        }
      */
     /* for(int i = 0; i <myAnimals.size(); i++){
         animal moveAnimal = myAnimals.get(i);
         moveAnimal.move();
         myAnimals.set(i, moveAnimal);
         //myAnimals.get(i).move();
         
      }*/   
      //System.out.println(myAnimals.get(0).x + " " + myAnimals.get(0).y);
   }
     public void guide(int dir){
         ArrayList<animal> deleteDogs = new ArrayList<animal>();
        for(net myCatch: myCatcher){
         myCatch.guide(dir);
        for(animal myAnimal:myAnimals){
         
         if(myAnimal.getClass().getName().equals("dog")){
         
         
         
            int x1 = myAnimal.getX();
            int y1 = myAnimal.getY();
           
            double dist = Math.sqrt((double)((myCatch.getX() - x1)*(myCatch.getX()- x1) + (myCatch.getY() - y1)*(myCatch.getY() - y1)));
            int colDist = myCatch.getSize() + myAnimal.getSize();
            if(dist < colDist){
               myCatch.captured();   
               deleteDogs.add(myAnimal);
            }
         
        }
       
       
        }
        
      }  
        for(animal myAnimal:deleteDogs){
            myAnimals.remove(myAnimal);
        }
        this.repaint();
     }
     
     
     
     public void paintComponent(Graphics g){
         
         for (int i =0; i < myAnimals.size(); ++i){
            myAnimals.get(i).paint(g);
         }
         
         for(int i = 0; i < myCatcher.size(); ++i){
            myCatcher.get(i).paint(g);
         }
   
   }

}