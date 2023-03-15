package org.bedu.PW5;

import java.util.Scanner;

import org.bedu.PW5.model.Persona;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.bedu.PW5.service.FormatearTelefono;
import org.bedu.PW5.service.ValidarTelefono;


@SpringBootApplication
public class Pw5Application implements CommandLineRunner {

	private final ValidarTelefono validarTelefono;
	private final FormatearTelefono formatearTelefono;


	public static void main(String[] args) {
		SpringApplication.run(Pw5Application.class, args);
	}

	@Autowired
	public Pw5Application(ValidarTelefono validarTelefono, FormatearTelefono formatearTelefono) {
		this.validarTelefono = validarTelefono;
		this.formatearTelefono = formatearTelefono;
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner reader = new Scanner(System.in);


		System.out.println("Introduce el nombre: ");
		String nombre = reader.nextLine();


		System.out.println("Introduce el teléfono: ");
		String telefono = reader.nextLine();


		if (validarTelefono.isValido(telefono)) {
			telefono = validarTelefono.limpiaNumero(telefono);
			telefono = formatearTelefono.formatea(telefono);


			Persona persona = new Persona(nombre, telefono);


			System.out.println(persona);
		} else {
			System.out.println("Por favor, introduce un número válido");
		}
	}
}






