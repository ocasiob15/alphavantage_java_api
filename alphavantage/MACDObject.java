
package alphavantage;

public class MACDObject {
    public String stock_ticker;
    public String stock_time;
    public double MACD;

    public MACDObject(String stock_ticker, String stock_time, double MACD){
        this.stock_ticker = stock_ticker;
        this.stock_time = stock_time;
        this.MACD = MACD;
    }
}
