package fr;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import fr.service.CardboardService;

public class Main {

	public static void main(String[] args) {
		System.out.print("Veuillez renseigner une chaîne d\'articles :");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		s.close();
		try {
			String optimizedCardboard = CardboardService.generateListCardBoard(input);
			int numberCardboard = StringUtils.countMatches(optimizedCardboard, '/');
			System.out.print("La chaîne d'articles emballés est composée de " + numberCardboard + " cartons : " + optimizedCardboard);
		} catch (NumberFormatException e) {
			System.out.print("La chaîne d'articles ne doit contenir que des chiffres !");
		}
	}

}
