<h1 align="center"> PetSitters Testing Project </h1>

<p align="center">
  <img src="https://img.shields.io/github/stars/RomNox/finalProject?style=for-the-badge">
  <img src="https://img.shields.io/github/forks/RomNox/finalProject?style=for-the-badge">
  <img src="https://img.shields.io/github/license/RomNox/finalProject?style=for-the-badge">
</p>

---

## 🌟 About the Project  

This project was created as part of the **final stage of the software testing course** and is **educational**. We,  
the **Students Team**, conducted **comprehensive testing** of the **PetSitters** platform, developed as an **educational web application**.

📝 **Platform:** [PetSitters Service](https://pets-care-u2srs.ondigitalocean.app/#/)  
🐶 **Purpose:** A service for searching and booking pet care services.  
💡 **Features:** User registration, booking services, profile management, reviews, and ratings.

Our main goal was to **test this project from different aspects**, using various **testing methodologies**, modern tools, and working through **the full testing cycle** from requirements analysis to reporting.

---

## 📂 Repository with Tests and Documentation  

📌 **Public repository:**  
[🔗 GitHub: Final Project](https://github.com/RomNox/finalProject)

📌 **Test Plan:**  
[📝 Test Plan Pet Service](https://docs.google.com/spreadsheets/d/1gTUD-IqnO0w2ujMA5a3g1kEghGazr4yl/edit?usp=sharing&ouid=111919283918973058395&rtpof=true&sd=true)

---

## 🛠 Our Approach to Testing  

We used a **structured and systematic** approach based on **best testing practices**:

1. **Requirements Analysis** – Reviewed specifications and analyzed the system using the **FURPS model** (Functionality, Usability, Reliability, Performance, Supportability).  
2. **Test Documentation** – Developed a **test plan, test cases, and checklists** to verify functional and non-functional requirements.  
3. **Functional Testing** – Tested core user flows: **registration, login, booking, profile management, and payments**.  
4. **API Testing** – Used **Postman & Newman** to check API endpoints for correctness, security, and error handling.  
5. **UI/UX Testing** – Checked usability, design compliance, and responsiveness across devices.  
6. **Load Testing** – **Artillery** was used to evaluate system performance under high load.  
7. **Automated Testing** – Developed **Selenium WebDriver + JUnit** tests and implemented **CI/CD with Jenkins**.  
8. **Reporting** – Used **Allure for test reports** and documented bugs in **Jira**.

---

## 🔧 Used Tools and Technologies  

| Category               | Tools                                        |
|------------------------|----------------------------------------------|
| Test automation        | Java, Selenium WebDriver, JUnit, Gradle      |
| CI/CD and reporting    | Jenkins, Allure                             |
| API testing            | Postman, Newman                             |
| Load testing           | Artillery                                   |
| Logging and debugging  | Logback                                     |
| Test management        | Jira, TestLink                              |

---

## 📊 Test Results  

### 📌 **General Statistics**  
- **Total test cases:** 200  
  - ✅ **136 positive scenarios** (successful checks)  
  - ❌ **64 negative scenarios** (error handling)  

### 📌 **Functional Tests**  
- **Registration and authorization:** ✅ Passed  
- **Booking services:** ⚠️ 2 issues with cancellation processing  
- **Search for performers:** ✅ Passed  
- **Profile management:** ✅ Passed  
- **Review system:** ⚠️ 1 bug (rating does not update after deleting a review)  

### 📌 **API Testing**  
- **100 API requests via Postman** – **97% successful**  
- **3% failures:** incorrect handling of invalid data  

### 📌 **Load Testing (Artillery)**  

| Requests   | Average response time | Success rate | Errors |
|------------|-----------------------|-------------|--------|
| **100**    | 38 ms                 | 100%        | 0%     |
| **1,000**  | 39 ms                 | 99.5%       | 0.5%   |
| **5,000**  | 41 ms                 | 97%         | 3%     |

### 📌 **Automated Testing**  
- **50 Selenium tests:** **95% success**, 5% unstable due to UI delays  

### 📌 **Bugs Registered in Jira**  
- **Total:** 37 bugs  
- **Fixed:** 30  
- **Pending:** 7  

### ⚠ **Key Issues Requiring Fixing**  
1. Incorrect handling of **booking cancellations**.  
2. Error **updating ratings** after deleting a review.  
3. API does not **always correctly handle invalid data**.  

---

## 🎥 Video Demonstrations  

📌 **Example of test automation implementation in the project:**  
[![Test Automation in PetSitters](https://img.youtube.com/vi/f2U3DToJif4/0.jpg)](https://youtu.be/f2U3DToJif4)  
[▶ Watch on YouTube](https://youtu.be/f2U3DToJif4)

📌 **Jenkins automation execution demo:**  
[![Jenkins Automation Execution](https://img.youtube.com/vi/33VRRRoJxKc/0.jpg)](https://youtu.be/33VRRRoJxKc)  
[▶ Watch on YouTube](https://youtu.be/33VRRRoJxKc)

---

## 🤝 Team Contribution  

This project was developed by a **team of students** as part of the final testing assignment.

### 👥 **Team Members:**  
- **Vladimir Romaikin** (Project Manager)  
- **Denys Parkhomenko**  
- **Dana Streltsova**  
- **Kseniia Ivanova**  

---

## 📜 License  

This project is licensed under the **MIT License**, meaning it can be freely used, modified, and shared as long as the original authorship is acknowledged.

---

<h3 align="center">⭐️ If you like the project, please star and follow!</h3>
