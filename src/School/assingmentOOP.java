package School;

// Name: Ruan Viesti Moraes; Date: 12/05/2025

class Car {

    private String make;
    private String model;
    private int year;

    // trdting
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int calculateAge() {
        int currentYear = 2025;
        return currentYear - year;
    }
}

public class assingmentOOP {
    public static void main(String[] args) {

        Car myCar = new Car("Toyota", "Corolla", 2018);

        myCar.setMake("Honda");

        System.out.println("Make: " + myCar.getMake());
        System.out.println("Model: " + myCar.getModel());
        System.out.println("Year: " + myCar.getYear());
        System.out.println("Age: " + myCar.calculateAge() + " years");

    }
}
