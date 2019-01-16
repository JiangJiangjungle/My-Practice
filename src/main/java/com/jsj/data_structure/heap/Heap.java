package com.jsj.data_structure.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 堆的实现
 *
 * @author jsj
 * @date 2019-01-16
 */
public class Heap<E> {
    private Comparator<? super E> comparator;
    private final int size;
    private List<E> array;

    public Heap(Comparator<? super E> comparator, int size) {
        this.comparator = comparator;
        this.size = size;
        this.array = new ArrayList<>(size < 10 ? size : 10);
    }

    public boolean add(E e) {
        if (this.size == array.size()) {
            return false;
        }
        array.add(e);
        adjust();
        return true;
    }

    public boolean remove(E e) {
        boolean removed = array.remove(e);
        if (removed) {
            adjust();
        }
        return removed;
    }


    public List<E> getArray() {
        return array;
    }


    private void adjust() {
        for (int i = array.size() / 2 - 1; i >= 0; i--) {
            adjustHeap(this.array, i, array.size());
        }
    }

    /**
     * 从index开始调整大顶堆（建立在大顶堆已构建的基础上）
     *
     * @param array
     * @param index  节点位置
     * @param length 边界
     */
    private void adjustHeap(List<E> array, int index, int length) {
        //先取出当前元素i
        E temp = array.get(index);
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = index * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && comparator.compare(array.get(k), array.get(k + 1)) < 0) {
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (comparator.compare(array.get(k), temp) > 0) {
                array.set(index, array.get(k));
                index = k;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        array.set(index, temp);
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(Comparator.comparingInt(o -> o), 8);
        heap.add(1);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(0);
        heap.add(9);
        heap.add(3);
        heap.add(2);
        List<Integer> list = heap.getArray();
        System.out.println(Arrays.toString(list.toArray()));
        heap.remove(9);
        System.out.println(Arrays.toString(heap.getArray().toArray()));
    }
}
