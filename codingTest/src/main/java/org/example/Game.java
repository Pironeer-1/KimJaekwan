package org.example;

import org.example.enums.Value;
import org.example.output.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.example.enums.Value.STATUS_POINT;

class Game {
    int statusPoint;
    List<Player> playerList;
    Enemy enemy;
    Printer printer;

    public Game() {
        this.statusPoint = STATUS_POINT.getValue();
        this.playerList = new ArrayList<>();
        this.printer = new Printer();
    }

    /*
    플레이어 인원 설정 및 배열에 추가
     */
    public void setPlayers() {
        Scanner scanner = new Scanner(System.in);

        int listNum;
        while (true) {
            try {
                printer.setPlayerNum();
                listNum = Integer.parseInt(scanner.nextLine());

                if (listNum <= 0) {
                    printer.requiredPlayerNum1();
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                printer.requiredInt();
            }
        }

        for (int i = 0; i < listNum; i++) {
            Player player = new Player();
            player.setStatus(this.statusPoint);
            this.playerList.add(player);
        }
    }

    /*
    적 설정
     */
    public void setEnemy() {
        this.enemy = new Enemy(this.playerList.size());
    }

    /*
    게임 진행 여부를 판단하는 확인 메서드
     */
    public boolean turnCheck() {
        this.playerList.removeIf(player -> player.hp == 0);

        return !(this.playerList.isEmpty() || this.enemy.hp == 0);
    }

    public Player selectTargetPlayer() {
        Random rand = new Random();
        return this.playerList.get(rand.nextInt(this.playerList.size()));
    }

    /*
    게임 - 메인 로직
     */
    public void game() {
        this.setPlayers();
        this.setEnemy();

        while (this.turnCheck()) {
            for (int i = 0; i < this.playerList.size(); i++) {
                Player player = this.playerList.get(i);
                player.attack(this.enemy, i);

                if (this.enemy.hp == 0) {
                    break;
                }
            }

            if (this.turnCheck()) {
                Player targetPlayer = this.selectTargetPlayer();
                int targetIndex = this.playerList.indexOf(targetPlayer);
                this.enemy.attack(targetPlayer, targetIndex);
            } else {
                break;
            }
        }

        if (this.enemy.hp <= 0) {
            printer.winMassage();
        } else {
            printer.loseMassage();
        }
    }
}
