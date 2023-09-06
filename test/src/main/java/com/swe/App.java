package com.swe;
import com.fazecast.jSerialComm.SerialPort;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.println(SerialPort.getCommPorts());
    }
}
