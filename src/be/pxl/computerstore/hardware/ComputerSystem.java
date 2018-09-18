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
    private int peripheralIndex = 0;

    public ComputerSystem() {
        peripherals = new Peripheral[MAX_PERIPHERAL];
    }

    public void addPeripheral(Peripheral peripheral) {
        if (peripheralIndex < MAX_PERIPHERAL) {
            peripherals[peripheralIndex] = peripheral;
        } else {
            throw new TooManyPeripheralsException();
        }
    }

    public void removePeripheral(String articleNumber) {
        throw new NotImplementedException();
    }

    public int getNumberOfPeripherals() {
        return peripheralIndex;
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
        double totalPrice = processor.price + hardDisk.price + computerCase.price;

        for (int i=0; i < peripheralIndex; i++) {
            totalPrice += peripherals[i].price;
        }
        return totalPrice;
    }
}