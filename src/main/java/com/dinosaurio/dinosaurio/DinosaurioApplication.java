package com.dinosaurio.dinosaurio;

import com.dinosaurio.dinosaurio.controller.CuidadorController;
import com.dinosaurio.dinosaurio.controller.DinosaurioController;
import com.dinosaurio.dinosaurio.controller.HabitatController;
import com.dinosaurio.dinosaurio.entity.Habitat;
import com.dinosaurio.dinosaurio.entity.Dinosaurio;
import com.dinosaurio.dinosaurio.entity.Cuidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class DinosaurioApplication implements CommandLineRunner {

	@Autowired
	private HabitatController habitatCtrl;

	@Autowired
	private DinosaurioController dinosaurioCtrl;

	@Autowired
	private CuidadorController cuidadorCtrl;

	public static void main(String[] args) {
		SpringApplication.run(DinosaurioApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n🌍 GESTIÓN DE MUNDO DE DINOSAURIOS");
			System.out.println("1. Crear hábitat");
			System.out.println("2. Crear dinosaurio");
			System.out.println("3. Crear cuidador");
			System.out.println("4. Listar dinosaurios");
			System.out.println("5. Asignar cuidadores a dinosaurio");
			System.out.println("0. Salir");
			System.out.print("Opción: ");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
				case 1 -> {
					System.out.print("Nombre: ");
					String nombre = sc.nextLine();
					System.out.print("Tipo: ");
					String tipo = sc.nextLine();
					System.out.print("Clima: ");
					String clima = sc.nextLine();
					habitatCtrl.crearHabitat(nombre, tipo, clima);
				}
				case 2 -> {
					System.out.print("Nombre: ");
					String nombre = sc.nextLine();
					System.out.print("Especie: ");
					String especie = sc.nextLine();
					System.out.print("Peso: ");
					double peso = sc.nextDouble();
					System.out.print("Edad: ");
					int edad = sc.nextInt();
					System.out.print("ID del hábitat: ");
					int idHabitat = sc.nextInt();
					Optional<Habitat> habitat = habitatCtrl.buscarHabitat(idHabitat);
					if (habitat.isPresent()) {
						dinosaurioCtrl.crearDinosaurio(nombre, especie, peso, edad, habitat.get());
					} else {
						System.out.println("❌ Hábitat no encontrado.");
					}
					sc.nextLine();
				}
				case 3 -> {
					System.out.print("Nombre: ");
					String nombre = sc.nextLine();
					System.out.print("Especialidad: ");
					String especialidad = sc.nextLine();
					cuidadorCtrl.crearCuidador(nombre, especialidad);
				}
				case 4 -> {
					List<Dinosaurio> dinos = dinosaurioCtrl.listarDinosaurios();
					dinos.forEach(System.out::println);
				}
				case 5 -> {
					System.out.print("ID del dinosaurio: ");
					int idDino = sc.nextInt();
					Optional<Dinosaurio> dino = dinosaurioCtrl.buscarDinosaurio(idDino);
					if (dino.isEmpty()) {
						System.out.println("❌ Dinosaurio no encontrado.");
						break;
					}
					System.out.print("¿Cuántos cuidadores quieres asignar?: ");
					int cantidad = sc.nextInt();
					sc.nextLine();
					List<Cuidador> seleccionados = new java.util.ArrayList<>();
					for (int i = 0; i < cantidad; i++) {
						System.out.print("ID cuidador #" + (i + 1) + ": ");
						int idC = sc.nextInt();
						Optional<Cuidador> c = cuidadorCtrl.buscarCuidador(idC);
						c.ifPresent(seleccionados::add);
					}
					dinosaurioCtrl.asignarCuidadores(dino.get(), seleccionados);
				}
				case 0 -> System.out.println("👋 ¡Hasta luego!");
				default -> System.out.println("❌ Opción inválida.");
			}
		} while (opcion != 0);

		sc.close();
	}
}
