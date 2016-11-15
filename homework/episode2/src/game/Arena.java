package game;

import java.util.Scanner;

/**
 * Created by german on 11.11.16.
 */
class Arena {

    private Scanner in;

    Arena(){
        in=new Scanner(System.in);
    }

    void Fight(Pokemon first, Pokemon second){
        System.out.println("FIGHT!");
        View(first, second);

        boolean FirstActive=true;
        if(first.Speed<second.Speed)
            FirstActive=false;

        while(first.Health>0 && second.Health>0){
            if(FirstActive) {
                System.out.println("Player 1, your turn.");
                Turn(first, second);
                FirstActive=!FirstActive;
            }
            else {
                System.out.println("Player 2, your turn.");
                Turn(second, first);
                FirstActive=!FirstActive;
            }
        }
        if(first.Health<=0)
            System.out.println("Player_2 WIN!");
        else System.out.println("Player_1 WIN!");
    }

    private void Turn(Pokemon Player, Pokemon Opponent){
        SmallView(Player, Opponent);
        System.out.println("To use basic attack, enter 1");
        System.out.println("To use power attack, enter 2");
        int choice=in.nextInt();
        switch (choice){
            case 1:
                Player.BasicHit(Opponent);
                break;
            case 2:
                if(Player.Rage)
                    Player.SpecialHit(Opponent);
                else{
                    System.out.println("You can't do special attack yet");
                    Player.BasicHit(Opponent);
                }
                break;
        }

    }

    private void View(Pokemon first, Pokemon second){
        System.out.println("_________________________");
        System.out.println(first.POKEMON_NAME+"__VS__"+second.POKEMON_NAME);
        System.out.println("You:");
        first.ShowStats();
        System.out.println();
        System.out.println("Opponent:");
        second.ShowStats();
        System.out.println("_________________________");
        System.out.println();
    }
    private void SmallView(Pokemon first, Pokemon second){
        System.out.println("_________________________");
        System.out.println("Current health:");
        System.out.println("You__"+first.Health+"__Opponent__"+second.Health);
        System.out.println("_________________________");
        System.out.println();
    }

}
