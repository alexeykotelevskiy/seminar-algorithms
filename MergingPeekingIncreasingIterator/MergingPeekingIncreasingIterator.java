package MergingPeekingIncreasingIterator;

import java.util.Comparator;
import java.util.Iterator;

import IPriorityQueue.*;

/**
 * Итератор возвращающий последовательность из N возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 *
 * Time = O(n + k * log n),
 *  n — количество итераторов
 *  k — суммарное количество элементов
 */
public class MergingPeekingIncreasingIterator implements Iterator<Integer> {

    private Comparator<PeekingIncreasingIterator> comparator = (p1, p2) -> {
        if (p1.peek() > p2.peek())
            return 1;
        return -1;
    };
    private ArrayPriorityQueue<PeekingIncreasingIterator> heap;
    public MergingPeekingIncreasingIterator(IPeekingIterator... peekingIterator) {
        /* TODO: implement it */
        heap = new ArrayPriorityQueue<PeekingIncreasingIterator>();
        for (int i = 0; i < peekingIterator.length; i++) {
            PeekingIncreasingIterator it = (PeekingIncreasingIterator)peekingIterator[i];
            heap.add(it);
       }
    }

    @Override
    public boolean hasNext() {
        /* TODO: implement it */
        return !heap.isEmpty();
    }

    @Override
    public Integer next() {
        /* TODO: implement it */
        PeekingIncreasingIterator it = heap.extractMin();
        Integer a = it.next();
       if (it.hasNext())
        {
            heap.add(it);
        }
        return a;
    }
}