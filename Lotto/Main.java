package Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

//Napisz program, który:
//zapyta o typowane liczby, przy okazji sprawdzi następujące warunki:
//        czy wprowadzony ciąg znaków jest poprawną liczbą,
//        czy użytkownik nie wpisał tej liczby już poprzednio,
//        czy liczba należy do zakresu 1-49,
//po wprowadzeniu 6 liczb, posortuje je rosnąco i wyświetli na ekranie,
//wylosuje 6 liczb z zakresu i wyświetli je na ekranie,
//poinformuje gracza, czy trafił przynajmniej "trójkę".

public class Main {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in); 
		
		int[] randomNumbers = drawNumbers(); 
		int[] userGuess = collectNumbers(userInput); 
		determineWin(randomNumbers, userGuess); 
		
	}

	
	static int[] drawNumbers() { 
		
		int[] resultTable = new int[6];
		for(int i=0; i<6; i++) { 
			Random randomNumber = new Random(); 
			resultTable[i]= randomNumber.nextInt(49)+1; 			
			for(int j=0;j<i;j++) { 		
				if(resultTable[j]==resultTable[i]) { 
					i--; 
				}
			}
		}
		Arrays.sort(resultTable);
		System.out.println("Wylosowano następujące liczby: "+Arrays.toString(resultTable));
		return resultTable; 
	}
	
	static String determineWin(int[] randomNumbers, int[] userNumbers) { 
		
		int x=0; 
		for(int i=0; i<randomNumbers.length; i++) { 
			if(randomNumbers[i]==userNumbers[i]) { 
				x++;
			}
		}
		
		String Win=""; 
		
		if(x<3) { 
			Win = "Nie wygrałeś nic!";
		} else 
		{
			Win = "Wygrałeś trafiając "+x;
		}
		
		System.out.println(Win);
		return Win; 
	}
	
	
	
	static int[] collectNumbers(Scanner inputNumber) {

		int[] resultTable = new int[6];
		boolean unique = false; 
		
		for (int i = 0; i < 6; i++) {

			System.out.println("Wprowadź liczbę nr " + (i + 1));

			while (resultTable[i] < 1 || resultTable[i] > 49 || unique) {

				while (!inputNumber.hasNextInt()) {
					inputNumber.nextLine();
					System.out.println("To nie jest liczba! wprowadź liczbę nr " + (i + 1));
				}

				resultTable[i] = inputNumber.nextInt();

				if (resultTable[i] < 1 || resultTable[i] > 49) {
					System.out.println("Podano liczbę spoza przedziału 1-49. Wprowadź liczbę nr " + (i + 1));
				}
				
				for(int j=0; j<i; j++) { 
					
					if(resultTable[j]==resultTable[i]) { 
						
						System.out.println("Taką liczbę już raz wybrałeś! Wprowadź liczbę nr "+(i+1));
						unique = true; 
						break; 
					} else { 
						
						unique = false; 
					}	
				}
			}
		}
		Arrays.sort(resultTable);
		System.out.println("Wybrałeś następujące liczby: "+Arrays.toString(resultTable));
		return resultTable;

	}

}
