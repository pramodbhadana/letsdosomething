package test.Matrix;

import Matrix.Matrix;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void rotateBy90InAntiClock() {
        //checking for square matrix for size 1 to 10
        for(int k = 0; k < 10;k++) {
            int rows, columns, num = 1;
            rows = columns = k;
            int[][] matrixArray = new int[rows][columns];

            //initialize matrix with values from 1 to rows*columns
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrixArray[i][j] = num++;
                }
            }

            Matrix matrix = new Matrix(rows, columns);
            matrix.setMatrix(matrixArray);

            int[][] rotatedMatrix = matrix.rotateBy90InAntiClock();
            int[][] expectedMatrix = new int[rows][columns];

            // reference the rotated matrix to understand this
            int num1 = rows, num2 = num1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    expectedMatrix[i][j] = num2;
                    num2 = num2 + rows;
                }
                num2 = --num1;
            }

            assertTrue(Arrays.deepEquals(rotatedMatrix, expectedMatrix), "manually rotated array and rotated array should be equal. Failed for matrix size: "+k);
            //assertEquals(expectedMatrix,rotatedMatrix,"Rotated matrix should be as expected"); cannot use as Java is not
            // good with multi dimensional arrays.
        }

        int rows, columns, num = 1;
        rows = columns = 5;
        int[][] matrixArray ={ {3,1,4,0,10},{11,3,5,-1,4},{9,2,6,14,0},{15,5,6,23,99},{-10,3,25,78,1}};

        Matrix matrix = new Matrix(rows, columns);
        matrix.setMatrix(matrixArray);

        int[][] rotatedMatrix = matrix.rotateBy90InAntiClock();
        int[][] expectedMatrix = { {10,4,0,99,1},{0,-1,14,23,78},{4,5,6,6,25},{1,3,2,5,3},{3,11,9,15,-10}};

        assertTrue(Arrays.deepEquals(rotatedMatrix, expectedMatrix), "manually rotated array and rotated array should be equal");
    }
}