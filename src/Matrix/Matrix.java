package Matrix;

public class Matrix {
    int[][] matrix;
    int rows,columns;
    public Matrix(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    public void setMatrix(int[][] matrix) {
        //this.matrix = matrix.clone(); this wont work in java
        //as java will create different arrays which store row entries but
        // those row objects will be same for both and changing one
        // will change other matrix also

        for(int i=0;i<rows;i++)
        {
            this.matrix[i] = matrix[i].clone();
        }
    }

    public void printMatrix()
    {
        printMatrix(this.matrix);
    }

    public void printMatrix(int[][] matrix)
    {
        //lets format the output for readability
        int biggest = Integer.MIN_VALUE;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(matrix[i][j] > biggest)
                    biggest = matrix[i][j];
            }

        }

        int noOfDigitsInBiggest = noOfDigits(biggest),digits;

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                digits = noOfDigits(matrix[i][j]);
                for(int k=0;k<noOfDigitsInBiggest-digits;k++)
                    System.out.print(" ");
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private int noOfDigits(int number)
    {
        int digits = 0;
        if(number == 0)
            digits = 1;
        while(number != 0)
        {
            digits++;
            number = number/10;
        }
        return digits;
    }

    public int[][] rotateBy90InAntiClock()
    {
        int[][] localMatrix = new int[rows][columns];
        for(int i=0;i<rows;i++)
        {
            localMatrix[i] = matrix[i].clone();
        }
        for(int i=0;i<rows/2;i++)
        {
            for(int j=i;j<=columns-i-2;j++)
            {
                int temp = localMatrix[i][j];
                localMatrix[i][j] = localMatrix[j][columns-i-1];
                localMatrix[j][columns-i-1] = localMatrix[rows-i-1][columns-j-1];
                localMatrix[rows-i-1][columns-j-1] = localMatrix[rows-j-1][i];
                localMatrix[rows-j-1][i] = temp;
            }
        }

        return localMatrix;
    }
}
