/*
 * Copyright (c) 2020.
 * Author: Vipul Goswami
 * This property belongs to VG
 */

package com.lendo.service;

import com.lendo.model.Deck;
import com.lendo.model.Player;

public class GameService {

    private final Player sam;
    private final Player dealer;
    private final Deck deck;

    public GameService(Player sam, Player dealer, Deck deck) {
        this.sam = sam;
        this.dealer = dealer;
        this.deck = deck;
    }

    public Player play() {
        Player winner = null;
        while (winner == null) {
            sam.addToHand(deck.draw());
            dealer.addToHand(deck.draw());
            sam.addToHand(deck.draw());
            dealer.addToHand(deck.draw());
            if (sam.hasBlackJack() && dealer.hasBlackJack()) {
                winner = sam;
                break;
            } else if (sam.has22() && dealer.has22()) {
                winner = dealer;
                break;
            }

            while (sam.hasLessThan17()) {
                sam.addToHand(deck.draw());
            }

            if (sam.hasGreaterThan21()) {
                winner = dealer;
                break;
            }

            while (dealer.getScore() < sam.getScore()) {
                dealer.addToHand(deck.draw());
            }

            if (dealer.hasGreaterThan21()) {
                winner = sam;
                break;
            }else if (sam.hasBlackJack() && dealer.hasBlackJack()) {
                winner = sam;
                break;
            } else if (sam.has22() && dealer.has22()) {
                winner = dealer;
                break;
            }
        }
        return winner;
    }
}
