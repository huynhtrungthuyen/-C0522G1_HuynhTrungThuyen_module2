package ss06_inheritance.exercise.point_moveable_point;

public class MoveablePoint extends Point {
    private float xSpeed = 0f;
    private float ySpeed = 0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{getX(), getY()};
    }

    public String toString() {
        return super.toString() + String.format(", speed=(%1.2f,%1.2f)", getXSpeed(), getYSpeed());
    }

    public MoveablePoint move() {
        super.setX(super.getX() + getXSpeed());
        super.setY(super.getY() + getYSpeed());
        return this;
    }

}
