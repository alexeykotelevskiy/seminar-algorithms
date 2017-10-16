package MergingIncreasingIterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Итератор возвращающий последовательность из двух возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 *
 * Time = O(k),
 *  k — суммарное количество элементов
 */
public class MergingIncreasingIterator implements Iterator<Integer> {

    private IncreasingIterator first;
    private IncreasingIterator second;
    private int it = 0;

    public MergingIncreasingIterator(IncreasingIterator first, IncreasingIterator second) {
        this.first = first;
        this.second = second;

    }

    @Override
    public boolean hasNext() {
        /* TODO: implement it */
        return first.hasNext() || second.hasNext();
    }

    @Override
    public Integer next() {
        Integer min = null;
        if (first.hasNext() && second.hasNext())
        {
            if (first.curr < second.curr)
            {
                min = first.next();
            }
            else
            {
                min = second.next();
            }
        }
        else if (first.hasNext())
        {
            min = first.next();
        }
        else if (second.hasNext())
        {
            min = second.next();
        }
        return min;
    }
}