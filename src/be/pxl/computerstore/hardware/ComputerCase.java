package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Dimension;

public class ComputerCase extends ComputerComponent {
    Dimension dimension;
    double weight;

    public ComputerCase(String vendor, String name, double price) {
        super(vendor, name, price);
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getFullDescription() {
        return super.getFullDescription() +
                seperateWithEquals("Width", Integer.toString((int)dimension.getWidth()) + "mm") +
                seperateWithEquals("Height", Integer.toString((int)dimension.getHeight()) + "mm") +
                seperateWithEquals("Depth", Integer.toString((int)dimension.getDepth()) + "mm") +
                seperateWithEquals("Weight", Double.toString(weight) + "kg");
    }
}