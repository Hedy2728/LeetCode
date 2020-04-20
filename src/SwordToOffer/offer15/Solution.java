package SwordToOffer.offer15;

public class Solution {
    /*1右移1，结果为0
    * -1右移1，结果仍为-1，原因是负数在计算机中表达形式为补码形式，负数的相反数除符号位取反加一，右移的过程中高位补一*/
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;

        while(flag <= n) {
            if ( (n & flag) == flag) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.NumberOf1(15));

    }
}
