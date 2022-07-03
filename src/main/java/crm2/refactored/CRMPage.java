package crm2.refactored;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CRMPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id=\"user-name\"]")
    private WebElement userNameField;

    @FindBy(how = How.XPATH, using = "//input[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//input[@id=\"login-button\"]")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement title;

    @FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement addToCartProduct1;

    @FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    private WebElement addToCartProduct2;

    @FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    private WebElement addToCartProduct3;

    @FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
    private WebElement addToCartProduct4;

    @FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
    private WebElement addToCartProduct5;

    @FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
    private WebElement addToCartProduct6;

    @FindBy(how = How.XPATH, using = "//*[@id=\"shopping_cart_container\"]")
    private WebElement cartButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"remove-sauce-labs-bike-light\"]")
    private WebElement removeProduct2;

    @FindBy(how = How.XPATH, using = "//*[@id=\"remove-test.allthethings()-t-shirt-(red)\"]")
    private WebElement removeProduct6;

    @FindBy(how = How.XPATH, using = "//*[@id=\"continue-shopping\"]")
    private WebElement continueShoppingButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"checkout\"]")
    private WebElement checkoutButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"first-name\"]")
    private WebElement firstNameField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"last-name\"]")
    private WebElement lastNameField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"postal-code\"]")
    private WebElement zipPostalCode;

    @FindBy(how = How.XPATH, using = "//*[@id=\"continue\"]")
    private WebElement continueButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"finish\"]")
    private WebElement finishButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"back-to-products\"]")
    private WebElement backHomeButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"menu_button_container\"]/div/div[1]/div")
    private WebElement menuButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"menu_button_container\"]/div/div[2]/div[1]")
    private WebElement menuSection;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reset_sidebar_link\"]")
    private WebElement resetAppStateButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement logoutButton;

    public CRMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CRMPage userNameFill(String username) {
        userNameField.click();
        userNameField.sendKeys(username);
        return this;
    }

    public CRMPage passwordFill(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }

    public CRMPage loginButtonClick() {
        loginButton.click();
        return this;
    }

    public String getTitle() {
        return title.getText();
    }

    public CRMPage addProductsToCart() {
        addToCartProduct1.click();
        addToCartProduct2.click();
        addToCartProduct3.click();
        addToCartProduct4.click();
        addToCartProduct5.click();
        addToCartProduct6.click();
        return this;
    }

    public CRMPage goToCart() {
        cartButton.click();
        return this;
    }

    public CRMPage removeProductsFromCart(){
        removeProduct2.click();
        removeProduct6.click();
        return this;
    }

    public CRMPage backToShopping() {
        continueShoppingButton.click();
        return this;
    }

    public CRMPage addProduct2ToCart() {
        addToCartProduct2.click();
        return this;
    }

    public CRMPage checkoutButton() {
        checkoutButton.click();
        return this;
    }

    public CRMPage firstNameFill(String firstName){
        firstNameField.click();
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CRMPage lastNameFill(String lastName) {
        lastNameField.click();
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CRMPage zipPostalCodeFill(String zipPostalCode) {
        this.zipPostalCode.click();
        this.zipPostalCode.sendKeys(zipPostalCode);
        return this;
    }

    public CRMPage continueButtonClick(){
        continueButton.click();
        return this;
    }

    public CRMPage finishButtonClick(){
        finishButton.click();
        return this;
    }

    public CRMPage backToProductClick(){
        backHomeButton.click();
        return this;
    }

    public CRMPage resetAndLogout(){
        menuButton.click();
        menuSection.click();
        resetAppStateButton.click();
        logoutButton.click();
        return this;
    }

    public String getLoginButtonText(){
        return loginButton.getAttribute("value");
    }

}
