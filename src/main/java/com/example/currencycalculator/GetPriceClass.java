package com.example.currencycalculator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GetPriceClass {
    public double price;
    public String name;
    // source: https://stackoverflow.com/questions/1359689/how-to-send-http-request-in-java
    public static GetPriceClass getvalue(String value) throws IOException {
            GetPriceClass test1 = new GetPriceClass();
            //grab data from api
            String header = "X-CoinAPI-Key: E9049DF1-05DA-4BC3-AEBF-A277A63901E6";
            String[] commands = {"curl", "-H", header, "-X", "GET", "http://rest.coinapi.io/v1/assets/" + value};
            Process process = Runtime.getRuntime().exec(commands);
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                i++;
                //grab the 16th line and split apart to save the price
                if (i== 4){
                    String[] solution = line.split(": ");
                    String integer = solution[1];
                    solution = integer.split(",");
                    test1.name = solution[0];
                    test1.name = test1.name.replace('"', ' ');
                    test1.name = test1.name.replaceAll(" ", "");
                }
                if (i == 16) {
                    String[] solution = line.split(": ");
                    String integer = solution[1];
                    solution = integer.split(",");
                    integer = solution[0];
                    test1.price = Double.parseDouble(integer);
                    return test1;
                }
            }
            return test1;
        }


    public static Map<String, Double> getcurrency(String base){
        //get prices from api
        try {
            String url = "https://api.exchangerate-api.com/v4/latest/";
            String[] commands = {"curl", "-X", "GET", url + base};
            Process process = Runtime.getRuntime().exec(commands);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line2 = " ";
            String line;
            //grab return values
            while ((line = reader.readLine()) != null) {
                line2 = line;
            }
            //save everything into a hashmap after cutting apart and sorting
            Map<String, Double> dictionary = new HashMap<>();
            String[] array;
            line2 = line2.replaceAll("\\{", "/");
            line2 = line2.replaceAll("}", "/");
            array = line2.split("/");
            String rates = array[11];
            String[] array2;
            array2 = rates.split(",");
            for (String s : array2) {
                String[] result = s.split(":");
                result[0] = result[0].replace('"', ' ');
                result[0] = result[0].replaceAll(" ", "");
                dictionary.put(result[0], Double.parseDouble(result[1]));
            }
            //return the hashmap with Currency shortcut and respective price
            return dictionary;
        }
        catch (IOException e){
            Map<String, Double> dictionary = new HashMap<>();
            return dictionary;
        }
    }

    //used to print a map
    public static void printMap(Map<String, Double> map){
        for (String name: map.keySet()) {
            double value2 = map.get(name);
            System.out.println(name + " " + value2);
        }
    }

}


