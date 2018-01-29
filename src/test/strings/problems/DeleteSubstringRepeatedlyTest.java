package test.strings.problems;

import org.junit.jupiter.api.Test;
import strings.problems.DeleteSubstringRepeatedly;

import static org.junit.jupiter.api.Assertions.*;

class DeleteSubstringRepeatedlyTest {

    @Test
    void moves() {
        String inputString;
        String pattern;
        int expectedMoves;
        int moves;
        DeleteSubstringRepeatedly var;

        //normal
        inputString = "aabb";
        pattern = "ab";
        expectedMoves = 2;
        moves = strings.problems.DeleteSubstringRepeatedly.moves(inputString,pattern);
        assertEquals(expectedMoves,moves,"expected moves and current moves returned are different");

        //pattern does not exist
        inputString = "aabb";
        pattern = "abc";
        expectedMoves = 0;
        moves = strings.problems.DeleteSubstringRepeatedly.moves(inputString,pattern);
        assertEquals(expectedMoves,moves,"expected moves and current moves returned are different");

        //all elements are pattern
        inputString = "aaaaaaaa";
        pattern = "a";
        expectedMoves = inputString.length();
        moves = strings.problems.DeleteSubstringRepeatedly.moves(inputString,pattern);
        assertEquals(expectedMoves,moves,"expected moves and current moves returned are different");

        //input is empty
        inputString = "";
        pattern = "ab";
        expectedMoves = 0;
        moves = strings.problems.DeleteSubstringRepeatedly.moves(inputString,pattern);
        assertEquals(expectedMoves,moves,"expected moves and current moves returned are different");

        //pattern is empty
        inputString = "aabb";
        pattern = "";
        expectedMoves = 0;
        moves = strings.problems.DeleteSubstringRepeatedly.moves(inputString,pattern);
        assertEquals(expectedMoves,moves,"expected moves and current moves returned are different");

        //input is null
        inputString = null;
        pattern = "ab";
        expectedMoves = 0;
        moves = strings.problems.DeleteSubstringRepeatedly.moves(inputString,pattern);
        assertEquals(expectedMoves,moves,"expected moves and current moves returned are different");

        //pattern is null
        inputString = "aabb";
        pattern = null;
        expectedMoves = 0;
        moves = strings.problems.DeleteSubstringRepeatedly.moves(inputString,pattern);
        assertEquals(expectedMoves,moves,"expected moves and current moves returned are different");

        //multiple patterns emerge when deleting pattern
        inputString = "abababccc";
        pattern = "abc";
        expectedMoves = 3;
        moves = strings.problems.DeleteSubstringRepeatedly.moves(inputString,pattern);
        assertEquals(expectedMoves,moves,"expected moves and current moves returned are different");

    }
}