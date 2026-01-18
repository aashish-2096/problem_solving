package gfg.language_formats.java;

import java.util.PriorityQueue;

public class PqSortingCustom {
    
    class TempNode{
        int num;
        String key;
        int tieBreaker;
        TempNode(int num, int tieBreaker, String key){
            this.key = key;
            this.tieBreaker = tieBreaker;
            this.num = num;
        }
    }

    public PriorityQueue<TempNode> getSortedPriorityQueue(){
                return new PriorityQueue<>((a,b) -> Integer.compare(a.num, b.num));
    }   

    public PriorityQueue<TempNode> getSortedPriorityQueueOnConflict(){
                return new PriorityQueue<>((a,b) -> {
    if(a.num  == b.num){
        return a.key.compareTo(b.key);
    } return Integer.compare(a.num, b.num);
                });
    }   

    public void customSort(){
       
    }
}
