package DynamicProgramming;

public class NoOfStatesAcceptedByBinaryDFA {
    int[] transitionOnZero;
    int[] transitionOnOne;
    int[] finalStates;
    int startState;
    int noOfStates;

    public NoOfStatesAcceptedByBinaryDFA(int A[],int B[],int C[], int D, int K)
    {
        this.transitionOnZero = A;
        this.transitionOnOne = B;
        this.finalStates = C;
        this.startState = D;
        this.noOfStates = K;
    }

    public int getNoOfAcceptedStates(int lenghtOfString)
    {
        int[][] DP = new int[lenghtOfString+1][noOfStates];
        DP[0][startState] = 1;
        int sumOfAcceptedStates = 0;

        for(int i=0;i<lenghtOfString;i++)
        {
            for(int j=0;j<noOfStates;j++)
            {
                // add the no of current states to the state to which the current state will transition to
                DP[i+1][transitionOnZero[j]] +=DP[i][j];
                DP[i+1][transitionOnOne[j]] +=DP[i][j];
            }
        }

        for(int i=0;i<finalStates.length;i++)
        {
            sumOfAcceptedStates +=DP[lenghtOfString][finalStates[i]];
        }

        return sumOfAcceptedStates;
    }
}
