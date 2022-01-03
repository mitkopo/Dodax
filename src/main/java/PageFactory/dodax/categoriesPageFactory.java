package PageFactory.dodax;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

    @FindBy(css = "[class=\"c-viewSwitch__button js-c-viewSwitch__button--grid btn-reset c-viewSwitch__button--activeView\"]")
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

    public categoriesPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void randomCategory() {
        Random rnd = new Random();
        int i = rnd.nextInt(allCategories.size());
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", allCategories.get(i));
    }

    private int randomProduct() {
        Random rnd = new Random();
        int i = rnd.nextInt(products.size());
        return i;
    }


    public WebElement getRandProduct() {
        return products.get(randomProduct());
    }

    public String getRandProducthref() {

        WebElement prodInfo = getRandProduct();
        String prodInfo2 = prodInfo.getAttribute("href");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", prodInfo);
        System.out.println(prodInfo);
        System.out.println(prodInfo2);
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

    public boolean isListViewSelected() {
        boolean b;
        b = listView.isSelected();
        return b;
    }

    public void clickListView() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", listView);
    }

    public boolean dropdownSelect() {
        Select sel = new Select(dropdown);
        int i;
        Boolean equals = null;

        for (i = 0; i <= 4; i++) {
            sel.selectByIndex(i);
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


    public boolean checkPaginationNumber() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        Boolean b;


        System.out.println(currentURL());
        b = getPagehRef(page1).contains(currentURL());
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        if (b == true) {
            waitForElement(pagination);
            homepagePF.moveToBottom();
            executor.executeScript("arguments[0].click();", page2);


            if (b == true) {
                b = getPagehRef(page2).equals(currentURL());
                // System.out.println("Page 2 href "+hRef);
                System.out.println("Page 2 currenturl " + currentURL());
                waitForElement(pagination);
                homepagePF.moveToBottom();
                executor.executeScript("arguments[0].click();", page3);

                if (b == true) {
                    b = getPagehRef(page3).equals(currentURL());

                    System.out.println("Page 3 currenturl " + currentURL());
                    waitForElement(pagination);
                    homepagePF.moveToBottom();
                    executor.executeScript("arguments[0].click();", page4);

                    if (b == true) {
                        b = getPagehRef(page4).contains(currentURL());
                        waitForElement(pagination);
                        homepagePF.moveToBottom();
                        System.out.println("Page 4 currenturl " + currentURL());
                        if (b == true) {
                            String continueButtonhRef = getPagehRef(continueButton);
                            executor.executeScript("arguments[0].click();", continueButton);
                            b = continueButtonhRef.equals(currentURL());

                            if (b == true) {
                                String threeDotsBack = getPagehRef(threeBackDots);
                                waitForElement(pagination);
                                homepagePF.moveToBottom();
                                System.out.println("Three back dots url is: " + threeDotsBack);
                                executor.executeScript("arguments[0].click();", threeBackDots);
                                b = threeDotsBack.equals(currentURL());

                                if (b == true) {
                                    String threeDotsForward = getPagehRef(threeForwardDots);
                                    waitForElement(pagination);
                                    homepagePF.moveToBottom();
                                    System.out.println("Three forward dots url is: " + threeDotsForward);
                                    executor.executeScript("arguments[0].click();", threeForwardDots);
                                    b = threeDotsForward.equals(currentURL());

                                    if (b == true) {
                                        String firstPageNumber = getPagehRef(page1);
                                        waitForElement(pagination);
                                        homepagePF.moveToBottom();
                                        System.out.println("The first page link is: " + firstPageNumber);
                                        executor.executeScript("arguments[0].click();", page1);
                                        b = firstPageNumber.equals(currentURL());

                                        if (b == true) {
                                            String lastPageNumber = getPagehRef(lastPage);
                                            waitForElement(pagination);
                                            homepagePF.moveToBottom();
                                            System.out.println("last page link is: " + lastPageNumber);
                                            executor.executeScript("arguments[0].click();", lastPage);
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



