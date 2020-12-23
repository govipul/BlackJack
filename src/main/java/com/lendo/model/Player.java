/*
 * Copyright (c) 2020.
 * Author: Vipul Goswami
 * This property belongs to VG
 */

package com.lendo.model;

public class Player {

    final private String playerName;

    final private Hand hand = new Hand();

    public Player(String playerName) {
        this.playerName=playerName;
    }

    public boolean hasBlackJack(){
        return hand.hasBlackJack();
    }

    public boolean has22() {
        return hand.has22();
    }

    public boolean hasLessThan17(){
        return hand.lessThan17();
    }

    public boolean hasGreaterThan21() {
        return hand.greaterThan21();
    }

    public void addToHand(Card card) {
        hand.addCard(card);
    }


    public String getPlayerName(){
        return playerName;
    }

    public String toString() {
        return playerName + ":" + " " + hand.toString();
    }

    public int getScore(){
        return hand.score();
    }

}