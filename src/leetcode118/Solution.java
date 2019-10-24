package leetcode118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows < 1){
            return res;
        }
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        res.add(arr);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            /*here is core code*/
            List<Integer> list_pre = res.get(i-2);
            for (int j = 1; j < i-1; j++) {
                list.add(list_pre.get(j-1)+list_pre.get(j));
            }

            list.add(1);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(0));
    }
}
