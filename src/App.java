public class App {
    public static pizza takeOrder(String orderId, String ingredients, String sides, String drink, String prices, String total) {
        pizza pizza = new pizza(); 
        return pizza;
    }
    public static void main(String[] args) throws Exception {
        pizza pizza1 = new pizza();
        pizza1 = takeOrder("1234", "cheese", "12", "milk", "20", "20");
    }
}
