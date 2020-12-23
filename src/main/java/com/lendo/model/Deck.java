/*
 * Copyright (c) 2020.
 * Author: Vipul Goswami
 * This property belongs to VG
 */

package com.lendo.model;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Deck {

    private LinkedList<Card> deck;

    private Deck(LinkedList<Card> deck) {
        this.deck = deck;
        shuffleDeck();
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card draw() {
        return deck.poll();
    }

    public static class Builder {

        private LinkedList<Card> deck = null;

        public static Builder createNew() {
            return new Deck.Builder();
        }

        public Builder defaultStack() {
            deck = new LinkedList<>();
            Arrays.stream(Card.values())
                    .forEach(deck::push);
            return this;
        }

        public Builder fromFile(File file) throws IOException {
            try (Scanner scanner = new Scanner(file);) {
                deck = new LinkedList<Card>();
                for (String card : scanner.nextLine().split(",")) {
                    deck.add(Enum.valueOf(Card.class, card.trim()));
                }
            }
            return this;
        }

        public Builder validate() {
            HashSet<Card> allUniqueCards = new HashSet<>(deck);
            if (deck.size() != allUniqueCards.size()) {
                throw new RuntimeException("Let's play a fair game, c'mon be a GENTLEMAN");
            }

            final List<Card> invalidCards = allUniqueCards.stream()
                    .filter(data -> !Arrays.asList(Card.values()).contains(data))
                    .collect(Collectors.toList());
            if (invalidCards.size() > 0) {
                throw new RuntimeException("Please enter valid cards, we have some invalid:" + invalidCards.toString());
            }

            return this;
        }

        public Deck build() {
            return new Deck(deck);
        }
    }

    public String toString() {
        String toString = deck.stream().map(t -> {
            return t.toString() + ", ";
        }).reduce("", (t, q) -> {
            return t + q;
        });

        if (!toString.isEmpty()) {
            toString = toString.substring(0, toString.length() - 2);
        }
        return toString;
    }

}
