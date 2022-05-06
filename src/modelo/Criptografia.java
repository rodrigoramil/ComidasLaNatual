package modelo;

import java.util.Base64;

public class Criptografia {

		
	public static String cifrado (String textoOriginal) {
		String textoCifrado = Base64.getEncoder().encodeToString(textoOriginal.getBytes());
		return textoCifrado;		
	}

	public static String desCifrado (String textoCifrado) {
		
		byte[] bytesDescodificados = Base64.getDecoder().decode(textoCifrado);
		String textoDescifrado = new String(bytesDescodificados);
		
		return textoDescifrado;		
	}
	

	
	
}