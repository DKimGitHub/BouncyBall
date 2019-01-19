import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.* ;

public class BallCollision extends JFrame implements ChangeListener, ActionListener {
                   

   AnimationPanel ap;
   JSlider spdSlid1, massSlid1, angSlid1, sizeSlid1, spdSlid2, massSlid2, angSlid2, sizeSlid2;
   JTextField spdText1, massText1, angText1, sizeText1, spdText2, massText2, angText2, sizeText2; 
   JRadioButton fricOn, fricOff;
   ButtonGroup fricGroup;
   JButton start, pause, reset;
   JPanel fricPanel, ball1Panel, ball2Panel, ballsLabel;
   int size1=25, size2=25;
   double x1=110, y1=110, x2=790, y2=340;
   double speed1, mass1, angle1, speed2, mass2, angle2, xSpeed1, ySpeed1, xSpeed2, ySpeed2;
   boolean started=false, paused=true, friction;
   
   public BallCollision() {
      super("Ball Collision");  
      ap = new AnimationPanel();
      ap.setPreferredSize(new Dimension(900,450)); 
      
      spdSlid1 = new JSlider( JSlider.HORIZONTAL, 0, 100, 0);
      spdSlid1.setMajorTickSpacing( 10 );
      spdSlid1.setMinorTickSpacing(  5 );
      spdSlid1.setPaintTicks( true );
      spdSlid1.setPaintLabels( true );
      spdSlid1.setPreferredSize( new Dimension(300,50) ) ;
      spdSlid1.addChangeListener( this );
      spdSlid1.setName("spdSlid1"); 
      spdText1 = new JTextField( 4 );
      spdText1.setText( spdSlid1.getValue() + " " );
   
      massSlid1= new JSlider( JSlider.HORIZONTAL, 0, 100, 0);
      massSlid1.setMajorTickSpacing( 10 );
      massSlid1.setMinorTickSpacing(  5 );
      massSlid1.setPaintTicks( true );
      massSlid1.setPaintLabels( true );
      massSlid1.setPreferredSize( new Dimension(300,50) ) ;
      massSlid1.addChangeListener( this );
      massSlid1.setName("massSlid1"); 
      massText1 = new JTextField( 4 );
      massText1.setText( massSlid1.getValue() + " " );
   
      angSlid1 = new JSlider( JSlider.HORIZONTAL, 0, 360, 0);
      angSlid1.setMajorTickSpacing( 90 );
      angSlid1.setMinorTickSpacing(  30 );
      angSlid1.setPaintTicks( true );
      angSlid1.setPaintLabels( true );
      angSlid1.setPreferredSize( new Dimension(300,50) ) ;
      angSlid1.addChangeListener( this );
      angSlid1.setName("angSlid1"); 
      angText1 = new JTextField( 4 );
      angText1.setText( angSlid1.getValue() + " " );
      
      sizeSlid1 = new JSlider( JSlider.HORIZONTAL, 0, 100, 25);
      sizeSlid1.setMajorTickSpacing( 10 );
      sizeSlid1.setMinorTickSpacing(  5 );
      sizeSlid1.setPaintTicks( true );
      sizeSlid1.setPaintLabels( true );
      sizeSlid1.setPreferredSize( new Dimension(300,50) ) ;
      sizeSlid1.addChangeListener( this );
      sizeSlid1.setName("sizeSlid1"); 
      sizeText1 = new JTextField( 4 );
      sizeText1.setText( sizeSlid1.getValue() + " " );
      
      ball1Panel= new JPanel();
      ball1Panel.setLayout( new FlowLayout());
      ball1Panel.add(new JLabel("Speed "));
      ball1Panel.add(spdText1);
      ball1Panel.add(spdSlid1);
      ball1Panel.add(new JLabel("Mass "));
      ball1Panel.add(massText1);
      ball1Panel.add(massSlid1);
      ball1Panel.add(new JLabel("Angle "));
      ball1Panel.add(angText1);
      ball1Panel.add(angSlid1);
      ball1Panel.add(new JLabel("Size "));
      ball1Panel.add(sizeText1);
      ball1Panel.add(sizeSlid1);
      ball1Panel.setPreferredSize(new Dimension(420,230));
   
      spdSlid2 = new JSlider( JSlider.HORIZONTAL, 0, 100, 0);
      spdSlid2.setMajorTickSpacing( 10 );
      spdSlid2.setMinorTickSpacing(  5 );
      spdSlid2.setPaintTicks( true );
      spdSlid2.setPaintLabels( true );
      spdSlid2.setPreferredSize( new Dimension(300,50) ) ;
      spdSlid2.addChangeListener( this );
      spdSlid2.setName("spdSlid2"); 
      spdText2 = new JTextField( 4 );
      spdText2.setText( spdSlid2.getValue() + " " );
   
      massSlid2= new JSlider( JSlider.HORIZONTAL, 0, 100, 0);
      massSlid2.setMajorTickSpacing( 10 );
      massSlid2.setMinorTickSpacing(  5 );
      massSlid2.setPaintTicks( true );
      massSlid2.setPaintLabels( true );
      massSlid2.setPreferredSize( new Dimension(300,50) ) ;
      massSlid2.addChangeListener( this );
      massSlid2.setName("massSlid2"); 
      massText2 = new JTextField( 4 );
      massText2.setText( massSlid2.getValue() + " " );
   
      angSlid2 = new JSlider( JSlider.HORIZONTAL, 0, 360, 0);
      angSlid2.setMajorTickSpacing( 90 );
      angSlid2.setMinorTickSpacing(  30 );
      angSlid2.setPaintTicks( true );
      angSlid2.setPaintLabels( true );
      angSlid2.setPreferredSize( new Dimension(300,50) ) ;
      angSlid2.addChangeListener( this );
      angSlid2.setName("angSlid2"); 
      angText2   = new JTextField( 4 );
      angText2.setText( angSlid2.getValue() + " " );   
            
      sizeSlid2 = new JSlider( JSlider.HORIZONTAL, 0, 100, 25);
      sizeSlid2.setMajorTickSpacing( 10 );
      sizeSlid2.setMinorTickSpacing(  5 );
      sizeSlid2.setPaintTicks( true );
      sizeSlid2.setPaintLabels( true );
      sizeSlid2.setPreferredSize( new Dimension(300,50) ) ;
      sizeSlid2.addChangeListener( this );
      sizeSlid2.setName("sizeSlid2"); 
      sizeText2 = new JTextField( 4 );
      sizeText2.setText( sizeSlid2.getValue() + " " );
      
      ball2Panel= new JPanel();
      ball2Panel.setLayout( new FlowLayout());
      ball2Panel.add(new JLabel("Speed "));
      ball2Panel.add(spdText2);
      ball2Panel.add(spdSlid2);
      ball2Panel.add(new JLabel("Mass "));
      ball2Panel.add(massText2);
      ball2Panel.add(massSlid2);
      ball2Panel.add(new JLabel("Angle "));
      ball2Panel.add(angText2);
      ball2Panel.add(angSlid2);
      ball2Panel.add(new JLabel("Size "));
      ball2Panel.add(sizeText2);
      ball2Panel.add(sizeSlid2);
      ball2Panel.setPreferredSize(new Dimension(420,230));
      
      fricOn = new JRadioButton("ON", false );
      fricOn.setActionCommand( "fricOn" );
      fricOn.addActionListener( this );
      fricOff = new JRadioButton("OFF", true );
      fricOff.setActionCommand( "fricOff" );
      fricOff.addActionListener( this );
      fricGroup = new ButtonGroup();
      fricGroup.add( fricOn );  
      fricGroup.add( fricOff );
      fricPanel = new JPanel();
      fricPanel.setLayout( new BoxLayout( fricPanel, BoxLayout.X_AXIS ) );
      fricPanel.add( new JLabel("Friction") );
      fricPanel.add( fricOn ); 
      fricPanel.add( fricOff );
   
      ballsLabel= new JPanel();
      ballsLabel.setLayout( new BorderLayout() );
      ballsLabel.add( new JLabel("                                                                                                Ball 1 (Red)                                                                                                                         Ball 2 (Blue)"), BorderLayout.NORTH);
      ballsLabel .setPreferredSize(new Dimension(1000,20));
      
      start= new JButton("START");
      start.setActionCommand("start");
      start.addActionListener(this);
      
      pause = new JButton("PAUSE");
      pause.setActionCommand("pause");
      pause.addActionListener(this);
            
      reset= new JButton("RESET");
      reset.setActionCommand("reset");
      reset.addActionListener(this);
      
      setLayout( new FlowLayout() );
      add(ballsLabel);
      add(ball1Panel);
      add(ball2Panel);
      add(fricPanel); 
      add(start);
      add(pause);
      add(reset);
      add(ap);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setResizable(false);
      setSize(1000, 800);
      setLocation(300, 50); 
   }
   private class AnimationPanel extends JPanel {
        
