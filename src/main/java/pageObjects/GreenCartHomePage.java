package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import resources.FrameworkBase;

public class GreenCartHomePage extends FrameworkBase{
	// Elements
	// Hearder Elements
	@FindBy(xpath = ".//div/header")
	WebElement headerSection;
	
	@FindBy(partialLinkText = "Limited offer")
	WebElement offerLink;
	
	@FindBy(className = "greenLogo")
	WebElement pageNameLogo;
	
	@FindBy(linkText = "Top Deals")
	WebElement topDeals;
	
	@FindBy(css = ".cartinfo")
	WebElement smallCartTable;
	
	@FindBy(css = "tr:nth-child(1) td:nth-child(3)")
	WebElement smallCartItemCount;
	
	@FindBy(xpath = ".//div[@class='cart-info']/table/tbody/tr[2]/td[3]")
	WebElement smallCartItemPrice;
	
	// Product list
	@FindAll({
		@FindBy(className = "product") 
	})
	List<WebElement> allProducts;
	
	@FindBy(className = "products")
	WebElement productContainer;
	
	// Constructor
	public GreenCartHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Methods
	public boolean verifyLogoExists() { 
		return pageNameLogo.isDisplayed();
	}
	
	public boolean verifyLogoText() { 
		if(pageNameLogo.getText().equals("GREENKART")) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<String> verifyHeaderSectionStyle() {

		ArrayList<String> styleList = new ArrayList<String>(3);
		
		styleList.add(headerSection.getAttribute("style"));
		styleList.add(headerSection.getCssValue("margin-left"));
		styleList.add(headerSection.getCssValue("animation"));
		
		return styleList;
	}
	
	public void verifySmallCartInitialState() {
		Assert.assertEquals(smallCartItemCount.getText(), "0", "Default Item Count is 0");
		Assert.assertEquals(smallCartItemPrice.getText(), "0", "Default Item Price is 0");
		
	}
	
	public int verifyProductCount() {
		int actualProductCount;
		actualProductCount= allProducts.size();
		return actualProductCount;
	}
	
	public WebElement getProductByIndex(int index) {		
		return allProducts.get(index);
	}
	
	public WebElement getProductCardByName(String name) {		
		// Get Element with that name under products list 
		// Get parent element card that contains the product name
		WebElement cardElem = productContainer.findElement(By.xpath("//h4[contains(text(),'" + name + "')]/parent::div[@class='product']"));
		return cardElem;
	}
	
	public ProductCard getProductCardObj(WebElement productCardElement) {
		String imgSrc = productCardElement.findElement(By.cssSelector("img")).getAttribute("src"); 
		String imgAlt = productCardElement.findElement(By.cssSelector("img")).getAttribute("alt");
		String productName = productCardElement.findElement(By.className("product-name")).getText();
		String productPrice = productCardElement.findElement(By.className("product-price")).getText();
		String quantity = productCardElement.findElement(By.className("quantity")).getText();
		WebElement addToCart = productCardElement.findElement(By.tagName("button"));

		ProductCard productCard = new ProductCard(imgSrc, imgAlt, productName, productPrice, quantity, addToCart);
		return productCard;
	}
	
	public String getProductDetails(WebElement elem, String productProperty) {
		ProductCard newProductCard = this.getProductCardObj(elem);
		if(productProperty.equals("src")) {
			return newProductCard.imgSrc;
		} else if (productProperty.equals("alt")) {
			return newProductCard.imgAlt;
		} else if (productProperty.equals("product-name")) {
			return newProductCard.productName;
		} else if (productProperty.equals("product-price")) {
			return newProductCard.productPrice;
		} else if (productProperty.equals("quantity")) {
			return newProductCard.quantity;
		} else if (productProperty.equals("button")) {
			// TODO How to add different Return Datatype
			return "Button";
		} else {
			return "Not a valid Property Name. Use : src, alt, product-name, product-price, quantity, button";
		}
		
		
	}
	
	public void verifyIfImageBroken() {
		// TODO update Code using HTTPRequest
	}
	
	public void verifyIfLinkBroken() {
		// TODO update Code using HTTPRequest
	}
}
