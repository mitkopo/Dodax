package PageFactory.dodax;

import driverUtils.driverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.ParseException;
import java.time.Duration;
import java.util.*;

public class categoriesPageFactory {
    public WebDriver driver;


    @FindBy(xpath = "//div[@class=\"cat-categories\"]//a")
    List<WebElement> allCategories;

    @FindBy(css = "[data-qa=\"searchResultPageProductLink\"]")
    List<WebElement> products;


    @FindBy(xpath = "//*[ contains (text(),\"Computers\")]")
    WebElement computers;

    @FindBy(xpath = "//a[ contains (text(),\"Clothing & Accessories\")][last()]")
    WebElement clothes;

    @FindBy(xpath = "//a[ contains (text(),\"Baby & Child\")][last()]")
    WebElement babuAndChild;

    @FindBy(css = "[class=\"c-viewSwitch__icon icon-list-view\"]")
    WebElement listView;

    @FindBy(css = "[data-qa=\"searchResultPageGridViewIcon\"]")
    WebElement gridView;

    @FindBy(css = "li>button[class*='c-viewSwitch__button--activeView']")
    WebElement listViewSelected;

    @FindBy(css = "[data-qa=\"searchResultPageContentSortingSelect\"]")
    WebElement dropdown;

    @FindBy(css = "[data-product-price]")
    List<WebElement> getPrice;

    @FindBy(css = "[data-page=\"0\"]")
    WebElement page1;

    @FindBy(css = "[data-page=\"1\"]")
    WebElement page2;

    @FindBy(css = "[data-page=\"2\"]")
    WebElement page3;

    @FindBy(css = "[data-page=\"3\"]")
    WebElement page4;

    @FindBy(css = "[data-qa=\"paginationLinkNext\"]")
    WebElement continueButton;

    @FindBy(xpath = "(//a[@class='c-pagination__link js-c-pagination__item']) [3]")
    WebElement threeBackDots;

    @FindBy(xpath = "((//a[@class='c-pagination__link js-c-pagination__item']) [5])")
    WebElement threeForwardDots;

    @FindBy(css = "[data-qa=\"pagination\"]")
    WebElement pagination;

    @FindBy(css = "ul[class=\"c-pagination__list\"]>li>a")
    List<WebElement> pageListNumbers;

    @FindBy(css = "[data-qa=\"paginationLink\"]")
    List<WebElement> paginationLinks;

    @FindBy(css = "[data-qa=\"paginationLinkActive\"]")
    WebElement currentPage;

    @FindBy(css = "[data-qa=\"paginationLinkPrev\"]")
    WebElement backButton;

    @FindBy(xpath = "//a[contains(text(),'...')]")
    List<WebElement> theDots;

    @FindBy(css = "[data-qa=\"pagination\"]>ul>li:nth-last-child(2)>a")
    WebElement lastPage;

    @FindBy(css = "[data-qa=\"pagination\"]>ul>li:nth-child(2)>a")
    WebElement firstPage;

    public categoriesPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void randomCategory() {
        driverUtils dU = new driverUtils(driver);

        Random rnd = new Random();
        int i = rnd.nextInt(allCategories.size());

        dU.jsClick(allCategories.get(i));
    }

    private int randomProduct() {
        Random rnd = new Random();
        int i = rnd.nextInt(products.size());
        return i;
    }


    public WebElement getRandProduct() {
        return products.get(randomProduct());
    }

