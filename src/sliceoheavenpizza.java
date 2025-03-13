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
    public final static double PIZZA_BASE_PRICE = 10.0;

    String[] pizzasOrderd = new String[10];
    String[] pizzaSizesOrdered = new String[10];
    String[] sideDishesOrdered = new String[20];
    String[] drinksOrdered = new String[20];

    public sliceoheavenpizza(){
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_GREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
    }

    enum PizzaSelection {
        PEPPERONI("Pepperoni","Lots of pepperroni and extra cheese",18),
        HAWAIIAN("Hawaiian","Pineapple,ham,and extra cheese",22),
        VEGGIEE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives",25),
        BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
        EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);
    
        public String pizzaName;
        public String pizzaToppings;
        public double price;
    
        PizzaSelection(String pizzaName, String pizzaToppings, double price){
            this.pizzaName = pizzaName;
            this.pizzaToppings = pizzaToppings;
            this. price = price;
        }
    
        public String getpizzaName(){
            return pizzaName;
        }
    
        public String getpizzaToppings(){
            return pizzaToppings;
        }
    
        public double getprice(){
            return price;
        }
    
        public String toString(){
            return "pizza Name" + pizzaName + "\n" + "pizza Toppings" + pizzaToppings + "\n" + "price" + price + "\n";
        }
    }   
    
    enum PizzaToppings{
        HAM("Ham", 2), 
        PEPPERONI("Pepperoni", 2),
        BEEF("Beef", 2),
        CHICKEN("Chicken", 2), 
        SAUSAGE("Sausage", 2),
        PINEAPPLE("Pineapple", 1),
        ONION("Onion", 0.5), 
        TOMATOES("Tomatoes", 0.4), 
        GREEN_PEPPER("Green Pepper", 0.5), 
        BLACK_OLIVES("Black Olives", 0.5), 
        SPINACH("Spinach", 0.5), 
        CHEDDAR_CHEESE("Cheddar Cheese", 0.8), 
        MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8), 
        FETA_CHEESE("Feta Cheese", 1),
        PARMESAN_CHEESE("Parmesan Cheese", 1);
    
        public String topping;
        public double toppingPrice;
    
        PizzaToppings(String topping, double toppingPrice){
            this.topping = topping;
            this.toppingPrice = toppingPrice;
        }
    
        public String gettopping(){
            return topping;
        }
    
        public double gettoppingPrice(){
            return toppingPrice;
        }
    
        public String toString(){
            return "topping" + topping + "\n" + "topping price" + toppingPrice + "\n";
        }
    }
    
    enum PizzaSize{
        LARGE("Large", 10), 
        MEDIUM("Medium", 5),
        SMALL("Small", 0);
    
        public String pizzaSize;
        public double addToPizzaPrice;
    
        PizzaSize(String pizzaSize, double addToPizzaPrice){
            this.pizzaSize = pizzaSize;
            this.addToPizzaPrice = addToPizzaPrice;
        }
    
        public String getpizzaSise(){
            return pizzaSize;
        }
    
        public double getaddToPizzaPrice(){
            return addToPizzaPrice;
        }
    
        public String toString(){
            return "pizza size" + pizzaSize + "\n" + "add to pizza price" + addToPizzaPrice + "\n";
        }
    }
    
    enum SideDish{
        CALZONE("Calzone", 15), 
        CHICKEN_PUFF("Chicken Puff", 20),
        MUFFIN("Muffin", 12),
        NOTHING("No side dish", 0);
    
        public String sideDishName;
        public double addToPizzaPrice;
    
        SideDish(String sideDishName, double addToPizzaPrice){
            this.sideDishName = sideDishName;
            this.addToPizzaPrice = addToPizzaPrice;
        }
    
        public String getsideDishName(){
            return sideDishName;
        }
    
        public double getaddToPizzaPrice(){
            return addToPizzaPrice;
        }
    
        public String toString(){
            return "side Dish Name" + sideDishName + "\n" + "add to pizza price" + addToPizzaPrice + "\n";
        }
    }
    
    enum Drinks{
        COCA_COLA("Coca Cola", 8), 
        COCOA_DRINK("Cocoa Drink", 10),
        NOTHING("No drinks", 0);
    
        public String drinkName;
        public double addToPizzaPrice;
    
        Drinks(String drinkName, double addToPizzaPrice){
            this.drinkName = drinkName;
            this.addToPizzaPrice = addToPizzaPrice;
        }
    
        public String getdrinkName(){
            return drinkName;
        }
    
        public double getaddToPizzaPrice(){
            return addToPizzaPrice;
        }
    
        public String toString(){
            return "drink Name" + drinkName + "\n" + "add to pizza price" + addToPizzaPrice + "\n";
        }
    }

    public void takeOrder(){
        double totalOrderPrice = 0;
        int count = 0;
        boolean order = true;

        while(order){
            System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here’s what we serve:");
        PizzaSelection[] pizzaSelections = PizzaSelection.values();
        for(int i = 0; i < 5; i++){
            System.out.println((i+1) +"." + pizzaSelections[i]);
        }

        System.out.println((pizzaSelections.length + 1) + "." + "Custom Pizza with a maximum of 10 toppings that you choose");

        System.out.println("Please enter your choice (1 - 6):");
        int pizzaChoice = scanner.nextInt();

        if (pizzaChoice > 1 &&pizzaChoice < 5) {
            PizzaSelection selectedPizza = pizzaSelections[pizzaChoice-1];
            totalOrderPrice += selectedPizza.getprice();
        } else{
            PizzaToppings[] toppings = PizzaToppings.values();
            for(int i = 0; i < 10; i++){
                System.out.println((i + 1) + "." + toppings[i]);
            }

        double customPizzaPrice = PIZZA_BASE_PRICE;
        StringBuilder customPizzaToppings = new StringBuilder();
        System.out.println("enter a maximum of 10 choices:");
        String[] toppingChoice = scanner.nextLine().split(" ");

        for (int i = 0; i < 10; i++){
            int toppingIndex = Integer.parseInt(toppingChoice[i]) - 1;
            PizzaToppings selectedTopping = toppings[toppingIndex];
            customPizzaPrice += selectedTopping.gettoppingPrice();
            customPizzaToppings.append(selectedTopping.gettopping());
        }

        PizzaSize[] pizzaSizes = PizzaSize.values();
        for(int i = 0; i < 3; i++){
            System.out.println((i + 1) + "." + pizzaSizes[i]);
        }
        
        System.out.println("enter the size you want:");
        int sizeChoice = scanner.nextInt();
        PizzaSize selectedSize = pizzaSizes[sizeChoice - 1];
        pizzaSizesOrdered[count] = selectedSize.toString();
        totalOrderPrice += selectedSize.getaddToPizzaPrice();

        
        SideDish[] sideDishs = SideDish.values();
        for(int i = 0; i < 4; i++){
            System.out.println((i + 1) + "." + sideDishs[i]);
        }

        System.out.println("enter the side dish you want:");
        int sideDishChoice = scanner.nextInt();
        SideDish selectedSideDish = sideDishs[sideDishChoice - 1];
        sideDishesOrdered[count] = selectedSideDish.toString();
        totalOrderPrice += selectedSideDish.getaddToPizzaPrice();

        
        Drinks[] drinks = Drinks.values();
        for(int i = 0; i < 4; i++){
            System.out.println((i + 1) + "." + drinks[i]);
        }

        System.out.println("enter the side dish you want:");
        int drinkChoice = scanner.nextInt();
        Drinks selectedDrinks = drinks[drinkChoice - 1];
        drinksOrdered[count] = selectedDrinks.toString();
        totalOrderPrice += selectedDrinks.getaddToPizzaPrice();

        System.out.println("Do you want to order more(Y\\N)");
        String answer = scanner.next();
        if("Y". equalsIgnoreCase(answer)){
            order = true;
        }
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



    



