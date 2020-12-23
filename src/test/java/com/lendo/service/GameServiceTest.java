/*
 * Copyright (c) 2020.
 * Author: Vipul Goswami
 * This property belongs to VG
 */

package com.lendo.service;

import com.lendo.model.Card;
import com.lendo.model.Deck;
import com.lendo.model.Player;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameServiceTest {

    public Player dealerPlayer;
    private Deck deck;
    public Player samPlayer;

    @BeforeEach
    public void init(){
        deck = mock(Deck.class);
        dealerPlayer = new Player("dealer");
        samPlayer = new Player("sam");
    }

    @Test
    void givenBlackJackToBothSamIsWinner() {
        when(deck.draw()).thenReturn(Card.CA, Card.HA, Card.CJ, Card.S10);
        final GameService service = new GameService(samPlayer,
                dealerPlayer,
                deck);
        final Player winner = service.play();
        Assert.assertEquals(samPlayer.getPlayerName(), winner.getPlayerName());

    }

    @Test
    void given22ToBothDealerIsWinner() {
        when(deck.draw()).thenReturn(Card.CA, Card.SA, Card.HA, Card.DA);
        final GameService service = new GameService(samPlayer,
                dealerPlayer,
                deck);
        final Player winner = service.play();
        Assert.assertEquals(dealerPlayer.getPlayerName(), winner.getPlayerName());
    }

    @Test
    void givenSamGreaterThan21DealerIsWinner() {
        when(deck.draw()).thenReturn(Card.SJ, Card.CA, Card.S5, Card.C3, Card.H9);
        final GameService service = new GameService(samPlayer,
                dealerPlayer,
                deck);
        final Player winner = service.play();
        Assert.assertEquals(dealerPlayer.getPlayerName(), winner.getPlayerName());
    }

    @Test
    void givenDealerGreaterThan21SamIsWinner() {
        when(deck.draw()).thenReturn(Card.SJ, Card.CA, Card.S5, Card.C3, Card.H2,Card.CK);
        final GameService service = new GameService(samPlayer,
                dealerPlayer,
                deck);
        final Player winner = service.play();
        Assert.assertEquals(samPlayer.getPlayerName(), winner.getPlayerName());
    }

}