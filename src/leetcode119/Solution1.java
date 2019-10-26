package leetcode119;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        /*this is about how to use O(k) space complexity to solve the problem*/
        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
            for (int j = i-1; j > 0; j--) {
                list.set(j,list.get(j-1) + list.get(j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(3));
    }

}
