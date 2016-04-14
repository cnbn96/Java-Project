/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module1.chapter8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author hv
 */
public class JSONExamples {

    public static void main(String[] args) throws MalformedURLException, IOException, ParseException {
        URL layTiGia = new URL("http://dongabank.com.vn/exchange/export");
        URLConnection urlKetNoi = layTiGia.openConnection();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(urlKetNoi.getInputStream()));
        String s = br.readLine();
        System.out.println(s);
        s = s.substring(1, s.length() - 1);
        System.out.println("The string after removing ()");
        System.out.println(s);
        br.close();
        
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj = (JSONObject) jsonParser.parse(s);
        JSONArray jsArr = (JSONArray) jsonObj.get("items");
        
        for (int i = 0; i < jsArr.size(); i++) {
            String sJS = jsArr.get(i).toString();
            System.out.println(sJS);                  
            jsonObj = (JSONObject) jsonParser.parse(sJS);
            System.out.println(jsonObj.get("type"));
        }
        
        
        
    }
}
