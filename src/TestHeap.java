package sample.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sample.modelClasses.News;

import java.io.File;
import java.util.ArrayList;

public class TestHeap {

    public static void main(String[] args) {
        try{
            File file = new File("news.csv");
            if(!file.exists())
                file.createNewFile();

            Document doc = Jsoup.connect("https://www.bbc.com/urdu/topics/cjgn7n9zzq7t").timeout(6000).get();
            Elements el = doc.select("h3");
            System.out.println(el.size());
            ArrayList<News> newsList = new ArrayList<>();
            for (Element element : el) {
                System.out.println(element.text());
//                System.out.println(element.attr("href"));
//                newsList.add(new News(element.text(), null));
            }



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}