package be.pxl.computerstore.util;

public interface Computable {
	int BTW = 21;
	
	double totalPriceExcl();
	
	default double totalPriceIncl() {
		return Math.round(totalPriceExcl() * (1 + BTW / 100.0) * 100) / 100.0;
	}
}
