package com.knf.dev.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Component
public class QRCodeGenerator {

	public byte[] getQRCode(String text, int width, int height) 
			throws WriterException, IOException {

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter
				.encode(text, BarcodeFormat.QR_CODE, 
						width, height);
		ByteArrayOutputStream pngOutputStream =
				new ByteArrayOutputStream();
		MatrixToImageConfig con = 
				new MatrixToImageConfig(0xFF000002, 0xFF04B4AE);
		MatrixToImageWriter.writeToStream
		    (bitMatrix, "PNG", pngOutputStream, con);
		byte[] pngData = pngOutputStream.toByteArray();

		return pngData;
	}
}
