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
	
	public class RegistroPerfil {
		@Test
		public void RegistroCorrecto() {
		    PerfilControlador controlador = new PerfilControlador();
		    boolean flag = false;
		    Perfil nuevoPerfil = new Perfil(0, "nuevo_usuario", "nuevo_pseudonimo", "nuevo_correo@gmail.com", "nueva_contrasena", "Descripción", false);
		    if (controlador.addPerfil(nuevoPerfil)) {
		        System.out.println("Registro correcto");
		        flag = true;
		    } else {
		        System.out.println("Error el registro falló.");
		    }
		    assertEquals(true, flag);
		}
	
}
}
