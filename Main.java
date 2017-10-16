
import MergingPeekingIncreasingIterator.*;

public class Main {
    public static void main(String[] args)
    {
       MergingPeekingIncreasingIterator it = new MergingPeekingIncreasingIterator(new PeekingIncreasingIterator(0,100,3),new PeekingIncreasingIterator(0,100,3),new PeekingIncreasingIterator(0,100,3));
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}