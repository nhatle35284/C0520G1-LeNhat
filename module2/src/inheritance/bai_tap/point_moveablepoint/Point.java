package inheritance.bai_tap.point_moveablepoint;

public class Point {
    float x;
    float y;
    public Point(float x,float y) {
        this.x=x;
        this.y=y;
    }
    public Point(){}

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x,float y) {
        this.x=x;
        this.y=y;
    }
    public float[] getXY(){
        float[] array={x,y};
        return array;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
