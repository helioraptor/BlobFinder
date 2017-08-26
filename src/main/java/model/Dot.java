package model;

/**
 * Created by azorin on 26/08/2017.
 */
public class Dot {
    public Dot(){}
    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int x;
    public int y;
    public Dot rotate(){
        Dot result = new Dot();
        result.x = 10 - this.y - 1;
        result.y = x;
        return result;
    }
}
