package com.example.simple_to_do_app;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataStorage {

    public static final String FILENAME="listinfo.dat" ;

    public static void writeData(ArrayList<String> items, Context context){
        try{
            FileOutputStream file = context.openFileOutput(FILENAME,Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(file);
            os.writeObject(items);
            os.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }


    public  static ArrayList readData(Context context){
            ArrayList itemList = null;
            try {
                FileInputStream ip = context.openFileInput(FILENAME);
                ObjectInputStream ips = new ObjectInputStream(ip);
                itemList = (ArrayList) ips.readObject();
            }catch(FileNotFoundException ex){
                ex.printStackTrace();

                itemList =new ArrayList();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        return itemList;
    }

}
