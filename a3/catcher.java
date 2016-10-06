import java.awt.*;

public abstract class catcher /*implements iGuided*/

{   //iguided

  protected Color myColor;
   protected int x;          //x location
   protected int y;          //y location
   protected int size;
   protected int speed;      //might be floating point


   public catcher (int x, int y, int size, Color myColor){
      this.x = x;
      this.y = y;
      this.size = size;
      this.myColor = myColor;
   }
   
   public abstract void paint(Graphics g);
   //public void guide(String direction);
      
   

   
   
}    