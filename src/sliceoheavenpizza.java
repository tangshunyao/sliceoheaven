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
    public String pizzaSideDish;
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
        int ingChoice1;
        int ingChoice2;
        int ingChoice3;
    
        while(true) {
            System.out.println("Please pick any three of the following ingredients:\r\n" + //
                            "1. Mushroom\r\n" + //
                            "2. Paprika\r\n" + //
                            "3. Sun-dried tomatoes\r\n" + //
                            "4. Chicken\r\n" + //
                            "5. Pineapple\r\n" + //
                            "Enter any three choices (1, 2, 3,…) separated by spaces:");
            ingChoice1 = scanner.nextInt();
            ingChoice2 = scanner.nextInt();
            ingChoice3 = scanner.nextInt();
    
            if (ingChoice1 > 1 && ingChoice1 < 5 && ingChoice2 > 1 && ingChoice2 < 5 && ingChoice3 > 1 && ingChoice3 < 5) {
            String ing1 = Integer.toString(ingChoice1);
            String ing2 = Integer.toString(ingChoice2);
            String ing3 = Integer.toString(ingChoice3);
            }else{
                System.out.println("Invalid choice(s),Please pick only from the given list:");
            }
            break;
        }

        
        while(true) {
            System.out.println("\n" + //
                                "”What size should your pizza be?\r\n" + //
                                "1. Large\r\n" + //
                                "2. Medium\r\n" + //
                                "3. Small\r\n" + //
                                "Enter only one choice (1, 2, or 3):");
           int sizeChoice = scanner.nextInt();

        switch(sizeChoice){
            case 1:
                pizzaSize =  "Large";
                break;
            case 2:
                pizzaSize = "Medium";
                break;
            case 3:
                pizzaSize =  "Small";
                break;
            default:
                System.out.println("invalid choice(s),please pick only fron the given list");
                continue;
        }
        break;
    }


        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.next();

        while(true){
            System.out.println("”Following are the side dish that go well with your pizza:\r\n" + //
                                "1. Calzone\r\n" + //
                                "2. Garlic bread\r\n" + //
                                "3. Chicken puff\r\n" + //
                                "4. Muffin\r\n" + //
                                "5. Nothing for me\r\n" + //
                                "What would you like? Pick one (1, 2, 3,…):”");
          int sideDishChoice = scanner.nextInt();
  
        switch(sideDishChoice){
            case 1:
                pizzaSideDish =  "Calzone";
                break;
            case 2:
                pizzaSideDish = "Garlic bread";
                break;
            case 3:
                pizzaSideDish =  "Chicken puff";
                break;
            case 4:
               pizzaSideDish ="Muffin";
                break;
            case 5:
                pizzaSideDish = "Nothing for me";
                break;
            default:
            System.out.println("invalid choice(s),please pick only fron the given list");
                continue;
        }
        break;
    }
    

       while(true){
        System.out.println("\n" + //
                        "”Choose from one of the drinks below. We recommend Coca Cola:\r\n" + //
                        "1. Coca Cola\r\n" + //
                        "2. Cold coffee\r\n" + //
                        "3. Cocoa Drink\r\n" + //
                        "4. No drinks for me\r\n" + //
                        "Enter your choice:”");
      int drinkChoice = scanner.nextInt();

    switch(drinkChoice){
        case 1:
            drinks =  "Coca Cola";
            break;
        case 2:
            drinks = "Cold coffee";
            break;
        case 3:
            drinks =  "Chicken puffCocoa Drink";
            break;
        case 4:
            drinks ="No drinks for me";
            break;
        default:
        System.out.println("invalid choice(s),please pick only fron the given list");
            continue;
    }
    break;
}

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.next();
        if ("Y".equals(wantDiscount) || "y".equals(wantDiscount)) {
            isItYourBirthday();
                } else {
                makeCarPayment();                
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
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.parse(birthdate);

        Period diff = Period.between(birthDate, today);
        int age = diff.getYears();

        if(age < 5 && age > 120 ) {
            System.out.println("”Invalid date. You are either too young or too dead to order. Please enter a valid date:"); 
        } else{
            System.out.println("Congratulations! You pay only half the price for your order");
        }
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
        do {
            System.out.println("enter your card number:");
            cardNumber = scanner.nextLong();
            if(cardNumber == 14 && !equals(blackListNumber) ){
                break;
            }else{
                System.out.println("Invalid card number,pleace enter again.");
            }
        } while (true);

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

    public void specialOfTheDay(String pizzaOfTheDay, String sizeOfTheday,String SpeacialPrice){
        StringBuilder specialList = new StringBuilder();
        specialList.append(pizzaOfTheDay).append(SpeacialPrice).append(SpeacialPrice);

        System.out.println(specialList.toString());
    }
}




    



