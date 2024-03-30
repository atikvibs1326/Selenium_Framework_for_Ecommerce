****Repository Name: Selenium Ecommerce Test Automation Framework**** 🤖🛒

**Description:**
This repository contains a Selenium test automation framework built to test a dummy ecommerce website. The framework is designed to streamline the testing process and ensure the functionality and reliability of the website.

**Website Under Test:** [Rahul Shetty Academy Ecommerce](https://rahulshettyacademy.com/client/auth/login) 🌐

**Features:**
- Selenium WebDriver for browser automation.
- Page Object Model (POM) design pattern for better code organization and maintenance.
- TestNG for test case management and reporting 📊.
- Maven for project management and dependency handling.
- Logging for detailed reporting and debugging 📝.
- Test data management using configuration files or data providers.
- Customized utilities for common testing tasks.

**Setup Instructions:**
1. Clone the repository to your local machine:

```bash
git clone https://github.com/atikvibs1326/Selenium_Framework_for_Ecommerce.git
```

2. Ensure you have Java Development Kit (JDK) installed on your machine. You can download and install JDK from the official Oracle website.

3. Install Maven if not already installed. You can download Maven from the official Apache Maven website and follow the installation instructions.

4. Open the project in your preferred IDE (Integrated Development Environment) such as IntelliJ IDEA, Eclipse, or Visual Studio Code.

5. Resolve project dependencies by running:

```bash
mvn clean install
```

6. Download appropriate browser drivers (e.g., ChromeDriver, GeckoDriver) and place them in the 'drivers' directory of the project.

7. Update the test data or configuration files as per your requirements.

8. Run the tests using TestNG or Maven commands.

**ScreenShots of StandAlone TestScript**
![image](https://github.com/atikvibs1326/Selenium_Framework_for_Ecommerce/assets/64660852/0b2ada62-ee26-4586-b60d-1055027cc504)


![image](https://github.com/atikvibs1326/Selenium_Framework_for_Ecommerce/assets/64660852/6cc1ea5c-34e3-4bc1-870a-e81cb5630615)



**Usage:**
- To run all tests, execute:
```bash
mvn test
```
- To run tests in a specific package or class, use TestNG XML or Maven Surefire plugin configurations.

**Contributing:**
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

**License:**
This project is licensed under the MIT License. See the LICENSE file for details.

**Contact:**
For any inquiries or support, feel free to contact Atikraja Khochikar <atikrajakhochikar@gmail.com>.

**Acknowledgements:**
Special thanks to the creators of Selenium, TestNG, Maven, and other open-source tools used in this project. 🙌🎉


## Project Status
This project is currently under development, and certain features are yet to be implemented. 

### Pending Tasks:
- [ ] Implement Cucumber for Behavior-Driven Development (BDD) testing.
- [ ] Write feature files with Gherkin syntax to describe test scenarios.
- [ ] Create step definitions to automate tests using Selenium WebDriver.

Note: The implementation of Cucumber for BDD testing is planned and will be added in future iterations of the project. Meanwhile, testing is being conducted on StandAlone Scripts that are developed 
