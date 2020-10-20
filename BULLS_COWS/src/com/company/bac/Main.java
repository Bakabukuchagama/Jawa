package com.company.bac;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите сложность 3 4 5 для выхода нажмите 9");
        Scanner scanner = new Scanner(System.in);
        boolean game = true;
        boolean continue1 = true;
        int lvl = scanner.nextInt();
        int[] questArray;
        while (game) {
            switch (lvl) {
                case 3:
                    System.out.println("Вы выбрали сложность 3");
                    Bac genArray3 = new Bac(lvl);
                    questArray = genArray3.genArray(3);
                    while (continue1){
                    Game game1 = new Game(questArray);
                        if(game1.congratulation()){
                            lvl =9;
                            break;
                        }
                    System.out.println("Сдаётесь? Если да, то 1, если нет, то что-нибудь ещё");
                    if (scanner.nextInt()==1) {
                        continue1=false;
                        lvl =9;
                    }
                    }



                    break;
                case 4:
                    System.out.println("Вы выбрали сложность 4");
                    Bac genArray4 = new Bac(lvl);
                    questArray = genArray4.genArray(4);
                    while (continue1){
                        Game game1 = new Game(questArray);
                        if(game1.congratulation()){
                            lvl =9;
                            break;
                        }
                        System.out.println("Сдаётесь? Если да, то 1, если нет, то что-нибудь ещё");
                        if (scanner.nextInt()==1) {
                            continue1=false;
                            lvl =9;
                        }
                    }


                    break;
                case 5:
                    System.out.println("Вы выбрали сложность 5");
                    Bac genArray5 = new Bac(lvl);
                    questArray = genArray5.genArray(5);
                    while (continue1){
                        Game game1 = new Game(questArray);
                        if(game1.congratulation()){
                            lvl =9;
                            break;
                        }
                        System.out.println("Сдаётесь? Если да, то 1, если нет, то что-нибудь ещё");
                        if (scanner.nextInt()==1) {
                            continue1=false;
                            lvl =9;
                        }
                    }


                    break;
                case 9:
                        game = false;

                    break;
                default:
                    System.out.println("Неккоректная сложность! Введите новую или выйдете с помощью 9");
                    lvl = scanner.nextInt();
                    break;


            }
        }

    }
}
