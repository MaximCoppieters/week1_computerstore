package be.pxl.computerstore.hardware;

import java.util.concurrent.ThreadLocalRandom;

public class ComputerComponent {
    final String vendor;
    final String name;
    double price;
    final String articleNumber;

    private static final ThreadLocalRandom generator = ThreadLocalRandom.current();

    ComputerComponent(String vendor, String name, double price) {
        this.vendor = vendor;
        this.name = name;
        this.price = price;
        articleNumber = generateArticleNumber();
    }

    private String generateArticleNumber() {
        StringBuilder articleNumberBuilder = new StringBuilder();

        if (vendor.length() < 3) {
            articleNumberBuilder.append(String.format("%3s", vendor).replace(" ", "X"));
        } else {
            articleNumberBuilder.append(vendor.toUpperCase().substring(0,3));
        }

        articleNumberBuilder.append("-");
        articleNumberBuilder.append(String.format("%05d", generator.nextInt()));

        return articleNumberBuilder.toString();
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, articleNumber);
    }

    public String getFullDescription() {
        return seperateWithEquals("ArticleNumber", articleNumber) +
                seperateWithEquals("Vendor", vendor) +
                seperateWithEquals("Name", name) +
                seperateWithEquals("Price", Double.toString(price));
    }

    protected String seperateWithEquals(String propertyName, String propertyValue) {
        return propertyName + " = " + propertyValue;
    }
}
