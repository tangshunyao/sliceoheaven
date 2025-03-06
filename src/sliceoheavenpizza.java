import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
public class sliceoheavenpizza {

    Scanner scanner = new Scanner(System.in);
    public String storeAddress;
    public String storeName;

    public String Menu;

    public long storePhone;
    public String storEemail;
    public String pizzaIngredients;
    public double pizzaPrice;
    public String pizzaSize;
    public String drinks;

    private String orderID;
    private double orderTotal;

    public final static String DEF_ORDER_ID = "DEF_SOH_099";
    public final static String DEF_PIZZA_GREDIENTS = "Mozzarella pizza";
    public final static double DEF_ORDER_TOTAL = 15.00;

    public sliceoheavenpizza(){
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_GREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
    }

    public void takeOrder(){
        System.out.println("Enter three ingredients for your pizza:" );
        String ing1 = scanner.next();
        String ing2 = scanner.next();
        String ing3 = scanner.next();

        System.out.println("Enter size of pizza(small,medium,large):");
        String pizzaSize = scanner.next();

        System.out.println("Do you want extra cheese(Y/N):");
        String extraCheese = scanner.next();

        System.out.println("Enter one side dish(Calzone,Garlic,bread,None):");
        String sideDish = scanner.next();

        System.out.println("Enter drinks(Cold Coffee,Cocoa drink,Coke,None):");
        String drinks = scanner.next();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.next();
        if ("Y".equals(wantDiscount) || "y".equals(wantDiscount)) {
            isItYourBirthday();
                } else {
                makeCarPayment();                
        }

        LocalDate today = LocalDate.now();
        String birthdate = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthdate);

        Period diff = Period.between(birthDate, today);
        int age = diff.getYears();

        if (age < 18 ) {
            System.out.println("”Congratulations! You pay only half the price for your order"); 
        } else {
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
        }

        System.out.println("order accepted!");

        System.out.println("order is being prepared");

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            System.out.println("order is ready for pickup!");
        }

        System.out.println("your order is ready!");
            
        printreceipt();
    
     }

     public void isItYourBirthday(){
        System.out.println("please enter your birthday(dd/mm/yy)");
        String birthdate = scanner.nextLine();
     }

    public void setOrderID(String orderID){
        this.orderID = orderID;
    }

    public String getOrderID(){
        return orderID;
    }

    public void setpizzaIngredients(String pizzaIngredients){
        this.pizzaIngredients = pizzaIngredients;
    }

    public String getpizzaIngredients(){
        return pizzaIngredients;
    }

    public void setOrderTotal(double orderTotal){
        this.orderTotal = orderTotal;
    }

    public double getOrdetTotal(){
        return orderTotal;
    }

    private void printreceipt(){
        System.out.println("********RECEIPT********");

        System.out.println("order ID:" + orderID);
        System.out.println("pizza ingredients:"  + pizzaIngredients);
        System.out.println("pizza sides:"  + pizzaSize);
        System.out.println("drinks:"  + drinks);
        System.out.println("order total:" + orderTotal);
    
    }

    public void makepizza(){
        System.out.println("pizza ingredients:"  + pizzaIngredients);
        System.out.println("pizza sides:"  + pizzaSize);
        System.out.println("drinks:"  + drinks);
    } 

    public void makeCarPayment(){
        System.out.println("enter your card number:");
        long cardNumber = scanner.nextLong();

        System.out.println("enter the card's expiry date(mm/yy):");
        String expiryDate = scanner.next();

        System.out.println("enter your cvv:");
        String cvv = scanner.next();

        processCardPayment(cardNumber, expiryDate, cvv);
    }

    private static final String blackListNumber = "12345678909876";

    public void processCardPayment(long cardNumber, String expiryDate, String cvv){
        String cardnumber = Long.toString(cardNumber);
        int cardLength = cardnumber.length();
        if(cardLength == 14){
            System.out.println("Card acepted");
        }else{
            System.out.println("Invalid card");
        }

        if(cardnumber.equals(blackListNumber)){
            System.out.println("card is blacklisted,pleace use another card.");
        }

        int firstCardDigit = Integer.parseInt(cardnumber.substring(0,1));
        
        int lastFourDigits = Integer.parseInt(cardnumber.substring(cardLength - 4));

        String cardNumberToDisplay = cardnumber.charAt(0) + "*".repeat(cardLength - 5) + cardnumber.substring(cardLength - 4);
    
        System.out.println("first card digit:" + firstCardDigit);
        System.out.println("last four digits:" + lastFourDigits);
        System.out.println("card number to display:" + cardNumberToDisplay);
    }

}
    
