package be.pxl.computerstore.hardware;

public class Keyboard extends Peripheral {
    KeyboardLayout keyboardLayout;

    public Keyboard(String vendor, String name, double price, KeyboardLayout keyboardLayout) {
        super(vendor, name, price);
    }
}
