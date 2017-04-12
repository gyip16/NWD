package nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Getry on 3/30/2017.
 */
public class CSVFile {
    InputStream inputStream;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public ArrayList<Csvhold> read(){
        ArrayList<Csvhold> resultList = new ArrayList<Csvhold>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            Csvhold hold;
            int count = 0;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                if(count == 0) {
                    for(int i = 0; i < row.length; i++){
                        hold = new Csvhold(row[i]);
                        resultList.add(hold);


                    }
                    count = 1;

                }else {
                    for(int j =0; j < row.length; j++) {
                        resultList.get(j).setData(row[j]);
                    }
                }
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;
    }
}

