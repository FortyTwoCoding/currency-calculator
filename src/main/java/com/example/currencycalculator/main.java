package com.example.currencycalculator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static double getvalue(String value) throws java.io.IOException {
            double test = 0;
            String header = "X-CoinAPI-Key: E9049DF1-05DA-4BC3-AEBF-A277A63901E6";
            String[] commands = {"curl", "-H", header, "-X", "GET", "http://rest.coinapi.io/v1/assets/" + value};
            Process process = Runtime.getRuntime().exec(commands);
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                i++;
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
    public static Map<String, String> getcurrency(String base) throws IOException {
        String url = "https://api.exchangerate-api.com/v4/latest/";
        String[] commands = {"curl", "-X", "GET", url + base};
        Process process = Runtime.getRuntime().exec(commands);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line2 = " ";
        String line;
        while ((line = reader.readLine()) != null) {
            line2 = line;
            }
        Map<String, String> dictionary = new HashMap<>();
        String[] array;
        line2 = line2.replaceAll("\\{", "/");
        array = line2.split("/");
        String rates = array[11];
        String[] array2;
        array2 = rates.split(",");
        for (String s : array2) {
            String[] result = s.split(":");
            result[0] = result[0].replace('"', ' ');
            result[0] = result[0].replaceAll(" ", "");
            dictionary.put(result[0], result[1]);

        }
        for (String name: dictionary.keySet()) {
            String value2 = dictionary.get(name);
            System.out.println(name + " " + value2);
        }
        //TODO: return values
        return dictionary;

    }

    public static void main(String[] args) throws IOException{
        getcurrency("usd");
    }
}


