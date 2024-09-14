package org.example;

import org.example.output.Printer;

import java.util.Random;

import static org.example.enums.Value.*;
import static org.example.enums.Value.ENEMY_HP;
import static org.example.enums.Value.MAX_HP;

public class Enemy {
    int hp;
    int maxHp;
    int ad;
    int adDefence;
    int apDefence;
    Printer printer;

    public Enemy(int listNum) {
        this.maxHp = MAX_HP.getValue() * listNum;
        this.hp = ENEMY_HP.getValue() * listNum;
        this.ad = ENEMY_AD.getValue();
        this.adDefence = ENEMY_AD_DEFENCE.getValue();
        this.apDefence = ENEMY_AP_DEFENCE.getValue();
        this.printer = new Printer();
    }

    /*
    입력된 damage에 따라 HP 감소 메서드
     */
    public void decreaseHp(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }

    /*
    기본 공격
     */
    public void basicAttack(Player player, int playerIndex) {
        player.decreaseHp(this.ad);
        printer.enemyPrintDamage(playerIndex, this.ad, player.hp);
    }

    /*
    체력 회복
     */
    public void healSelf() {
        int healingAmount = HEALING_AMOUNT.getValue();
        if (this.maxHp < (this.hp + healingAmount)) {
            printer.enemyHealMax();
        } else {
            this.hp += healingAmount;
            printer.enemyHeal(this.hp);
        }
    }

    /*
    적의 공격 차례
     */
    public void attack(Player player, int playerIndex) {
        Random rand = new Random();
        printer.printEnemyTurn();

        int enemyAction = rand.nextInt(RANDOM_INDEX.getValue()) + 1;

        if (enemyAction == 1) {
            printer.freeze();
        } else if (enemyAction >= ENEMY_ACTION_MIN.getValue() && enemyAction <= ENEMY_ACTION_MAX.getValue()) {
            this.basicAttack(player, playerIndex);
        } else {
            this.healSelf();
        }
    }
}
