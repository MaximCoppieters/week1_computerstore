package be.pxl.computerstore.hardware;

public abstract class Peripheral extends ComputerComponent {

    Peripheral(String vendor, String name, double price) {
        super(vendor, name, price);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)",
                getClass().getSimpleName(), name, articleNumber);
    }
}
