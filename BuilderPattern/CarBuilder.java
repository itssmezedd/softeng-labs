public interface CarBuilder {
    CarBuilder brand(String brand);

    CarBuilder engineType(String engineType);

    CarBuilder transmission(String transmission);

    CarBuilder color(String color);

    CarBuilder passengerCapacity(int passengerCapacity);
}
