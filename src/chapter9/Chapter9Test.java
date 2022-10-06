package chapter9;

import org.junit.Test;

import static org.junit.Assert.*;

public class Chapter9Test {

    @Test
    public void testFindindLongestCommonSubstring() {
        String extended = "The Longest Common Substring for dishes - widget = 1";
        String actual = Chapter9.findindLongestCommonSubstring("dishes","widget");
        assertEquals(extended, actual);
    }

    @Test
    public void testFindindLongestCommonSubsequence() {
        String extended = "The Longest Common Subsequence for dishes - widget = 2";
        String actual = Chapter9.findindLongestCommonSubsequence("dishes","widget");
        assertEquals(extended, actual);
    }
}