package inheritance.bai_tap.point2d_point3d;

import java.awt.*;

class Point3D extends Point2D {
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
    public float[] setXYZ() {
        float[] array={super.getX(),super.getY(),z};
        return array;
    }
//    public  float getXYZ(float x) {
//        return x;
//    }

    @Override
    public String toString() {
        return "Point3D( x = "+getX()+" y = "+getY()+" z = "+getZ();
    }
}
