package hm.zju.MinHeap;

public class MinHeap {
    private int[] data;
    public MinHeap(int[] data) {
        this.data = data;
        buildHeap();
    }
    private void buildHeap() {
        for (int i = data.length/2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int l = (i+1) << 1 - 1;
        int r = (i+1) << 1;
        int smallest = i;

        if (r < data.length && data[r] < data[i]) {
            smallest = r;
        }

        if (l < data.length && data[l] < data[i]) {
            smallest = l;
        }

        if (i == smallest) {
            return;
        }

        swap(i, smallest);
        heapify(smallest);
    }

    private void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public int getRoot() {
        return data[0];
    }

    public void setRoot(int root) {
        data[0] = root;
        heapify(0);
    }
}
