package org.example.data;
/**
 * The type Coordinates.
 */
public class Coordinates {
    private int x; //Максимальное значение поля: 752
    private Long y; //Поле не может быть null

    public Coordinates(){

    }
    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x (max value is 752)
     * @param y the y
     */
    public Coordinates(int x, long y){
        this.x=x;
        this.y=y;
    }
    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX(){
        return x;
    }
    /**
     * Gets y.
     *
     * @return the y
     */
    public long getY(){
        return y;
    }
    /**
     * Sets x. (0<x<753)
     *
     * @param x the x
     */
    public void setX(int x) {
        if (x>0&&x<753)
        {this.x = x;}
    }
    /**
     * Sets y. (not null)
     *
     * @param y the y
     */
    public void setY(Long y){
        if(y!=null){
            this.y=y;
       }
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}