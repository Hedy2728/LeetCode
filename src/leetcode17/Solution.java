package leetcode17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<String, String> phone = new HashMap<>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> list = new LinkedList<>();
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return list;
        }
        return letterCombinations("",  digits);
    }

    private List<String> letterCombinations(String str, String next) {
        if (next.length() == 0) {
            list.add(str);
        } else {
            String digit = next.substring(0, 1);
            String strs = phone.get(digit);
            for (int i = 0; i < strs.length(); i++) {
                String letter = strs.substring(i, i + 1);
                letterCombinations(str + letter, next.substring(1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.letterCombinations("23"));
    }
}
