package com.knf.dev.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFGenerator {

	public InputStreamResource InputStreamResource
	   (byte[] pngData)
			throws DocumentException,
			MalformedURLException, IOException {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		Document document = new Document();
		PdfWriter.getInstance(document, out);
		document.open();

		Font font = FontFactory
				.getFont(FontFactory.COURIER, 
						14, BaseColor.BLACK);
		Paragraph para = new Paragraph("Scan QR Code", font);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);
		document.add(Chunk.NEWLINE);

		Image image = Image.getInstance(pngData);
		image.scaleAbsolute(170f, 170f);
		image.setAlignment(Element.ALIGN_CENTER);

		document.add(image);
		document.close();
		ByteArrayInputStream bis = new ByteArrayInputStream
				(out.toByteArray());
		return new InputStreamResource(bis);
	}
}
