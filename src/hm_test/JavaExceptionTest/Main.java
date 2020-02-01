package hm_test.JavaExceptionTest;

class MyException1 extends Exception{


}

class MyException2 extends Exception {
    MyException2(Throwable throwable) {
        super(throwable);
    }
    MyException2() {
        super();
    }
}

class A{
    public void f() throws MyException2{
        try {
            g();
        } catch (MyException1 e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new MyException2(e);
        }
    }
    public void g() throws MyException1{
        throw new MyException1();
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        try {
            a.f();
        } catch (MyException2 e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}