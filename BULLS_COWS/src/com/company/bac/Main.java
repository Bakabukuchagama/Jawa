package com.company.bac;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean game = true;
        while (game) {
            System.out.println("Введите сложность 3 4 5 для выхода нажмите 9");
            int lvl = scanner.nextInt();
            switch (lvl) {
                case 3 -> gaming(3);
                case 4 -> gaming(4);
                case 5 -> gaming(5);
                case 9 -> game = false;
                default -> {
                    System.out.println("Неккоректная сложность! Введите новую или выйдете с помощью 9");
                    lvl = scanner.nextInt();
                }
            }
        }

        }

    private static void gaming(int lvl) {
        boolean continue1 = true;
        int[] questArray;
        System.out.println("Вы выбрали сложность " + lvl);
        Bac genArray3 = new Bac(lvl);
        questArray = genArray3.genArray(lvl);
        while (continue1){
            Game game1 = new Game(questArray);
            if(game1.congratulation()){
                System.out.println("Вы победили!");
                break;
            }
            System.out.println("Сдаётесь? Если да, то 1, если нет, то что-нибудь ещё");
            if (scanner.nextInt()==1) {
                continue1=false;

            }
        }
    }

}