    public void clickRandomProduct() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(getRandProduct());
    }

    public String getRandProducthref() {
        driverUtils dU = new driverUtils(driver);

        WebElement prodInfo = getRandProduct();
        String prodInfoHref = prodInfo.getAttribute("href");
        dU.jsClick(prodInfo);
        return prodInfoHref;
    }

    public String currentURL() {
        return driver.getCurrentUrl();

    }

    public void clickComputers() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(computers);
    }

    public void clickClothes() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(clothes);
    }


    public void clickListView() {
        driverUtils dU = new driverUtils(driver);

        dU.jsClick(listView);
    }

    public boolean isListViewSelected() {
        return listViewSelected.isDisplayed();
    }

    public boolean dropdownSelect() throws ParseException {
        searchResultFactory searchPF = new searchResultFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        driverUtils dU = new driverUtils(driver);

        Select sel = new Select(dropdown);

        int i;
        Boolean equals = null;

        for (i = 0; i <= 4; i++) {
            sel.selectByIndex(i);
            if (i == 1) {
                Boolean dates = null;
                searchPF.waitForDropDown();
                searchPF.clickFirstSearchResult();
                Date bc = dU.dateFormat(productPF.getReleaseDate());
                driver.navigate().back();
                getRandProducthref();
                Date ac = dU.dateFormat(productPF.getReleaseDate());
                dates = bc.after(ac);
                if (dates == true) {
                    driver.navigate().back();
                    return dates;
                } else if (dates == false) {
                    System.out.println("Sorting by Newes Release date areNotificationsDisplayed has failed");

                }

            }
            if (i == 3) {

                equals = getPricesAscending();
                if (equals == true) {
                    return equals;
                }
            } else if (i == 4) {
                equals = getPricesDescending();
                if (equals == true) {
                    return equals;
                }
            }
        }
        return equals;
    }

    public List<String> getPrices() {
        List<String> prices = new ArrayList<>();
        for (WebElement element : getPrice) {
            prices.add(element.getAttribute("data-product-price"));
        }
        System.out.println("Prices not sorted" + prices);
        return prices;
    }

    public boolean getPricesAscending() {
        List<String> bc = new ArrayList<>(getPrices());
        Collections.sort(bc);

        System.out.println("Prices sorted by ASC" + bc);
        return bc.equals(getPrices());
    }

    public boolean getPricesDescending() {
        List<String> bc = new ArrayList<>(getPrices());

        bc.sort(Collections.reverseOrder());
        System.out.println("Prices sorted by DESC" + bc);
        return bc.equals(getPrices());
    }

    public void clickBabyNChild() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(babuAndChild);

    }


    public String getPagehRef(WebElement element) {
        return element.getAttribute("href");
    }

    public void checkPagination() {
        driverUtils dU = new driverUtils(driver);

//      Testing the first 4 pages of the pagination and checking if the right one is loading;
        do {
            Assert.assertTrue(dU.getHref(currentPage).contains(currentURL()));
            dU.jsClick(continueButton);
            waitForElement(pagination);
        }
        while (paginationLinks.size() < 6);

//      Testing the Continue and Back button;
        List<WebElement> backAndContinueButton = new ArrayList<WebElement>();
        backAndContinueButton.add(continueButton);
        backAndContinueButton.add(backButton);
        for (WebElement element : backAndContinueButton) {
            waitForElement(pagination);
            String b = element.getAttribute("href");
            System.out.println(b);
            dU.jsClick(element);
            waitForElement(pagination);
            Assert.assertEquals(b, currentURL());
        }

//      Testing three dots ... , the work as Continue and Back button;
        waitForElement(pagination);
        String b = dU.getHref(theDots.get(1));
        System.out.println(b);
        dU.jsClick(theDots.get(1));
        waitForElement(pagination);
        Assert.assertEquals(b, currentURL());
        String c = dU.getHref(theDots.get(0));
        System.out.println(c);
        dU.jsClick(theDots.get(0));
        waitForElement(pagination);
        Assert.assertEquals(c, currentURL());
//      Testing the First and Last Page button;
        List<WebElement> firstAndLastPage = new ArrayList<WebElement>();
        firstAndLastPage.add(firstPage);
        firstAndLastPage.add(lastPage);
        for (WebElement element : firstAndLastPage) {
            waitForElement(pagination);
            String d = dU.getHref(element);
            System.out.println(d);
            dU.jsClick(element);
            waitForElement(pagination);
            Assert.assertEquals(d, currentURL());
        }
    }


    public void waitForFirstSearchResultToLoad() {
        driverUtils dU = new driverUtils(driver);
        dU.waitForElementToBeVisible(products.get(0));
    }

    public void waitForPagination(){
        waitForElement(pagination);
    }
}



