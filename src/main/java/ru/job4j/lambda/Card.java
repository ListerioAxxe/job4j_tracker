package ru.job4j.lambda;

import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        String[] cards = {"Diamonds", "Hearts", "Spades", "Clubs"};
        String[] values = {"V_6", "V_7", "V_8"};
        Stream.of(cards)
                .flatMap(level -> Stream.of(values)
                        .map(card -> level + " " + card))
                .forEach(System.out::println);
    }
}