<h1 align="center">HerokuApp Automated Testing (Selenium WebDriver)</h1>

---

## 🌟 About the Project

This project is an **automated test suite** for verifying interactive elements on the **HerokuApp test website**.  
It uses **Selenium WebDriver, TestNG, and Java** to test **UI components, pop-up alerts, forms, and browser window management**.

📝 **Project Type:** Web Application Test Automation  
💡 **Main Goal:** Verify the functionality of web elements across different pages of HerokuApp

This project was **developed independently** to **enhance my skills in test automation**.

---

## 📂 Project Structure

The project is built using the **Page Object Model (POM)**, making tests **scalable and maintainable**.

### **Core Components**

| Component                 | Description |
|---------------------------|------------|
| `TestBase.java`           | Base class for WebDriver setup and logging. |
| `ApplicationManager.java` | Manages WebDriver initialization and test settings. |
| `BasePage.java`           | Common methods for interacting with UI elements. |
| **Helpers & Pages**       | Classes for handling specific web elements. |
| `AlertHelper.java`        | Handles JavaScript alert dialogs. |
| `FrameHelper.java`        | Manages switching between iFrames. |
| `MyListener.java`         | Implements WebDriver event listeners for logging and screenshots. |
| **Test Cases**            | `AddRemoveElementsTest.java`, `DropdownTest.java`, `FramesTest.java`, `BrokenImagesTest.java`, `UploadTest.java`, `MultipleWindowsTest.java`, `RedirectTest.java`, `JavaScriptAlertsTest.java` |

---

## 🔧 Technologies Used

| Category               | Tools                                        |
|------------------------|----------------------------------------------|
| Programming Language   | Java 17                                      |
| Testing Framework      | Selenium WebDriver, TestNG                   |
| Build Tool            | Maven                                        |
| Logging               | SLF4J, Logback                               |
| Browser Management    | ChromeDriver, FirefoxDriver, EdgeDriver     |

---

## 🏆 Key Test Scenarios

### 1️⃣ **UI Component Testing**
✔ **Add/Remove Elements** – Verify dynamic element addition and deletion  
✔ **Dropdown Menu** – Select and validate dropdown options  
✔ **Broken Images** – Detect and log broken image links  
✔ **Text Boxes** – Verify text input functionality

### 2️⃣ **Advanced Interactions**
✔ **Hover Effects** – Validate hover captions and pop-ups  
✔ **Horizontal Slider** – Adjust slider and verify values  
✔ **Frames Handling** – Work with nested iFrames and embedded content

### 3️⃣ **Alerts and Browser Handling**
✔ **JavaScript Alerts** – Handle confirmation, dismiss, and prompt dialogs  
✔ **Multiple Windows** – Open new tabs and switch between windows  
✔ **Redirections** – Verify URL redirections and HTTP status codes

### 4️⃣ **File Handling**
✔ **File Upload** – Verify file upload functionality

---

## 🤝 My Role in the Project

This project was **fully developed by me**, covering all aspects of test automation:

- **Designed the test architecture (Page Object Model)**
- **Developed test cases for UI interactions and browser events**
- **Implemented Selenium WebDriver and TestNG automation**
- **Configured Maven for dependency management**
- **Created WebDriver Event Listeners for logging and screenshots**

All test cases, utilities, and reporting mechanisms were developed from scratch.

---

## 📜 Development Stages

### 📌 **Test Planning**
1. Analyzed **HerokuApp test pages**.
2. Identified **key UI elements and user interactions**.
3. Created a **detailed test plan**.

### 📌 **Test Development**
4. Implemented **Page Object Model (POM)** for structured and maintainable test scripts.
5. Developed test cases for **alerts, dropdowns, sliders, frames, and windows**.
6. Implemented **WebDriver Event Listeners for advanced logging**.

### 📌 **Automation & Reporting**
7. Configured **Maven for dependency management**.
8. Integrated **Logback for structured test reporting**.
9. Optimized execution times and improved test stability.

---

## 📩 Contact

If you have any questions or would like to discuss collaboration opportunities, feel free to reach out:

- **Email:** [romaykin@gmail.com](mailto:romaykin@gmail.com)
- **LinkedIn:** [linkedin.com/in/romaykin](https://www.linkedin.com/in/romaykin)
- **WhatsApp:** [Chat on WhatsApp](https://api.whatsapp.com/send?phone=+380682620798)
- **Zoom Chat:** [Launch Zoom Chat](https://us05web.zoom.us/launch/chat?src=direct_chat_link&email=romaykin%40gmail.com)
- **Tel (Germany):** +49 175 881 01 50
- **Tel (Ukraine):** +38 068 262 07 98

---

## 📜 Additional Information

This project **is not intended for production use**, as it was developed **for educational and automation testing practice**.  
For more details, explore the **source code and test scripts**.

---

## 📜 License

This project is licensed under the **MIT License**, meaning it can be freely used, modified, and shared as long as the original authorship is acknowledged.
