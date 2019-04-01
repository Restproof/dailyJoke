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
                    System.out.println("Contenu de la blague");
                    // contenu de la blague
                    String blagueContent=stringScanner.nextLine();
                    // catégorie de la blague
                    System.out.println("Catégorie de la blague");
                    String cat=stringScanner.nextLine();
                    Blague newBlague= new Blague(blagueContent ,cat);
                   repo.create(newBlague);
                   //oki
                   System.out.println("blague ajoutée");
                    break;
                case "delete":
                    System.out.println("delete");
                    break;
                case "update":
                    System.out.println("update");
                    break;
                case "display":
                    Blague blague=repo.read();
                    System.out.println(blague.getJokeContent()+" cat :"+blague.getCategory());
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
