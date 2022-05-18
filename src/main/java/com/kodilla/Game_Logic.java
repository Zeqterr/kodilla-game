package com.kodilla;

import java.util.Scanner;

public class Game_Logic {
    public Game_Logic(){

    }

    public void waitForCommand(){

        System.out.println("What to do?");
        Scanner sc = new Scanner(System.in);
        String com = sc.nextLine();
        String[] words = com.split(" ");
        processCommand(words);

    }
    public void processCommand(String[] x) {

    }
}
