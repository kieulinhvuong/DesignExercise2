import java.util.*;

public class MemberCard {
    private Map<CoffeeType, Integer> orderHistory;
    private int coffeePurchased;
    private int coffeeCount;
    private int couponCount;
    private CoffeeType favCoffee;

    public MemberCard(Map<CoffeeType, Integer> orderHistory, int coffeePurchased, int coffeeCount, int couponCount, CoffeeType favCoffee) {
        this.orderHistory = orderHistory;
        this.coffeePurchased = coffeePurchased;
        this.coffeeCount = coffeeCount;
        this.couponCount = couponCount;
        this.favCoffee = favCoffee;
    }

    public void addToOrderHistory(CoffeeType coffee) {
        orderHistory.put(coffee, orderHistory.getOrDefault(coffee, 0)+1);
        coffeeCount++;
        coffeePurchased++;
    }

    public int cupsOfCoffeePurchased() {
        return coffeePurchased;
    }

    public String addCoupon() {
        String generateCoupon = "";
        if (coffeeCount == 3) {
            couponCount++;
            generateCoupon = "get one free";

            //coffeeCount = -1 after getting a coupon bc the fourth coffee cup is free and does not count
            coffeeCount = -1;
        }
        else {
            generateCoupon = "";
        }
        return generateCoupon;
    }

    public void useCoupon() {
        if (couponCount > 0) {
            couponCount--;
        }
    }

    public CoffeeType getFavCoffee() {
        Map.Entry<CoffeeType, Integer> maxEntry = null;
        for (Map.Entry<CoffeeType, Integer> entry : orderHistory.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
                favCoffee = maxEntry.getKey();
            }
        }
        return favCoffee;
    }
}
