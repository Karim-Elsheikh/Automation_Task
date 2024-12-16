package automationExercise.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.ElementActions;

public class SignupFormPage {
WebDriver driver ;

    public SignupFormPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url = "https://automationexercise.com/signup ";
    private By gender = By.id("id_gender1");
    private By passDataToPasswordField = By.cssSelector("input.form-control[id=password]");
    private By newsLetterCheckBox = By.id("newsletter");
    private By optionCheckBox = By.id("optin");
    private By firstNamefield = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By CompanyName = By.id("company");
    private By address1 = By.xpath("//input[@data-qa='address']");
    private By address2 = By.xpath("//input[@data-qa='address2']");
    private By country = By.id("country");
    private By stateFiled = By.xpath("//input[@name='state']");
    private By cityField = By.xpath("//input[@name='city']");
    private By zippcode = By.id("zipcode");
    private By mobileNummber = By.id("mobile_number");
    private By clickOnCreateAccoiuntButton = By.xpath("//button[@data-qa='create-account']");




public void getUrl(){
    driver.get(url);
}

@Step("Step 6")
    public SignupFormPage fillAddressInformation(String password,String firstname, String lastName, String company, String add1
            , String add2, String contry, String Stat, String City, String zip, String fonNumber) {
        driver.findElement(passDataToPasswordField).sendKeys(password);
        driver.findElement(firstNamefield).sendKeys(firstname);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(CompanyName).sendKeys(company);
        driver.findElement(address1).sendKeys(add1);
        driver.findElement(address2).sendKeys(add2);
        new Select(driver.findElement(country)).selectByVisibleText(contry);
        driver.findElement(stateFiled).sendKeys(Stat);
        driver.findElement(cityField).sendKeys(City);
        driver.findElement(zippcode).sendKeys(zip);
        driver.findElement(mobileNummber).sendKeys(fonNumber);
        return this;
    }
    @Step("Step 4")
    public SignupFormPage chooseGenderOption() {
        /*driver.findElement(gender).click();*/
        ElementActions.click(driver,gender);
        return this ;
    }
    @Step("Step 5")
    public SignupFormPage SelectDateOfBirth(String day, String month, String year) {
        new Select(driver.findElement(By.id("days"))).selectByValue(day);
        new Select(driver.findElement(By.id("months"))).selectByVisibleText(month);
        new Select(driver.findElement(By.id("years"))).selectByValue(year);
        return this ;
    }
    @Step("Step 7")
    public SignupFormPage selectSignUpAndOffersCheckboxes() {
        ElementActions.click(driver,newsLetterCheckBox);
        ElementActions.click(driver,optionCheckBox);
        return this ;
    }
    @Step("Step 8")
    public SignupFormPage clickOnCreateAccountButton() {
        ElementActions.click(driver,clickOnCreateAccoiuntButton);
        return this ;

    }

}
