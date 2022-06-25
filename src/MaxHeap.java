package sample.modelClasses;

public class MaxHeap <T,E>{
    Node<T,E>[] arr;
    int tl = 0;

    public MaxHeap(int x){
        arr= new Node[x];

    }

    public void add(Node<T, E> x){
        arr[++tl]=x;
        siftUp(tl);
    }

    public void siftUp(int x){
        if(getParent(x)<=0)
            return;


        if((Integer)arr[x].key > (Integer)arr[getParent(x)].key){
//            System.out.println(arr[x]+"      "+arr[getParent(x)]);
            Node<T,E> temp = arr[x];
            arr[x] = arr[getParent(x)];
            arr[getParent(x)] = temp;
            siftUp(getParent(x));
        }
    }

    public Node<T, E> extractMax(){
        Node<T,E> x =arr[1];
        arr[1] = arr[tl];
        arr[tl]=null;
        siftDown(1);
        tl--;
        return x;
    }

    public void siftDown(int x){

        if(arr[x]==null)
            return;

        if((Integer)arr[x].key < (Integer) arr[getLeft(x)].key || (Integer)arr[x].key< (Integer) arr[getRight(x)].key){
            if((Integer)arr[getLeft(x)].key <= (Integer) arr[getRight(x)].key){
                Node<T,E> shifter = arr[x];
                arr[x] = arr[getRight(x)];
                arr[getRight(x)] = shifter;
                siftDown(getRight(x));
            }else if((Integer)arr[getLeft(x)].key >= (Integer)arr[getRight(x)].key){
                Node<T,E> shifter = arr[x];
                arr[x] = arr[getLeft(x)];
                arr[getLeft(x)] = shifter;
                siftDown(getLeft(x));
            }
        }
    }

    public void display(){
        for (int x=1; x<arr.length ; x++) {
            if(arr[x]!=null)
                System.out.print(arr[x]+"  ");
        }
    }


    public int getLeft(int x){
        return 2*x;
    }
    public int getRight(int x){
        return 2*x+1;
    }
    public int getParent(int x){
        return x/2;
    }
}
