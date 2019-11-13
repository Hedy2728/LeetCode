package leetcode345;

import java.util.HashSet;

public class Solution {

    public String reverseVowels(String s) {
        HashSet hashSet = new HashSet();
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');
        hashSet.add('A');
        hashSet.add('E');
        hashSet.add('I');
        hashSet.add('O');
        hashSet.add('U');

        int i = 0, j = s.length()-1;
        char[] ch = new char[s.length()];

        while (i <= j) {
            if (!hashSet.contains(s.charAt(i))) {
                ch[i] = s.charAt(i);
                i++;
            }
            else if (!hashSet.contains(s.charAt(j))) {
                ch[j] = s.charAt(j);
                j--;
            }
            else {
                ch[i] = s.charAt(j);
                ch[j] = s.charAt(i);
                i++;
                j--;
            }

        }
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("leetcode"));
    }
}
