import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		String errorFormatMessage = "Caracter invalido, por favor preencha um numero limite para o fibonacci como parametro do programa.";
		Boolean invalidChar = true;
		try {
			int fiboLimit = Integer.parseInt(args[0]);
			fiboPrint(fiboLimit);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Preencha um numero limite para o fibonacci.");
			while (invalidChar) {
				Scanner scan = new Scanner(System.in);
				try {
					if (scan.hasNextInt()) {
						fiboPrint(scan.nextInt());
						invalidChar = false;
						scan.close();
					}
					invalidChar = true;
					throw new NumberFormatException();
	
				} catch (NumberFormatException ex) {
					System.out.println(errorFormatMessage.split(" como")[0]+".");
				}
			}			
		} catch (NumberFormatException e) {
			System.out.print(errorFormatMessage);
		}
	}

	public static void fiboPrint(int limit) {
		LinkedList<Long> number = new LinkedList<>(List.of(0l, 1l));

		for (int i = 0 ; i < limit; i++) {
			number.add(number.get(number.size()-1) + number.get(number.size()-2));
		}

		System.out.printf("Sequencia fibonacci com %d de limite: %s", limit, number);
		System.exit(0);
	}
}
