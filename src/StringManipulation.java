package sample.modelClasses;

import java.util.ArrayList;

public class StringManipulation {

    public static ArrayList<String> uniqueWordsArrayList(String text){
        int unique = 0;
        ArrayList<String> words = StringManipulation.wordsList(text);
        ArrayList<String> myWords = new ArrayList<>();
        for (int i = 0; i <words.size() ; i++) {
            if(!myWords.contains(words.get(i).toLowerCase())){
                myWords.add(words.get(i).toLowerCase());
                unique++;
            }
        }

        return myWords;
    }

    public static ArrayList<String> wordsList(String text){
        ArrayList<String> words = new ArrayList<>();
        String word="";
        for (int i = 0; i < text.length(); i++) {
            int code = text.codePointAt(i);
            if(48<=code && 57>=code || code>=65 && code<=90 || code>=97 && code<=122){
                word+=""+text.charAt(i);
            }
            else{
                if(!word.isEmpty())
                    words.add(word);
                word="";
            }
            if(i==text.length()-1){
                if(!word.isEmpty())
                    words.add(word);
            }
        }
        return words;
    }

    public static MaxHeap<Integer,String> topFrquency(String text){
        ArrayList<String> unique = uniqueWordsArrayList(text);
        ArrayList<String> textWords = StringManipulation.wordsList(text);
        MaxHeap<Integer, String> mh = new MaxHeap<>(unique.size()+1);
        for (int i = 0; i < unique.size(); i++) {
            int count=0;
            for (int j = 0; j < textWords.size(); j++) {
                if(unique.get(i).equalsIgnoreCase(textWords.get(j)))
                    count++;
            }
            if(unique.get(i).equalsIgnoreCase("we"))
                System.out.println(count);
            mh.add(new Node<Integer, String>(count, unique.get(i)));
        }
        return mh;
    }

//    public static void main(String[] args) {
//        MaxHeap<Integer, String> list = topFrquency("We we are working of of Headlines Jamal and News Jamal scrapping Jamal from a the  a web a page a");
//        System.out.println();
//        list.display();
//        System.out.println();
//        System.out.println(list.extractMax());
//        System.out.println();
//        list.display();
//        System.out.println();
//        System.out.println(list.extractMax());
//        System.out.println();
//        list.display();
//        System.out.println();
//        System.out.println(list.extractMax());
//    }

}
