package be.pxl.computerstore.hardware;

public class HardDisk extends ComputerComponent {
    private int capacity;

    public HardDisk(String vendor, String name, double price, int capacity) {
        super(vendor, name, price);
        this.capacity = capacity;
    }

}
