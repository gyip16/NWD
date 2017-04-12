package nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers;

import java.util.ArrayList;

/**
 * Created by Getry on 4/11/2017.
 */

public class Csvhold {
    String CsName;
    ArrayList<String> Data;
    public Csvhold(String name){
        CsName = name;
        Data = new ArrayList<String>();

    }
    public void setData(String data) {
        Data.add(data);
    }
    public ArrayList<String> getData(){
        return Data;
    }
    public String getName() {
        return CsName;
    }

}