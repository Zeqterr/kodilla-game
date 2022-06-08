package com.kodilla.bin;

import java.awt.*;

public class Player {
    String playerName;
    String profession;
    private int dx, dy;

    public Player(int x, int y, int width, int height, int dx, int dy){
//        setBounds(x,y,width,height);
        this.dx = dx;
        this.dy = dy;
    }

    //player update
    public void tick(){

    }



    public void setDx(int dx) {
        this.dx = dx;
    }
    public void setDy(int dy){
        this.dy = dy;
    }



}
