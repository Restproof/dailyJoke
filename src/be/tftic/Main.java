package be.tftic;
import java.util.Scanner;

import be.tftic.models.Blague;
import be.tftic.service.Repository;

public class Main {

    public static void main(String[] args) {

	System.out.println("coucou Thierry");
	// Choix de l'utilisateur
	String userInput="";
	// scan pour les strings
	Scanner stringScanner=new Scanner(System.in);
	//scan pour le reste
	Scanner intScanner=new Scanner(System.in);
	while (!userInput.equals("stop")){
		System.out.println("create,delete,update,display,stop");
	    userInput=stringScanner.nextLine();
	    switch (userInput) {
			case "add":
				System.out.println("create");
				break;
			case "delete":
					System.out.println("delete");
				break;
			case "update":
				System.out.println("update");
				break;
			case "display":
				System.out.println("read");
				break;
			case "stop":
					System.out.println("close");
					break;
			default:
				System.out.println("unknown command");
				break;
			}
        }

        

    }
}
