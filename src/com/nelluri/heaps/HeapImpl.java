package com.nelluri.heaps;

class HeapImpl {
    int[] elements;

    int size;

    private static  int CAPACITY = 2;

    public HeapImpl() {
        elements = new int[CAPACITY];
        size = 0;

    }

    public int length() {
        return size;
    }


    public void printHeap() {
        for(int i=0; i < size; i++) {
            System.out.println(elements[i] + "\t");
        }
    }

    public void percolateDown(int parent) {
        int leftChild, rightChild, child;
        leftChild = 2 * parent + 1;
        // Array Indexing starts from 0. So check should be < and not <=
        if(leftChild < size) {
            child = leftChild;
        } else {
            // Since Heap is a Complete Binary tree, if leftChild is > size, we can end execution here.
            return;
        }
        rightChild = leftChild + 1;
        if(rightChild < size && elements[rightChild] < elements[leftChild]) {
            child = rightChild;
        }
        if(elements[parent] > elements[child]) {
            int tmp = elements[parent];
            elements[parent] = elements[child];
            elements[child] = tmp;
            percolateDown(child);
        }

    }


    public void percolateUp(int child) {
        int parent;
        parent = (child - 1)/2;
        if(parent >= 0 && elements[parent] > elements[child]) {
            int tmp = elements[parent];
            elements[parent] = elements[child];
            elements[child] = tmp;
            percolateUp(parent);
        }

    }

    public boolean addElement(int val) {
        if(size == CAPACITY) {
            doubleHeap();
        }
        elements[size++] = val;
        percolateUp(size-1);
        return true;
    }

    private void doubleHeap() {
        int[] newElements = new int[2*CAPACITY];
        CAPACITY *= 2;
        System.arraycopy(elements,0,newElements,0,size);
        elements = newElements;
    }


    public int removeElement() {
        if(length() == 0) {
            System.out.println("Heap is Empty");
            return -1;
        }
        int element = elements[0];
        elements[0]= elements[size-1];
        size--;
        percolateDown(0);
        return element;
    }

    public int peek() {
        if(length() > 0) {
            return elements[0];
        } else {
            System.out.println("Heap is empty");
        }
        return -1;
    }

    public static void main(String[] args) {
        // starter code will be here.
        HeapImpl heap= new HeapImpl();
        heap.addElement(5);
        heap.addElement(20);
        heap.addElement(30);
        heap.addElement(40);
        heap.addElement(50);
        heap.addElement(28);
        heap.addElement(27);
        heap.addElement(60);
        heap.printHeap();

        int deletedElement = heap.removeElement();
        heap.printHeap();
    }
}