/*
 * Copyright (c) 2020.
 * Author: Vipul Goswami
 * This property belongs to VG
 */

package com.lendo;

import com.lendo.controller.GameController;

public class PlayBlackJack {

    public static void main(String[] args) throws Exception {
        GameController controller = new GameController(args);
        controller.console();
    }
}

