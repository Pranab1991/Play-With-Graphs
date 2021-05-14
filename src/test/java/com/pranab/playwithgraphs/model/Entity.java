package com.pranab.playwithgraphs.model;

public enum Entity{
        ORCS(5),
        RINGWRAITHS(15),
        TROLLS(10),
        DRAGON(50),
        BALROG(30),
        GOLLUM(25),
		GOBLIN(5),
		FRIENDLY(0),
		SAURUMAN(100);

        private final int value;

        Entity(final int newValue) {
            value = newValue;
        }

        public int getValue() { return value; }
    }