package test.DynamicProgramming;

import DynamicProgramming.NoOfStatesAcceptedByBinaryDFA;

import static org.junit.jupiter.api.Assertions.*;

class NoOfStatesAcceptedByBinaryDFATest {

    @org.junit.jupiter.api.Test
    void NoOfStatesAcceptedByBinaryDFA()
    {
        int A[] = {0,2,1};
        int B[] = {1,0,2};
        int C[] = {0};
        int D = 0;
        int states = 3;

        NoOfStatesAcceptedByBinaryDFA mDFA = new NoOfStatesAcceptedByBinaryDFA(A,B,C,D,states);
        int lengthOfString = 0;

        assertEquals(1,mDFA.getNoOfAcceptedStates(0),"No of accepted string in case of length 0 should be 1 ");

        lengthOfString =1;
        assertEquals(1,mDFA.getNoOfAcceptedStates(lengthOfString),"for length 1 : 0 is the only accepted strings");

        lengthOfString =2;
        assertEquals(2,mDFA.getNoOfAcceptedStates(lengthOfString),"for length 2 : 00 and 11 are the only accepted strings");

        lengthOfString =3;
        assertEquals(3,mDFA.getNoOfAcceptedStates(lengthOfString),"for length 3 : 000, 011 and 110 are the only accepted strings");

        lengthOfString =4;
        assertEquals(6,mDFA.getNoOfAcceptedStates(lengthOfString),"for length 4 : 0000, 0011, 0110 , 1001, 1100, 1111 are the only accepted states");
    }
}