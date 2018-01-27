package test.DynamicProgramming;

import DynamicProgramming.LongestCommonSubstring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubstringTest {

    @Test
    void findLCS() {
        String first;
        String second;
        String LCS;
        String expectedLCS;
        LongestCommonSubstring var;

        //substring starts at index 0, second string is contained in first
        first = "abcdef";
        second = "abc";
        var = new LongestCommonSubstring(first,second);
        LCS = var.findLCS();
        expectedLCS = "abc";
        assertEquals(expectedLCS,LCS,"for strings : 1."+first+" and 2."+second+" LCS found : "+LCS
                +" and expected LCS : "+expectedLCS+" are not same");

        //substring ends at last index, second string is contained in first
        first = "abcdef";
        second = "def";
        var = new LongestCommonSubstring(first,second);
        LCS = var.findLCS();
        expectedLCS = "def";
        assertEquals(expectedLCS,LCS,"for strings : 1."+first+" and 2."+second+" LCS found : "+LCS
                +" and expected LCS : "+expectedLCS+" are not same");

        //substring starts at index 0, first string is contained in second
        first = "abc";
        second = "abcdef";
        var = new LongestCommonSubstring(first,second);
        LCS = var.findLCS();
        expectedLCS = "abc";
        assertEquals(expectedLCS,LCS,"for strings : 1."+first+" and 2."+second+" LCS found : "+LCS
                +" and expected LCS : "+expectedLCS+" are not same");

        //substring ends at last index, first string is contained in second
        first = "def";
        second = "abcdef";
        var = new LongestCommonSubstring(first,second);
        LCS = var.findLCS();
        expectedLCS = "def";
        assertEquals(expectedLCS,LCS,"for strings : 1."+first+" and 2."+second+" LCS found : "+LCS
                +" and expected LCS : "+expectedLCS+" are not same");

        //first string is empty
        first = "";
        second = "abcdef";
        var = new LongestCommonSubstring(first,second);
        LCS = var.findLCS();
        expectedLCS = "";
        assertEquals(expectedLCS,LCS,"for strings : empty and 2."+second+" LCS should be empty string");

        //there are two substrings of different length
        first = "abcdefgh";
        second = "bcefg";
        var = new LongestCommonSubstring(first,second);
        LCS = var.findLCS();
        expectedLCS = "efg";
        assertEquals(expectedLCS,LCS,"for strings : 1."+first+" and 2."+second+" LCS found : "+LCS
                +" and expected LCS : "+expectedLCS+" are not same");

        //first string is null
        first = null;
        second = "abcdef";
        var = new LongestCommonSubstring(first,second);
        LCS = var.findLCS();
        expectedLCS = "";
        assertEquals(expectedLCS,LCS,"for strings : null and 2."+second+" LCS should be empty string");

        //multiple substrings of same size
        first = "afbedb";
        second = "abcdef";
        var = new LongestCommonSubstring(first,second);
        LCS = var.findLCS();
        String[] expectedLCSArray = {"a","b","c","d","e","f"};

        //search for LCS in expected LCS array, at least it should match with one entry

        boolean isLCSFound = false;
        for(String a : expectedLCSArray)
        {
            if(a.equals(LCS))
            {
                isLCSFound = true;
            }
        }

        assertEquals(true,isLCSFound,"for multiple substrings of same length, found LCS should" +
                "be one of them"+LCS);

    }
}