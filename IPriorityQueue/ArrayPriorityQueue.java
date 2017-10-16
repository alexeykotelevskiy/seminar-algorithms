package IPriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayPriorityQueue<Key extends Comparable<Key>> implements IPriorityQueue<Key> {

    private Key[] elementData;
    private Comparator<Key> comparator;
    private int size=0;

    public ArrayPriorityQueue() {
        /* TODO: implement it — O(n) */
        elementData = (Key[]) new  Comparable[10];
    }

    public ArrayPriorityQueue(Comparator<Key> comparator) {
        /* TODO: implement it — O(n) */
        this.comparator = comparator;
        elementData = (Key[]) new  Comparable[10];
    }

    @Override
    public void add(Key key) {
        /* TODO: implement it — O(log n) */
        if (size() == elementData.length-1)
            grow();
        elementData[++size] = key;
        siftUp();
    }

    @Override
    public Key peek() {
        /**
         * TODO: implement it — O(1)
         * Посмотреть на минимальный элемент
         */
        return isEmpty() ? null : elementData[1];
    }

    @Override
    public Key extractMin() {
        /**
         * TODO: implement it — O(log n)
         * Достать минимальный элемент
         *  и перестроить кучу
         */
        if (!isEmpty()) {
            Key res = elementData[1];
            elementData[1] = elementData[size()];
            size--;
            siftDown();
            return res;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        /* TODO: implement it */
        return size() == 0;
    }

    @Override
    public int size() {
        /* TODO: implement it */
        return size;
    }

    private void siftUp() {
        /**
         * TODO: implement it — O(log n)
         * Просеивание вверх —
         *  подъём элемента больше родителей
         */
        int curr = size();
        while (curr > 1 && greater(curr,curr>>1))
        {
            Key tmp = elementData[curr];
            elementData[curr] = elementData[curr>>1];
            elementData[curr>>1] = tmp;
            curr >>= 1 ;
        }
    }

    public void siftDown()
    {
        siftDown(1);
    }

    private void siftDown(int node) {
        /**
         * TODO: implement it — O(log n)
         * Просеивание вниз
         *  спуск элемента меньше детей
         */

        int curr = node;
        while (curr <= size() / 2)
        {
            int maxim = curr;
            if ((curr * 2 ) <= size() && greater(curr * 2, curr))
                maxim = curr * 2 ;
            if (curr * 2 + 1 <= size() && greater(curr * 2 + 1, curr))
                maxim = curr * 2 + 1;
            if (maxim != curr)
            {
                Key tmp = elementData[curr];
                elementData[curr] = elementData[maxim];
                elementData[maxim] = tmp;
                curr = maxim;
            } else break;
        }
    }

    private void changeCapacity(int newsize)
    {
        elementData = Arrays.copyOf(elementData,newsize);

    }

    private void grow() {
        /**
         * TODO: implement it
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */
        if (size() == elementData.length-1)
            changeCapacity((int)(elementData.length * 1.5));

    }

    private void shrink() {
        /**
         * TODO: implement it
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        if (size() * 4 <= elementData.length)
            changeCapacity(elementData.length >> 1);
    }

    private boolean greater(int i, int j) {
        return comparator == null
                ? elementData[i].compareTo(elementData[j]) > 0
                : comparator.compare(elementData[i], elementData[j]) > 0
                ;
    }

    @Override
    public Iterator<Key> iterator() {
        /* TODO: implement it */
        return new ArrayPriorityQueueIterator();
    }
    private class ArrayPriorityQueueIterator implements Iterator<Key> {

        private int currentPosition = 1;

        @Override
        public boolean hasNext() {
            return currentPosition <= size();
        }

        @Override
        public Key next() {
            return elementData[currentPosition--];
        }

    }
}