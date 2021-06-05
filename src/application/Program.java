package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter with Contract Data:");
		System.out.print("Number:");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy) :");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract Value :");
		double totalValue = sc.nextDouble();
		System.out.print("Enter with a number of installments :");
		int installments = sc.nextInt();
		
		Contract contract = new Contract(number, date, totalValue);
		
		ContractService cs = new ContractService(new PaypalService());
		
		cs.processContract(contract, installments);
		
		System.out.println("Installments:");
		
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
		}
		
		
		
		
		
		
		
		sc.close();
	}

}
