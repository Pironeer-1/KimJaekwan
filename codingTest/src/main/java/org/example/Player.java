package org.example;

import org.example.output.Printer;

import java.util.Random;
import java.util.Scanner;

import static org.example.enums.Value.*;

public class Player {
    int hp;
    int ad;
    int ap;
    Printer printer = new Printer();

    public Player() {
        this.hp = PLAYER_HP.getValue();
        this.ad = PLAYER_AD.getValue();
        this.ap = PLAYER_AP.getValue();
    }

    /*
    사용자가 입력한 점수에 따라 플레이어의 능력치를 설정하는 메서드
     */
    public void setStatus(int point) {
        Scanner scanner = new Scanner(System.in);
        printer.inputStatus(point);

        while(true) {
            try {
                printer.setStatus();
                String[] stats = scanner.nextLine().split(" ");
                int hp = Integer.parseInt(stats[0]);
                int ad = Integer.parseInt(stats[1]);
                int ap = Integer.parseInt(stats[2]);

                if (hp + ad + ap == point) {
                    this.hp += COEF_HP.getValue() * hp;
                    this.ad += ad;
                    this.ap += ap;
                    printer.getStatus(this.hp, this.ad, this.ap);
                    break;
                } else {
                    printer.statusSumExp(point);
                }
            } catch (Exception e) {
                printer.statusValidateExp();
            }
        }
    }

    /*
    입력된 damage에 따라 HP 감소 메서드
     */
    public void decreaseHp(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }

    /*
    현재 상태 확인 함수
     */
    public void checkStatus(Enemy enemy) {
        printer.currentPlayerStatus(this.hp, this.ad, this.ap);
        printer.currentEnemyStatus(enemy.hp, enemy.ad, enemy.adDefence, enemy.apDefence);

        // 적에게 공격
        int damage = this.ad - enemy.adDefence;
        enemy.decreaseHp(damage);

        printer.printDamage(damage);
    }

    /*
    일반 공격
     */
    public void basicAttack(Enemy enemy) {
        Random random = new Random();
        int criticalPoint = random.nextInt(RANDOM_INDEX.getValue()) + 1;
        int damage = this.ad - enemy.adDefence;

        if (criticalPoint > CRITICAL_POINT.getValue()) {
            enemy.decreaseHp(damage);
            printer.printDamage(damage);
        } else {
            damage *= COEF_CRITICAL.getValue();
            enemy.decreaseHp(damage);
            printer.printFatalDamage(damage);
        }
    }

    /*
    마법 공격
     */
    public void magicAttack(Enemy enemy) {
        int damage = (COEF_MAGIC_ATTACK.getValue() * this.ap) - enemy.apDefence;
        enemy.decreaseHp(damage);
        printer.printMagicDamage(damage);
    }

    /*
    자가 치유
     */
    public void healSelf() {
        Random random = new Random();
        int healPoint = random.nextInt(HEAL_RANDOM_INDEX.getValue()) + HEAL_ROOT_INDEX.getValue();
        this.hp += healPoint;
        printer.printHeal(this.hp);
    }

    /*
    플레이어의 공격 차례
     */
    public void attack(Enemy enemy, int playerIndex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                printer.printPlayerTurn(playerIndex);
                String inputKey = scanner.nextLine();

                if (inputKey.equals("exit")) {
                    printer.printExit();
                    System.exit(0);
                }

                int choice = Integer.parseInt(inputKey);

                if (choice < CHOICE_MIN_VALUE.getValue() || choice > CHOICE_MAX_VALUE.getValue()) {
                    printer.required1T4Int();
                    continue;
                }

                switch (choice) {
                    case 1:
                        this.checkStatus(enemy);
                        break;
                    case 2:
                        this.basicAttack(enemy);
                        break;
                    case 3:
                        this.magicAttack(enemy);
                        break;
                    case 4:
                        this.healSelf();
                        break;
                }
                break;

            } catch (Exception e) {
                printer.requiredInt();
            }
        }
    }
}
