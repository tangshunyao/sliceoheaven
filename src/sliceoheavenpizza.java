public class sliceoheavenpizza {
        public String storeAddress;
        public String storeName;
    
        public String Menu;
    
        public long storePhone;
        public String storEemali;
        public String pizzaIngredients;
        public double pizzaPrice;
        public String pizzaSide;
        public String drinks;
    
        private String orderID;
        private double orderTotal;
    
        public final static String DEF_ORDER_ID = "DEF_SOH_099";
        public final static String DEF_PIZZA_INGREDIENTS = "Mozzarella pizza";
        public final static double DEF_ORDER_TOTAL = 15.00;

        public sliceoheavenpizza(){
            this.orderID = DEF_ORDER_ID;
            this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
            this.orderTotal = DEF_ORDER_TOTAL;

        }
        public void takeOrder(String id, String ingredients, String sides, String drink, double price, double total){
            this.orderID = id;
            this.pizzaIngredients = ingredients;
            this.pizzaSide = sides;
            this.drinks = drink;
            this.pizzaPrice = price;
            this.orderTotal = total;
            
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
            System.out.println("pizza sides:"  + pizzaSide);
            System.out.println("drinks:"  + drinks);
            System.out.println("order total:" + orderTotal);
        
        }
    
        public void makepizza(){
            System.out.println("pizza ingredients:"  + pizzaIngredients);
            System.out.println("pizza sides:"  + pizzaSide);
            System.out.println("drinks:"  + drinks);
        } 

        private static final String blackListNumber = "12345678909876";

        public void processCardPayment(String cardNumber, String expiryDate, int cvv){
            int cardLength = cardNumber.length();
            if(cardLength == 14){
                System.out.println("Card acepted");
            }else{
                System.out.println("Invalid card");
            }

            if(cardNumber.equals(blackListNumber)){
                System.out.println("card is blacklisted,pleace use another card.");
            }

            int firstCardDigit = Integer.parseInt(cardNumber.substring(0,1));
            
            int lastFourDigits = Integer.parseInt(cardNumber.substring(cardLength - 4));

            String cardNumberToDisplay = cardNumber.charAt(0) + "*".repeat(cardLength - 5) + cardNumber.substring(cardLength - 4);
        
            System.out.println("first card digit:" + firstCardDigit);
            System.out.println("last four digits:" + lastFourDigits);
            System.out.println("card number to display:" + cardNumberToDisplay);
        }

    }
    
