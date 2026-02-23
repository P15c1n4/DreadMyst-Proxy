package com.dreadMyst.proxy.service;

import com.dreadMyst.proxy.UTILs.OutputUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

//FROM REAL SERVER
public class FakeClientPacketReceive extends Thread{
    private PacketProcess packetProcess;
    private PacketSend packetSend;

    private InputStream fromRealServertInputStream;

    public FakeClientPacketReceive(InputStream fromRealServertInputStream, PacketSend packetSend) {
        this.fromRealServertInputStream = fromRealServertInputStream;
        this.packetSend = packetSend;

        this.packetProcess = new PacketProcess();
    }

    @Override
    public void run() {
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
            byte[] data = new byte[8192];
            int readBytes;

            int packetSize = -1;

            while ((readBytes = fromRealServertInputStream.read(data)) != -1) {
                buffer.write(data, 0, readBytes);
                byte[] totalData = buffer.toByteArray();

                if(totalData.length < 4){
                    continue;
                }
                if(packetSize == -1){
                    //OutputUtils.debug("Receiving new server packet");
                    packetSize  = ByteBuffer.wrap(totalData,  0, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
                }

                if(totalData.length < packetSize){
                    continue;
                }

                packetProcess.packerProcess("Server", ByteBuffer.wrap(totalData));
                packetSend.sendToRealClient(totalData);

                buffer.reset();
                packetSize = -1;
            }
        } catch (IOException e) {
            OutputUtils.error("Error sending data to REAL client");
            //throw new RuntimeException(e);
        }
    }
}
