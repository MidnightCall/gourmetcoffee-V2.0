import java.util.Iterator;

/**
 *@ClassName HTMLSalesFormatter
 *@Description
 *@Author kojikoji
 *@Date 2022.5.17
 *@Version 1.0
 */

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
            }
            out += o.getTotalCost() + NEW_LINE;
        }

        return out;
    }
}
