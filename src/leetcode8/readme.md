# LeetCode8 String to Integer (atoi)
## 思路
1. 标志两个变量flag和posi，分别表示是否开始计数（出现数字或者正负号），posi表示数值正负；
2. 在数字开始出现之前可以略过空格，flag仍为false，当遇见数字或者正负号时将flag置为true；
3. 当遇见数字开始计算数值；
4. 值得注意的是，需要考虑res的取值范围，是否超过int范围