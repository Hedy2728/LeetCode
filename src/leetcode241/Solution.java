package leetcode241;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> list = new ArrayList<>();

        if (input == null || input.length() == 0) {
            return list;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (int l : left) {
                    for (int r : right) {
                        switch (input.charAt(i)) {
                            case '+':
                                list.add(l+r);
                                break;
                            case '-':
                                list.add(l-r);
                                break;
                            case '*':
                                list.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.valueOf(input));
        }

        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "2-1*4";
        System.out.print(s.diffWaysToCompute(str));
    }
}
