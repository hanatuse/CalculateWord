import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FileTextReader {

    public FileTextReader() {
        // TODO Auto-generated constructor stub
    }

    public static boolean wordExist(String word, Node head) {
        while (head != null) {
            if (Objects.equals(head.getWord(), word)) {
                head.setWordCnt(head.getWordCnt()+1);
                return true;
            }
            head = head.nextNode;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = null;
        FileReader fr = null;
        String fileName = "/Users/yingtongzhou/Documents/CS342/Assign2/inputData.txt";
        String [] words = null;
        Node node = new Node();
        Node head = node;

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z0-9 ]+", "");
                line = line.toLowerCase();
                //line = line.replaceAll(System.lineSeparator(), "");
                words = line.split(" ");


                for (int i = 0; i < words.length; ++i) {
                /**
                 if (!exist)
                    add a new node with count 1*/

                    if (!wordExist(words[i],head)) {
                        node.setWord(words[i]);
                        node.setWordCnt(1);
                        node.nextNode = new Node();
                        node = node.nextNode;
                    }
                }
            }

        } catch (Exception e) {
            System.err.format("Exception occurred trying to read the file: "+fileName+".\n");
            e.printStackTrace();
        } finally {
            if (fr!=null) fr.close();
            if (br !=null) br.close();
        }

        System.out.println("a. How many times do the following words appear?");
        node.wordOccur(head,"portrait");
        node.wordOccur(head,"persian");
        node.wordOccur(head,"dorian");
        node.wordOccur(head,"experimental");
        node.wordOccur(head,"magnetic");
        System.out.println();
        System.out.println("b. How many entries are in the Linked List?");
        System.out.println(node.listLength(head));
        System.out.println();
        System.out.println("c. How many words occur more than 25 times?");
        for (Node cursor = head; cursor != null; cursor = cursor.nextNode) {
            if (cursor.getWordCnt() > 25) {
                System.out.println(cursor.getWord() + ": " + cursor.getWordCnt());
            }
        }
        System.out.println();
        System.out.println("d. Which word occurs most frequently?");
        node.maxCnt(head);
        System.out.println();
        System.out.println("e. Which word is the longest in the book?");
        System.out.println(node.longestWord(head));
    }
}
