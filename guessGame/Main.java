package guessGame;

import java.util.Random;
import java.util.Scanner;

//Napisz prostą grę w zgadywanie liczb. 
//Komputer musi wylosować liczbę w zakresie od 1 do 100. Następnie:
//
//    Zadać pytanie: "Zgadnij liczbę" i pobrać liczbę z klawiatury.
//    Sprawdzić, czy wprowadzony napis, to rzeczywiście liczba 
//    i w razie błędu wyświetlić komunikat "To nie jest liczba", po czym wrócić do pkt. 1
//    Jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana, 
//    wyświetlić komunikat "Za mało!", po czym wrócić do pkt. 1.
//    Jeśli liczba podana przez użytkownika jest większa niż wylosowana, 
//    wyświetlić komunikat "Za dużo!", po czym wrócić do pkt. 1.
//    Jeśli liczba podana przez użytkownika jest równa wylosowanej, 
//    wyświetlić komunikat "Zgadłeś!", po czym zakończyć działanie programu.


public class Main {
	
	public static void main(String[] args) { 
		
		
		int randomValue = randomizeNumber(); 		
		Scanner userInput = new Scanner(System.in); 
		int num = 0; 
		
		while(num!=randomValue) { 
			System.out.println("Zgadnij liczbę!");
			num = getNumber(userInput); 
			
			if(num>randomValue) { 
				System.out.println("Za wysoka wartość");
			} else if (num<randomValue) { 
				
				System.out.println("Za niska wartość");
			} else 
				
			{
				System.out.println("Zgadłeś");
			}
			
		}
		
		userInput.close();
		
	}
	
	static int getNumber(Scanner scan) { 
		
		while(!scan.hasNextInt()) { 
			scan.nextLine(); 
			System.out.println("To nie jest liczba");
			
		}
		return scan.nextInt(); 
	}
	
	static int randomizeNumber() { 
		
		Random resultNumber = new Random(); 
		return resultNumber.nextInt(100)+1; 
		
	}
	
	
	
	}
	
	
	