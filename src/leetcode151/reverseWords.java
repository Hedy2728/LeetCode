package leetcode151;

public class reverseWords {
    public String reverseWords(String s) {
//        if (s == null || s.length() == 0) {
//            return s;
//        }
//        StringBuilder str = new StringBuilder();
//        boolean flag = false;
//        StringBuilder str_temp = new StringBuilder();
//        for (int i = s.length() - 1; i >=0; i--) {
//            char c = s.charAt(i);
//
//            if (' ' == c) {
//                if (flag) {
//                    str.append(str_temp.reverse());
//                    flag = false;
//                    str_temp = new StringBuilder();
//                }
//                str.append(c);
//
//            } else {
//                str_temp.append(c);
//                flag = true;
//            }
//        }
//        str.append(str_temp.reverse());
//        return str.toString();
        if (s == null || s.length() == 0) {
            return s;
        }
        s=s.trim();
        StringBuilder str = new StringBuilder();
        boolean flag = false;
        boolean f = false;
        StringBuilder str_temp = new StringBuilder();
        for (int i = s.length() - 1; i >=0; i--) {
            char c = s.charAt(i);

            if (' ' == c) {
                if (flag) {
                    str.append(str_temp.reverse());
                    flag = false;
                    f = false;
                    str_temp = new StringBuilder();
                }
                if (!f) {
                    str.append(c);
                    f = true;
                }


            } else {
                str_temp.append(c);
                flag = true;
            }
        }
        str.append(str_temp.reverse());
        return str.toString();

    }

    public static void main(String[] args) {
//        String s = "hh  hello   world!";
        String s = "a good   example";
        String res = new reverseWords().reverseWords(s);
        System.out.println(res);
        System.out.println(res.length()+ " "+s.length());
//        for (char c : res.toCharArray()) {
//            System.out.println(c);
//        }
    }
}