      public void paintComponent(Graphics g){
         Graphics2D g2d = (Graphics2D) g;
         super.paintComponent(g);
         g2d.setColor(Color.white);
         g2d.fillRect(0,0, 900, 450);
         g2d.setColor(Color.red);
         g2d.fillOval((int)Math.round(x1-size1),(int)Math.round(y1-size1),size1*2,size1*2);
         g2d.setColor(Color.blue);
         g2d.fillOval((int)Math.round(x2-size2),(int)Math.round(y2-size2),size2*2,size2*2);
         repaint();
      }
   }

   public void actionPerformed( ActionEvent evt) {      
   
      if (evt.getActionCommand().equals("start")){
        // if(started!=true){
            started=true;
            
            xSpeed1=speed1*Math.cos(Math.toRadians(angle1));
            ySpeed1=speed1*Math.sin(Math.toRadians(angle1));
            xSpeed2=speed2*Math.cos(Math.toRadians(angle2));
            ySpeed2=speed2*Math.sin(Math.toRadians(angle2));
      //   }      
      }
      
      if (evt.getActionCommand().equals("pause")){
         
         started=false;

         speed1=Math.sqrt(Math.pow(xSpeed1,2)+Math.pow(ySpeed1,2));
         spdSlid1.setValue((int)Math.round(speed1));
         spdText1.setText(spdSlid1.getValue() + " " );
         
         angle1=Math.toDegrees(Math.atan((ySpeed1)/(xSpeed1)));
         if(xSpeed1==0&&ySpeed1==0)
            angle1=0;
         if(xSpeed1==0&&ySpeed1>0)
            angle1=90;
         if(xSpeed1==0&&ySpeed1<0)
            angle1=270;
         if(xSpeed1<0)
            angle1+=180;
         if(ySpeed1<0&&xSpeed1>0)
            angle1+=360;
      
         angSlid1.setValue((int)Math.round(angle1));
         angText1.setText(angSlid1.getValue() + " " );
              
         
         speed2=Math.sqrt(Math.pow(xSpeed2,2)+Math.pow(ySpeed2,2));
         spdSlid2.setValue((int)Math.round(speed2));
         spdText2.setText(spdSlid2.getValue() + " " );
         
         angle2=Math.toDegrees(Math.atan((ySpeed2)/(xSpeed2)));
         if(xSpeed2==0&&ySpeed2==0)
            angle2=0;
         if(xSpeed2==0&&ySpeed2>0)
            angle2=90;
         if(xSpeed2==0&&ySpeed2<0)
            angle2=270;
         if(xSpeed2<0)
            angle2+=180;
         if(ySpeed2<0&&xSpeed2>0)
            angle2+=360;
      
         angSlid2.setValue((int)Math.round(angle2));
         angText2.setText(angSlid2.getValue() + " " );   
      }
      
      if(evt.getActionCommand().equals("reset")){
         started=false;
         x1=110;
         y1=110;
         x2=790; 
         y2=340;
         
      }
      if (evt.getActionCommand().equals("fricOn")){
         friction=true;
      }
            
      if (evt.getActionCommand().equals("fricOFf")){
         friction=false;
      }
   }
   
   
   
