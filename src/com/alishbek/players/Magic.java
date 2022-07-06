package com.alishbek.players;

import com.alishbek.general.RPG_Game;

public class Magic extends Hero{

    public Magic(int health, int damage , String heroName) {
        super(health, damage, SuperAbility.BOOST, heroName);
    }

    @Override
    public void useSuperAbility(Hero[] heroes, Boss boss) {
        int number = RPG_Game.random.nextInt(5)+2;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0&&this!=heroes[i]){
                heroes[i].setDamage(heroes[i].getDamage()+number);
            }
        }
    }
}
