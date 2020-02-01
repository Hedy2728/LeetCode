package hm_test.JavaSocket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketHttpClient {

    public void start(String host, int port) {
        Socket socket = new Socket();

        try {
            SocketAddress remote = new InetSocketAddress(host, port);
            socket.setSoTimeout(5000);
            socket.connect(remote);

            PrintWriter writer = getWriter(socket);
            System.out.println(HttpUtil.compositeRequest(host));
            writer.write(HttpUtil.compositeRequest(host));
            writer.flush();

            String msg;
            BufferedReader reader = getReader(socket);
            while ((msg = reader.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(in));
    }
    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        return new PrintWriter((new OutputStreamWriter(out)));
    }

}