   public void stateChanged( ChangeEvent evt ){
      JSlider source;
      source = (JSlider)evt.getSource();
    
      if ( source.getName().equals("spdSlid1") ){
         speed1=source.getValue();
         spdText1.setText( source.getValue() + " " );
      }
      
      if ( source.getName().equals("massSlid1") ){
         mass1=source.getValue();
         massText1.setText( source.getValue() + " " );
      }
      if ( source.getName().equals("angSlid1") ){
         angle1=source.getValue();
         angText1.setText( source.getValue() + " " );
      }
            if ( source.getName().equals("sizeSlid1") ){
         size1=source.getValue();
         sizeText1.setText( source.getValue() + " " );
      }
                  if ( source.getName().equals("sizeSlid2") ){
         size2=source.getValue();
         sizeText2.setText( source.getValue() + " " );
      }
      if ( source.getName().equals("spdSlid2") ){
         speed2=source.getValue();
         spdText2.setText( source.getValue() + " " );
      }
      if ( source.getName().equals("massSlid2") ){
         mass2=source.getValue();
         massText2.setText( source.getValue() + " " );
      }
      if ( source.getName().equals("angSlid2") ){
         angle2=source.getValue();
         angText2.setText( source.getValue() + " " );
      }
   }
   public void ballCollisionBounce() {                
      double newSpdX1= (xSpeed1 * (mass1 - mass2) + (2 * mass2 * xSpeed2)) / (mass1 + mass2);
      double newSpdX2= (xSpeed2 * (mass2 - mass1) + (2 * mass1 * xSpeed1)) / (mass1 + mass2);
      double newSpdY1= (ySpeed1 * (mass1 - mass2) + (2 * mass2 * ySpeed2)) / (mass1 + mass2);
      double newSpdY2= (ySpeed2 * (mass2 - mass1) + (2 * mass1 * ySpeed1)) / (mass1 + mass2);
   		
      xSpeed1 = newSpdX1;
      xSpeed2 = newSpdX2;
      ySpeed1 = newSpdY1;
      ySpeed2 = newSpdY2;
                
      x1+= newSpdX1;
      y1+= newSpdY1;
      x2+= newSpdX2;
      y2+= newSpdY2;
   
   }
         
