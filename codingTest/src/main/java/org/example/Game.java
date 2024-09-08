package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Game {
    int statusPoint;
    List<Player> playerList;
    Enemy enemy;

    public Game() {
        this.statusPoint = 13;
        this.playerList = new ArrayList<>();
    }

    /*
    플레이어 인원 설정 및 배열에 추가
     */
    public void setPlayers() {
        Scanner scanner = new Scanner(System.in);

        int listNum;
        while (true) {
            try {
                System.out.println("플레이어 인원을 정하세요: ");
                listNum = Integer.parseInt(scanner.nextLine());

                if (listNum <= 0) {
                    System.out.println("플레이어 인원은 1 이상이어야 합니다.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
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
            System.out.println("축하합니다! 승리하셨습니다!");
        } else {
            System.out.println("아쉽지만 패배하셨습니다.");
        }
    }
}
