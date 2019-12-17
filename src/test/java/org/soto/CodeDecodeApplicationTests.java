package org.soto;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.soto.example.CodeDecodeExample;
import org.soto.exception.CodeDecodeQRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeDecodeApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private CodeDecodeExample codeDecodeExample;
	
	@Test
	public void codificarCadenaTest(){
		System.out.println("Codificar Cadena: " +  codeDecodeExample.codificarCadena("Nestor Alejandro Soto Amezcua"));
		//TmVzdG9yIEFsZWphbmRybyBTb3RvIEFtZXpjdWE=
		//Tm Vz dG 9y IE Fs ZW ph bm Ry by BT b3 Rv IE Ft ZX pj dW E=
	}
	
	@Test
	public void decodificarCadenaTest() throws Exception{
		System.out.println("Decodificar Cadena: " +  
				codeDecodeExample.decodificarCadena("Tm Vz dG 9y IE Fs ZW ph bm Ry by BT b3 Rv IE Ft ZX pj dW E="));
	}
	
	@Test
	public void generarImgQRTest(){
		String IMAGE_FORMAT = "png";
	    String IMG_PATH = "c:/temp/qrcode.png";
	    
	    try {
			FileOutputStream imagenQR = new FileOutputStream(IMG_PATH);
			try {
				ImageIO.write(codeDecodeExample.generarImgQR("TmVzdG9yIEFsZWphbmRybyBTb3RvIEFtZXpjdWE="), IMAGE_FORMAT, imagenQR);
			} catch (IOException | CodeDecodeQRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	
	@Test
	public void generarImgQRCadenaTest(){
		try {
			System.out.println(codeDecodeExample.generarImgQRB64("TmVzdG9yIEFsZWphbmRybyBTb3RvIEFtZXpjdWE="));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void obtenerImgQRB64Test() {
		String IMAGE_FORMAT = "png";
	    String IMG_PATH = "c:/temp/qrcodeB64.png";
	    
	    try {
			FileOutputStream imagenQR = new FileOutputStream(IMG_PATH);
			try {
				ImageIO.write(
						codeDecodeExample.obtenerImgQRB64("iVBORw0KGgoAAAANSUhEUgAAAGQAAABkAQAAAABYmaj5AAABE0lEQVR42s3UParDMAwAYIHWQC5g8NUCuUAgq8EGrwVfIJCrCXSBQlaBnpK+V5qXps5Ybd9k/Rr0Je7wVSJA10t/A4gVsTKhqkR5I2AIXQhDc0X9LM0l+UwQ3kpZ/NSFZy6n2mqYdhWdyEJ6ndpnl15EyA58Gu/b65/E7KSXrs23msghrB0cF61InIfgQnzkshcRUxegLaUmJs8pwChYkyLi5NwwDPEgK8HPswSIWpEKuD7hUlKsiWxo1sfy6PxOjMCCOae2JhWxPL1qqUkQbUVywu31T7IA26OyFD2I1gnN1AxYk20kJ9Sy/O3nuWCdhKbfi/svsLEvRS7I2R3FC7IeUhcTjHqQ1YCzpjbnmr71d/sBi3CEs7euPYgAAAAASUVORK5CYII="), 
							IMAGE_FORMAT, imagenQR);
			} catch (IOException | CodeDecodeQRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
		}
	}
	

}
