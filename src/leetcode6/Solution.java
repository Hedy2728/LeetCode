package leetcode6;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;

//        StringBuilder[] sbs = new StringBuilder[numRows];
        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++)
//            sbs[i] = new StringBuilder();
            sbs[i] = new StringBuffer();

        int index = 0, len = s.length();
        while (index < len) {
            for (int row = 0; row < numRows && index < len; row++) // 往下走
                sbs[row].append(s.charAt(index++));
            for (int row = numRows - 2; row > 0 && index < len; row--) // 往上走
                sbs[row].append(s.charAt(index++));
        }

        for (int row = 1; row < numRows; row++)
            sbs[0].append(sbs[row]);

        return sbs[0].toString();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.convert("0123456789",3));
    }
}
