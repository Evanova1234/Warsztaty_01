package Lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
	
	static void determineWin(int[] randomNumbers, int[] userNumbers) { 
		
		int x=0; 
		for(int i=0; i<randomNumbers.length; i++) { 
			if(contains(randomNumbers, userNumbers[i])) { 
				x++;
			}
		}
		if(x<3) { 
			System.out.println("Nie wygrałeś nic!");
		} else 
		{
			System.out.println("Wygrałeś trafiając "+x);
		}		
	}
	
	
	static int[] collectNumbers(Scanner inputNumber) {

		int[] resultTable = new int[6];
		int interNumber = 0; 
		
		for (int i = 0; i < 6; i++) {

			System.out.println("Wprowadź liczbę nr " + (i + 1));
			interNumber = getNumber(inputNumber, i); 
			
			if(contains(resultTable, interNumber)) { 
				System.out.print("Taką liczbę już raz wybrałeś! ");
				i--; 				
			} else if (interNumber>49 || interNumber<1) { 
				System.out.print("Podano liczbę spoza przedziału 1-49. ");
				i--; 				
			} else { 
				resultTable[i] = interNumber; 	
			}
		}
		Arrays.sort(resultTable);
		System.out.println("Wybrałeś następujące liczby: "+Arrays.toString(resultTable));
		return resultTable;
	}


	static int getNumber(Scanner inputNumber, int i) {
		while (!inputNumber.hasNextInt()) {
			inputNumber.nextLine();
			System.out.println("To nie jest liczba! wprowadź liczbę nr " + (i + 1));
		}
		
		return inputNumber.nextInt(); 
	}
	
	
	static boolean contains(int[] array, int value) { 
		for(int elem : array) { 
			if(value == elem) { 		
				return true; 
			}
		}
		return false; 
	}

}
