package com.company.bac;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private int[] user;
    private final int[] questgame;
    int cows =0;
    int bulls =0;
    public Game (int[] quest){
        user = new int[quest.length];
        questgame = quest;
        user = userin(user);
        letsplay();
    }
    private int[] userin (int[] user){
        int[] array = new int[user.length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите число: ");
            array[i]=scanner.nextInt();
        }
        return array;
    }
    private void letsplay(){
        for (int i = 0; i < questgame.length; i++) {
            for (int j = 0; j < user.length; j++) {
                if(questgame[i]==user[j]){
                    cows++;
                    if(questgame[j]==user[j]){
                        cows--;
                        bulls++;
                    }
                }
            }
        }
        if (congratulation()) {
            System.out.println("Вы победили!");
        }
        System.out.println("cows = " +cows + " bulls = " + bulls + "\n");
    }
    public boolean congratulation(){
        int congratulation = 0;
        for (int i = 0; i < questgame.length; i++) {
            if(questgame[i]==user[i]) congratulation++;
        }
        if(congratulation==user.length) {
            return true;
        }
        else return false;
    }


}
