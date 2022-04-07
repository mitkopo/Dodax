Here you can find all the tasks as request and the steps that have to be performed.

I.	Login


1.	Successful login

Implement a test for user login
Prerequisite for the test: User registration
https://www.dodax.ca/en-ca/shop/registration

       Skeleton:
Navigate to https://www.dodax.ca
Click on the Sign up icon
           Fill in Sign in form with valid credentials for a registered user 
           Submit the form
Check if the user is successfully logged in


2.	Successful login starts and ends on the same page 

Implement a test in which the user starts Login flow from Home, Categories, Random category, Shopping cart, Random product details page and after the successful login the user is navigated to the same page from which the Login process has started.
Skeleton:
Navigate to start page of the Login flow (Home, Categories, Random category, Shopping cart, Random product details page)
Click on Sign up icon in the header
Fill in Sign in form with valid credentials
Submit the form
Check if the user is successfully logged in
Check if the user is on the page from which the Login flow has started

3.	Reset password for an existing user
U: testitytt@gmail.com
P: Popokatepeltel1@
Implement a test for Reset password of an existing user
Prerequisite for the test: User registration
https://www.dodax.ca/en-ca/shop/registration

       Skeleton:
Navigate to https://www.dodax.ca
Click on the Sign up icon
Click on the Forgot your password link (Sign in to My Account tab)
Fill in the Email field with an email of registered user
Click on the Reset password button
Check if the message for an email sent is shown 

4.	Register an account – TAC and Privacy policy acceptance checkbox is mandatory

Implement a test for the Account registration checking that Terms and Conditions checkbox is mandatory

       Skeleton:
Navigate to https://www.dodax.ca
Click on the Sign up icon
Navigate to Sign up for Free tab
Fill in the Email field with an email of registered user
Fill in all input fields /doesn’t check TAC and Privacy Policy checkbox below the form)
Click on the Register button 
Check that the form is not submitted


II.	Home page

1.	Cookies set 

Implement a test for cookies set

     	Skeleton:
Navigate to  https://www.dodax.ca 
Click on the link Privacy policy
Check if the page for Privacy policy is loaded
Click on the button Accept cookies
Check that cookies are set 
2.	Search for non-existing product

Implement a test that search for non-existing product “kkttpp”

     	Skeleton:
Navigate to  https://www.dodax.ca 
           In the search field type “kkttpp” and submit it
           Check that an empty search result page is shown with Back button and carousel with additional products is shown
           Click on the Back button 
           Check that  https://www.dodax.ca   is loaded 

3.	Check links in the footer

Implement a test that checks links in the footer
 
     	
Skeleton:
Navigate to  https://www.dodax.ca 
          Click on the link in the footer
          Check that the right page is open

4.	Check domains

Implement a test that checks redirection to all supported domains 
     	
Skeleton:
Navigate to  https://www.dodax.ca 
          Click on the links in the bottom of the page
 
          Check that the right domain is loaded
		  
		  
III. Catalog page


1.	Catalog page list view 

Implement a test to check list view and sorting by New arrived, Price ascending, Price descending in the following categories Electronic → Computer, Clothing & Accessories, Toys & Baby → Baby & Child

Skeleton:
Navigate to https://www.dodax.ca
Click “Shop by category” on the header
In the first level of Categories tree click on the “See all categories” link
Find the and click on the following categories: 
a) Electronics & Computers → Computers
b) Clothing & Accessories
     c) Toys & Baby → Baby & Child

On the page with listed products from the selected category click on the list view button  
Check if products on the page are displayed in a list 
Select the following sorting for each category 
a)	Newest release date
   b)  Oldest release date 
   c)  Price high to low
   d)  Cheapest
Check if the proper soring is applied (Newly arrived, Price ascending and Price descending)

2.	Catalog page full pagination check 

Implement a test to check the pagination functionality on Catalog page (Next, Previous, …, First page, Last page).

Skeleton:
Navigate to https://www.dodax.ca 
Using the Search box in the header of the site make a search by “book”
Navigate to the bottom of the search result list and check pagination 
Select the first 4 pages in the pagination and check if the right page loads
Click on the “Continue” button and check if the right page loads
Click on the “Back” button and check if the right page loads
Click on the “…” button and check if the right page loads (… works as “Continue”, “Back” buttons) 
Click on the first page number and check if the right page loads
Click on the last page number and check if the right page loads


IV.	Product page

1.	Visit Product details page 

Implement a test to check Product details page

Skeleton:
Navigate to https://www.dodax.ca
Click “Shop by category” on the header
In the first level of Categories tree click on the “Movies, Music & Gaming” link
On the second level of Categories tree click on the “Movies, Music & Gaming - Show all products” to see all the products in the category
Click on a random product
Check that the right Product details page loads

2.	Product page – add to cart

Implement a test to add a product to the shopping cart

