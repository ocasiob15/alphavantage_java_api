
package alphavantage;

public class RSIObject {
    public String stock_ticker;
    public String stock_time;
    public double rsi;

    public RSIObject(String stock_ticker, String stock_time, double rsi){
        this.stock_ticker = stock_ticker;
        this.stock_time = stock_time;
        this.rsi = rsi;
    }
}