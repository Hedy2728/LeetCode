package leetcode524;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = new String();
        for (String sub : d) {
            if (sub.length() < res.length() || (sub.length() == res.length() && res.compareTo(sub) < 0)) {
                continue;
            }
            if (isSub(s, sub)) {
                res = sub;
            }
        }
        return res;
    }

    private boolean isSub(String s, String sub) {
        if (s.length() < sub.length()) {
            return false;
        }

        int i = 0, j = 0;
        while(j < sub.length() && i < s.length()) {
            if (s.charAt(i) == sub.charAt(j)) {
                if (j == sub.length()-1) {
                    return true;
                }
                i++;
                j++;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String > d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");

        Solution solution = new Solution();
//        System.out.println(solution.isSub("abple", "ale"));
        System.out.println(solution.findLongestWord(s, d));

    }
}
