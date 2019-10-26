package leetcode119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();
        if(rowIndex < 1){
            return arr;
        }
        arr.add(1);
        res.add(arr);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            List<Integer> list_pre = res.get(i-1);
            for (int j = 1; j < i; j++) {
                list.add(list_pre.get(j-1)+list_pre.get(j));
            }

            list.add(1);
            res.add(list);
        }
        return res.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(3));
    }
}
