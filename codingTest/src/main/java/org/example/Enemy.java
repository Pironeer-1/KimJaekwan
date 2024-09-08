package org.example;

import java.util.Random;

public class Enemy {
    int hp;
    int maxHp;
    int ad;
    int adDefence;
    int apDefence;

    public Enemy(int listNum) {
        this.maxHp = 100 * listNum;
        this.hp = 100 * listNum;
        this.ad = 25;
        this.adDefence = 7;
        this.apDefence = 7;
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
        System.out.println((playerIndex + 1) + "번 유저에게 " + this.ad + "의 데미지. 적의 공격으로 현재 남은 체력은 " + player.hp + "입니다.");
    }

    /*
    체력 회복
     */
    public void healSelf() {
        int healingAmount = 7;
        if (this.maxHp < (this.hp + healingAmount)) {
            System.out.println("적이 회복했지만 적은 이미 최대체력입니다.\n");
        } else {
            this.hp += healingAmount;
            System.out.println("적의 회복으로 현재 적의 체력은 " + this.hp + "입니다.\n");
        }
    }

    /*
    적의 공격 차례
     */
    public void attack(Player player, int playerIndex) {
        Random rand = new Random();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("적의 차례입니다.\n");

        int enemyAction = rand.nextInt(10) + 1;

        if (enemyAction == 1) {
            System.out.println("적은 섣불리 움직이지 못하고 있습니다.\n");
        } else if (enemyAction >= 2 && enemyAction <= 8) {
            this.basicAttack(player, playerIndex);
        } else {
            this.healSelf();
        }
    }
}
