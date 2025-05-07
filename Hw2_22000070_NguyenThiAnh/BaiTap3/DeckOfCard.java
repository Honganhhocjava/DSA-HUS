package Hw2_22000070_NguyenThiAnh.BaiTap3;
import java.util.ArrayList;
import java.util.List;

public class DeckOfCard {
    protected List<Card> deck;
     public DeckOfCard() {
            deck = new ArrayList<>();
            String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
            String[] suits = {"diamonds","hearts","clubs","spades"};
            for (String suit : suits) {
                for (String rank : ranks) {
                    deck.add(new Card(rank, suit));
                }
            }
        }

    public List<Card> getDeck() {
        return deck;
    }
}
