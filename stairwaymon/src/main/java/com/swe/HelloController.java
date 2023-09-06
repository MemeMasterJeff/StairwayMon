package com.swe;

import lombok.Data;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fazecast.jSerialComm.*;


//shid I did this in the wrong file
@RestController
public class HelloController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    private static InputStream in;
    public static void main(String[] args) {
        SerialPort comPort = SerialPort.getCommPorts()[0];
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);;
        in = comPort.getInputStream();
                

    }
    //idk 
    @RequestMapping("/")
    char poll() {
        char signal = 1;//picked random number
        try{
            signal = (char)in.read();
            System.out.println(signal);
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return signal;
    }

}