Skeleton:
Navigate to https://www.dodax.ca
          Search for a product by code 5SV0AJ4QUFK. If there no results for this one search for A2R4V574SMF.

          Click on the first result listed in the Search result page
          Check that details page opens
          Choose 2 items in the quantity box
          Click on the button Add to cart
          The cart button on the top is updated
          Click on the button View shopping cart
          Check that the product is added in the Shopping cart

3.	Product details page – add to Wish list 

Implement a test to add a product to the Wish list
Prerequisite for the test: User registration
https://www.dodax.ca/en-ca/shop/registration

Skeleton:
Navigate to https://www.dodax.ca
Click “Shop by category” on the header
In the first level of Categories tree click on the “Movies, Music & Gaming” link
On the second level of Categories tree click on the “Movies, Music & Gaming - Show all products” to see all the products in the category
Click on a random product
Check that the right Product details page loads
Click on the Add to wish list icon (heart icon) to open login dialog
Login with a registered user 
Check that the counter for Wishlist is updated


V.	Shopping cart

1.	Shopping cart – add/remove to the Wish list

Implement a test which adds a product to the Shopping cart and then adds/removed/adds it to the Wish list. 

     Skeleton:
Navigate to https://www.dodax.ca
Click “Shop by category” on the header
In the first level of Categories tree click on the “Movies, Music & Gaming” link
On the second level of Categories tree click on the “Movies, Music & Gaming - Show all products” to see all the products in the category
Click on a random product
Check that the right Product details page loads
Click on the button Add to cart
Click on the button View shopping cart 
Click on the Add to wish list icon (heart icon) to open login dialog
Login with a registered user 
Check that Shopping cart is the active page and Wishlist counter is increased
Click one more time on the Wishlist icon (to remove the product from the Wishlist)
Check that the counter for Wishlist is decreased

Click one more time on the Wishlist icon (to add the product to the Wishlist)
Check that the counter for Wishlist is increased


2.	Shopping cart - check values

Implement a test which checks values in the Shopping cart. 
Add three different products in the Shopping cart and check:

a) if for each product the total item price is the right one
b) if the Total price in the side box is equal of the sum of all total item prices

Change the quantity of one of the first product and check: 

a) if for each product the total item price is the right one
b) if the Total price in the side box is equal of the sum of all total item prices

Skeleton:
Navigate to https://www.dodax.ca 
Click “Shop by category” on the header
In the first level of Categories tree click on the “All categories” link
Click on random category 
Click on random product
Add product to the shopping cart 
Repeat all steps above and add other 2 products
Open Shopping cart and check:
a) if for each product the total item price is the right one
b) if the Total price in the side box is equal of the sum of all total item prices
Change the quantity of one product and check: 
a) if for each product the total item price is the right one
b) if the Total price in the side box is equal of the sum of all total item prices


VI.	Wish list

1.	Add product to the Wish list (logged user)
Implement a test to add random product in the Wishlist. 
Prerequisite for the test: User registration
https://www.dodax.ca/en-ca/shop/registration

Skeleton:
	Navigate to https://www.dodax.ca 
Login as registered user
Click “Shop by category” on the header
In the first level of Categories tree click on the “See all categories” link
Choose a random category 
Choose a random product
Open Product details page 
Click on the icon Add to Wish list
Check if the product is added to the Wish list

2.	Delete all items from the Wish list 
Implement a test which deletes all items from the Wishlist.
Prerequisite for the test: User registration
https://www.dodax.ca/en-ca/shop/registration

Skeleton:
	    Navigate to https://www.dodax.ca 
    Login as registered user
    Click “Shop by category” on the header
    In the first level of Categories tree click on the “See all categories” link
    Choose a random category 
    Choose a random product
    Open Product details page 
    Click on the icon Add to Wish list
    Check if the product is added to the Wish list
               From the top header icon navigate to the Wish list
               Delete all items in the Wish list
			   
			   
VII.  Addresses

1.	Add address with empty mandatory fields

Implement a test to add an address with empty mandatory fields. 
Prerequisite for the test: User registration
https://www.dodax.ca/en-ca/shop/registration

Skeleton:
	Navigate to https://www.dodax.ca 
Login as registered user
           Click on the avatar for logged user 
           From the pop-up menu click My Addresses
           On Manage addresses page delete all addresses except the first one
           Click on the link Create a new address
Submit the form with empty mandatory fields

Check that error validation messages are displayed below the mandatory fields


2.	Set Billing address
Implement a test to set Billing address. 
Prerequisite for the test: User registration
https://www.dodax.ca/en-ca/shop/registration

Skeleton:
	Navigate to https://www.dodax.ca 
Login as registered user
           Click on the avatar for logged user
           From the pop-up menu click My Addresses
           On Manage addresses page delete all addresses except the first one
           Click on the button Create a new address
           Fill mandatory fields and submit the form 
           Check that the new address is listed in the Saved addresses section
           Choose the last added address from Saved addresses section and click on the button Use as billing address
           Check that the chosen address is set as billing address

