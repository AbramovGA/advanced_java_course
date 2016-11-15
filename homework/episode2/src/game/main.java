package game;

import java.util.Scanner;

/**
 * Created by german on 11.11.16.
 */
public class main {
   static private Pokemon choose(){
        Pokemon Player;
        Scanner in=new Scanner(System.in);
        int choice=in.nextInt();
        switch(choice){
            case 1:
                return Player=new Bulbasaur();
            case 2:
                return Player=new Pickachu();
            case 3:
                return Player=new Pigeot();
        }
        return Player=new Bulbasaur();
    }
    public static void main(String[] args) {
        Arena arena=new Arena();
        Pokemon Player1;
        Pokemon Player2;
        System.out.println("Player_1 choose your Pokemon");
        System.out.println("1 - Bulbasaur");
        System.out.println("2 - Pikachu");
        System.out.println("3 - Pigeot");

        Player1=choose();
        System.out.println("Player_2 choose your Pokemon");
        System.out.println("1 - Bulbasaur");
        System.out.println("2 - Pikachu");
        System.out.println("3 - Pigeot");
        Player2=choose();
        arena.Fight(Player1, Player2);
    }
}
