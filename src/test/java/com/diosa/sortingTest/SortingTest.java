package com.diosa.sortingTest;

import com.diosa.sorting.HashTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class SortingTest {
    private HashTable hashTable;

    @Test
    @DisplayName("Check sorting")
    public void sorting() {
            assertAll(
                () -> {
                    hashTable = new HashTable (1000, new int[] {438, 363, 455, 832, 594, 745, 791, 91, 750, 727, 972, 170, 234, 762, 614, 428, 140, 972, 984, 412, 81, 493, 665, 784, 546, 357, 883, 567, 72, 945});
                    hashTable.bucketSort();
                    assertArrayEquals(new int[]{72, 81, 91, 140, 170, 234, 357, 363, 412, 428, 438, 455, 493, 546, 567, 594, 614, 665, 727, 762, 745, 750, 784, 791, 832, 883, 945, 984, 972, 972}, hashTable.getOriginalList());
                }
                ,() -> {
                    hashTable = new HashTable (1000, new int[] {170, 91, 140, 81, 72});
                    hashTable.bucketSort();
                    assertArrayEquals(new int[]{72, 81, 91, 140, 170}, hashTable.getOriginalList());
                }
                ,() -> {
                    hashTable = new HashTable (200, new int[] {170, 91, 140});
                    hashTable.bucketSort();
                    assertArrayEquals(new int[]{91, 140, 170}, hashTable.getOriginalList());
                }
                ,() -> {
                    hashTable = new HashTable (200, new int[] {170, 91});
                    hashTable.bucketSort();
                    assertArrayEquals(new int[]{91, 170}, hashTable.getOriginalList());
                }
                ,() -> {
                    hashTable = new HashTable (200, new int[] {170});
                    hashTable.bucketSort();
                    assertArrayEquals(new int[]{170}, hashTable.getOriginalList());
                }
                ,() -> {
                    hashTable = new HashTable (200, new int[] {});
                    hashTable.bucketSort();
                    assertArrayEquals(new int[]{}, hashTable.getOriginalList());
                }
            );
    }

    @Test
    @DisplayName("Check sorting")
    public void failSort() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            hashTable = new HashTable (150, new int[] {170, 91, 140, 81, 72});
        });
        assertTrue(ex.getMessage().contains("Максимальное значение должно быть больше наибольшего элемента массива"));
    }
}