3.	Set Shipping address
Implement a test to set Shipping address. 
Prerequisite for the test: User registration
https://www.dodax.ca/en-ca/shop/registration

Skeleton:
	Navigate to https://www.dodax.ca 
Login as registered user
           Click on the avatar for logged user
           From the pop-up menu click My Addresses
           Click on the button Create a new address
           Fill mandatory fields and submit the form 
           Check that the new address is listed in the Saved addresses section
           Choose the last added address from Saved addresses section and click on the button Use as shipping address
           Check that the chosen address is set as shipping address
4.	Unsuccessful address add – an address with the same data is already saved
Implement a test for unsuccessful address add (there is an address with the same data).
Prerequisite for the test: User registration
https://www.dodax.ca/en-ca/shop/registration

Skeleton:
	Navigate to https://www.dodax.ca 
Login as registered user
           Click on the avatar for logged user
           From the pop-up menu click My Addresses
           Click on the button Create a new address
           Fill mandatory fields and submit the form 
           Check that the new address is listed in the Saved addresses section
           Click on the button Create a new address
           Fill mandatory fields with the same data used for the previously created address 
           Click on the Add Address button
           Check that validation error message is shown (saying that the address with the same data is already saved)





VIII.	Checkout 
Prerequisite for all Checkout tests is to have at least one registered user
     https://www.dodax.ca/en-ca/shop/registration

1.	Checkout - login 
Implement a test for user login on Checkout

Skeleton:
Navigate to https://www.dodax.ca 
Click “Shop by category” on the header
In the first level of Categories tree click on the “See all categories” link
Choose random category 
Choose random product
Open Product details page
Choose one item in the quantity box 
Click on the button Add to cart 
Click on the button View shopping cart 
Click on the Checkout button (in the Shopping cart page)
Submit the login form with credentials of registered user
Check that Shopping cart merged or Checkout page with an active Addresses step is loaded

2.	Checkout – Addresses - create a new delivery address with invalid input 
Implement a test which creates a new delivery address in the Checkout with invalid input (fills in some of mandatory fields)
     
Skeleton:
Navigate to https://www.dodax.ca 
Login as registered user
Click “Shop by category” on the header
In the first level of Categories tree click on the “See all categories” link
Choose a random category 
Choose a random product
Add it to the Shopping cart (use Add to cart button on the Product details page)
           Navigate to the Shopping cart (use View shopping cart button on the Product details page)
	Navigate to the Checkout – Addresses step (use Checkout button on the Shopping cart page)
	Click on the Create new address button
	Fill in some of mandatory fields in the form 
           Check if validation error messages are displayed below the mandatory fields which are empty 

3.	Checkout - Addresses - create a new delivery address 

Implement a test which creates a new delivery address in the Checkout with valid input 
     
Skeleton:
Navigate to https://www.dodax.ca 
Login as registered user
Click “Shop by category” on the header
In the first level of Categories tree click on the “See all categories” link
Choose random category 
Choose random product
Add it to the Shopping cart (use Add to cart button on the Product details page)
           Navigate to the Shopping cart (use View shopping cart button on the Product details page)
	Navigate to the Checkout – Addresses step (use Checkout button on the Shopping cart page)
	Click on the Create new address button
	Fill in all mandatory fields in the form and submit it
           The new address is added to the list with available addresses

4.	Checkout - Items - delete all items

Implement a test which checks if the user is navigated to the home page after the deletion of all items on the third Checkout step
     
Skeleton:
Navigate to https://www.dodax.ca
Login as registered user
Click “Shop by category” on the header
In the first level of Categories tree click on the “See all categories” link
Choose a random category 
Choose a random product
Add it to the Shopping cart (use Add to cart button on the Product details page)
Use one more time the previous three steps to add one more product to the Shopping cart 
           Navigate to the Shopping cart (use View shopping cart button on the Product details page)
	Navigate to the Checkout – Addresses step (use Checkout button on the Shopping cart page)
	Create a delivery address if there no any on the Checkout – Addresses step
           Click on the Continue button to navigate to Checkout – Items step
           Delete all items on the Checkout – Items step
           The user is navigated to Home page https://www.dodax.ca 

5.	Checkout - Items – select more than one delivery address for products sold by same merchant

Implement a test which adds two items into the Shopping cart, proceed to the Checkout, adds two different delivery addresses for both items and checks that they are shown in two Delivery groups on the forth Checkout step
     
Skeleton:
Navigate to https://www.dodax.ca 
Login as registered user
Search for 2 specific products sold by Dodax merchant (here are some products VVBBSAJ6E4Q, GSOQKVJTQGL, VN3FPQVMSB1)
Add both products in the Shopping cart 
Navigate to the Checkout – Addresses step 
Аdd at least two addresses
           Click on the Continue button to navigate to Checkout – Items step
           Set different delivery addresses for both items
Click on the button Continue to next forth page
Checkout page is open with an active Choose shipping option step and both items are shown in a different Delivery groups



