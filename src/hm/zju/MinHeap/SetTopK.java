package hm.zju.MinHeap;

public class SetTopK {
    public static void main(String[] args) {
        int[] data = {3,6,1,9,12,4,2,10,11};
        int[] top5 = SetTopK(data, 5);
        for (int i = 0; i < 5; i++) {
            System.out.println(top5[i]);
        }

    }

    private static int[] SetTopK(int[] data, int k) {
        int[] topk = new int[k];
        for (int i = 0; i < k; i++) {
            topk[i] = data[i];
        }
        MinHeap heap = new MinHeap(topk);

        for (int i = k; i < data.length; i++) {
            int root = heap.getRoot();
            if (data[i] > root) {
                heap.setRoot(data[i]);
            }
        }
        return topk;
    }
}
