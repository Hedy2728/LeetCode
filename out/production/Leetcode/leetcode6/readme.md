# LeetCode6. ZigZag Conversion
## 思路
+ 题目的意思很简单，开始并没有理解他是什么意思，所以很苦恼。本题的意思是将其写成一个z字形的结构（可认为是N的镜像写法）。
+ 在遍历整个字符的时候，对于新建的字符数组（此时应该注意：String数组是无法修改的，所以声明需要StringBulider或者StringBuffer。而且对于每一个字符数组单元都需要重新声明一下他是个数组）
```
//        StringBuilder[] sbs = new StringBuilder[numRows];
        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++)
//            sbs[i] = new StringBuilder();
            sbs[i] = new StringBuffer();
```
先往下走numRows，再往上走numRows-2（因为要减去第一行和最后一行）避免重复
```
for (int row = 0; row < numRows && index < len; row++) // 往下走
    sbs[row].append(s.charAt(index++));
for (int row = numRows - 2; row > 0 && index < len; row--) // 往上走
    sbs[row].append(s.charAt(index++));
```
+  最后将字符数组拉直，全部append到0号位置上即可得到z字形排列后的数组

