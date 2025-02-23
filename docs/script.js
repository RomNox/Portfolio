document.addEventListener("DOMContentLoaded", function () {
    // ---------------------------
    // Анимация слов на главной (hero)
    // ---------------------------
    const textElement = document.querySelector(".hero h1");
    const words = ["QA Tester", "FS Developer"];
    let wordIndex = 0;
    let charIndex = words[wordIndex].length;
    let isDeleting = true;
    let speed = 250;

    function typeEffect() {
        const currentWord = words[wordIndex];
        const displayText = currentWord.substring(0, charIndex);
        textElement.textContent = `I'M ${displayText}`;

        if (isDeleting) {
            charIndex--;
            if (charIndex === 0) {
                isDeleting = false;
                wordIndex = (wordIndex + 1) % words.length;
            }
        } else {
            charIndex++;
            if (charIndex > currentWord.length) {
                setTimeout(() => {
                    isDeleting = true;
                    typeEffect();
                }, 3000);
                return;
            }
        }
        setTimeout(typeEffect, isDeleting ? speed - 150 : speed);
    }
    setTimeout(typeEffect, 2500);

    // ---------------------------
    // Селекторы DOM
    // ---------------------------
    const navLinks = document.querySelectorAll(".nav-link");
    const main = document.getElementById("content");
    const footer = document.querySelector("footer");

    // Исходный контент (Home) и футер
    const originalMainHTML = main.innerHTML;
    const originalFooterHTML = footer.innerHTML;

    // ---------------------------
    // Объект pages
    // ---------------------------
    const pages = {
        // Домашняя страница
        "home": {
            html: originalMainHTML,
            footer: originalFooterHTML,
            onLoad: function() {
                bindNavLinks();
            }
        },

        // Вкладка Resume – краткое резюме (QA / FS)
        "resume": {
            html: `
<section class="resume-section">
  <h1>Мои профессии</h1>
  <div class="resume-content" style="justify-content: space-around;">
    <div class="resume-col">
      <img class="resume-img" src="imeg/QA.webp" alt="QA Tester">
      <h3>QA Tester</h3>
      <button class="resume-btn" data-page="resumeQA">Подробнее</button>
    </div>
    <div class="resume-col">
      <img class="resume-img" src="imeg/FS_Dev.webp" alt="FS Developer">
      <h3>FS Developer</h3>
      <button class="resume-btn" data-page="resumeFS">Подробнее</button>
    </div>
  </div>
  <p class="resume-description">
    Здесь приведено краткое резюме, подчёркивающее мой опыт в тестировании и разработке.
    Нажмите "Подробнее", чтобы увидеть полную версию.
  </p>
</section>`,
            footer: originalFooterHTML,
            onLoad: function() {
                // Кнопки "Подробнее"
                const resumeBtns = document.querySelectorAll(".resume-btn");
                resumeBtns.forEach(btn => {
                    btn.addEventListener("click", function() {
                        loadPage(this.dataset.page);
                    });
                });
                bindNavLinks();
            }
        },

        // Детальное резюме QA (полностью по центру)
        "resumeQA": {
            html: `
<div style="max-height:calc(100% - 40px); overflow-y:auto; padding:20px;">
  <div class="resume-detail-centered">

    <!-- КРУГЛАЯ ФОТО -->
    <img src="imeg/My_photo.webp"
         alt="Profile Photo"
         style="
           display:block;
           margin:0 auto 20px;
           width:180px;
           height:180px;
           border-radius:50%;
           object-fit:cover;
         ">

    <h2>QA MANUAL AND AUTOMATION TESTER</h2>
    <br>

    <p>
      I am interested in the opportunity to grow in the field of software quality assurance.
      With experience in manual and automated testing, as well as an understanding of fullstack development processes,
      I strive to apply my knowledge in a practical environment.
      I would be happy to discuss how my experience could benefit your team
      and look forward to the opportunity for a personal conversation.
    </p>

    <br><h3>SUMMARY</h3><br>
    <p>
      QA Manual & Automation Tester with a background in IT development and project management.
      Led my own IT company, where I was involved in software development, testing, and implementation,
      gaining a deep understanding of the software development process.
      Completed 960 hours of theory and 160 hours of hands-on training at AIT TR GmbH (Berlin),
      mastering the full testing cycle – from manual to automated UI and API testing.
    </p>

    <br><h3>MANUAL & AUTOMATION TESTING</h3><br>
    <p>
      Experienced in testing software at all levels, including functional, compatibility, performance, and security.
      Participated in the full testing cycle – from test case design to result analysis and process optimization.
    </p>

    <ul>
      <li><strong>Test documentation development:</strong> requirement analysis, test case creation, and bug reporting.</li>
      <li><strong>Functional testing:</strong> verifying system compliance with requirements, analyzing user scenarios.</li>
      <li><strong>UI testing:</strong> interface validation, regression, and cross-browser checks.</li>
      <li><strong>API testing:</strong> ensuring request correctness, data transmission, and security.</li>
      <li><strong>Compatibility testing:</strong> assessing performance across various devices, OS, and browsers.</li>
      <li><strong>Boundary and validation tests:</strong> evaluating system behavior with valid and invalid inputs.</li>
      <li><strong>Performance testing:</strong> analyzing system load capacity and identifying bottlenecks.</li>
      <li><strong>Security testing:</strong> detecting vulnerabilities, assessing API and UI protection.</li>
      <li><strong>End-to-End testing:</strong> comprehensive validation of system component interactions.</li>
    </ul>

    <br><h3>TOOLS & TECHNOLOGIEN</h3><br>
    <ul>
      <li><strong>Automation:</strong> Selenium WebDriver, TestNG, JUnit, Cucumber, Appium</li>
      <li><strong>API Testing:</strong> Postman, RestAssured, HttpClient, OkHttp, Fiddler</li>
      <li><strong>Performance Testing:</strong> JMeter, Artillery</li>
      <li><strong>CI/CD & Version Control:</strong> Git, GitHub, Jenkins, Maven, Gradle</li>
      <li><strong>Programming:</strong> Java (Core & OOP), JavaScript</li>
      <li><strong>Databases:</strong> SQL, NoSQL (MongoDB, PostgreSQL)</li>
      <li><strong>Test Management:</strong> Jira, TestLink</li>
      <li><strong>Security & Compliance:</strong> DSGVO, Privacy Policy</li>
    </ul>

    <br><h3>WORK EXPERIENCE</h3><br>
    <div class="timeline">
      <div class="timeline-item">
        <div class="timeline-content">
          <h4>QA Manual & Automation Tester<br>AIT TR GmbH, Germany<br>2024 – 2025</h4>
          <p>
            Completed a full software testing training program, mastering UI and API test automation,
            test design, performance, and security testing.
          </p>
        </div>
      </div>
      <div class="timeline-line"></div>
      <div class="timeline-item">
        <div class="timeline-content">
          <h4>CEO<br>GmbH "ConTrust", Ukraine<br>2015 – 2024</h4>
          <p>
            Led software development and implementation, established testing processes,
            automated business workflows, and ensured digital product quality.
          </p>
        </div>
      </div>
      <div class="timeline-line"></div>
      <div class="timeline-item">
        <div class="timeline-content">
          <h4>Head of Public Organization<br>International Red Cross, Illichivsk, Ukraine<br>2011 – 2015</h4>
          <p>
            Coordinated projects, managed operations, and implemented reporting and quality control systems.
          </p>
        </div>
      </div>
    </div>

    <br><h3>EDUCATION</h3><br>
    <div class="timeline">
      <div class="timeline-item">
        <div class="timeline-content">
          <h4>QA Manual & Automation Tester<br>AIT TR GmbH, Germany<br>2024 – 2025</h4>
          <p>
            960 hours of theoretical training + 160 hours of practice, covering manual and automated testing,
            test design, API and UI testing, performance, and security testing.
          </p>
        </div>
      </div>
      <div class="timeline-line"></div>
      <div class="timeline-item">
        <div class="timeline-content">
          <h4>Environmental Engineer<br>Odessa National Ecological University, Ukraine<br>2005 – 2010</h4>
          <p>
            Developed analytical thinking, a systematic approach, and data processing skills,
            which later contributed to IT project management and software testing.
          </p>
        </div>
      </div>
    </div>

    <br><h3>LANGUAGES</h3><br>
    <ul>
      <li><strong>English</strong> - B2</li>
      <li><strong>German</strong> - A2</li>
      <li><strong>Ukrainian</strong> - Native</li>
      <li><strong>Russian</strong> - Native</li>
    </ul>

    <button class="resume-back-btn" style="margin-top:15px;">Назад</button>
  </div> <!-- .resume-detail-centered -->
</div>
            `,
            footer: originalFooterHTML,
            onLoad: function() {
                // Кнопка "Назад"
                const backBtn = document.querySelector(".resume-back-btn");
                backBtn.addEventListener("click", function() {
                    loadPage("resume");
                });
                bindNavLinks();
            }
        },

        // Детальное резюме FS
        "resumeFS": {
            html: `
<div style="max-height:calc(100% - 40px); overflow-y:auto; padding:20px;">
  <img src="imeg/Logo.webp" alt="Profile Photo"
       style="display:block; margin:0 auto 20px; width:150px; height:150px; border-radius:50%; object-fit:cover;">
  <h2 style="text-align:center;">Fullstack Developer</h2>
  <p>Опыт full-stack разработки (frontend/backend, CI/CD, Docker, Kubernetes...).</p>
  <button class="resume-back-btn" style="margin-top:15px;">Назад</button>
</div>
            `,
            footer: originalFooterHTML,
            onLoad: function() {
                const backBtn = document.querySelector(".resume-back-btn");
                backBtn.addEventListener("click", function() {
                    loadPage("resume");
                });
                bindNavLinks();
            }
        },

        // Портфолио
        "portfolio": {
            html: `
<section>
  <h2>Портфолио</h2>
  <p>Проекты, над которыми я работал.</p>
</section>`,
            footer: originalFooterHTML,
            onLoad: function() {
                bindNavLinks();
            }
        },

        // Контакты
        "contacts": {
            html: `
<section class="contacts-section">
  <div class="contacts-content" style="text-align: center;">
    <h2>Свяжитесь со мной</h2>
    <div class="contact-block" style="margin: 20px 0;">
      <img src="imeg/Phone.webp" alt="Phone" class="contact-icon">
      <p>+38 068 262 07 98</p>
      <p>+49 175 881 01 50</p>
    </div>
    <div class="contact-block" style="margin: 20px 0;">
      <img src="imeg/Mail.webp" alt="Mail" class="contact-icon">
      <p>romaykin@gmail.com</p>
    </div>
  </div>
  <div class="social-icons" style="justify-content: center; margin-top: 20px;">
    <a href="#"><img src="imeg/LinkedIn.webp" alt="LinkedIn"></a>
    <a href="#"><img src="imeg/GitHub.webp" alt="GitHub"></a>
    <a href="#"><img src="imeg/Whatsapp.webp" alt="Whatsapp"></a>
    <a href="#"><img src="imeg/Skype.webp" alt="Skype"></a>
  </div>
</section>`,
            footer: `<p>© 2025 Romaikin V.</p>`,
            onLoad: function() {
                bindNavLinks();
            }
        }
    };

    // ---------------------------
    // Функция loadPage (переключение вкладок)
    // ---------------------------
    function loadPage(page) {
        main.classList.add("blur-fade-out");
        if (page === "contacts") {
            footer.classList.add("blur-fade-out");
        }

        setTimeout(() => {
            if (pages[page]) {
                main.innerHTML = pages[page].html;
                footer.innerHTML = pages[page].footer || originalFooterHTML;
            } else {
                // Если вкладки нет => Home
                main.innerHTML = originalMainHTML;
                footer.innerHTML = originalFooterHTML;
            }

            // Если у страницы есть onLoad
            if (pages[page] && typeof pages[page].onLoad === "function") {
                pages[page].onLoad();
            }

            main.classList.remove("blur-fade-out");
            main.classList.add("blur-fade-in");
            if (page === "contacts") {
                footer.classList.remove("blur-fade-out");
                footer.classList.add("blur-fade-in");
            }
            setTimeout(() => {
                main.classList.remove("blur-fade-in");
                footer.classList.remove("blur-fade-in");
            }, 800);
        }, 800);
    }

    // ---------------------------
    // Привязка ссылок меню
    // ---------------------------
    navLinks.forEach(link => {
        link.addEventListener("click", function(e) {
            e.preventDefault();
            navLinks.forEach(l => l.classList.remove("active"));
            this.classList.add("active");
            loadPage(this.dataset.page);
        });
    });

    // Перепривязка ссылок при обновлении контента
    function bindNavLinks() {
        const newNavLinks = document.querySelectorAll(".nav-link");
        newNavLinks.forEach(link => {
            link.addEventListener("click", function (e) {
                e.preventDefault();
                newNavLinks.forEach(l => l.classList.remove("active"));
                this.classList.add("active");
                loadPage(this.dataset.page);
            });
        });
    }
});
