package com.dreadMyst.proxy.server;

import com.dreadMyst.proxy.UTILs.OutputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FakeServerInitializer {
    private ServerSocket receiveServerSocket;
    private Socket receiveProxySocket;
    private final short PORT = 16383;

    OutputStream out;
    InputStream in;

    public FakeServerInitializer() throws IOException {
        receiveServerSocket = new ServerSocket(16383);
        OutputUtils.info("Server waiting connection on PORT: " + PORT);

        receiveProxySocket = receiveServerSocket.accept();
        OutputUtils.print("Accepted connection on PORT: " + PORT);
        OutputUtils.print("Client connected, ip: " + receiveProxySocket.getInetAddress().getHostAddress());

        this.out = receiveProxySocket.getOutputStream();
        this.in = receiveProxySocket.getInputStream();
    }

    public OutputStream getOut() {
        return out;
    }

    public InputStream getIn() {
        return in;
    }

    public void closeFakeServerConnection() {
        if (receiveProxySocket == null) {
            OutputUtils.error("Socket is null");
            return;
        }

        if (receiveProxySocket.isConnected()) {
            try {
                receiveProxySocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
