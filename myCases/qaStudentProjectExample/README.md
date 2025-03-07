<h1 align="center">PhoneBook Automated Testing (Selenium WebDriver)</h1>

---

## 🌟 About the Project

This project is an **automated testing system** for the **PhoneBook web application**.  
It utilizes **Selenium WebDriver** and **TestNG** to verify **user registration, login, contact management, and UI interactions**.

📝 **Project Type:** Automated Web Testing  
💡 **Main Goal:** Validate user scenarios and functionality using Selenium WebDriver

This project was **developed independently** as a practical implementation of **test automation principles**.

---

## 📂 Project Structure

The project follows the **Page Object Model (POM)** to ensure **scalability and maintainability**.

### **Core Components**

| Component                | Description |
|--------------------------|------------|
| `TestBase.java`          | Base class for WebDriver setup and logging. |
| `ApplicationManager.java`| Manages WebDriver and initializes helpers. |
| `UserHelper.java`        | Methods for user registration, login, and logout. |
| `ContactHelper.java`     | Methods for contact management (create, delete). |
| `HomePageHelper.java`    | UI navigation and verification. |
| **Test Cases**           | `LoginTests.java`, `CreateAccountTests.java`, `AddContactTests.java`, `DeleteContactTests.java`, `HomePageTests.java` |
| **Test Configurations**  | `smoky.xml`, `negative.xml` (TestNG test groups) |
| **Logging**              | `logback.xml` – Logging configuration for tests |

---

## 🔧 Technologies Used

| Category               | Tools                                        |
|------------------------|----------------------------------------------|
| Programming Language   | Java 11+                                     |
| Testing Framework      | Selenium WebDriver, TestNG                  |
| Build Tool            | Gradle                                       |
| Logging               | Logback                                      |
| Browser Management    | ChromeDriver, FirefoxDriver, EdgeDriver     |

---

## 🏆 Key Test Scenarios

### 1️⃣ **User Authentication & Registration**
✔ Successful user login  
✔ Login with invalid credentials (negative test)  
✔ Verifying "Sign Out" button after successful login

### 2️⃣ **Contact Management**
✔ Adding a new contact  
✔ Deleting an existing contact  
✔ Checking proper display of contact lists

### 3️⃣ **UI & Navigation**
✔ Ensuring presence of key UI elements  
✔ Verifying homepage functionality

### 4️⃣ **Test Groups**
✔ **Smoke Tests:** (`smoky.xml`) – Core functionality tests without negative scenarios  
✔ **Negative Tests:** (`negative.xml`) – Validation and error handling tests

---

## 🤝 My Role in the Project

This project was **developed independently**.  
I was responsible for all aspects of the test automation process, including:

- **Designing the test architecture (Page Object Model)**
- **Creating and implementing test scenarios**
- **Configuring Selenium WebDriver and TestNG**
- **Automating test execution with Gradle**
- **Setting up logging with Logback**

All tests, structure, and reporting were designed and implemented by me.

---

## 📜 Development Stages

### 📌 **Test Planning**
1. Analyzed **PhoneBook web application requirements**.
2. Identified **core user scenarios**.
3. Developed a **test plan, test cases, and checklists**.

### 📌 **Test Development**
4. Configured **Selenium WebDriver** and created the **Page Object Model (POM)**.
5. Implemented tests for **UI, registration, login, and contact management**.
6. Added **test groups** for **Smoke and Negative testing**.

### 📌 **Automation & Reporting**
7. Integrated **Gradle** for test execution.
8. Configured **logging (Logback)** and **automated test reports**.
9. Optimized tests and fixed identified issues.

---

## 📩 Contact

If you have any questions or suggestions about the project, feel free to reach out:

- **Email:** [romaykin@gmail.com](mailto:romaykin@gmail.com)
- **LinkedIn:** [linkedin.com/in/romaykin](https://www.linkedin.com/in/romaykin)
- **WhatsApp:** [Chat on WhatsApp](https://api.whatsapp.com/send?phone=+380682620798)
- **Zoom Chat:** [Launch Zoom Chat](https://us05web.zoom.us/launch/chat?src=direct_chat_link&email=romaykin%40gmail.com)
- **Tel (Germany):** +49 175 881 01 50
- **Tel (Ukraine):** +38 068 262 07 98

---

## 📜 Additional Information

This project **is not intended for direct production use**, as it was developed for **test automation learning and practice**.  
For more details, refer to the **source code and test implementation**.

---

## 📜 License

This project is licensed under the **MIT License**, meaning it can be freely used, modified, and shared as long as the original authorship is acknowledged.