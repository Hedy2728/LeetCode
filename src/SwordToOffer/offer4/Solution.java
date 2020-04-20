package SwordToOffer.offer4;

public class Solution {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        int row = array.length;
        int column = array[0].length;
        int i = 0, j = column - 1;
        while (i < row &&  j>= 0) {
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Solution s = new Solution();
        System.out.println(s.Find(5, array));
    }
}
