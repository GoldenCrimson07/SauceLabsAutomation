# UI Automation Project

## 📌 Overview
This project is a **UI Automation Framework** built using:
- **Appium** for mobile automation
- **Selenium** for web automation
- **Cucumber** for BDD-style test cases
- **TestNG** as the test runner

## 🛠️ Tech Stack
- **Java 11** (Configured in `pom.xml`)
- **Maven** (Dependency & Build Management)
- **TestNG** (Test Execution)
- **Cucumber** (Behavior-Driven Development)
- **Appium Java Client** (Mobile UI Automation)
- **Selenium WebDriver** (Web UI Automation)

## 📦 Dependencies
This project uses the following dependencies (as defined in `pom.xml`):
- **TestNG** (`7.6.0`)
- **Appium Java Client** (`7.6.0`)
- **Selenium Java** (`3.141.59`)
- **Cucumber Java & TestNG** (`7.14.0`)
- **Cucumber Reporting** (`5.7.6`)
- **Gherkin Parser** (`26.0.0`)

## 🚀 Setup & Installation
### 1️⃣ Prerequisites
- Install **Java 11**
- Install **Maven** (`mvn -version` to check)
- Install **Appium** (`npm install -g appium`)

### 2️⃣ Clone the Repository
```bash
git clone https://github.com/your-repo/ui-automation.git
cd ui-automation
```

### 3️⃣ Install Dependencies
```bash
mvn clean install
```

## 🏃 Running Tests
### Run All Tests
```bash
mvn test
```

### Run Cucumber Tests
```bash
mvn test -Dcucumber.features=src/test/resources/checkout.feature
```

## 📊 Generating Reports
After test execution, generate the Cucumber report:
```bash
mvn verify
```
Find reports in:
```
target/cucumber-reports.html
```

## 🛠️ Project Structure
```
UIAutomation/
├── src/test/java/testcases/        # Cucumber Step Definitions
├── src/test/resources/             # Feature Files (Gherkin)
├── src/main/java/pages/            # Page Object Models (POM)
├── src/test/java/runner/          # Test Runners
├── pom.xml                          # Maven Configuration
└── README.md                        # Project Documentation
```

## 🔗 References
- [Appium Official Docs](https://appium.io/docs/en/about-appium/intro/)
- [Selenium WebDriver](https://www.selenium.dev/documentation/)
- [Cucumber](https://cucumber.io/docs/)
- [TestNG](https://testng.org/doc/)

---

🚀 **Happy Testing!**

