package com.alishbek.general;

import com.alishbek.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(1000, 50);
        Warrior warrior = new Warrior(270, 15, "Warrior");
        Medic medic = new Medic(220, 5, "Doc", 15);
        Magic magic = new Magic(240, 20, "Magic");
        Berserk berserk = new Berserk(300, 20, "Berserk");
        Medic assistant = new Medic(250, 10, "Assistant", 5);

        Hero[] heroes = {warrior, medic, magic, berserk, assistant};

        printStatistics(heroes, boss);
        while(!isGameFinished(heroes, boss)){
            round(heroes, boss);
        }
    }

    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("-------ROUND" + roundNumber);
        System.out.println("Boss health: " + boss.getHealth() + "   |" + boss.getDamage());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getHeroName() + " health: " +
                    heroes[i].getHealth() + "   |" + heroes[i].getDamage());

        }
    }

    private static void bossHits(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() < boss.getDamage()) {
                heroes[i].setHealth(0);
            } else {
                if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                }
            }
        }
    }

    private static void heroesHits(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] instanceof Warrior){
                continue;
            } else {
            if (boss.getHealth() < heroes[i].getDamage()){
                boss.setHealth(0);
            } else {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }

            }
            }
            }
        }

    private static void useSuperPower(Hero[] heroes, Boss boss){
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth()>0&&boss.getHealth()>0){
                heroes[i].useSuperAbility(heroes, boss);
            }
        }
    }

    private static boolean isGameFinished(Hero[] heroes, Boss boss){
        if (boss.getHealth()<=0){
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth()>0){
                allHeroDead=false;
                break;
            }
        }
        if (allHeroDead){
            System.out.println("Boss won!!!");
        }
        return allHeroDead;
    }
    private static void round(Hero[]heroes, Boss boss){
        roundNumber++;
        bossHits(heroes, boss);
        heroesHits(heroes, boss);
        useSuperPower(heroes, boss);
        printStatistics(heroes, boss);
    }

}