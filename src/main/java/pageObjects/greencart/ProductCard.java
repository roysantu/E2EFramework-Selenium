package pageObjects.greencart;

import org.openqa.selenium.WebElement;

public class ProductCard {
	
	String imgSrc;
	String imgAlt;
	String productName;
	String productPrice;
	String quantity;
	WebElement addToCart;
	
	public ProductCard(String imgSrc, String imgAlt, String productName, String productPrice, String quantity,
			WebElement addToCart) {
		this.imgSrc = imgSrc;
		this.imgAlt = imgAlt;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.addToCart = addToCart;
	}

	

}
