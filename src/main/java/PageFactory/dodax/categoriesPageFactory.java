package PageFactory.dodax;

import driverUtils.driverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.time.Duration;
import java.util.*;

public class categoriesPageFactory {
    WebDriver driver;


    @FindBy(xpath = "//div[@class=\"cat-categories\"]//a")
    List<WebElement> allCategories;

    @FindBy(xpath = "//div[@class=\"pr-productsList__items js-pr-productsList__items d-flex flex-wrap\"]//a")
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

    @FindBy(xpath = "((//a[@class='c-pagination__link js-c-pagination__item']) [3])")
    WebElement lastPage;

    @FindBy(css = "[data-qa=\"pagination\"]")
    WebElement pagination;

    @FindBy(css = "ul[class=\"c-pagination__list\"]>li")
    List<WebElement> pageListNumbers;

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

    public void clickRandomProduct(){
        driverUtils dU = new driverUtils(driver);
       dU.jsClick(getRandProduct());
    }

    public String getRandProducthref() {
        driverUtils dU = new driverUtils(driver);

        WebElement prodInfo = getRandProduct();
        String prodInfo2 = prodInfo.getAttribute("href");

        dU.jsClick(prodInfo);

        return prodInfo2;
    }

    public String currentURL() {
        return driver.getCurrentUrl();

    }

    public void clickComputers() {
        computers.click();
    }

    public void clickClothes() {
        clothes.click();
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
                    System.out.println("Sorting by Newes Release date test has failed");

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
        babuAndChild.click();
    }


    public String getPagehRef(WebElement element) {
        return element.getAttribute("href");
    }


    public void testCheckPaginationNumber() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        driverUtils dU = new driverUtils(driver);

        int i;
        Boolean b = null;

        for (WebElement element : pageListNumbers) {
            System.out.println(element);
            System.out.println(getPagehRef(element));
            b = getPagehRef(element).contains(currentURL());
            if (b == true) {
                dU.jsClick(element);
                b = getPagehRef(element).equals(currentURL());
                waitForElement(pagination);
                homepagePF.moveToBottom();


            }
        }


    }

    public boolean checkPaginationNumber() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        Boolean b;


        System.out.println(currentURL());
        b = getPagehRef(page1).contains(currentURL());
        driverUtils dU = new driverUtils(driver);


        if (b == true) {
            waitForElement(pagination);
            homepagePF.moveToBottom();
            dU.jsClick(page2);


            if (b == true) {
                b = getPagehRef(page2).equals(currentURL());

                System.out.println("Page 2 currenturl " + currentURL());
                waitForElement(pagination);
                homepagePF.moveToBottom();
                dU.jsClick(page3);


                if (b == true) {
                    b = getPagehRef(page3).equals(currentURL());

                    System.out.println("Page 3 currenturl " + currentURL());
                    waitForElement(pagination);
                    homepagePF.moveToBottom();
                    dU.jsClick(page4);


                    if (b == true) {
                        b = getPagehRef(page4).contains(currentURL());
                        waitForElement(pagination);
                        homepagePF.moveToBottom();
                        System.out.println("Page 4 currenturl " + currentURL());
                        if (b == true) {
                            String continueButtonhRef = getPagehRef(continueButton);
                            dU.jsClick(continueButton);
                            b = continueButtonhRef.equals(currentURL());

                            if (b == true) {
                                String threeDotsBack = getPagehRef(threeBackDots);
                                waitForElement(pagination);
                                homepagePF.moveToBottom();
                                System.out.println("Three back dots url is: " + threeDotsBack);
                                dU.jsClick(threeBackDots);

                                b = threeDotsBack.equals(currentURL());

                                if (b == true) {
                                    String threeDotsForward = getPagehRef(threeForwardDots);
                                    waitForElement(pagination);
                                    homepagePF.moveToBottom();
                                    System.out.println("Three forward dots url is: " + threeDotsForward);
                                    dU.jsClick(threeForwardDots);
                                    b = threeDotsForward.equals(currentURL());

                                    if (b == true) {
                                        String firstPageNumber = getPagehRef(page1);
                                        waitForElement(pagination);
                                        homepagePF.moveToBottom();
                                        System.out.println("The first page link is: " + firstPageNumber);
                                        dU.jsClick(page1);
                                        b = firstPageNumber.equals(currentURL());

                                        if (b == true) {
                                            String lastPageNumber = getPagehRef(lastPage);
                                            waitForElement(pagination);
                                            homepagePF.moveToBottom();
                                            System.out.println("last page link is: " + lastPageNumber);
                                            dU.jsClick(lastPage);
                                            b = lastPageNumber.equals(currentURL());

                                        }

                                    }
                                }
                            }

                        }

                        return b;
                    }
                }
            }
            return b;
        }

        return b;
    }

}



