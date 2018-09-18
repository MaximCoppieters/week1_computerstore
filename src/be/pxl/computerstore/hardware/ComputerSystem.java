package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Computable;
import be.pxl.computerstore.util.TooManyPeripheralsException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ComputerSystem implements Computable {
    public static final int MAX_PERIPHERAL = 3;

    private Processor processor;
    private HardDisk hardDisk;
    private ComputerCase computerCase;
    
    private Peripheral[] peripherals;
    private int numberOfPeripherals;

    public ComputerSystem() {
        peripherals = new Peripheral[MAX_PERIPHERAL];
    }

    public void addPeripheral(Peripheral peripheral) {
        int nextIndex = findNextPeripheralIndex();

        peripherals[nextIndex] = peripheral;
        numberOfPeripherals++;
    }

    private int findNextPeripheralIndex() {
        for (int i=0; i < MAX_PERIPHERAL; i++) {
            if (peripherals[i] == null) {
                return i;
            }
        }
        throw new TooManyPeripheralsException();
    }

    public void removePeripheral(String articleNumber) {
        for (int i=0; i < MAX_PERIPHERAL; i++) {
            if (peripherals[i] ==  null) continue;
            if (peripherals[i].getArticleNumber().equals(articleNumber)) {
                peripherals[i] = null;
                numberOfPeripherals--;
            }
        }
    }

    public int getNumberOfPeripherals() {
        return numberOfPeripherals;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public ComputerCase getComputerCase() {
        return computerCase;
    }

    public void setComputerCase(ComputerCase computerCase) {
        this.computerCase = computerCase;
    }

    public Peripheral[] getPeripherals() {
        return peripherals;
    }

    public void setPeripherals(Peripheral[] peripherals) {
        this.peripherals = peripherals;
    }

    @Override
    public double totalPriceExcl() {
        double totalPrice = addComponentPriceIfPresent(processor);
        totalPrice += addComponentPriceIfPresent(hardDisk);
        totalPrice += addComponentPriceIfPresent(computerCase);

        for (int i=0; i < MAX_PERIPHERAL; i++) {
            totalPrice += addComponentPriceIfPresent(peripherals[i]);
        }
        return totalPrice;
    }

    private double addComponentPriceIfPresent(ComputerComponent component) {
        if (component != null) {
            return component.getPrice();
        }
        return 0;
    }
}