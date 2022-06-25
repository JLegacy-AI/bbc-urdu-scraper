package sample.modelClasses;


public class News {
    String headLine;
    String details;
    News next;

    public News(String headLine, String details) {
        this.headLine = headLine;
        this.details = details;
    }

    public MaxHeap<Integer, String> wordsHeap(){
        return StringManipulation.topFrquency(details);
    }

    public String[] topTenWords(){
        MaxHeap<Integer, String> mh = wordsHeap();
        String[] topTenWords = new String[10];
        for (int i = 0; i < 10 ; i++) {
            topTenWords[i] = mh.extractMax().value;
        }
        return topTenWords;
    }
}
