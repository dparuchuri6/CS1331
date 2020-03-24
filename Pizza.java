public class Pizza {

    private int numSlices;
    private boolean hasCheese;
    private boolean isGlutenFree;
    private String[] toppings;


    public Pizza() {
        this.numSlices = 0;
        this.hasCheese = false;
        this.isGlutenFree =  false;
        this.toppings = new String[0];

    }

    public Pizza(int numSlices, boolean hasCheese, boolean isGlutenFree, String[] toppings) {
        this.numSlices = numSlices;
        this.hasCheese = hasCheese;
        this.isGlutenFree = isGlutenFree;
        this.toppings = toppings;

    }

    public int getNumSlices() {
        return this.numSlices;
    }

    public void setNumSlices(int numSlices) {
        this.numSlices = numSlices;
    }

    /*
    public boolean isHasCheese() {
        return this.hasCheese;
    }
    */

    public void setHasCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
    }

    /*
    public boolean isIsGlutenFree() {
        return this.isGlutenFree;
    }
    */

    public void setIsGlutenFree(boolean isGlutenFree) {
        this.isGlutenFree = isGlutenFree;
    }



    public String[] getToppings() {
        return this.toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public void printToppings() {
        System.out.println("Pizza Toppings: ");
        for (int i = 0; i < this.toppings.length; i++) {
            System.out.println(this.toppings[i]);
        }
    }

    public void changeFirstTopping(String changeFirstTopping) {
        if (this.toppings.length != 0) {
            this.toppings[0] = changeFirstTopping;
        }
    }
}
