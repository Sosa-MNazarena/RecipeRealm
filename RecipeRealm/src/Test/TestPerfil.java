package Test;

import Controladores.PerfilControlador;

import Modelos.Perfil;
public class TestPerfil {
	
	
	
	public class InicioSesion {
	   @Test
	    public void InicioCorrecto() {
	        PerfilControlador controlador = new PerfilControlador();
	        boolean flag = false;
	        for (Perfil perfil : controlador.getAllPerfils()) {
	            if (perfil.IniciarSesion("Coni_2020", "Coni")) {
	                System.out.println("Perfil si");
	                System.out.println("Contraseña: " + perfil.getContrasena()); 
	                flag=true;
	                break;
	            }
	        }
	        assertEquals(true,flag);
	    }
	    @Test
	    public void InicioIncorrecto() {
	        PerfilControlador controlador = new PerfilControlador();
	        boolean flag = false;
	        for (Perfil usuario : controlador.getAllPerfils()) {
	            if (usuario.IniciarSesion("naza", "naaa@gmail.com")) {
	                System.out.println("Perfil no");
	                flag=true;
	                break;
	            }
	        }
	        assertEquals(false,flag);

	    }
	}
	

	
}
