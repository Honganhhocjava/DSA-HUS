package Hw3_22000070_NguyenThiAnh.BaiTap4;

import Hw3_22000070_NguyenThiAnh.BaiTap3.SimpleLinkedList;
import Hw3_22000070_NguyenThiAnh.BaiTap4.WordCount;

public class main {
    public static void main(String[] args) {
        SimpleLinkedList<WordCount> wordList = new SimpleLinkedList<>();
        String text = "Toi la toi la toi la hong anh anh hong day ne ne ne";
        text = text.toLowerCase();
        // Tách các từ bằng khoảng trắng
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.length() > 0) {
                WordCount wc = new WordCount(word);
                if (wordList.isContain(wc)) {
                    int index = wordList.indexOf(wc);
                    WordCount existingWord = wordList.get(index);
                    existingWord.count++;
                } else {
                    wordList.add(wc);
                }
            }
        }
        // In ra số lần xuất hiện của các từ
        for (WordCount wc : wordList) {
            System.out.println(wc.word + ": " + wc.count);
        }
    }
}
