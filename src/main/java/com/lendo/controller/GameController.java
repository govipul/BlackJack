/*
 * Copyright (c) 2020.
 * Author: Vipul Goswami
 * This property belongs to VG
 */

package com.lendo.controller;

import com.lendo.model.Deck;
import com.lendo.model.Player;
import com.lendo.service.DeckService;
import com.lendo.service.GameService;

public class GameController {

    private final String[] args;

    public GameController(String[] args) {
        this.args = args;
    }

    public void console() throws Exception {
        Deck deck = DeckService.createDeck(args);

        Player dealer = new Player("dealer");
        Player sam = new Player("sam");

        GameService game = new GameService(sam,dealer,deck);
        Player winner = game.play();

        System.out.println(winner.getPlayerName());
        System.out.println(sam.toString());
        System.out.println(dealer.toString());

    }

}
