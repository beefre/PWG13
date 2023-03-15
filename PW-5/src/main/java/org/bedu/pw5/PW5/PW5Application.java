package org.bedu.pw5.PW5;

import org.bedu.pw5.PW5.Service.FormatearTelefono;
import org.bedu.pw5.PW5.Model.Persona;
import org.bedu.pw5.PW5.Service.ValidarTelefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class PW5Application implements CommandLineRunner {


	private final ValidarTelefono validarTelefono;
	private final FormatearTelefono formatearTelefono;


	@Autowired
	public PW5Application(ValidarTelefono validarTelefono, FormatearTelefono formatearTelefono) {
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



