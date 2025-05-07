package Hw2_22000070_NguyenThiAnh.BaiTap3;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        DeckOfCard deckOfCard = new DeckOfCard();
        List<Card> deck = deckOfCard.deck;
        for (Card card : deck) {
            System.out.println(card);
        }
        System.out.println("Using comparator: ");
        Comparecard comparecard = new Comparecard();
        Card[] deckArray = deck.toArray(deck.toArray(new Card[0]));
        Arrays.sort(deckArray,comparecard);
        for (Card card : deckArray) {
            System.out.println(card);
        }
        System.out.println("Using comparable: ");
        Card[] deckArray1 = deck.toArray(deck.toArray(new Card[0]));
        Arrays.sort(deckArray1);
        for (Card card1 : deckArray1) {
            System.out.println(card1);
        }
    }
}
