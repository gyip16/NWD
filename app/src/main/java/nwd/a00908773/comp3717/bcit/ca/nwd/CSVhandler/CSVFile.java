package nwd.a00908773.comp3717.bcit.ca.nwd.CSVhandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Getry on 3/30/2017.
 */
public class CSVFile {

    public static ArrayList<Csvhold> read(InputStream is) throws IOException {
        ArrayList<Csvhold> resultList = new ArrayList<Csvhold>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String csvLine;
        Csvhold hold;
        boolean titleSet = false;
        while ((csvLine = reader.readLine()) != null) {
            String[] row = csvLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            if(!titleSet) {
                for(int i = 0; i < row.length; i++){
                    hold = new Csvhold(row[i]);
                    resultList.add(hold);
                }
                titleSet = true;
            }else {
                for(int j =0; j < row.length; j++) {
                    hold = resultList.get(j);
                    hold.addData(row[j]);
                }
            }
        }

        return resultList;
    }
}

