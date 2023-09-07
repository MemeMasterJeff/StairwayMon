package com.swe;
import com.fazecast.jSerialComm.SerialPort;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        SerialPort[] serialPorts = SerialPort.getCommPorts();
        //so it doesn't error out when no ports
        if (serialPorts.length == 0) {
            System.err.println("No serial ports found.");
            return;
        }

        SerialPort serialPort = serialPorts[0];//idk copilot did this lol
        serialPort.setBaudRate(9600);
        serialPort.setNumDataBits(8);
        serialPort.setNumStopBits(1);
        serialPort.setParity(SerialPort.NO_PARITY);

        //reading part
        try {
           while (true) {
                byte[] readbuffer = new byte[1024];
                int bytesRead = serialPort.readBytes(readbuffer, readbuffer.length);

                if (bytesRead > 0) {
                    System.out.println("Read " + bytesRead + " bytes.");
                    System.out.println("Data: " + new String(readbuffer, 0, bytesRead));
                }
                Thread.sleep(100);
           } 
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            serialPort.closePort();
        }
    }
}
