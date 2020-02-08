package hm.zju.Sort;

public class QuickSort_DigHole {
    private int[] arr;

    public QuickSort_DigHole(int[] arr) {
        this.arr = arr;
    }

    public void digHole(int left, int right) {
        int l = left;
        int r = right;
        int temp = arr[l];
        if (l >= r) {
            return;
        }
        while (l < r) {
            while (temp < arr[r] && l < r) {
                r--;
            }
            if (l < r) {
                arr[l++] = arr[r];
            }

            while (arr[l] < temp && l < r) {
                l++;
            }
            if (l < r) {
                arr[r--] = arr[l];
            }
        }
        arr[l] = temp;
        digHole(left, l-1);
        digHole(l+1, right);
    }

}
