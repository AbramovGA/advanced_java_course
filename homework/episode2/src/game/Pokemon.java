package game;

import java.util.Random;

import static java.lang.Math.abs;

/**
 * Created by german on 10.11.16.
 */
 abstract class Pokemon {
    String POKEMON_NAME;
    int MAX_HEALTH;
    double Health;
    int MinDamage;
    int MaxDamage;
    double Attack;
    double Defense;
    int Speed;
    boolean Rage=false;

    void BasicHit(Pokemon victim) {
        Random random = new Random();
        int Damage = MinDamage + random.nextInt(MaxDamage - MinDamage);
        double TotalDamage;
        if (Attack > victim.Defense) {
            TotalDamage = Damage * (1 + abs(Attack - victim.Defense) * 0.2);
        } else {
            TotalDamage = Damage / (1 + abs(Attack - victim.Defense) * 0.2);
        }
        victim.Health-=TotalDamage;
        System.out.println(victim.POKEMON_NAME+" takes "+TotalDamage+" damage!");
        System.out.println();

        if(victim.Health<=victim.MAX_HEALTH*0.4){
            victim.Rage=true;
            System.out.println(victim.POKEMON_NAME+" can now do POWER ATTACK!");
        }
    }
    void SpecialHit(Pokemon victim){
        victim.Health -= MaxDamage*2;
        System.out.println(victim.POKEMON_NAME+" takes "+(MaxDamage*2)+" damage!");
        System.out.println();
    }
    void ShowStats(){
        System.out.println(POKEMON_NAME);
        System.out.println("Health_"+MAX_HEALTH);
        System.out.println("Damage_"+this.MinDamage+"("+this.MaxDamage+")");
        System.out.println("Attack_"+this.Attack);
        System.out.println("Defence_"+this.Defense);
        System.out.println("Speed_"+this.Speed);
    }
}
