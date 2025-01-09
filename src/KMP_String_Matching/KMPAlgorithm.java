package KMP_String_Matching;

// This algorithm is used to perform string matching(substring match first last index in linear time complexity
// We need 2 functions ont to create a hash array where we will track the repeating characters
// another one to perform checks and find the match

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// longest prefix which is also the suffix -> LPS
public class KMPAlgorithm {
    public static void main(String[] args) {

        String text = "aabaacaadaabaaba";
        String pattern = "aaba";

        List<Integer> out = new LinkedList<Integer>();

        int[] lps = new int[pattern.length()];

        getLPS(text, pattern, lps);
        System.out.println(Arrays.toString(lps));

        int  i =0, j =0, n = text.length(), m = pattern.length();

        while(i < n)
        {
            if(text.charAt(i) == pattern.charAt(j))
            {
                i++;
                j++;

                if(j == m)
                {
                    out.add(i - j);
                    j = lps[j-1];
                }
            }
            else {
                if(j == 0) i++;
                else {
                    j = lps[j-1];
                }
            }
        }

        System.out.println(out);

    }

    private static void getLPS(String text, String pattern, int[] lps) {

        int prev = 0, i = 1;
        lps[0] = prev;
        while(i < pattern.length())
        {
            if(pattern.charAt(i) == pattern.charAt(prev))
            {
                prev++;
                lps[i] = prev;
                i++;
            }
            else if(prev == 0)
            {
                lps[i] = 0;
                i++;
            }
            else {
                prev = lps[prev-1];
            }
        }
    }
}
