
package alphavantage;

import java.util.ArrayList;

public class VantageData {
    String key;
    AlphaVantage api;

    public VantageData(String key){
        this.key = key;
        api = new AlphaVantage(key);
    }

    public double stock_quote(String ticker){
        ArrayList<TimeSeriesIntraday> data = api.TIME_SERIES_INTRADAY(ticker);
        if(data == null){
            System.out.println("Failure 1x0001: Could not retrieve stock data");
            return 0;
        }
        int last_index = data.size() - 1;
        return data.get(last_index).stock_quote;
    }

    public double stock_rsi(String ticker, String time_interval){
        boolean support = false;
        String[] interval_support = {"1min", "5min", "30min", "60min", "daily", "weekly", "monthly"};
        for(String interval : interval_support){
            if(interval == time_interval){
                support = true;
            }
        }
        if(support == false){
            System.out.println("Fault 0o0001: The time_interval provided is not supported");
            System.out.println("\t-Supported inputs- 1min, 5min, 30min, 60min, daily, weekly, monthly");
            return 0.0;
        }
        ArrayList<RSIObject> data = api.RSI(ticker, time_interval, "20");
        if(data == null){
            System.out.println("Failure 1x0001: Could not retrieve stock data");
            return 0;
        }
        int last_index = data.size() - 1;
        return data.get(last_index).rsi;
    }
}