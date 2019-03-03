package org.soto.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Base64;

import org.soto.exception.CodeDecodeQRException;
import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.BarcodeQRCode;

@Component
public class CodeDecodeExample {
	
	
	public String codificarCadena(String cadena){
		String encodedString = Base64.getEncoder().encodeToString(cadena.getBytes());
		String encode = "";
		for (int i = 0; i < encodedString.length(); i++) {
			encode += encodedString.charAt(i) + (((i+1)%2 == 0) ? " " : "");
		}
		
		System.out.println("cadena: " +  cadena);
		System.out.println("encodedString: " +  encodedString);
		System.out.println("encode: " +  encode);
		
		return encode;
	}
	
	public String decodificarCadena(String cadena){
		byte[] decodedBytes = Base64.getDecoder().decode(cadena.replace(" ", ""));
		String decodedString = new String(decodedBytes);
		
		System.out.println("cadena: " +  cadena);
		System.out.println("cadenaOrginal: " +  cadena.replace(" ", ""));
		System.out.println("decodedString: " +  decodedString);
		
		return decodedString;
	}
	
	public BufferedImage generarImgQR(String cadena) throws CodeDecodeQRException{
		try{
			
			System.out.println("cadena: " + cadena);
			BarcodeQRCode codeQR = new BarcodeQRCode(cadena, 0, 0, null);
			Image imageQR = codeQR.createAwtImage(Color.BLACK, Color.WHITE);
			BufferedImage buffImage = new BufferedImage(imageQR.getWidth(null), imageQR.getHeight(null), BufferedImage.TYPE_BYTE_BINARY);
			Graphics g = buffImage.createGraphics();
			g.drawImage(imageQR, 0, 0, null);
			g.dispose();
			return buffImage;
		}catch (Exception e) {
			throw new CodeDecodeQRException("Error al generar la imagen del QR", e);
		}
	}
	
	 
}
