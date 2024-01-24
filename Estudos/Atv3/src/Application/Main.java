package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		List<Product> produtos = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = leitor.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.print("Product #" + i + " data: ");
			System.out.print("\nCommon, used or imported (c/u/i)? ");
			char opc = leitor.next().charAt(0);
			System.out.print("Name: ");
			String name = leitor.next();
			System.out.print("Price: ");
			double price = leitor.nextDouble();
			
			if(opc == 'i') {
				System.out.print("Customs fee: ");
				double customFee = leitor.nextDouble();
				produtos.add(new ImportedProduct(name, price, customFee));	
			} 
			else if(opc == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate manufactureDate = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				produtos.add(new UsedProduct(name, price, manufactureDate));
			} 
			else {
				produtos.add(new Product(name, price));
			}
		}
		System.out.println("\nPRICE TAGS:");
		for(Product produto : produtos) {
			System.out.print(produto.priceTag());
			System.out.println();
		}
		
		leitor.close();
	}

}
