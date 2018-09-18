package be.pxl.computerstore.hardware;

public class WebCam extends Peripheral {

    private int framerate;

    public WebCam(String vendor, String name, double price, int framerate) {
        super(vendor, name, price);
        this.framerate = framerate;
    }
}
