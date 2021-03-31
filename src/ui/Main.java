package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import exceptions.DayNotAvailableException;
import exceptions.UnderAgeException;
import model.Document;
import model.MiniMarket;

public class Main {

	private static MiniMarket miniMarket;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int cont;

	public static void main(String[] args) throws IOException, DayNotAvailableException, UnderAgeException {
		Main main = new Main();
		main.startApp();
	}

	public void startApp() throws IOException, DayNotAvailableException, UnderAgeException {
		miniMarket = new MiniMarket();
		boolean stop = false;
		while(!stop){

			System.out.println("\n------------------------------------------------------\n*"
					+ " ¿QUÉ DESEA HACER? *\n------------------------------------------------------\n"
					+ "**********************************************************************************\n "
					+ "(1.) Registrar el ingreso de una persona.\n (2.) Consultar la cantidad de personas que han intentado ingresar al minimercado.\n"
					+ " (3.) Salir de la aplicación.\n**********************************************************************************\n");

			String option = br.readLine();

			try {

				int opt = Integer.parseInt(option);
				switch(opt){

				case 1: 
					System.out.println("\n ***** Registrar Ingreso de una persona. *****");
					addPeople();
					break;

				case 2:
					System.out.println("\n ***** Consultar la cantidad de personas que han intentado ingresar al minimercado *****");
					System.out.println("Ha intentado ingresar un total de "+cont+" personas al minimercado.");
					break;

				case 3:
					bw.write("Gracias por usar la aplicación :D"); 
					stop = true;
					break;

				default: 
					System.out.println("\nIngresó un numero NO válido");
				}

			}catch(NumberFormatException nfe){
				System.out.println("Debe ingresar un valor númerico como opción.");
			}
		}
		bw.close();
		br.close();
	}

	public static void addPeople() throws IOException {

		boolean stop = false;
		cont++;
		int verify = 0;
		
		while(!stop){
			System.out.println("\n------------------------------------------------------\n*"
					+ " INGRESE EL TIPO DE DOCUMENTO *\n------------------------------------------------------\n"
					+ "*************************************************\n "
					+ "(1.) TI.\n (2.) CC.\n (3.) PP.\n (4.) CE\n*************************************************\n");

			String document = br.readLine();

			try {

				try {

					try {

						int doc = Integer.parseInt(document);
						switch(doc){

						case 1: 
							System.out.println("Ingrese el número de tarjeta identidad");
							String numberTI = br.readLine();  
							stop = true;
							verify = miniMarket.addPeople(Document.TI, numberTI); 
							break;

						case 2:
							System.out.println("Ingrese el número de cédula");
							String numberCC = br.readLine();  
							verify = miniMarket.addPeople(Document.CEDULA, numberCC); 
							stop = true;
							
							if(verify == 1) {
								miniMarket.addPeopleToArray(Document.CEDULA,numberCC);
							}

							verifyNumber(verify);
							
							break;

						case 3:
							System.out.println("Ingrese el número de pasaporte");
							String numberPP = br.readLine();
							stop = true;
							verify = miniMarket.addPeople(Document.CEDULA, numberPP); 
							
							if(verify == 1) {
								miniMarket.addPeopleToArray(Document.CEDULA,numberPP);
							}
							verifyNumber(verify);
							break;

						case 4:
							System.out.println("Ingrese el número de Cédula de extranjería");
							String numberCE = br.readLine();
							stop = true;
							verify = miniMarket.addPeople(Document.CEDULA, numberCE); 
							
							if(verify == 1) {
								miniMarket.addPeopleToArray(Document.CEDULA,numberCE);
							}
							verifyNumber(verify);
							break;

						default: 
							System.out.println("\nIngresó un numero NO válido");
						}
						
					}catch(UnderAgeException uae) {
						System.out.println("La persona es menor de edad, no puede ingresar");
					}
				}catch(DayNotAvailableException dnae) {
					System.out.println("La persona no puede entrar el día de hoy a el mini Mercado");
				}

			}catch(NumberFormatException nfe){
				System.out.println("Debe ingresar un valor númerico como opción.");
			}
		}
	}

	public static void verifyNumber(int verify) {

		if(verify == 1){
			System.out.println("El usuario ha sido registrado");

		}else {
			System.out.println("No ingresó un número para verificar el penúltimo digito");
		}
	}
}
