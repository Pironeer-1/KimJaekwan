package org.example.output;

import org.example.Player;

public class Printer {

    public void inputStatus(int point) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요\n(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)\n");
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.\n");
    }

    public void setStatus() {
        System.out.println("HP, AD, AP를 입력해주세요: ");
    }

    public void getStatus(int hp, int ad, int ap) {
        System.out.println("체력: " + hp + ", 공격력: " + ad + ", 마법력: " + ap);
    }

    public void statusSumExp(int point) {
        System.out.println("입력한 능력치의 총합이" + point + "와 같아야 합니다. 다시 입력해주세요.");
    }

    public void statusValidateExp() {
        System.out.println("HP, AD, AP는 정수로 입력해야 합니다. 다시 입력해주세요.");
    }

    public void currentPlayerStatus(int hp, int ad, int ap) {
        System.out.println("현재 유저: 체력 " + hp + ", 공격력 " + ad + ", 마법력 " + ap);
    }

    public void currentEnemyStatus(int hp, int ad, int adDefence, int apDefence) {
        System.out.println("적: 체력 " + hp + ", 공격력 " + ad + ", 방어력 " + adDefence + ", 마법방어력 " + apDefence + "\n");
    }

    public void printDamage(int damage) {
        System.out.println("일반 공격으로 " + damage + "의 데이지를 주었습니다. \n");
    }

    public void printFatalDamage(int damage) {
        System.out.println("치명타가 적용되어 " + damage + "의 데미지를 주었습니다.");
    }

    public void printMagicDamage(int damage) {
        System.out.println("마법 공격으로 " + damage + "의 데미지를 주었습니다.");
    }

    public void printHeal(int hp) {
        System.out.println("체력을 회복합니다. 현재 HP는 " + hp + "입니다.");
    }

    public void printPlayerTurn(int playerIndex) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println((playerIndex + 1) + "번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)\n");
    }

    public void printExit() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void required1T4Int() {
        System.out.println("1~4 사이의 정수를 입력해주세요.");
    }

    public void requiredInt() {
        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
    }

    /*
    Game
     */
    public void setPlayerNum() {
        System.out.println("플레이어 인원을 정하세요: ");
    }

    public void requiredPlayerNum1() {
        System.out.println("플레이어 인원은 1 이상이어야 합니다.");
    }

    public void winMassage() {
        System.out.println("축하합니다! 승리하셨습니다!");
    }

    public void loseMassage() {
        System.out.println("아쉽지만 패배하셨습니다.");
    }

    /*
    Enemy
     */
    public void enemyPrintDamage(int playerIndex, int ad, int hp) {
        System.out.println((playerIndex + 1) + "번 유저에게 " + ad + "의 데미지. 적의 공격으로 현재 남은 체력은 " + hp + "입니다.");
    }

    public void enemyHealMax() {
        System.out.println("적이 회복했지만 적은 이미 최대체력입니다.\n");
    }

    public void enemyHeal(int hp) {
        System.out.println("적의 회복으로 현재 적의 체력은 " + hp + "입니다.\n");
    }

    public void printEnemyTurn() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("적의 차례입니다.\n");
    }

    public void freeze() {
        System.out.println("적은 섣불리 움직이지 못하고 있습니다.\n");
    }
}
