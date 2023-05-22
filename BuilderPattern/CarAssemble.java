interface CarBuilder {
    CarBuilder brand(String brand);

    CarBuilder engineType(String engineType);

    CarBuilder transmission(String transmission);

    CarBuilder color(String color);

    CarBuilder passengerCapacity(int passengerCapacity);
}

public class CarAssemble {
    private String brand;
    private String engineType;
    private String transmission;
    private String color;
    private int passengerCapacity;

    public CarAssemble brand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarAssemble engineType(String engineType) {
        this.engineType = engineType;
        return this;
    }

    public CarAssemble transmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarAssemble color(String color) {
        this.color = color;
        return this;
    }

    public CarAssemble passengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
        return this;
    }

    @Override
    public String toString() {
        return "CarAssemble{" +
                "brand='" + brand + '\'' +
                ", engineType='" + engineType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", color='" + color + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                '}';
    }

    public static void main(String[] args) {
        CarAssemble carBuilder = new CarAssemble()
                .brand("Toyota")
                .engineType("Gasoline")
                .transmission("Automatic")
                .color("Red")
                .passengerCapacity(5);

        // Testing toString() method
        System.out.println("Object 1 - toString():");
        System.out.println(carBuilder);

        // Testing getter methods
        System.out.println("\nObject 2 - Getter methods:");
        System.out.println("Brand: " + carBuilder.brand);
        System.out.println("Engine Type: " + carBuilder.engineType);
        System.out.println("Transmission: " + carBuilder.transmission);
        System.out.println("Color: " + carBuilder.color);
        System.out.println("Passenger Capacity: " + carBuilder.passengerCapacity);

        // Testing constructor and setter methods
        CarAssemble car = new CarAssemble()
                .brand("Ford")
                .engineType("Diesel")
                .transmission("Manual")
                .color("Blue")
                .passengerCapacity(4);

        System.out.println("\nObject 3 - Constructor and Setter methods:");
        System.out.println("Brand: " + car.brand);
        System.out.println("Engine Type: " + car.engineType);
        System.out.println("Transmission: " + car.transmission);
        System.out.println("Color: " + car.color);
        System.out.println("Passenger Capacity: " + car.passengerCapacity);
    }
}
