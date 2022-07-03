package crm2.refactored;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class CRMWebDriverTest {

    private CRMWebDriver crmWebDriver;
    private CRMPage crmPage;

    @BeforeAll
    public void setUp() {
        crmWebDriver = new CRMWebDriver();
        crmPage = new CRMPage(crmWebDriver.getDriver());
    }

    @DisplayName("Authorization to the https://www.saucedemo.com")
    @Test
    public void authorizationTest() {
        log.info("Authorization test has been started...");
        String title = crmPage.userNameFill("standard_user")
                .passwordFill("secret_sauce")
                .loginButtonClick()
                .getTitle();
        assertEquals("PRODUCTS", title);
        log.info("Authorization test is completed successfully");
    }

    @DisplayName("Ordering items on the https://www.saucedemo.com")
    @Test
    public void orderingItemsTest() {
        log.info("Items ordering test has been started...");
        String title1 = crmPage.addProductsToCart()
                .goToCart()
                .getTitle();
        assertEquals("YOUR CART",title1);

        String title2 = crmPage.removeProductsFromCart()
                .backToShopping()
                .getTitle();
        assertEquals("PRODUCTS",title2);

        String title3 = crmPage.addProduct2ToCart()
                .goToCart()
                .getTitle();
        assertEquals("YOUR CART", title3);

        String title4 = crmPage.checkoutButton()
                .getTitle();
        assertEquals("CHECKOUT: YOUR INFORMATION",title4);

        String title5 = crmPage.firstNameFill("Vika")
                .lastNameFill("Chyhrynets")
                .zipPostalCodeFill("15-500")
                .continueButtonClick()
                .getTitle();
        assertEquals("CHECKOUT: OVERVIEW", title5);

        String title6 = crmPage.finishButtonClick()
                .getTitle();
        assertEquals("CHECKOUT: COMPLETE!",title6);

        String title7 = crmPage.backToProductClick()
                .getTitle();
        assertEquals("PRODUCTS",title7);

        String loginButtonName = crmPage.resetAndLogout()
                .getLoginButtonText();
        assertEquals("Login",loginButtonName);
        log.info("Items ordering test is completed successfully");
    }

    @AfterAll
    public void closeChromeTab() {
        crmWebDriver.getDriver().quit();
    }

}
