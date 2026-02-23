package com.dreadMyst.proxy.service;

import com.dreadMyst.proxy.UTILs.OutputUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

//FROM REAL CLIENT
public class FakeServerPacketReceive extends Thread{
    private InputStream fromRealClientInputStream;
    private PacketSend packetSend;
    private PacketProcess packetProcess;

    public FakeServerPacketReceive(InputStream fromRealClientInputStream, PacketSend packetSend) {
        this.fromRealClientInputStream = fromRealClientInputStream;
        this.packetSend = packetSend;

        this.packetProcess = new PacketProcess();
    }

    @Override
    public void run() {
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
            byte[] data = new byte[8192];
            int readBytes;

            int packetSize = -1;

            while ((readBytes = fromRealClientInputStream.read(data)) != -1) {
                buffer.write(data, 0, readBytes);
                byte[] totalData = buffer.toByteArray();

                if(totalData.length < 4){
                    continue;
                }
                if(packetSize == -1){
                    //OutputUtils.debug("Receiving new client packet");
                    packetSize  = ByteBuffer.wrap(totalData,  0, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
                }

                if(totalData.length < packetSize){
                    continue;
                }

                packetProcess.packerProcess("Client", ByteBuffer.wrap(totalData));
                packetSend.sendToRealServer(totalData);

                buffer.reset();
                packetSize = -1;
            }
        } catch (IOException e) {
            OutputUtils.error("Error sending data to REAL server");
            //throw new RuntimeException(e);
        }
    }
}
