package be.pxl.computerstore.hardware;

import java.util.concurrent.ThreadLocalRandom;

public class ComputerComponent {
    private final String vendor;
    private final String name;
    private double price;
    private final String articleNumber;

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
            String vendorPadded = vendor + getAmountOfCharacter('X', 3 - vendor.length());

            articleNumberBuilder.append(vendorPadded);
        } else {
            articleNumberBuilder.append(vendor.toUpperCase().substring(0,3));
        }

        articleNumberBuilder.append("-");
        articleNumberBuilder.append(String.format("%05d", generator.nextInt(99999)));

        return articleNumberBuilder.toString();
    }

    private String getAmountOfCharacter(char character, int amount) {
        char[] characters = new char[amount];
        for (int i=0; i < amount; i++) {
            characters[i] = character;
        }
        return new String(characters);
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
        return propertyName + " = " + propertyValue + System.lineSeparator();
    }
}
