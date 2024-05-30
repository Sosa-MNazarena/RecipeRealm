package Tests;

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
		
		@Test
		 public void InicioIncorrecto() {
		        PerfilControlador controlador = new PerfilControlador();
		        boolean flag = false;

		        //CamposVacios
		        Perfil perfilCamposVacios = new Perfil(0, "", "Coni", "coni@example.com", "Coni_2020", "Descripción correcta", false);
		        if (controlador.addPerfil(perfilCamposVacios)) {
		            System.out.println("Registro incorrecto: campos vacíos.");
		            flag = true;
		        } else {
		            System.out.println("Error, se supone que el registro falla por campos vacíos.");
		        }

		        //RegistroContraIncorrecta
		        Perfil perfilContraIncorrecta = new Perfil(0, "Coni", "Coni", "coni@example.com", "123456", "Descripción correcta", false);
		        if (controlador.addPerfil(perfilContraIncorrecta)) {
		            System.out.println("Registro incorrecto: contraseña incorrecta.");
		            flag = true;
		        } else {
		            System.out.println("Error, se supone que el registro falla por contraseña incorrecta.");
		        }

		        //RegistroDescripcionLarga
		        String descripcionLarga = "El pequeño cocodrilo para aprender sus cantares usa las aguas del Nilo con sus notas musicales. Con hipo... con hipo... con hipócrita modestia sus garras pone a indicar a los tiernos pececillos por donde deben entrar.";
		        Perfil perfilDescripcionLarga = new Perfil(0, "Coni", "Coni", "coni@example.com", "Coni_2020", descripcionLarga, false);
		        if (controlador.addPerfil(perfilDescripcionLarga)) {
		            System.out.println("Registro incorrecto: descripción larga.");
		            flag = true;
		        } else {
		            System.out.println("Error, se supone que el registro falla por descripción larga.");
		        }

		      
		        assertEquals(false, flag);
		    }
	
}
}
