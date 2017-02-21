package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("***** Application Opérateurs *****\nVeuillez saisir le premier nombre...");
		float nombre1 = sc.nextFloat();
		System.out.println("*Veuillez saisir le second nombre...");
		float nombre2 = sc.nextFloat();
		System.out.println(nombre1 + " + " +nombre2 + " = " + (nombre1+nombre2));
		System.out.println(nombre1 + " - " +nombre2 + " = " + (nombre1-nombre2));
		System.out.println(nombre1 + " * " +nombre2 + " = " + (nombre1*nombre2));
		System.out.println(nombre1 + " / " +nombre2 + " = " + (nombre1/nombre2));
		System.out.println(nombre1 + " % " +nombre2 + " = " + (nombre1%nombre2));
	}

}