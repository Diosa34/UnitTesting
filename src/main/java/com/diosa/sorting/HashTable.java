package com.diosa.sorting;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class HashTable {
    private int ELEMENTS_NUMBER;
    private int MAX_VALUE;
    private int BUCKET_DEPTH;

    private int[] originalList;
    private int[][] sortedList;

    public HashTable(int maxValue, int[] initList) throws IOException {
        this.ELEMENTS_NUMBER = initList.length;
//        if (this.ELEMENTS_NUMBER == 0) {
//            throw new IOException("Массив не может быть пустым");
//        }
        this.MAX_VALUE = maxValue;
        if (this.ELEMENTS_NUMBER > 0) {
            int max = initList[0];
            for (int i = 1; i < initList.length; i++) max = Math.max(max, initList[i]);
            if (max > this.MAX_VALUE) {
                throw new IllegalArgumentException("Максимальное значение должно быть больше наибольшего элемента массива");
            }
        }

        this.originalList = initList;
        this.sortedList = new int[ELEMENTS_NUMBER][initList.length];
    }

    public HashTable(int elementsNumber, int maxValue, int bucketDepth) {
        this.ELEMENTS_NUMBER = elementsNumber;
        this.MAX_VALUE = maxValue;
        this.BUCKET_DEPTH = bucketDepth;

        this.originalList = new int[ELEMENTS_NUMBER];
        this.sortedList = new int[ELEMENTS_NUMBER][BUCKET_DEPTH];

        initFillOriginal();
    }

    public void bucketSort() {
        System.out.println("InitFillOriginal: " + Arrays.toString(originalList));
        fillSorted();
        finishFillOriginal();
        System.out.println("finishFillOriginal: " + Arrays.toString(originalList));
    }

    public void initFillOriginal() {
        Random random = new Random();

        IntStream.range(0, ELEMENTS_NUMBER).forEach(index -> originalList[index] = random.nextInt(1, MAX_VALUE + 1));
    }

    public void finishFillOriginal() {
        int counter = 0;
        for (int i = 0; i < ELEMENTS_NUMBER; i++) {
            for (int j = 0; j < sortedList[i].length; j++) {
                if (sortedList[i][j] != 0) {
                    originalList[counter] = sortedList[i][j];
                    counter++;
                }
            }
        }
    }

    public void fillSorted() {
        int j;
        for (int i = 0; i < ELEMENTS_NUMBER; i++) {
            j = originalList[i] * ELEMENTS_NUMBER / (MAX_VALUE + 1);

            if (sortedList[j][0] == 0) {
                sortedList[j][0] = originalList[i];
            } else {
                for (int k = 0; k < sortedList[j].length; k++) {
                    if (sortedList[j][k] == 0) {
                        sortedList[j][k] = originalList[i];
                        Arrays.sort(sortedList[j]);
                        break;
                    }
                }
            }
        }
    }

    public int[] getOriginalList() {
        return originalList;
    }

    public int[][] getSortedList() {
        return sortedList;
    }

    public void setOriginalList(int[] originalList) {
        this.originalList = originalList;
    }

    public void setSortedList(int[][] sortedList) {
        this.sortedList = sortedList;
    }
}
