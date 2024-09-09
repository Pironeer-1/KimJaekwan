package org.example.enums;

public enum Value {
    MAX_HP(100),
    ENEMY_HP(100),
    ENEMY_AD(25),
    ENEMY_AD_DEFENCE(7),
    ENEMY_AP_DEFENCE(7),
    HEALING_AMOUNT(7),
    RANDOM_INDEX(10),
    ENEMY_ACTION_MIN(2),
    ENEMY_ACTION_MAX(8),
    STATUS_POINT(13),
    PLAYER_HP(50),
    PLAYER_AD(10),
    PLAYER_AP(5),
    COEF_HP(3),
    CRITICAL_POINT(2),
    COEF_CRITICAL(2),
    COEF_MAGIC_ATTACK(2),
    HEAL_ROOT_INDEX(6),
    HEAL_RANDOM_INDEX(5),
    CHOICE_MIN_VALUE(1),
    CHOICE_MAX_VALUE(4);

    private final int value;

    Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
