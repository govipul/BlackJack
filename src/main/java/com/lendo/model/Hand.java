/*
 * Copyright (c) 2020.
 * Author: Vipul Goswami
 * This property belongs to VG
 */

package com.lendo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {

    public static final int BLACKJACK = 21;
    private List<Card> hand = new ArrayList<>();

    /*
     * A black Jack is Combination of A + [10, K,J,Q]
     * */
    public boolean hasBlackJack() {
        final Integer score = hand.stream()
                .filter(card -> card.getPoints() > 9)
                .map(Card::getPoints)
                .reduce(0, Integer::sum);
        return score.intValue() == BLACKJACK;
    }

    /*
     * A + A
     * */
    public boolean has22() {
        final Integer score = hand.stream()
                .filter(card -> card.getPoints() == 11)
                .map(Card::getPoints)
                .reduce(0, Integer::sum);
        return score.intValue() == 22;
    }

    public boolean lessThan17() {
        return score() < 17;
    }

    public boolean greaterThan21() {
        return score() > 21;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int score() {
        return hand.stream().mapToInt(t -> {
            return t.getPoints();
        }).sum();

    }

    public String toString() {

        String toString = hand.stream()
                .sequential()
                .map(t -> {
                    return t.name();
                })
                .reduce("", (t, q) -> {
                    return t.isEmpty() ? q : t + ", " + q;
                });
        return toString;
    }


}
