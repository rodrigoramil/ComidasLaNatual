package modelo;

public class SentenciasSQL {
	
	

	public static boolean iniciar_Sesion(String entrada_usuario, String entrada_contrasena) {
		
		boolean loginCorrecto = true;
		
		System.out.println("Usuario: "+entrada_usuario+" - Contrase�a: "+ entrada_contrasena);
		
				
		String passcifrado =Criptografia.cifrado(entrada_contrasena);
		
		System.out.println("contrase�a cifrada: "+passcifrado);
		 
		 
		return loginCorrecto;
	}

}
