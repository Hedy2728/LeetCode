package hm.zju.LRUCache;

public class LRUCache2 {
    String a = "aaa";
    public LRUCache2() {
        a = "bbb";
    }

    public static void main(String[] args) {
//        String str2 = new String("str")+new String("01");
        String str2 = new String("str01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2==str1);//true
    }
}
