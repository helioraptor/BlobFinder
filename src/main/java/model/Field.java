package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azorin on 26/08/2017.
 */
public class Field {
    public Field(){}
    public Field(int[][] data ){
        this.data = data;
        this.visitedCells = new int[10][10]; //default 0
    }
    private int[][] data;
    private int[][] visitedCells;
    private List<Dot> discoveredDots = new ArrayList<Dot>();
    public int totalReadCount=0;

    //rotate clockwise
    public Field rotate(){
        Field field = new Field();
        field.data = this.rotate(this.data);
        field.visitedCells = this.rotate(this.visitedCells);
        for(Dot dot: this.discoveredDots){
            field.discoveredDots.add(dot.rotate());
        }
        field.totalReadCount = this.totalReadCount;
        return field;
    }

    private int[][] rotate(int[][] data){
        int[][] result = new int[10][10];
        for(int x=0;x!=10;x++){
            for(int y=0;y!=10;y++){
                Dot a = new Dot(x,y);
                Dot b = a.rotate();
                result[b.y][b.x] = data[a.y][a.x];
            }
        }
        return result;
    }

    public int depth() throws Exception{
        int y = 0;
        while(y<10){
            for(int x=0;x!=10;x++){
                for (Dot d: this.discoveredDots) {
                    if(d.y <= y){
                        //one of found dot is also topmost in this direction
                        return d.y;
                    }
                }
                if(this.visitedCells[y][x]==0){
                    ///read
                    int i = this.data[y][x];
                    totalReadCount++;
                    this.visitedCells[y][x]=1;
                    if(i==1){//found!
                        Dot result = new Dot(x,y);
                        this.discoveredDots.add(result);
                        return result.y;
                    }
                }
            }
            y++;
        }
        throw new Exception("can not find any dots");
    }

    public void print(){
        for(int y=0;y!=10;y++) {
            for (int x = 0; x != 10; x++) {
                boolean found = false;
                for(Dot dot : this.discoveredDots){
                    if((dot.x==x)&&(dot.y==y)) {
                        System.out.print('*');
                        found=true;
                        break;
                    }
                }

                if(!found && visitedCells[y][x]==1){
                    System.out.print('o');
                    found = true;
                }

                if(!found) {
                    System.out.print(this.data[y][x]);
                }
                System.out.print(",");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
