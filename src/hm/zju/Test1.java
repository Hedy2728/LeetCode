package hm.zju;

public class Test1 {
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
        String str1 = "";
        String str2 = "aba";
        String str3 = "Aba";
        String str4 = "12a21";
        System.out.print(new Test1().isPalindrome(str4));
    }
}
