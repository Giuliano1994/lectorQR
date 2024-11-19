package com.qr.lectorqr;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.google.zxing.WriterException;
import com.qr.lectorqr.utils.GeneradorQR;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class LectorqrApplication {

	public static void main(String[] args) {
		SpringApplication.run(LectorqrApplication.class, args);
	}


}
