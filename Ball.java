public class Ball{
   public double x, y, xSpeed, ySpeed, speed, mass, angle;
   public int size;
   
   public Ball(double x, double y){
      this.x=x;
      this.y=y;
      xSpeed=0;
      ySpeed=0;
      speed=0;
      mass=0;
      angle=0;
      size=0;
   }

   public void setXandYSpeed(){
      xSpeed=speed*Math.cos(Math.toRadians(angle));
      ySpeed=speed*Math.sin(Math.toRadians(angle));
   }  
   
   public double updatedSpeed(){
      return Math.sqrt(Math.pow(xSpeed,2)+Math.pow(ySpeed,2));
   }
   public double updatedAngle(){        
   
      if(xSpeed==0&&ySpeed==0)
         return 0;
      else if(xSpeed==0&&ySpeed>0)
         return 90;
      else if(xSpeed==0&&ySpeed<0)
         return 270;
      else if(xSpeed<0)
         return Math.toDegrees(Math.atan((ySpeed)/(xSpeed))) +180;
      else if(ySpeed<0&&xSpeed>0)
         return Math.toDegrees(Math.atan((ySpeed)/(xSpeed))) +360;
      else
         return Math.toDegrees(Math.atan((ySpeed)/(xSpeed)));  
   }
   
   
   
   
   public void ballCollisionBounce(Ball b2) {             

      double newSpdX1= (this.xSpeed * (this.mass - b2.mass) + (2 * b2.mass * b2.xSpeed)) / (this.mass + b2.mass);
      double newSpdX2= (b2.xSpeed * (b2.mass - this.mass) + (2 * this.mass * this.xSpeed)) / (this.mass + b2.mass);
      double newSpdY1= (this.ySpeed * (this.mass - b2.mass) + (2 * b2.mass * b2.ySpeed)) / (this.mass + b2.mass);
      double newSpdY2= (b2.ySpeed * (b2.mass - this.mass) + (2 * this.mass * this.ySpeed)) / (this.mass + b2.mass);
   		
      this.xSpeed = newSpdX1;
      b2.xSpeed = newSpdX2;
      this.ySpeed = newSpdY1;
      b2.ySpeed = newSpdY2;
                
      this.x+= 2*newSpdX1;
      this.y+= 2*newSpdY1;
      b2.y+= 2*newSpdX2;
      b2.y+= 2*newSpdY2;
   
   }
   public boolean circlesTouching(Ball b2){
      double distance = Math.sqrt(Math.pow(((this.x) -(b2.x)),2) + (Math.pow(((this.y) - (b2.y)),2)));
   
      if (distance<=(this.size+b2.size))   
         return true;
      else
         return false;
   }
       
   public void move(){
      x += xSpeed/20;
            //negative because jframe coordinates are backwards for y
      y -= ySpeed/20;
      if (x >= 900-size && xSpeed > 0){ 
         x=900-size;
         xSpeed = -xSpeed;
      }
      if (x <= size && xSpeed < 0) {
         x=size;
         xSpeed = -xSpeed;
      }
      if (y >= 450-size && ySpeed < 0) {
         y=450-size;
         ySpeed = -ySpeed;
      }
      if (y <= size && ySpeed > 0) {
         y=size;
         ySpeed = -ySpeed;
      }
   
      
   }
}

   
   
