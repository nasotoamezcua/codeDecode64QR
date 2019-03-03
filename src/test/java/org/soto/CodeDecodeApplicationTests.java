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
	public void decodificarCadenaTest(){
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
			e.printStackTrace();
		}
	}

}
