package com.dreadMyst.proxy.client;

import com.dreadMyst.proxy.UTILs.OutputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FakeClientInitializer {
    private Socket sendProxySocket;
    private OutputStream out;
    private InputStream in;

    //CHANGE TO FILE
    private final String IP = "148.113.218.141";
    private final int PORT = 16383;

    public FakeClientInitializer() throws IOException {
        this.sendProxySocket = new Socket(IP, PORT);
        OutputUtils.info("Connected to " + IP + ":" + PORT);

        this.out = sendProxySocket.getOutputStream();
        this.in = sendProxySocket.getInputStream();

        OutputUtils.print("Connection status: " + sendProxySocket.isConnected());
    }

    public OutputStream getOut() {
        return out;
    }

    public InputStream getIn() {
        return in;
    }

    public void closeFakeClientConnection() {
        if (sendProxySocket == null) {
            OutputUtils.error("Socket is null");
            return;
        }

        if(sendProxySocket.isConnected()){
            try {
                sendProxySocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
