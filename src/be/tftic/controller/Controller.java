package be.tftic.controller;
import be.tftic.models.Blague;
import be.tftic.service.Repository;

import java.util.Scanner;

public class Controller {
    public Controller(){
        System.out.println("controller created");
    }
    public void control(){
        String userInput="";
        Repository<Blague> repo= new Repository<Blague>();
        // scan pour les strings
        Scanner stringScanner=new Scanner(System.in);
        //scan pour le reste
        Scanner intScanner=new Scanner(System.in);
        while (!userInput.equals("stop")){
            System.out.println("add,delete,update,display,stop");
            userInput=stringScanner.nextLine();
            switch (userInput) {
                case "add":
                    //blague à insérer
                    Blague newBlague= new Blague("Pourquoi les nord Coréens boivent du thé vert?C'est riche en anti-occident!" ,"politique");
                   repo.create(newBlague);
                   System.out.println("blague ajoutée");
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
