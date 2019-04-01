package be.tftic.controller;
import be.tftic.models.Blague;
import be.tftic.service.Repository;

import java.util.List;
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
                    System.out.println("catégorie de la blague");
                    String cat=stringScanner.nextLine();
                    Blague newBlague= new Blague(blagueContent ,cat);
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
                    List<Blague> liste = repo.read();
                    for(Blague key : liste){
                        System.out.println(key.getJokeContent()+" cat :"+ key.getCategory());
                    }

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
