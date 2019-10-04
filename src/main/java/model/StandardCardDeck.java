package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A standard 52 card deck.
 */
public class StandardCardDeck implements IDeck<StandardCard> {
    List<StandardCard> cards;

    /**
     * Default constructor. Creates an unshuffled deck.
     */
    public StandardCardDeck() {
        init();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public StandardCard pop() {
        StandardCard card = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        return card;
    }

    @Override
    public void push(StandardCard c) {
        cards.add(c);
    }

    @Override
    public void reset() {
        init();
    }

    private void init() {
        cards = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            for (int c = 0; c < 3; c++) {
                cards.add(new StandardCard(i, String.valueOf(i), StandardSuit.fromValue(c)));
            }

            cards.add(new StandardCard(i, String.valueOf(i), StandardSuit.Hearts));
            cards.add(new StandardCard(i, String.valueOf(i), StandardSuit.Diamonds));
            cards.add(new StandardCard(i, String.valueOf(i), StandardSuit.Spades));
        }

        for (int c = 0; c < 3; c++) {
            cards.add(new StandardCard(11, "Jack", StandardSuit.fromValue(c)));
            cards.add(new StandardCard(12, "Queen", StandardSuit.fromValue(c)));
            cards.add(new StandardCard(13, "King", StandardSuit.fromValue(c)));
            cards.add(new StandardCard(1, "Ace", StandardSuit.fromValue(c)));
        }

    }
}
