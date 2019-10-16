package hm_test;

public class test {

    //递归深度：logn
    //时间复杂度：O(logn)
    double pow( double x, int n){
        if (n == 0) return 1.0;
        double t = pow(x,n/2);
        if (n % 2==1) return x*t*t;
        return t * t;
    }
    int f(int n){
        if (n == 0) return 1;
        int temp= f(n-1);
        return 2*temp;
        }

    public static void main(String[] args) {
        test t = new test();
//        double p = t.pow(10,5);
        int p = t.f(3);
        System.out.println("p = " + p);
    }
}
