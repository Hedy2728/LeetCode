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

