public class pizza {
    public string storeAddress;
    public string storeName;

    private string menu;

    public long storePhone;
    public string storEemali;
    public string pizzaIngredients;
    public string pizzaPrice;
    public srting pizzaSide;
    public string drinks;

    private string orderID;
    private double orderTotal;

    public void takeorder(srting id, double total){
        orderID = id;
        orderTotal = total;

        system.out.printin("order accepted!");

        system.out.printin("order is being prepared");

        try{
            thread.sleep(5000);
        } catch(interruptedexception e){
            system.out.printin("order is ready for pickup!");
        }

        system.out.printin("your order is ready!");
         
        printreceipt();
    
    }

    private printreceipt(){
        system.out.printin("order ID:" + orderID);
        system.out.printin("order total:" + orderTotal);
    
    }

    public void makepizza(){
        system.out.printin("pizza ingredients:"  + pizzaIngredients);
        system.out.printin("pizza sides:"  + pizzaSide);
        system.out.printin("drinks:"  + drinks);
    }
    
}
