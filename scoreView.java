import java.util.*;
import java.awt.*;
import javax.swing.*;


public class scoreView extends JPanel implements Observer{

   int totalPoints =0;
   int dogsCaptured =0;
   int catsCaptured = 0;
   int dogsRemaining = 0;
   int catsRemaining = 0;
   boolean soundCheck = true;
   JPanel panel = new JPanel();
   
   
   
   public scoreView(int points, int dCaptured, int cCaptured, int dRemaining, int cRemaining, boolean soundC){
      
        this.panel = panel; 
        totalPoints = points;
        dogsCaptured = dCaptured;
        catsCaptured = cCaptured;
        dogsRemaining = dRemaining;
        catsRemaining = cRemaining;
        soundCheck = soundC;
   }
   public JPanel scorePanel(){

      JPanel scoreViewLabels = new JPanel(new GridLayout(7,1));
      scoreViewLabels.setBorder(BorderFactory.createLineBorder(Color.green));
      JLabel  pointsLabel= new JLabel("Total Points: " + totalPoints);
      JLabel capturedDLabel = new JLabel("Dogs Captured: "+ dogsCaptured);
      JLabel capturedCLabel = new JLabel("Cats Captured: "+catsCaptured);
      JLabel remainingDLabel = new JLabel("Dogs Remaining: " +dogsRemaining);
      JLabel remainingCLabel = new JLabel("Cats Remaining: " + catsRemaining);

      
      
      
      scoreViewLabels.add(pointsLabel);
      scoreViewLabels.add(capturedDLabel);
      scoreViewLabels.add(capturedCLabel);
      scoreViewLabels.add(remainingDLabel);
      scoreViewLabels.add(remainingCLabel);
      
      return scoreViewLabels;
  
 }     
        public JPanel getPanel(){
      
         return panel;
      }  
   
   
  public void update(Observable obs, Object obj){
      
         System.out.println("test");
         repaint();
   }
   
   public void setPoints(int totalPoints){
      this.totalPoints = totalPoints;
   }
   
   public void setDogsCaptured(int dogsCaptured){
      this.dogsCaptured = dogsCaptured;
   }
   
   public void setCatsCaptured(int catsCaptured){
      this.catsCaptured = catsCaptured;
   }
   
   public void setDogsRemaining(int dogsRemaining){
      this.dogsRemaining = dogsRemaining;
   }
   
   public void setCatsRemaining(int catsRemaining){
      this.catsRemaining = catsRemaining;
   }
   
   public void setSound (boolean soundCheck){
      this.soundCheck = soundCheck;
   }
   
   public int getPoints(){
      return totalPoints;
   }
   
   public int getDogsCaptured(){
      return dogsCaptured;
   }
   
   public int getCatsCaptured(){
      return catsCaptured;
   }
   
   public int getDogsRemaining(){
      return dogsRemaining;
   }
   
   public int getCatsRemaining(){
      return dogsRemaining;
   }
   
   public boolean getSound(){
      return soundCheck;
   } 
        
   
   }