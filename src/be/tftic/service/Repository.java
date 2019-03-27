package be.tftic.service;

import be.tftic.models.Blague;

import java.io.*;

public class Repository <T,Tkey> {
    public void create(T obj) {

        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("\\Logs\\blagues.txt"))));
            oos.writeObject(obj);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}