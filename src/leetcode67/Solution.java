package leetcode67;

public class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int len = len1 > len2 ? len1 : len2;
//        if (len1 >= len2) {
//            len = len1;
//            b = String.format("%0"+len+"d",Integer.parseInt(b));
//        }
//        else {
//            len = len2;
//            a = String.format("%0"+len+"d",Integer.parseInt(a));
//        }

        StringBuffer res = new StringBuffer();
        boolean pre = false;

        for (int i = 1; i <= len; i++) {
            int aVal = a.length()-i >= 0 ? a.charAt(len1-i)-'0' : 0;
            int bVal = b.length()-i >= 0 ? b.charAt(len2-i)-'0' : 0;
            int temp = aVal + bVal;
            if (temp == 0) {
                if (pre) {
                    res.append(1);
                    pre = false;
                }
                else {
                    res.append(0);
                }

            }
            else if (temp == 1) {
                if (pre) {
                    res.append(0);
                }
                else {
                    res.append(1);
                }
            }
            else if (temp == 2) {
                if (pre) {
                    res.append(1);
                }
                else {
                    res.append(0);
                }
                pre = true;
            }
        }
        if (pre) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
//        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String a = "111";
        String b = "11";
        System.out.println(s.addBinary(a,b));
    }
}
