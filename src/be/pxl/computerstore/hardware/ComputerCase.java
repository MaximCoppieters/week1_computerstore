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
                seperateWithEquals("Width", Double.toString(dimension.getWidth())) +
                seperateWithEquals("Height", Double.toString(dimension.getHeight())) +
                seperateWithEquals("Depth", Double.toString(dimension.getDepth())) +
                seperateWithEquals("Weight", Double.toString(weight));
    }
}