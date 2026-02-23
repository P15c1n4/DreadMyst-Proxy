package com.dreadMyst.proxy.service;

import java.io.IOException;
import java.io.OutputStream;

public class PacketSend {
    private OutputStream fakeClientOut;
    private OutputStream fakeServerOut;

    public PacketSend(OutputStream fakeClientOut, OutputStream fakeServerOut) {
        this.fakeClientOut = fakeClientOut;
        this.fakeServerOut = fakeServerOut;
    }

    public void sendToRealClient(byte[] data) throws IOException {
        fakeServerOut.write(data);
        fakeServerOut.flush();
    }

    public void sendToRealServer(byte[] data) throws IOException {
        fakeClientOut.write(data);
        fakeClientOut.flush();
    }
}
