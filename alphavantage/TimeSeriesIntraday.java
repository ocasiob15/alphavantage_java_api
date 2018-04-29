
package alphavantage;

public class TimeSeriesIntraday {
    public String stock_ticker;
    public String stock_time;
    public double stock_quote;
    public double open;
    public double high;
    public double low;
    public double close;
    public double volume;

    public TimeSeriesIntraday(String stock_ticker, String stock_time, double stock_quote, double open, double high, double low, double close, double volume){
        this.stock_ticker = stock_ticker;
        this.stock_time = stock_time;
        this.stock_quote = stock_quote;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }
}