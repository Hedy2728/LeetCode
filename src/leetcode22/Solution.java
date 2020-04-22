package leetcode22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        recursion( n, 0, 0,"");
        return list;
    }

    private void recursion(int n, int left, int right, String s) {
        if (left == right && left == n) {
            list.add(s);
            return;
        } else if (left < right || left > n || right > n) {
            return;
        } else {
            recursion(n, left+1, right, s + "(");
            recursion(n, left, right+1, s + ")");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
