import java.util.Objects;

public class Node {
    private String word;
    private int wordCnt;

    Node nextNode;

    public boolean equals(Object mynode) {
        if (this == mynode) {
            return true;
        }

        if (mynode == null || mynode.getClass() != this.getClass()) {
            return false;
        }

        Node temp = (Node) mynode;
        return (this.word.equals(temp.word));
    }

    public void wordOccur(Node cursor, String word) {
        while (cursor != null) {
            if (Objects.equals(cursor.getWord(), word)) {
                System.out.println(word + ": " + cursor.getWordCnt());
                return;
            }
            cursor = cursor.nextNode;
        }
        System.out.println(word + ": 0");
    }
    public int listLength(Node head) {
        int answer = 1;

        for (Node cursor = head; cursor != null; cursor = cursor.nextNode)
            answer++;

        return answer;
    }

    public void maxCnt(Node head) {
        Node cursor = head;
        if (cursor == null) {
            throw new IllegalStateException("The list is empty.");
        }
        int maxCnt = 0;
        while (cursor != null) {
            if (cursor.getWordCnt() > maxCnt) {
                maxCnt = cursor.getWordCnt();
            }
            cursor = cursor.nextNode;
        }
        cursor = head;
        while (cursor != null) {
            if (cursor.getWordCnt() == maxCnt) { //If there are more than one words occur most frequently, print them all.
                System.out.println(cursor.getWord());
            }
            cursor = cursor.nextNode;
        }
    }

    public String longestWord(Node head) {
        Node cursor = head;
        String longestWord = null;
        int maxChar = 0;
        if (cursor == null) {
            throw new IllegalStateException("The list is empty.");
        }
        while (cursor != null) {
            if (cursor.getWord() != null && cursor.getWord().length() > maxChar) {
                maxChar = cursor.getWord().length();
                longestWord = cursor.getWord();
            }
            cursor = cursor.nextNode;
        }
        return longestWord;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordCnt() {
        return wordCnt;
    }

    public void setWordCnt(int wordCnt) {
        this.wordCnt = wordCnt;
    }
}

