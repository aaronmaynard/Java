/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amprojectone;
import java.util.*;
/**
 *
 * @author User
 */
public class AMProjectOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Here we display the headers of the table.  After we will pring the values using printValue().
        System.out.print("|Array size    |Selection Sort|Bubble Sort   |Merge Sort    |Quick Sort    |Heap Sort     |Radix Sort    |");
        for (int i = 50000; i <= 300000; i += 50000) {
            printValue(i);
        }
    }
    
    /**
     * This function prints all the values to the table. It does this by
     * getting the array size and sending them to the corresponding function.
     * @param arraySize 
     */
    public static void printValue(int arraySize){
        int  strWidth = 14;
        int[] list = new int[arraySize];
        for (int i = 0; i < list.length; i++){
            list[i] = (int)(Math.random() * 1000000);
        }
        
        System.out.print("\n|");
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < strWidth; j++){
                System.out.print("-");
            }
            System.out.print("|");
        }
        
        /**
         * All of these sort patterns are constructed the same. The only
         * difference being which sort type they are being called to.
         * Before a process starts, a timer with begin... As soon as that
         * particular process ends, the time will stop, record the time
         * to printValue, which in turn sends it to the table.  This is
         * repeated for each sort per array size.
         */
        // Process for SELECTION SORT
        System.out.printf("\n|%" + strWidth + "d|", arraySize);
        int[] list2 = new int[arraySize];
        System.arraycopy(list, 0, list2, 0, list.length);
        long startTime = System.currentTimeMillis();
        selectionSort(list2);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.printf("%" + strWidth + "d|", executionTime);
        
        // Process for BUBBLE SORT
        list2 = new int[arraySize];
        System.arraycopy(list, 0, list2, 0, list.length);
        startTime = System.currentTimeMillis();
        bubbleSort(list2);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.printf("%" + strWidth + "d|", executionTime);
        
        // Process for MERGE SORT
        list2 = new int[arraySize];
        System.arraycopy(list, 0, list2, 0, list.length);
        startTime = System.currentTimeMillis();
        mergeSort(list2);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.printf("%" + strWidth + "d|", executionTime);

        // Process for QUICK SORT
        list2 = new int[arraySize];
        System.arraycopy(list, 0, list2, 0, list.length);
        startTime = System.currentTimeMillis();
        quickSort(list2);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.printf("%" + strWidth + "d|", executionTime);
        
        // Process for HEAP SORT
        list2 = new int[arraySize];
        System.arraycopy(list, 0, list2, 0, list.length);  
        startTime = System.currentTimeMillis(); 
        heapSort(list2);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.printf("%" + strWidth + "d|", executionTime);
        
        // Process for RADIX SORT
        list2 = new int[arraySize];
        System.arraycopy(list, 0, list2, 0, list.length); 
        startTime = System.currentTimeMillis();
        radixSort(list2, 1000000);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.printf("%" + strWidth + "d|", executionTime);
    }
    
    /**
     * SELECTION SORT
     * During each pass, the unsorted element with the smallest value is
     * moved to the next position in the array. The number of times the sort
     * passes through the array is one less than the number of items.
     * @param list 
     */
    public static void selectionSort(int[] list){
        for (int i = 0; i < list.length - 1; i++){
            int minCur = list[i];
            int minCurIndex = i;
            for (int j = i + 1; j < list.length; j++){
                if (minCur > list[j]){
                    minCur = list[j];
                    minCurIndex = j;
                }
            }
            if (minCurIndex != i){
                list[minCurIndex] = list[i];
                list[i] = minCur;
            }
        }
    }

    /**
     * BUBBLE SORT
     * Compares adjacent elements in the array.  First and second are compared
     * and then swapped if our of order. 
     * @param list 
     */
    public static void bubbleSort(int[] list){
        boolean nextPass = true;
        for (int k = 1; k < list.length && nextPass; k++){
            nextPass = false;
            for (int i = 0; i < list.length - k; i++){
                if (list[i] > list[i + 1]){
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    nextPass = true;
                }
            }
        }
    }

    /**
     * MERGE SORT
     * The merge sort first splits up the array and processes a section at
     * a time.  Once a section is processed, the section will be placed within
     * a corresponding part of the array.
     * @param list 
     */
    public static void mergeSort(int[] list){
        if (list.length > 1){
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * MERGE SORT
     * @param list1
     * @param list2
     * @param temp 
     */
    public static void merge(int[] list1, int[] list2, int[] temp){
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        
        while (c1 < list1.length && c2 < list2.length) {
            if (list1[c1] < list2[c2]){
                temp[c3++] = list1[c1++];
            }else{
                temp[c3++] = list2[c2++];
            }
        }
        
        while (c1 < list1.length){
            temp[c3++] = list1[c1++];
        }
        
        while (c2 < list2.length){
            temp[c3++] = list2[c2++];
        }
    }

    /**
     * QUICK SORT INITIALIZER
     * Initializes the quick sort method in base JAVA.
     * One of the divide and conquer algorithms. Divides a large array into
     * smaller ones, and then sorts those smaller arrays.
     * @param list 
     */
    public static void quickSort(int[] list){
        quickSort(list, 0, list.length - 1);
    }

    /**
     * QUICK SORT
     * @param list
     * @param first
     * @param last 
     */
    private static void quickSort(int[] list, int first, int last){
        if (last > first){
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * INTERFACE FOR QUICKSORT
     * @param list
     * @param first
     * @param last
     * @return 
     */
    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;
        
        while (high > low){
            while (low <= high && list[low] <= pivot){
                low++;
            }
            while (low <= high && list[high] > pivot){
                high--;
            }
            if (high > low){
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        
        while (high > first && list[high] >= pivot){
            high--;
        }
        if (pivot > list[high]){
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }else{
            return first;
        }
    }
    
    /**
     * HEAP SORT
     * Heap sort is a comparison based sorting algorithm to create a sorted
     * array out of another.
     * @param list 
     */
    public static void heapSort(int[] list){
        Heap<Integer> heap = new Heap<>();
        for (int i = 0; i < list.length; i++){
            heap.add(list[i]);
        }
        for (int i = list.length - 1; i >= 0; i--){
            list[i] = heap.remove();
        }
    }

    static final class Heap<E extends Comparable<E>>{
        private java.util.ArrayList<E> list;
        public Heap(){this.list = new java.util.ArrayList<>();
}
        public Heap(E[] objects){
            this.list = new java.util.ArrayList<>();
            for (E object : objects) {
                add(object);
            }
        }
        public void add(E newObject){
            list.add(newObject);
            int currentIndex = list.size() - 1;
            
            while (currentIndex > 0){
                int parentIndex = (currentIndex - 1) / 2;
                if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
                    E temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(parentIndex));
                    list.set(parentIndex, temp);
                }else{
                    break;
                }
                currentIndex = parentIndex;
            }
        }
        
        public E remove(){
            if (list.isEmpty()){
                return null;
            }
            E removedObject = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            int currentIndex = 0;
            
            while (currentIndex < list.size()){
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;
                if (leftChildIndex >= list.size()){
                    break;
                }
                int maxIndex = leftChildIndex;
                if (rightChildIndex < list.size()){
                    if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0){
                        maxIndex = rightChildIndex;
                    }
                }
                if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0){
                    E temp = list.get(maxIndex);
                    list.set(maxIndex, list.get(currentIndex));
                    list.set(currentIndex, temp);
                    currentIndex = maxIndex;
                }else{
                    break;
                }
            }
            return removedObject;
        }
        
        public int getSize(){
            return list.size();
        }
    }

    /**
     * RADIX SORT
     * Radix sort is integer sorting that sorts data with integer keys
     * by the individual digits which share the same position and value.
     * @param list
     * @param maxOrder 
     */
    static void radixSort(int[] list, int maxOrder){
        for (int order = 1; order < maxOrder; order *= 10){
            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] bucket = new ArrayList[10];
            for (int i = 0; i < bucket.length; i++){
                bucket[i] = new java.util.ArrayList<>();
            }
            for (int i = 0; i < list.length; i++){
                bucket[(list[i] / order) % 10].add(list[i]);
            }
            int k = 0;
            for (ArrayList<Integer> bucket1 : bucket) {
                if (bucket1 != null) {
                    for (int j = 0; j < bucket1.size(); j++) {
                        list[k++] = bucket1.get(j);
                    }
                }
            }
        }
    }
}