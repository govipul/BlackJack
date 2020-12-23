/*
 * Copyright (c) 2020.
 * Author: Vipul Goswami
 * This property belongs to VG
 */

package com.lendo.service;

import com.lendo.model.Card;
import com.lendo.model.Deck;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class DeckServiceTest {

    @Test
    public void createDeckWithZeroInputs() throws Exception {
        final Deck deck = DeckService.createDeck(new String[0]);
        Assert.assertNotNull(deck);
    }

    @Test
    public void createDeckWithZeroInputCardValueNotNull() throws Exception {
        final Deck deck = DeckService.createDeck(new String[0]);
        final Card myCard = deck.draw();
        Assert.assertNotNull(myCard);
        Assert.assertTrue(myCard.getPoints() > 0);
    }

    @Test
    public void createDeckWithFileInput() throws Exception {
        final Deck deck = DeckService.createDeck(new String[]{"./cardlist.txt"});
        Assert.assertNotNull(deck);
    }

    @Test
    public void checkDeckValueFromFileInput() throws Exception {
        final Deck deck = DeckService.createDeck(new String[]{"./cardlist.txt"});
        final boolean isPresent = Arrays.asList(new String[]{"CA", "D5", "H9", "HQ", "S8"}).contains(deck.draw().name());
        Assert.assertTrue(isPresent);
    }

    @Test
    public void checkDeckValueFromFileInputValidateDraw() throws Exception {
        final Deck deck = DeckService.createDeck(new String[]{"./cardlist.txt"});
        Assert.assertEquals("CA", deck.draw().name());
        Assert.assertEquals("D5", deck.draw().name());
        Assert.assertEquals("H9", deck.draw().name());
        Assert.assertEquals("HQ", deck.draw().name());
        Assert.assertEquals("S8", deck.draw().name());
    }

    @Test
    public void checkShuffleDeckFileInput() throws Exception {
        final List<String> inputs = Arrays.asList(new String[]{"CA", "D5", "H9", "HQ", "S8"});
        final Deck deck = DeckService.createDeck(new String[]{"./cardlist.txt"});
        final String firstDraw = deck.draw().name();
        final String secondDraw = deck.draw().name();
        final String thirdDraw = deck.draw().name();
        final String fourthDraw = deck.draw().name();
        final String fifthDraw = deck.draw().name();
        inputs.containsAll(Arrays.asList(new String[]{firstDraw, secondDraw, thirdDraw, fourthDraw, fifthDraw}));
    }

    @Test
    public void validateShuffle() throws Exception {
        final Deck deck = DeckService.createDeck(new String[0]);
        final Card card = deck.draw();
        Assert.assertNotNull(card);
        Assert.assertTrue(card.getPoints() > 0);
    }

    @Test
    public void createDeckWithNullInput() throws Exception {
        Exception exception =
                Assertions.assertThrows(NullPointerException.class, ()->DeckService.createDeck(null));
        Assert.assertNull(exception);
    }
}