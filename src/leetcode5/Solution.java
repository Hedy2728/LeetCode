package leetcode5;

//方法一： 从中心开始，检查是否为回文字符串
class Solution{
    public String longestPalindrome(String s){
        int end = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandCenter(s,i,i);
            int len2 = expandCenter(s,i, i+1);
            int len = Math.max(len1, len2);

            if (len > end - begin) {
                end = i + len/2;
                begin = i - len/2;

            }

        }
        return s.substring(begin, end+1);
    }

    public int expandCenter(String cur, int i, int j) {
        while (i >= 0 && j < cur.length() && cur.charAt(i) == cur.charAt(j)) {
            i--;
            j++;
        }
        return j-i-1;
    }

    public static void main(String[] args) {
        String s = "abacd";
        Solution sl = new Solution();
        System.out.println(sl.longestPalindrome(s));
    }
}

//方法二：从首位开始依次遍历
//class Solution {
//    public boolean isPalindrome(String s){
//        boolean isOrNot = true;
//        int size = s.length();
//        int i=0,j = size-1;
//        while(j>=i){
//            char c1 = s.charAt(i);
//            char c2 = s.charAt(j);
//            if(c1 == c2){
//                i++;
//                j--;
//            }else{
//                isOrNot = false;
//                break;
//            }
//        }
//        return isOrNot;
//    }
//
//    public String longestPalindrome(String s) {
//        if(s.length()==0){
//            return s;
//        }
//        int location = 0;
//        int size = 1; //最大窗口值
//        int i = 0;  //左侧指针
//        int j = 1;  //右侧指针
//        while(i<s.length()-1&&j<s.length()){
//            String substring = s.substring(i, j+1);
//            if(isPalindrome(substring)){
//                if(size < j-i+1){
//                    size = j-i+1;
//                    location = i;
//                }
//            }
//            j++;
//            if(j==s.length()) {
//                i++;
//                j = i+size;
//            }
//        }
//        String ans = s.substring(location,size+location);
//        return ans;
//    }
//
//        public static void main(String[] args) {
//            String s = "aba";
//            Solution sl = new Solution();
//            System.out.println(sl.longestPalindrome(s));
//    }
//}

//方法三：使用动态规划的方法
//class Solution {
//    public String longestPalindrome(String s) {
//        int size = s.length();
//        int[][] label = new int[size][size]; //标志数组
//        int maxLength = 0; //存储最长子串的长度
//        int location = 0;  //存储最长子串的起始位置
//        int i = size - 1, j = size - 1;  //初始时 i,j都为最后一位下标
//        while (i >= 0) {
//            j = i;
//            while (j < size) {
//                char c1 = s.charAt(i);
//                char c2 = s.charAt(j);
//                if (c1 == c2) {
//                    if (j - i < 2) {
//                        label[i][j] = 1;
//                    } else {
//                        label[i][j] = label[i + 1][j - 1];
//                    }
//                } else {
//                    label[i][j] = 0;
//                }
//                if (label[i][j] == 1 && maxLength < j - i + 1) {
//                    maxLength = j - i + 1;
//                    location = i;
//                }
//                j++;
//            }
//            i--;
//        }
//        String ans = s.substring(location, maxLength + location);
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        String s = "abacd";
//        Solution sl = new Solution();
//        System.out.println(sl.longestPalindrome(s));
//    }
//}

