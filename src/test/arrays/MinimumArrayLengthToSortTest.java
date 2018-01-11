package test.arrays;

import arrays.MinimumArrayLengthToSort;

import static org.junit.jupiter.api.Assertions.*;

class MinimumArrayLengthToSortTest {

    @org.junit.jupiter.api.Test
    void findMinimumArray() {
        int[] testArray;
        MinimumArrayLengthToSort var;

        //normal case
        testArray = new int[] {16,20,10,52,40,50,55,60};
        var = new MinimumArrayLengthToSort(testArray);
        assertEquals(6,var.sizeOfUnsortedArray,"Size of Unsorted array is wrong");
        assertEquals(var.start,0,"wrong start index");
        assertEquals(var.end,5,"wrong end index");

        // already sorted array
        testArray = new int[] {1,2,3,4,5,6,7,8,9,10};
        var = new MinimumArrayLengthToSort(testArray);
        assertEquals(0,var.sizeOfUnsortedArray,"Size of Unsorted array should be 0 for an already sorted array");
        assertEquals(var.start,-1,"start index should be -1 for an already sorted array");
        assertEquals(var.end,-1,"end index should be -1 for an already sorted array");

        // totally unsorted array
        testArray = new int[] {9,1,5,6,2,7,4,3};
        var = new MinimumArrayLengthToSort(testArray);
        assertEquals(testArray.length,var.sizeOfUnsortedArray,"Size of Unsorted array should be array length for a totally unsorted array");
        assertEquals(var.start,0,"start index should be 0 for a totally unsorted array");
        assertEquals(var.end,testArray.length-1,"end index should be one less than array length for a totally unsorted array");


        //size of array is one
        testArray = new int[] {1};
        var = new MinimumArrayLengthToSort(testArray);
        assertEquals(0,var.sizeOfUnsortedArray,"Size of Unsorted array should be zero for an array of size one");
        assertEquals(var.start,-1,"There is no unsorted array in case of a single element array, thus start index should be -1");
        assertEquals(var.end,-1,"There is no unsorted array in case of a single element, thus end index should be -1");

        //empty array
        testArray = new int[] {};
        var = new MinimumArrayLengthToSort(testArray);
        assertEquals(0,var.sizeOfUnsortedArray,"Size of Unsorted array should be zero for an empty array");
        assertEquals(var.start,-1,"There is no unsorted array in case of an empty array, thus start index should be -1");
        assertEquals(var.end,-1,"There is no unsorted array in case of an empty, thus end index should be -1");

        //duplicate elements
        testArray = new int[] {2,3,8,7,4,2,9};
        var = new MinimumArrayLengthToSort(testArray);
        assertEquals(5,var.sizeOfUnsortedArray,"Size of Unsorted array is wrong");
        assertEquals(var.start,1,"wrong start index, we need not sort first occurrence of the duplicate");
        assertEquals(var.end,5,"wrong end index");

    }
}