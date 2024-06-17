/*Fazer um programa para ler os dados de uma conta bancária e depois realizar um
saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
saque da conta. Implemente a conta bancária conforme projeto abaixo:
 * */
package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data: ");
		System.out.println("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.println("Holder: ");
		String name = sc.nextLine();
		System.out.println("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.println("Withdraw limit: ");
		double limitWithdraw = sc.nextDouble();

		Account acc = new Account(number, name, balance, limitWithdraw);

		System.out.println("Enter amount for withdraw: \n");
		double amount = sc.nextDouble();
		try {
			acc.withdraw(amount);
			System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
		} catch (DomainException e) {
			System.out.println("Error withdraw: " + e.getMessage());
		}

		sc.close();
	}
}
