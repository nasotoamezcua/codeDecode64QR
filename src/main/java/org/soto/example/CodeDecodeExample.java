package org.soto.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

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
	
	public String decodificarCadena(String cadena) throws Exception{
		byte[] decodedBytes = Base64.getDecoder().decode(cadena.replace(" ", ""));
		String decodedString = new String(decodedBytes, "UTF-8");
		
		System.out.println("cadena: " +  cadena);
		System.out.println("cadenaOrginal: " +  cadena.replace(" ", ""));
		System.out.println("decodedString: " +  decodedString);
		
		return decodedString;
	}
	
	/**
	 * Este metodo genera la imagen QR
	 * @param cadena
	 * @return
	 * @throws CodeDecodeQRException
	 */
	public BufferedImage generarImgQR(String cadena) throws CodeDecodeQRException{
		try{
			
			System.out.println("cadena: " + cadena);
			
//			PARA MOSTRAR LA IMAGEN QR EN JASPERT REPORT
//			Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>(1);
//	        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//	        BarcodeQRCode codeQR = new BarcodeQRCode(cadena, 0, 0, hints);
//			Image imageQR = codeQR.createAwtImage(Color.BLACK, Color.WHITE);
//			BufferedImage buffImage = new BufferedImage(imageQR.getWidth(null), imageQR.getHeight(null), BufferedImage.TYPE_BYTE_BINARY);
//			Graphics g = buffImage.createGraphics();
//			g.drawImage(imageQR, 0, 0, null);
//			g.dispose();
			
						
//			PARA GUARDAR LA IMAGEN QR EN UN DIRECORIO
			BarcodeQRCode codeQR = new BarcodeQRCode(cadena, 0, 0, null);
			Image imageQR = codeQR.createAwtImage(Color.BLACK, Color.WHITE);
			BufferedImage buffImage = new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_BINARY);
			Graphics g = buffImage.createGraphics();
			g.drawImage(imageQR, 0, 0, 100, 100, null);
			g.dispose();
			
			return buffImage;
		}catch (Exception e) {
			throw new CodeDecodeQRException("Error al generar la imagen del QR", e);
		}
	}
	
	/**
	 * Este metodo codifica la imagen QR en una cadena en base 64
	 * @param cadena
	 * @return
	 * @throws CodeDecodeQRException
	 */
	public String generarImgQRB64(String cadena) throws CodeDecodeQRException {
		
		String encodedString = null;
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(this.generarImgQR(cadena), "png", baos);
			encodedString = new String(Base64.getEncoder().encode(baos.toByteArray()), "UTF-8");
			//Otra forma
			//encodedString = Base64.getEncoder().encodeToString(baos.toByteArray());
		}catch (Exception e) {
			throw new CodeDecodeQRException("Error al codificar la cadena de la imagen QR", e);
		}
		
		return encodedString;
		
	}
	
	/**
	 * Este metodo decodifica  la cadena en base 64 de la imagen QR 
	 * @param imgBase64
	 * @return
	 * @throws IOException
	 */
	public BufferedImage obtenerImgQRB64(String imgBase64) throws CodeDecodeQRException {
		try {
			BufferedImage img = null;
			byte[] bytes = Base64.getDecoder().decode(imgBase64);
			InputStream codeStream = new ByteArrayInputStream(bytes);
			img = ImageIO.read(codeStream);
			codeStream.close();
			return img;
		}catch (Exception e) {
			throw new CodeDecodeQRException("Error al decodificar la cadena de la imagen QR", e);
		}
		
	}
	
	 
}
