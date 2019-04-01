package be.tftic.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository <T> {


   /* private static Repository ourInstance = new Repository();

    public static Repository getInstance() {
        return ourInstance;
    }

    private Repository () {
    }*/

    public void create(T obj) {

        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("blagues.txt"), true)));
            oos.writeObject(obj);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> read(){
        ObjectInputStream ois;
        List<T> list = new ArrayList<T>();

        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File ("blagues.txt"))));
            try {
                while(ois.readObject() != null){
                    list.add((T)ois.readObject());

                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}

