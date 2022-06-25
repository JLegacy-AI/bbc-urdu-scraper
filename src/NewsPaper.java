package sample.modelClasses;

public class NewsPaper {
    News head;
    int tN=0;

    public void add(News n){
        if(tN>100)
            return;
        if(head==null)
        {
            head = n;
            tN++;
        }
        addHelp(head, n);
    }

    public void addHelp(News root, News n){
        if(root.next==null){
            root.next = n;
            tN++;
            return;
        }
        addHelp(root.next, n);
    }

    public News next(){
        if(head == null)
            return null;
        News n = new News(head.headLine, head.details);
        head =  head.next;
        return n;
    }

}

