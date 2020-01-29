package hm_test.JavaIO_Test;

import java.io.*;

public class Test{

    public static void test01() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符：");
        char c;
        c = (char) bufferedReader.read();
        System.out.println("你输入的字符是："+c);

    }

    public static void test02() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符，按q结束");
        char c;
        do {
            c = (char)bufferedReader.read();
            System.out.println("你输入的字符为：" + c);
        } while (c != 'q');
    }

    public static void test03() throws IOException{
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一行字符：");
        String str;
        str = bufferedReader.readLine();
        System.out.println("你输入的字符为：" + str);
    }

    public static void test04() throws IOException {
        byte[] bytes = {12, 21, 33, 44, 55};
        FileOutputStream fileOutputStream = new FileOutputStream(new File("./hm_test.txt"));
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    public static void test05() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("hm_test.txt"));
        int c;
        while ((c = fileInputStream.read()) != -1) {
            System.out.println(c);
        }
    }

    public static void test06() throws IOException {
        FileWriter fileWriter = new FileWriter(new File("hm_test.txt"));
        fileWriter.write("Hello, world!\n欢迎了来到Java世界\n");
        fileWriter.write("不会覆盖文件原本的内容\n");
        fileWriter.append("并不是追加一行内容，不要被方法名迷惑");
        fileWriter.append(null);
        fileWriter.flush();
        System.out.println("文件默认编码为"+fileWriter.getEncoding());
        fileWriter.close();
    }

    public static void test07() throws IOException {
        FileWriter fileWriter = new FileWriter(new File("hm_test.txt"));
        fileWriter.write("Hello, world! Welcome to java world!");
        fileWriter.write("我来覆盖文件原本内容");
        fileWriter.append("我是下一行");
        fileWriter.flush();
        fileWriter.close();

    }

    public static void test08() throws IOException{
        FileReader fileReader = new FileReader(new File("hm_test.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while ((str = bufferedReader.readLine()) != null ) {
            System.out.println(str);
        }
        fileReader.close();
        bufferedReader.close();
    }

    public static void test09() throws IOException {
        FileReader fileReader = new FileReader(new File("hm_test.txt"));
        int c;
        while ((c = fileReader.read() )!= -1) {
            System.out.println((char) c);
        }
    }

    public static void test10() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("hm_test.txt"));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK");
        outputStreamWriter.write("Hello, world\n 欢迎来到java世界\n");
        outputStreamWriter.append("另一行内容");
        outputStreamWriter.flush();
        System.out.println("文件编码为"+outputStreamWriter.getEncoding());
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    public static void test11() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("hm_test.txt"));
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while ((str=bufferedReader.readLine())!= null) {
            System.out.println(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
    }

    public static void  test12() throws IOException {
        // 输入和输出都使用缓冲流
        FileInputStream in = new FileInputStream("hm_test.txt");
        BufferedInputStream inBuffer = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream("hm_test.txt");
        BufferedOutputStream outBuffer = new BufferedOutputStream(out);
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len = inBuffer.read(bs)) != -1) {
            outBuffer.write(bs, 0, len);
        }
        System.out.println("复制文件所需的时间：" + (System.currentTimeMillis() - begin)); // 平均时间约 200 多毫秒
        inBuffer.close();
        in.close();
        outBuffer.close();
        out.close();
    }


    public static void  test13() throws IOException {
        // 只有输入使用缓冲流
        FileInputStream in = new FileInputStream("hm_test.txt");
        BufferedInputStream inBuffer = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream("hm_test.txt");
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len = inBuffer.read(bs)) != -1) {
            out.write(bs, 0, len);
        }
        System.out.println("复制文件所需时间：" + (System.currentTimeMillis() - begin)); // 平均时间约 500 多毫秒
        inBuffer.close();
        in.close();
        out.close();
    }

    public static void test14() throws IOException {
        // 输入和输出都不使用缓冲流
        FileInputStream in = new FileInputStream("hm_test.txt");
        FileOutputStream out = new FileOutputStream("hm_test.txt");
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len = in.read(bs)) != -1) {
            out.write(bs, 0, len);
        }
        System.out.println("复制文件所需时间：" + (System.currentTimeMillis() - begin)); // 平均时间 700 多毫秒
        in.close();
        out.close();
    }

    public static void test15() throws IOException {
        // 不使用缓冲
        FileInputStream in = new FileInputStream("hm_test.txt");
        FileOutputStream out = new FileOutputStream("hm_test.txt");
        int len = 0;
        long begin = System.currentTimeMillis();
        while ((len = in.read()) != -1) {
            out.write(len);
        }
        System.out.println("复制文件所需时间：" + (System.currentTimeMillis() - begin)); // 平均时间约 160000 毫秒，约 2 分多钟
        in.close();
        out.close();
    }
    public static void main(String[] args) throws IOException{
        test12();
    }

}
