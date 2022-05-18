import java.util.Iterator;

public class PlainTextSalesFormatter implements SalesFormatter {
    private final static String NEW_LINE =
            System.getProperty("line.separator");
    private static PlainTextSalesFormatter singletonInstance = null;

    static public PlainTextSalesFormatter getSingletonInstance(){
        if(singletonInstance == null)
            singletonInstance = new PlainTextSalesFormatter();

        return singletonInstance;
    }

    private PlainTextSalesFormatter(){

    }

    @Override
    public String formatSales(Sales sales){
        String out = "";
        double total = 0;
        int number = 0;

        for(Iterator salesIter = sales.getOrdersIterator(); salesIter.hasNext(); ){
            number++;
            out += "------------------------" + NEW_LINE;
            out += "Order" + number + NEW_LINE;
            Order o = (Order) salesIter.next();
            for(Iterator orderIter = o.getItemsIterator(); orderIter.hasNext(); ){
                OrderItem i = (OrderItem) orderIter.next();
                out += i.getQuantity() + " " + i.getProduct().getCode() + " "
                        + i.getProduct().getPrice() + NEW_LINE;
                total += i.getQuantity() * i.getProduct().getPrice();
            }
        }
        out += total;

        return out;
    }
}
