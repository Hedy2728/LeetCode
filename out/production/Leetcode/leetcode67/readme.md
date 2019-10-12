# Leetcode67 add binary
```
if (len1 >= len2) {
    len = len1;
    b = String.format("%0"+len+"d",Integer.parseInt(b));
}
else {
    len = len2;
    a = String.format("%0"+len+"d",Integer.parseInt(a));
}
```
这样写对于长度较短的字符串是可行的，但是对于长字符造成int溢出。  
所以针对字符串的长度来进行设置,防止outOfIndex
```
int aVal = a.length()-i >= 0 ? a.charAt(len1-i)-'0' : 0;
int bVal = b.length()-i >= 0 ? b.charAt(len2-i)-'0' : 0;
```
最近几道题都是关于字符串的处理问题，最重要是看out of index的异常

