import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

import java.awt.*;


class Game extends JFrame implements KeyListener, ActionListener  {
   private GameWorld2 gw;
   private scoreView sv;
   private mapView mv;
   private java.util.Timer myTimer;
   JFrame frame = new JFrame("Game");
   String soundString = "";  
   JPanel panel = new JPanel();
   JButton expandButton = new JButton("Expand Net");
   JButton shrinkButton = new JButton("Shrink Net");
   JButton scoopButton = new JButton("Scoop");
   JButton moveRightButton = new JButton("Move Right");
   JButton moveLeftButton = new JButton("Move Left");
   JButton moveDownButton = new JButton("Move Down");
   JButton upButton = new JButton("Move Up");
   JButton kittenButton = new JButton("Kitten Collision");
   JButton fightButton = new JButton("Cat/Dog Fight");
   JButton tickButton = new JButton("Tick");
   String soundStatus = "";
   JLabel soundOption2 = new JLabel("Sound: OFF"); 
   JPanel mapViewPanel;
   JTextField textField = new JTextField(20); 
   //keyClass myKeyClass;
   
   
   public Game() {
   
          System.out.println("came back from game");
       class moveTask extends TimerTask{
     
      
      public void run(){
            
          Scanner input = new Scanner(System.in);
          
         // System.out.println("Moving in run");
          move(); 
          
                                                                                                                                        
         
      }
      }     
      
      
      java.util.Timer myTimer = new java.util.Timer();

                
      myTimer.schedule(new moveTask(), 100, 100);

      sv = new scoreView(0, 0, 0, 4, 5, true);
      mv = new mapView(4, 5, sv);
      //myKeyClass= new keyClass(mv, sv);
      gw = new GameWorld2(mv);
      gw.addObserver(sv); 
      gw.addObserver(mv);
      //frame.getContentPane().add(myKeyClass.getAL());
      //frame.add(myKeyClass);
      mv.initLayout();
      layout();
      //Thread t1 = new Thread(myKeyClass);
      //t1.start();
      
      
      
      
      
      
      play();
      
      
   }
   

