package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitites.Employee;
import entitites.OutsourcedEmployee;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = leitor.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.print("Employee #"+ i +" data: ");
			System.out.print("Outsourced (y/n)? ");
			char opc = leitor.next().charAt(0);	
			System.out.print("Name: ");
			leitor.nextLine();
			String name = leitor.next();
			System.out.print("Hours: ");
			int hours = leitor.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = leitor.nextDouble();
			
			if(opc == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = leitor.nextDouble();
				Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(emp);
				
			} else {
				Employee emp = new Employee(name, hours, valuePerHour);
				list.add(emp);
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS");
		for(Employee employee : list) {
			System.out.printf(employee.getName() + " - U$" + "%.2f", employee.payment());
			System.out.println();
		}
		
		leitor.close();
	}

}
