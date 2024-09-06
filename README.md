# Web Automation Framework Test for saucedemo.com

## Features

### Logout from the application

**Scenario:** Successfully logout and redirect to login page

**Given** user logs in with username "standard_user" and password "secret_sauce"

**When** user logs out

**Then** user is redirected to the login page "saucedemo.com"


### Purchase a product

**Scenario:** Purchase a single product

**Given** user logs in with username "standard_user" and password "secret_sauce"

**When** user adds a random product to the cart

**And** user proceeds to checkout

**And** user enters personal details and continues

**And** user finishes the checkout process

**Then** the order is completed successfully


### Remove elements from the shopping cart

**Scenario:** Remove all items from the cart

**Given** user logs in with username "standard_user" and password "secret_sauce"

**When** user adds three products to the cart

**And** user removes all items from the cart

**Then** the cart is empty

## Framework Components

The web automation framework for saucedemo.com includes the following components:

- Selenium: A powerful web automation tool used for interacting with web elements and performing actions on web pages.
- Cucumber: A behavior-driven development (BDD) framework that allows test scenarios to be written in a human-readable format.
- TestNG: A testing framework that provides advanced test execution and reporting capabilities.

## Getting Started

To run the automation tests using this framework, follow these steps:

1. Install the necessary dependencies: Selenium, Cucumber, and TestNG.
2. Set up the WebDriver for Selenium to use (e.g., ChromeDriver, FirefoxDriver).
3. Clone the repository and navigate to the project directory.
4. Run the test suite using the test runner provided.

## Test Execution

To execute the tests, run the test runner class that includes the test cases for the features mentioned above. The test runner will generate detailed test reports and provide insights into the test results.

## Test Data

For the test scenarios mentioned above, the test data includes the username "standard_user" and password "secret_sauce". These credentials are used for logging into the saucedemo.com application.

## Test Results

After executing the test suite, you will be able to view the test results, including any failures or errors encountered during the test execution. These results will help identify any issues or bugs in the application.

Feel free to modify or enhance the framework as per your specific requirements. Happy testing!
