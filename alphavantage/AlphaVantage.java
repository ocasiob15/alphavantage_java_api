package alphavantage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.DoubleAccumulator;

import com.oracle.javafx.jmx.json.JSONReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class AlphaVantage {

    String key;

    public AlphaVantage(String key){
        this.key = key;
    }

    public ArrayList<TimeSeriesIntraday> TIME_SERIES_INTRADAY(String stock_ticker){
        ArrayList<TimeSeriesIntraday> data = new ArrayList<TimeSeriesIntraday>();
        JSONParser parser = new JSONParser();
        try {
            URL endpoint = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + stock_ticker +"&interval=1min&apikey=" + key);
            URLConnection connect = endpoint.openConnection();
            JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(connect.getInputStream()));
            JSONObject obj_2 = (JSONObject) parser.parse(obj.get("Time Series (1min)").toString());
            for(Iterator iterator = obj_2.keySet().iterator();iterator.hasNext();){
                String key = (String) iterator.next();
                JSONObject obj_3 = (JSONObject) parser.parse(obj_2.get(key).toString());
                data.add(new TimeSeriesIntraday(stock_ticker, key,
                        Double.parseDouble(obj_3.get("4. close").toString()), Double.parseDouble(obj_3.get("1. open").toString()),
                        Double.parseDouble(obj_3.get("2. high").toString()), Double.parseDouble(obj_3.get("3. low").toString()),
                        Double.parseDouble(obj_3.get("4. close").toString()), Double.parseDouble(obj_3.get("5. volume").toString())));
            }
        }catch(MalformedURLException ml){
            System.out.println("Failure 0x0001: Endpoint string could not be resolved");
            return null;
        }catch(IOException io){
            System.out.println("Failure 0x0002: Could not connect to endpoint");
            return null;
        }catch(ParseException pe){
            System.out.println("Failure 0x0003: Could not parse the json response");
            return null;
        }

        return data;
    }

    public ArrayList<TimeSeriesIntraday> TIME_SERIES_INTRADAY(String stock_ticker, String time_interval){
        boolean support = false;
        String[] interval_support = {"1min", "5min", "30min", "60min"};
        for(String interval : interval_support){
            if(interval == time_interval){
                support = true;
            }
        }
        if(support == false){
            System.out.println("Fault 0o0001: The time_interval provided is not supported");
            return null;
        }
        ArrayList<TimeSeriesIntraday> data = new ArrayList<TimeSeriesIntraday>();
        JSONParser parser = new JSONParser();
        try {
            URL endpoint = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + stock_ticker +"&interval=" + time_interval +"&apikey=" + key);
            URLConnection connect = endpoint.openConnection();
            JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(connect.getInputStream()));
            JSONObject obj_2 = (JSONObject) parser.parse(obj.get("Time Series (1min)").toString());
            for(Iterator iterator = obj_2.keySet().iterator();iterator.hasNext();){
                String key = (String) iterator.next();
                JSONObject obj_3 = (JSONObject) parser.parse(obj_2.get(key).toString());
                data.add(new TimeSeriesIntraday(stock_ticker, key,
                        Double.parseDouble(obj_3.get("4. close").toString()), Double.parseDouble(obj_3.get("1. open").toString()),
                        Double.parseDouble(obj_3.get("2. high").toString()), Double.parseDouble(obj_3.get("3. low").toString()),
                        Double.parseDouble(obj_3.get("4. close").toString()), Double.parseDouble(obj_3.get("5. volume").toString())));
            }
        }catch(MalformedURLException ml){
            System.out.println("Failure 0x0001: Endpoint string could not be resolved");
            return null;
        }catch(IOException io){
            System.out.println("Failure 0x0002: Could not connect to endpoint");
            return null;
        }catch(ParseException pe){
            System.out.println("Failure 0x0003: Could not parse the json response");
            return null;
        }

        return data;
    }
