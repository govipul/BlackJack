/*
 * Copyright (c) 2020.
 * Author: Vipul Goswami
 * This property belongs to VG
 */

package com.lendo.service;

import com.lendo.model.Deck;

import java.io.File;

public class DeckService {

    public static Deck createDeck(String args[]) throws Exception {
        final Deck deck;
        if (args == null || args.length==0) {
            deck=Deck.Builder.createNew()
                    .defaultStack()
                    .validate()
                    .build();
        } else if (args.length==1) {
            File file =  new File(args[0]);
            if (file.isFile()) {
                deck=Deck.Builder.createNew()
                        .fromFile(file)
                        .validate()
                        .build();
            }
            else {
                throw new RuntimeException("Path is not a file, or file does not exist");
            }
        } else {
            throw new RuntimeException("Illegal number of arguments.");
        }
        return deck;
    }
}
