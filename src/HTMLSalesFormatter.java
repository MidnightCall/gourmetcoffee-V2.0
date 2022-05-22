import java.util.Iterator;
import java.util.Objects;

/**
 *@ClassName HTMLSalesFormatter
 *@Description  HTML commit
 *@Author kojikoji
 *@Date 2022.5.17
 *@Version 2.0
 */


public class HTMLSalesFormatter implements SalesFormatter{
    private final static String NEW_LINE =
            System.getProperty("line.separator");
    private static HTMLSalesFormatter singletonInstance = null;

    public static HTMLSalesFormatter getSingletonInstance() {
        if(singletonInstance == null)
            singletonInstance = new HTMLSalesFormatter();

        return singletonInstance;
    }

    private HTMLSalesFormatter(){

    }

    public String formatSales(Sales sales) {
        String out = "<html>"
                    + NEW_LINE
                    + "  <body>"
                    + NEW_LINE
                    + "    <center><h2>Orders</h2></center>"
                    + NEW_LINE;

        for(Iterator orderIter = sales.getOrdersIterator(); orderIter.hasNext(); ){
            Order o = (Order) orderIter.next();
            out += "    <hr>"
                    + NEW_LINE
                    + "    <h4>"
                    + "Total = "+ o.getTotalCost()
                    + "</h4>"
                    + NEW_LINE
                    + "      <p>"
                    + NEW_LINE;
            for(Iterator itemIter = o.getItemsIterator(); itemIter.hasNext(); ){
                OrderItem i = (OrderItem) itemIter.next();
                out += "        <b>code:</b> "
                        + i.getProduct().getCode()
                        + "<br>"
                        + NEW_LINE
                        + "        <b>quantity:</b> "
                        + i.getQuantity()
                        + "<br>"
                        + NEW_LINE
                        + "        <b>price:</b> "
                        + i.getProduct().getPrice()
                        + "<br>"
                        + NEW_LINE
                        + "     </p>"
                        + NEW_LINE;
            }
            out += "  </body>" + NEW_LINE
                    + "</html>";
        }

        return out;
    }
}
