import java.util.Iterator;

public class XMLSalesFormatter implements SalesFormatter{
    private final static String NEW_LINE =
            System.getProperty("line.separator");
    private static XMLSalesFormatter singletonInstance = null;

    public static XMLSalesFormatter getSingletonInstance(){
        if(singletonInstance == null)
            singletonInstance = new XMLSalesFormatter();

        return singletonInstance;
    }

    private XMLSalesFormatter(){

    }

    @Override
    public String formatSales(Sales sales) {
        String out = "<Sales>" + NEW_LINE;

        for(Iterator orderIter = sales.getOrdersIterator(); orderIter.hasNext();){
            Order o = (Order) orderIter.next();
            out += "  <Order total=\""
                    + o.getTotalCost()
                    + "\">"
                    + NEW_LINE;
            for(Iterator itemIter = o.getItemsIterator(); itemIter.hasNext(); ){
                OrderItem i = (OrderItem) itemIter.next();
                out += "  <OrderItem quantity=\""
                        + i.getQuantity()
                        +"\" price=\""
                        + i.getProduct().getPrice()
                        + "\">"
                        + i.getProduct().getCode()
                        + "</OrderItem>"
                        + NEW_LINE;
            }
            out += "  </Order>" + NEW_LINE;
        }
        out += "</Sales>" + NEW_LINE;

        return out;
    }
}
