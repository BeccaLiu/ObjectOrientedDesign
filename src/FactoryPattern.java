/**
 * Created by rliu on 5/5/17.
 */
class FactoryPattern {
    public static void main(String[] args) {
        FoodFactory foodFactory = new FoodFactory();

        //factory instantiates an object
        Food food = foodFactory.getFood("cake");

        System.out.println("The factory returned " + food.getClass());
        System.out.println(food.getType());
    }

}

class FoodFactory {
    public Food getFood(String order) {
        if (order.equals("pizza")) {
            return new Pizza();
        }
        if (order.equals("cake")) {
            return new Cake();
        } else
            return null;
    }
}

interface Food {
    String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {

    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