   public void move(){
      mv.move();
      //System.out.println("Moved" + mapViewPanel.getSize());
      mapViewPanel.repaint();
      
   }
   public void actionPerformed(ActionEvent e){
      textField.setText("");
      System.out.println("Action performed");
   }
   public void keyTyped(KeyEvent e){
    System.out.println("Key Typed: " + e);
   }
   public void keyPressed(KeyEvent e){
   System.out.println("Key Prssed: " + e);
   }
      public void keyReleased(KeyEvent e){
      
               int keyCode = e.getKeyCode();             //user key pressed stored in keycode, used to compare with desired key
         
         if(keyCode == e.VK_LEFT){                 //if user presses left
          
            mv.guide(3);
         }
         
          if(keyCode == e.VK_RIGHT){
           System.out.println("Key Released: " + e);
            
            mv.guide(1); 
         }
         
          if(keyCode == e.VK_UP){
            
            mv.guide(0);
                 
         }
         
          if(keyCode == e.VK_DOWN){
            
            mv.guide(2);
         }
  
   }
   
  
      
      
   public void layout(){
      frame.setLayout(new BorderLayout());
      panel.setLayout(new BorderLayout());
      JPanel buttons = new JPanel(new GridLayout(10,1));
      JPanel scorePanel = new JPanel(new GridLayout(6,1));
      scorePanel.add(sv.scorePanel());


      mapViewPanel=new JPanel(new GridLayout(1,1));
      mapViewPanel.setBorder(BorderFactory.createLineBorder(Color.red));
      
           
      JPanel menuPanel = new JPanel();
      mapViewPanel.add(mv);
      
     
      ///////buttons/////////

       
      buttons.add(expandButton);
      buttons.add(shrinkButton);
      buttons.add(scoopButton);
      buttons.add(moveRightButton);
      moveRightButton.addActionListener(
      new rightListener(){
      public void actionPerformed(ActionEvent e){
         
           //code to move net right
           mv.guide(1);
           mapViewPanel.repaint();
         }
      }
      ); 
      buttons.add(moveLeftButton);
      moveLeftButton.addActionListener(
      new leftListener(){
      public void actionPerformed(ActionEvent e){
         
                              //user key pressed stored in keycode, used to compare with desired key
         
        //code to move net left
           mv.guide(3);
           mapViewPanel.repaint();
         }
         
      }
      ); 
      buttons.add(upButton);
      upButton.addActionListener(
      new upListener(){
         public void actionPerformed(ActionEvent e){
         
           //code to move net up
           mv.guide(0);
           mapViewPanel.repaint();
         }
      }
      );   
      
      buttons.add(moveDownButton);
      moveDownButton.addActionListener(
      new downListener(){
      public void actionPerformed(ActionEvent e){
         
           //code to move net down
           mv.guide(2);
           mapViewPanel.repaint();
         }
      }
      ); 
      buttons.add(kittenButton);
      buttons.add(fightButton);
      buttons.add(tickButton);
      
      panel.add(buttons, BorderLayout.WEST);  
     
     

      ///////menus/////////////
      
      JMenuBar menuBar = new JMenuBar();
  
      JMenu fileMenu = new JMenu("Files");
      menuBar.add(fileMenu);
      JMenuItem newOption = new JMenuItem("New");
      fileMenu.add(newOption);
      JMenuItem saveOption = new JMenuItem("Save");
      fileMenu.add(saveOption);
      JMenuItem undoOption = new JMenuItem("Undo");
      fileMenu.add(undoOption);

      JCheckBoxMenuItem soundCheckers = new JCheckBoxMenuItem("Sound");
      
       
      ActionListener actionListener = new ActionListener (){
         public void actionPerformed(ActionEvent actionEvent){
            AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
            boolean selected = abstractButton.getModel().isSelected();
            System.out.println(selected);
            if(selected == true){
               soundOption2.setText("Sound: ON");
            }else{
               soundOption2.setText("Sound OFF");
            }
         }
      };
      
      soundCheckers.addActionListener(actionListener);
       
      fileMenu.add(soundCheckers);
      JLabel soundStatus = new JLabel("Sound: OFF" + soundString);
      
      
      scorePanel.add(soundOption2);
      
            panel.add(scorePanel, BorderLayout.EAST);
      panel.add(mapViewPanel, BorderLayout.CENTER);
      frame.add(panel);

      
      JMenuItem aboutOption = new JMenuItem("About");
      
      aboutOption.addActionListener(
      new aboutListener(){
      public void actionPerformed(ActionEvent e){
         JOptionPane.showMessageDialog(null, "Name of Programmer: Nicole Greer" + '\n' + "Made For Course: CSC 133" + '\n' + "Program Version 2");
        
      }
      }
      );
      
      fileMenu.add(aboutOption);
     
      JMenu commandMenu = new JMenu("Commands");
      menuBar.add(commandMenu);
      /////jmenu command/////
      JMenuItem expandOption = new JMenuItem("Expand Net ('e')");
      commandMenu.add(expandOption);
      JMenuItem contractOption = new JMenuItem("Contract Net ('c')");
      commandMenu.add(contractOption);
      JMenuItem kittenOption = new JMenuItem("Kittens('k')");
      commandMenu.add(kittenOption);
      JMenuItem fightOption = new JMenuItem("Fight('f')");
      commandMenu.add(fightOption);
      JMenuItem quitOption = new JMenuItem("Quit('q')");

      
      quitOption.addActionListener(
      new closeListener(){
      public void actionPerformed(ActionEvent e){
         System.exit(0);
      }
     }
     );
      commandMenu.add(quitOption); 
      

      
      menuPanel.add(menuBar);
      panel.add(menuPanel, BorderLayout.NORTH);   //add menubar to frame not panel
      
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1024 ,1024);
      
      frame.setVisible(true);
      
      //frame.getContentPane().add(this);
      frame.setResizable(false);
      
   } 
     
   
   private void play() {
      System.out.println("Before getCommand");
      getCommand();
      System.out.println("After getCommand");
   }
   
   private void getCommand(){
      Scanner input = new Scanner(System.in);
        
   

      while (input.hasNext()){
         String myString = input.next();
      if(myString.equals("e")){
         gw.expandNet();
      }else if (myString.equals("c")){
         gw.contractNet();
      }else if (myString.equals("s")){
         gw.scoop();
      }else if (myString.equals("r")){
         gw.rightNet();
      }else if (myString.equals("l")){
         gw.leftNet();
      }else if(myString.equals("u")){
         gw.upNet();
      }else if (myString.equals("d")){
         gw.downNet();
      }else if (myString.equals("k")){
         gw.kittens();
      }else if (myString.equals("f")){
         gw.fight();
      }else if (myString.equals("t")){
         gw.tick();
      }else if (myString.equals("p")){
         gw.printPoints();
      }else if (myString.equals("m")){
         gw.map();
      }else if (myString.equals("q")){
         gw.quit();
      }else{
         System.out.println("Invalid command");
      }
     
   }
   
  }
   
 }
 
