package be.tftic.service;

import be.tftic.models.AppendableObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository <T> {

    public void create(T obj) {

        File newFile = new File ("blagues.txt");
        ObjectOutputStream oos = null;
        AppendableObjectOutputStream aoos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    newFile, true)));

            aoos = new AppendableObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    newFile, true)));

            if (newFile.length()==0){

                oos.writeObject(obj);
                oos.close();
            }

            else{
                aoos.writeObject(obj);
                aoos.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<T> read(){
        ObjectInputStream ois = null;
        T obj = null;
        List<T> list = new ArrayList<T>();

        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File ("blagues.txt"))));
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        try{
                for(;;) {
                    obj = (T) ois.readObject();
                    list.add(obj);
                }
        }

        catch(EOFException e){

        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return list;
        }

    }

}

