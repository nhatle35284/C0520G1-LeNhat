package inheritance.bai_tap.point2d_point3d;

public class Point2D {
    float x=0.0f;
    float y=0.0f;
    public Point2D(float x,float y){
        this.x = x;
        this.y = y;
    }
    public  Point2D(){}

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
    public float[] setXY() {
        float[] array= {x,y};
        return array;
    }
//    public  float getXY(float x) {
//        return x;
//    }
//}
class Point3D extends Point2D{
    float z = 0.0f;
    public Point3D (float x,float y, float z) {
        super.getX();
        super.getY();
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x,float y, float z) {
        super.getX();
        super.getY();
        this.z = z;
    }
    public float[] getXYZ() {
        float[] array={super.getX(),super.getY(),z};
        return array;
    }

    @Override
    public String toString() {
        return "Point3D( x = "+getX()+" y = "+getY()+" z = "+getZ();
    }
    }
}