   public boolean circlesTouching(){
      double distance = Math.sqrt(Math.pow((x1 -x2),2) + (Math.pow((y1 - y2),2)));
   
      if (distance<=(size1+size2))   
         return true;
      else
         return false;
   }
   private void update(){
      
      while(true){
         try {    
            Thread.sleep(1);
         }
         catch (Exception exc){ 
            exc.printStackTrace();
         }
         if(started==true){
            x1 += xSpeed1/20;
            //negative because jframe coordinates are backwards for y
            y1 -= ySpeed1/20;
            if (x1 >= 900-size1 && xSpeed1 > 0){ 
               x1=900-size1;
               xSpeed1 = -xSpeed1;
            }
            if (x1 <= size1 && xSpeed1 < 0) {
               x1=size1;
               xSpeed1 = -xSpeed1;
            }
            if (y1 >= 450-size1 && ySpeed1 < 0) {
               y1=450-size1;
               ySpeed1 = -ySpeed1;
            }
            if (y1 <= size1 && ySpeed1 > 0) {
               y1=size1;
               ySpeed1 = -ySpeed1;
            }
            x2 += xSpeed2/20;
            
            //negative because jframe coordinates are backwards for y
            y2 -= ySpeed2/20;
            if (x2 >= 900-size2 && xSpeed2 > 0) {
               xSpeed2 = -xSpeed2;
               while(x2>900-size2){
                  x2=900-size2;
               
               }
            }
            if (x2 <= size2 && xSpeed2 < 0) {
               while(x2<size2)
                  x2=size2;
               xSpeed2 = -xSpeed2;
            }
            if (y2 >= 450-size2 && ySpeed2 < 0) {
               while(y2<450-size2)
                  y2=450-size2;
               ySpeed2 = -ySpeed2;
            }
            if (y2 <= size2 && ySpeed2 > 0){
               while(y2<size2)
                  y2=size2;
               ySpeed2 = -ySpeed2;
            }
            if(circlesTouching()==true){
               ballCollisionBounce();
            }

          
         }
      }
   }
  
   public static void main ( String[] args ){
      BallCollision test = new BallCollision();
     test.update();
     // Ball b1=new Ball(110,100);
     // Ball b2=new Ball(790,430);
     // b1.update(b2);
      
   
   }
}