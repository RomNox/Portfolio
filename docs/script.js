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
    // Основные селекторы
    // ---------------------------
    const navLinks = document.querySelectorAll(".nav-link");
    const main = document.getElementById("content");
    const footer = document.querySelector("footer");

    // Сохраняем исходное содержимое (Home) и футер
    const originalMainHTML = main.innerHTML;
    const originalFooterHTML = footer.innerHTML;

    // ---------------------------
    // Объект pages
    // ---------------------------
    const pages = {
        "home": {
            html: originalMainHTML,
            footer: originalFooterHTML,
            onLoad: function () {
                bindNavLinks();
            }
        },
        "resume": {
            html: `
<section class="resume-section">
 <h1>My specialization</h1>
 <div class="resume-content" style="justify-content: space-around;">
   <div class="resume-col">
     <img class="resume-img" src="imeg/QA.webp" alt="QA Tester">
     <h3>QA Tester</h3>
     <button class="resume-btn" data-page="resumeQA">Read more</button>
   </div>
   <div class="resume-col">
     <img class="resume-img" src="imeg/FS_Dev.webp" alt="FS Developer">
     <h3>FS Developer</h3>
     <button class="resume-btn" data-page="resumeFS">Read more</button>
   </div>
 </div>
 <br>
 <p class="resume-description">
   Here you can review a detailed resume that thoroughly describes my professional experience in testing and development.
   The materials include key milestones, technical skills, and certificate information.
   Click 'Read more' to see the full version.
 </p>
</section>
           `,
            footer: originalFooterHTML,
            onLoad: function () {
                // Вместо document.addEventListener(...)
                // напрямую вешаем обработчики на кнопки
                const resumeBtns = document.querySelectorAll(".resume-btn");
                resumeBtns.forEach(btn => {
                    btn.addEventListener("click", function() {
                        loadPage(btn.dataset.page);
                    });
                });
                bindNavLinks();
            }
        },


        "resumeQA": {
            html: `
<div style="max-height: calc(100% - 40px); overflow-y: auto; padding: 20px;">
 <div class="resume-detail-centered">
   <img src="imeg/My_photo.webp"
        alt="Profile Photo"
        style="display: block; margin: 0 auto 20px; width: 180px; height: 180px; border-radius: 50%; object-fit: cover;">
   <br>
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
   </p><br>
   <ul style="text-align:left; max-width:700px; margin:0 auto;">
     <li><strong>Test documentation development:</strong> requirement analysis, test case creation, bug reporting.</li>
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
   <ul style="text-align:left; max-width:700px; margin:0 auto;">
     <li><strong>Automation:</strong> Selenium WebDriver, TestNG, JUnit, Cucumber, Appium</li>
     <li><strong>API Testing:</strong> Postman, RestAssured, HttpClient, OkHttp, Fiddler</li>
     <li><strong>Performance Testing:</strong> JMeter, Artillery</li>
     <li><strong>CI/CD & Version Control:</strong> Git, GitHub, Jenkins, Maven, Gradle</li>
     <li><strong>Programming:</strong> Java (Core & OOP), JavaScript</li>
     <li><strong>Databases:</strong> SQL, NoSQL (MongoDB, PostgreSQL)</li>
     <li><strong>Test Management:</strong> Jira, TestLink</li>
     <li><strong>Security & Compliance:</strong> DSGVO, Privacy Policy</li>
   </ul>
   <br><br><h3>WORK EXPERIENCE</h3>
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
   <br><h3>EDUCATION</h3>
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
   <br><h3>CERTIFICATES</h3>
     <div class="certificates">
       <img src="imeg/ZertifikatQA.webp" alt="QA Certificate" class="certificate-img">
       <img src="imeg/ZertifikatQA2.webp" alt="QA Certificate 2" class="certificate-img">
     </div>
   <br>
   <h3>LANGUAGES</h3><br>
   <ul style="list-style:none; padding:0; margin:0;">
     <li><strong>English</strong> - B2</li>
     <li><strong>German</strong> - A2</li>
     <li><strong>Ukrainian</strong> - Native</li>
     <li><strong>Russian</strong> - Native</li>
   </ul>
   <br>
   <h3>VOLUNTEERING</h3>
   <p>
     <strong>Led the Blood Donation Program in Ukrain.</strong> Focused on donor recruitment and steady blood supplies.
     Organized 50+ events, ensuring logistics, safe transport, and collaboration with medical facilities,
     local authorities, and volunteers. Achieved a 40% donor increase through awareness campaigns and media support.
     Implemented a data management system for donor registration, history tracking, and event planning,
     and worked with youth organizations to attract new participants.
   </p>
   <br>
   <p>
     <strong>Youth Program Leader:</strong> Organized a youth program introducing participants to medical careers through educational events,
     hands-on training in emergency services and hospitals, and visits to medical institutions.
     Involved over 300 students, conducted 20+ sessions, arranged tours of medical museums, and collaborated with professionals.
   </p>
   <br>
   <p>
     <strong>Commander of Emergency Response Teams:</strong> I was responsible for organizing and coordinating volunteer teams during crisis situations. My work involved developing and implementing detailed emergency response plans, collaborating closely with local authorities, medical institutions, and community organizations, and ensuring the efficient allocation of resources during critical events. Through systematic training, regular briefings, and clear management of the teams, I significantly reduced response times and enhanced the overall effectiveness of the volunteer efforts, ultimately improving community safety in high-pressure situations.
   </p>
   <br>
   <button class="resume-btn resume-back-btn">Back</button>
 </div>
</div>
           `,
            footer: originalFooterHTML,
            onLoad: function () {
                document.querySelector(".resume-back-btn").addEventListener("click", function () {
                    loadPage("resume");
                });
                bindNavLinks();
            }
        },
        resumeFS: {
            html: `
<div style="max-height: calc(100% - 40px); overflow-y: auto; padding: 20px;">
 <div class="resume-detail-centered">
   <img src="imeg/My_photo.webp" alt="Profile Photo"
        style="display: block; margin: 0 auto 20px; width: 180px; height: 180px; border-radius: 50%; object-fit: cover;">
   <br>
   <h2>Fullstack Developer</h2>
   <br>
   <p>
     I am interested in the opportunity to grow in the field of fullstack development. With experience in building web applications, backend development,
     and database management, I strive to apply my knowledge in a practical environment.
     I would be happy to discuss how my skills and experience could contribute to your team.
   </p>
   <br><h3>SUMMARY</h3><br>
   <p>
     Fullstack Developer with experience in building web applications, working with databases, and backend infrastructure.
     Proficient in the full development cycle—from designing architecture to deployment and optimization.
     Over 8 years in IT, including project management, business process automation, and software quality assurance.
     Completed an intensive training program at AIT TR GmbH, gaining hands-on experience in Java, Spring Boot, JavaScript (ES6+), React, HTML/CSS, SQL and NoSQL databases, and DevOps methodologies.
   </p>
   <br><h3>TECHNICAL SKILLS</h3><br>
   <ul style="text-align:left; max-width:700px; margin:0 auto;">
     <li><strong>Backend Development:</strong> Java, Spring Boot, Hibernate, REST API</li>
     <li><strong>Frontend Development:</strong> HTML5, CSS3, JavaScript, React</li>
     <li><strong>Databases & Cloud:</strong> PostgreSQL, MySQL, MongoDB, Docker</li>
     <li><strong>DevOps & CI/CD:</strong> Git, GitHub, Jenkins, Docker, Kubernetes</li>
     <li><strong>Testing & QA:</strong> Selenium, Postman, JUnit</li>
   </ul>
   <br><h3>WORK EXPERIENCE</h3>
   <div class="timeline">
     <div class="timeline-item">
       <div class="timeline-content">
         <h4>Fullstack Developer<br>AIT TR GmbH, Germany<br>2024 – 2025</h4>
         <p>
           Completed a comprehensive fullstack development training program, mastering key technologies and best practices in web development.
         </p>
       </div>
     </div>
     <div class="timeline-line"></div>
     <div class="timeline-item">
       <div class="timeline-content">
         <h4>CEO<br>GmbH "ConTrust", Ukraine<br>2015 – 2024</h4>
         <p>
           Designed and implemented digital business solutions, managing end-to-end software development projects.
         </p>
       </div>
     </div>
     <div class="timeline-line"></div>
     <div class="timeline-item">
       <div class="timeline-content">
         <h4>Head of Public Organization<br>International Red Cross, Illichivsk, Ukraine<br>2011 – 2015</h4>
         <p>
           Coordinated humanitarian initiatives and implemented digital tools to optimize operations.
         </p>
       </div>
     </div>
   </div>
   <br><h3>EDUCATION</h3>
   <div class="timeline">
     <div class="timeline-item">
       <div class="timeline-content">
         <h4>Fullstack Developer<br>AIT TR GmbH, Germany<br>2024 – 2025</h4>
         <p>
           Intensive fullstack development program covering a range of technologies including Java, Spring Boot, JavaScript, and DevOps practices.
         </p>
       </div>
     </div>
     <div class="timeline-line"></div>
     <div class="timeline-item">
       <div class="timeline-content">
         <h4>Environmental Engineer<br>Odessa National Ecological University, Ukraine<br>2005 – 2010</h4>
         <p>
           Developed analytical skills and a systematic approach to problem-solving.
         </p>
       </div>
     </div>
   </div>
   <br><h3>CERTIFICATES</h3>
     <div class="certificates">
       <img src="imeg/ZertifikatFS.webp" alt="Fullstack Certificate" class="certificate-img">
       <img src="imeg/ZertifikatFS2.webp" alt="Fullstack Certificate 2" class="certificate-img">
     </div>
   <br>
   <h3>LANGUAGES</h3><br>
   <ul style="list-style:none; padding:0; margin:0;">
     <li><strong>English</strong> - B2</li>
     <li><strong>German</strong> - A2</li>
     <li><strong>Ukrainian</strong> - Native</li>
     <li><strong>Russian</strong> - Native</li>
   </ul>
   <br>
   <h3>VOLUNTEERING</h3>
   <p>
 <strong>Led the Blood Donation Program in Ukrain.</strong> Focused on donor recruitment and steady blood supplies.
 Organized 50+ events, ensuring logistics, safe transport, and collaboration with medical facilities,
 local authorities, and volunteers. Achieved a 40% donor increase through awareness campaigns and media support.
 Implemented a data management system for donor registration, history tracking, and event planning,
 and worked with youth organizations to attract new participants.
</p>
<br>
<p>
 <strong>Youth Program Leader:</strong> Organized a youth program introducing participants to medical careers through educational events,
 hands-on training in emergency services and hospitals, and visits to medical institutions.
 Involved over 300 students, conducted 20+ sessions, arranged tours of medical museums, and collaborated with professionals.
</p>
<br>
<p>
 <strong>Commander of Emergency Response Teams:</strong> Led and coordinated teams in crisis response, volunteer management, and first aid provision.
</p>
   <br><button class="resume-btn resume-back-btn">Back</button>
 </div>
</div>
           `,
            footer: originalFooterHTML,
            onLoad: function () {
                document.querySelector(".resume-back-btn").addEventListener("click", function () {
                    loadPage("resume");
                });
                bindNavLinks();
            }
        },
        portfolio: {
            html: `
<section class="portfolio-section">
 <h2>Portfolio</h2><br>
 <div class="portfolio-content">
   <div class="portfolio-col">
     <img class="portfolio-img" src="imeg/QA_Project.webp" alt="Project 1">
     <h3>QA Student Project</h3>
     <div class="download-button" data-file="Portfolio/QA_Project EN.pdf">
       <div class="text">Download</div>
       <div class="progress-bar"></div>
       <svg viewBox="0 0 25 30">
         <path class="check" d="M2,19.2C5.9,23.6,9.4,28,9.4,28L23,2"/>
       </svg>
     </div>
   </div>
   <div class="portfolio-col">
     <img class="portfolio-img" src="imeg/Java_Project.webp" alt="Project 2">
     <h3>Java Student Project</h3>
     <div class="download-button" data-file="Portfolio/FS_Project EN.pdf">
       <div class="text">Download</div>
       <div class="progress-bar"></div>
       <svg viewBox="0 0 25 30">
         <path class="check" d="M2,19.2C5.9,23.6,9.4,28,9.4,28L23,2"/>
       </svg>
     </div>
   </div>
   <div class="portfolio-col">
     <img class="portfolio-img" src="imeg/CRM_Project.webp" alt="Project 3">
     <h3>CRM Project</h3>
     <div class="download-button" data-file="files/project3.pdf">
       <div class="text">Download</div>
       <div class="progress-bar"></div>
       <svg viewBox="0 0 25 30">
         <path class="check" d="M2,19.2C5.9,23.6,9.4,28,9.4,28L23,2"/>
       </svg>
     </div>
   </div>
 </div>
 <br>
 <p class="portfolio-description">
   Here you can download project presentations that detail concepts, goals, tasks, and results.
   The materials include technical specifications, implementation diagrams, and additional links for an in-depth examination of each case.
   Moreover, you can explore most of the projects on my GitHub in the myCases section.
 </p>
</section>
           `,
            footer: originalFooterHTML,
            onLoad: function () {
                initDownloadButtons();
                bindNavLinks();
            }
        },
        contacts: {
            html: `
<section class="contacts-section">
 <div class="contacts-content" style="text-align: center;">
   <h2>Contact me:</h2>
   <div class="contact-block" style="margin: 20px 0;">
     <img src="imeg/Phone.webp" alt="Phone" class="contact-icon">
     <p><br>+38 068 2620798</p>
     <p>+49 175 8810150</p>
   </div>
   <div class="contact-block" style="margin: 20px 0;">
     <img src="imeg/Mail.webp" alt="Mail" class="contact-icon">
     <p><br>romaykin@gmail.com</p>
   </div>
 </div>
 <div class="social-icons" style="justify-content: center; margin-top: 20px;">
   <a href="#"><img src="imeg/LinkedIn.webp" alt="LinkedIn"></a>
   <a href="#"><img src="imeg/GitHub.webp" alt="GitHub"></a>
   <a href="#"><img src="imeg/Whatsapp.webp" alt="Whatsapp"></a>
   <a href="#"><img src="imeg/Skype.webp" alt="Skype"></a>
 </div>
</section>
           `,
            footer: `<p>© 2025 Romaikin V.</p>`,
            onLoad: function () {
                bindNavLinks();
            }
        }
    };


    // ---------------------------
    // Функция loadPage
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
                main.innerHTML = originalMainHTML;
                footer.innerHTML = originalFooterHTML;
            }

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
        link.addEventListener("click", function (e) {
            e.preventDefault();
            navLinks.forEach(l => l.classList.remove("active"));
            this.classList.add("active");
            loadPage(this.dataset.page);
        });
    });


    // ---------------------------
    // Перепривязка ссылок при обновлении контента
    // ---------------------------
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


    // ---------------------------
    // Инициализация анимированных кнопок скачивания
    // ---------------------------
    function initDownloadButtons() {
        $(".download-button").each(function () {
            var $btn = $(this);
            var fileUrl = $btn.data("file");
            var pathEl = $btn.find(".check")[0];
            var offset = anime.setDashoffset(pathEl);
            pathEl.setAttribute("stroke-dashoffset", offset);

            var timeline = anime.timeline({ autoplay: false });

            timeline
                .add({
                    targets: $btn.find(".text")[0],
                    duration: 1,
                    opacity: 0
                })
                .add({
                    targets: $btn[0],
                    duration: 1200,
                    height: "3px",
                    width: "200px",
                    backgroundColor: "#2B2D2F",
                    borderRadius: "200px"
                })
                .add({
                    targets: $btn.find(".progress-bar")[0],
                    duration: 900,
                    width: "200px",
                    easing: "linear"
                })
                .add({
                    targets: $btn[0],
                    duration: 750,
                    width: "40px",
                    height: "40px",
                    borderRadius: "50%",
                    backgroundColor: "#d8bc86"
                })
                .add({
                    targets: $btn.find(".progress-bar")[0],
                    duration: 1,
                    opacity: 0
                })
                .add({
                    targets: pathEl,
                    strokeDashoffset: [offset, 0],
                    duration: 200,
                    easing: "easeInOutSine",
                    complete: function () {
                        var a = document.createElement("a");
                        a.href = fileUrl;
                        a.download = "";
                        document.body.appendChild(a);
                        a.click();
                        document.body.removeChild(a);
                    }
                });

            $btn.on("click", function () {
                timeline.play();
            });
        });
    }
});
