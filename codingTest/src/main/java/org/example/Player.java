package org.example;

import java.util.Random;
import java.util.Scanner;

public class Player {
    int hp;
    int ad;
    int ap;

    public Player() {
        this.hp = 50;
        this.ad = 10 ;
        this.ap = 5;
    }

    /*
    사용자가 입력한 점수에 따라 플레이어의 능력치를 설정하는 메서드
     */
    public void setStatus(int point) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요\n(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)\n");
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.\n");

        while(true) {
            try {
                System.out.println("HP, AD, AP를 입력해주세요: ");
                String[] stats = scanner.nextLine().split(" ");
                int hp = Integer.parseInt(stats[0]);
                int ad = Integer.parseInt(stats[1]);
                int ap = Integer.parseInt(stats[2]);

                if (hp + ad + ap == point) {
                    this.hp += 3 * hp;
                    this.ad += ad;
                    this.ap += ap;
                    System.out.println("체력: " + this.hp + ", 공격력: " + this.ad + ", 마법력: " + this.ap);
                    break;
                } else {
                    System.out.println("입력한 능력치의 총합이" + point + "와 같아야 합니다. 다시 입력해주세요.");
                }
            } catch (Exception e) {
                System.out.println("HP, AD, AP는 정수로 입력해야 합니다. 다시 입력해주세요.");
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
        System.out.println("현재 유저: 체력 " + this.hp + ", 공격력 " + this.ad + ", 마법력 " + this.ap);
        System.out.println("적: 체력 " + enemy.hp + ", 공격력 " + enemy.ad + ", 방어력 " + enemy.adDefence + ", 마법방어력 " + enemy.apDefence + "\n");

        // 적에게 공격
        int damage = this.ad - enemy.adDefence;
        enemy.decreaseHp(damage);

        System.out.println("일반 공격으로 " + damage + "의 데이지를 주었습니다. \n");
    }

    /*
    일반 공격
     */
    public void basicAttack(Enemy enemy) {
        Random random = new Random();
        int criticalPoint = random.nextInt(10) + 1;
        int damage = this.ad - enemy.adDefence;

        if (criticalPoint > 2) {
            enemy.decreaseHp(damage);
            System.out.println("일반 공격으로 " + damage + "의 데미지를 주었습니다.");
        } else {
            damage *= 2;
            enemy.decreaseHp(damage);
            System.out.println("치명타가 적용되어 " + damage + "의 데미지를 주었습니다.");
        }
    }

    /*
    마법 공격
     */
    public void magicAttack(Enemy enemy) {
        int damage = 2 * this.ap - enemy.apDefence;
        enemy.decreaseHp(damage);
        System.out.println("마법 공격으로 " + damage + "의 데미지를 주었습니다.");
    }

    /*
    자가 치유
     */
    public void healSelf() {
        Random random = new Random();
        int healPoint = random.nextInt(5) + 6;
        this.hp += healPoint;
        System.out.println("체력을 회복합니다. 현재 HP는 " + this.hp + "입니다.");
    }

    /*
    플레이어의 공격 차례
     */
    public void attack(Enemy enemy, int playerIndex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println((playerIndex + 1) + "번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)\n");
                String inputKey = scanner.nextLine();

                if (inputKey.equals("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }

                int choice = Integer.parseInt(inputKey);

                if (choice < 1 || choice > 4) {
                    System.out.println("1~4 사이의 정수를 입력해주세요.");
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
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
    }
}
