package Hw2_22000070_NguyenThiAnh.BaiTap3;

public class Card implements Comparable<Card> {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public int compareTo(Card o) {
        if(this.rank.equals(o.rank)) {
            return this.suit.compareTo(o.suit);
        }
        return this.rank.compareTo(o.rank);
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card[" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                ']';
    }
}
