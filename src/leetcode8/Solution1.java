package leetcode8;

public class Solution1 {
    public int myAtoi(String str) {
        if (str.length() == 0 || str == null) {
            return 0;
        }
        long res = 0;
        boolean space_flag = false;
        boolean digit = true;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c <= '9' && c >= '0') {
                res = res * 10 + c - '0';
                space_flag = true;
            } else if (c == '+' && !space_flag) {
                digit = true;
                space_flag = true;
            } else if (c == '-' && !space_flag) {
                digit = false;
                space_flag = true;
            } else if (space_flag ||!space_flag && c != ' ') {
                break;
            }

            if (res > Integer.MAX_VALUE) {
                break;
            }
        }

        if (digit) {
            return (int) Math.min(res, Integer.MAX_VALUE);
        } else {
            return (int) Math.max(-res, Integer.MIN_VALUE);
        }



    }
    public static void main(String[] args) {
        Solution1 sl = new Solution1();
        System.out.println(sl.myAtoi("4193WWW"));
    }
}
