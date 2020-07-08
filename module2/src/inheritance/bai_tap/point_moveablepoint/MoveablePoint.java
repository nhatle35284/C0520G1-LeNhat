package inheritance.bai_tap.point_moveablepoint;

public class MoveablePoint extends Point{
    float xSpeed ;
    float ySpeed ;

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x,y);
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed,float ySpeed) {
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed(){
        float[] array={xSpeed,ySpeed};
        return array;
    }

    @Override
    public String toString() {
        return "x is: "+super.getX()+"\n"+
                "y is: "+super.getY()+"\n"+
                "Speed x: "+xSpeed+"\n"+"speed y"+ySpeed;
    }
    public MoveablePoint move() {
       super.x+=xSpeed;
       super.y+=ySpeed;
       return this;
    }
}
