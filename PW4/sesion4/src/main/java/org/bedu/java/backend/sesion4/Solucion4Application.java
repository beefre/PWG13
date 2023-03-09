package org.bedu.java.backend.sesion4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.bedu.java.backend.sesion4.model.Persona;
import java.util.Scanner;



@SpringBootApplication
public class Solucion4Application implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(Solucion4Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner reader = new Scanner(System.in);
		System.out.println("Nombre");
		String nombre = reader.nextLine();
		System.out.println("Apellidos");
		String apellidos = reader.nextLine();
		System.out.println("Teléfono: ");
		String telefono = reader.nextLine();
		System.out.println("Edad: ");
		String edad = reader.nextLine();

		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellidos(apellidos);
		persona.setEdad(edad);
		persona.setTelefono(telefono);

		System.out.println("Nombre: "+persona.getNombre());
		System.out.println("Apellidos: "+persona.getApellidos());
		System.out.println("Edad: "+persona.getEdad());
		System.out.println("Telefono: "+persona.getTelefono());
	}
}




