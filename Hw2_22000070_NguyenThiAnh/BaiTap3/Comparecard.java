package Hw2_22000070_NguyenThiAnh.BaiTap3;

import java.util.Comparator;

public class Comparecard implements Comparator<Card> {
        public int compare(Card card1, Card card2) {
            if(card1.getRank().equals(card2.getRank())) {
                return card1.getSuit().compareTo(card2.getSuit());
            }
            return card1.getRank().compareTo(card2.getRank());
    }
}
