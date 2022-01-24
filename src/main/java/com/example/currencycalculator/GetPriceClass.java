package com.example.currencycalculator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GetPriceClass {
    public static double getvalue(String value) throws java.io.IOException {
            double test = 0;
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
                if (i == 16) {
                    String[] solution = line.split(": ");
                    String integer = solution[1];
                    solution = integer.split(",");
                    integer = solution[0];
                    test = Double.parseDouble(integer);
                    return test;
                }
            }
            return test;
        }


    public static Map<String, Double> getcurrency(String base) throws IOException {
        //get prices from api
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
        line2 = line2.replaceAll("}","/");
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

    //used to print a map
    private static void printMap(Map<String, Double> map){
        for (String name: map.keySet()) {
            double value2 = map.get(name);
            System.out.println(name + " " + value2);
        }
    }

}


