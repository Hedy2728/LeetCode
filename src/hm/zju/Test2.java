package hm.zju;

public class Test2 {
    public String longestPalindrome(String str) {
        if (str.length() == 0 || str == null) {
            return null;
        }

        int maxLength = 1;
        int curLength = 1;
        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (isPalindrome(str.substring(i, j + 1))){
                    curLength = j - i + 1;
                    if (curLength > maxLength) {
                        maxLength = curLength;
                        start = i;
                        end = j + 1;
                    }
                }
            }
        }
        return str.substring(start, end);
    }
    public boolean isPalindrome(String str) {
        if (str.length()==0 || str == null) {
            return false;
        }
        int start = 0;
        int end = str.length()-1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "Abadcaba";
        String str2 = "";
        System.out.print(new Test2().longestPalindrome(str1));
    }

}
