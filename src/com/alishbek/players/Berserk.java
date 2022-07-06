package com.alishbek.players;

public class Berserk extends Hero{

    public Berserk(int health, int damage, String heroName) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, heroName);
    }

    @Override
    public void useSuperAbility(Hero[] heroes, Boss boss) {
        if (boss.getHealth()<boss.getDamage()/5){
            boss.setHealth(0);
        } else {
            boss.setHealth(boss.getHealth()- boss.getDamage()/5);
        }


    }
}
