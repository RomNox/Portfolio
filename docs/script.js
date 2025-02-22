document.addEventListener("DOMContentLoaded", function () {
    // Анимация текста в блоке hero (Home)
    const textElement = document.querySelector(".hero h1");
    const words = ["QA Tester", " FS Developer"];
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

    // Элементы DOM
    const navLinks = document.querySelectorAll(".nav-link");
    const card = document.getElementById("card");       // Вся карточка
    const main = document.getElementById("content");      // Центральный блок
    const footer = document.querySelector("footer");      // Футер

    // Исходный контент для Home
    const originalMainHTML = main.innerHTML;
    // Исходный футер (с иконками и контактами)
    const originalFooterHTML = footer.innerHTML;

    // Навигация по вкладкам
    navLinks.forEach(link => {
        link.addEventListener("click", function (e) {
            e.preventDefault();
            navLinks.forEach(l => l.classList.remove("active"));
            this.classList.add("active");
            loadPage(this.dataset.page);
        });
    });

    function loadPage(page) {
        // Всегда анимируем main
        main.classList.add("blur-fade-out");
        // Анимировать футер только для "contacts"
        if (page === "contacts") {
            footer.classList.add("blur-fade-out");
        }

        setTimeout(() => {
            card.classList.remove("flipped");
            if (page === "resume") {
                main.innerHTML = createFlipContainer();
                // Для вкладки Resume используем полный футер
                footer.innerHTML = originalFooterHTML;
                bindResumeButtons();
                bindNavLinks();
            } else if (page === "portfolio") {
                main.innerHTML = `
<section>
  <h2>Портфолио</h2>
  <p>Проекты, над которыми я работал.</p>
</section>`;
                footer.innerHTML = originalFooterHTML;
                bindNavLinks();
            } else if (page === "contacts") {
                main.innerHTML = `
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
</section>`;
                // Заменяем футер на сокращённый вариант
                footer.innerHTML = `<p>© 2025 Romaikin V.</p>`;
                bindNavLinks();
            } else {
                main.innerHTML = originalMainHTML;
                footer.innerHTML = originalFooterHTML;
                bindNavLinks();
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

    // Создание flip-контейнера для раздела Resume
    function createFlipContainer() {
        const frontHTML = `
<div class="face front">
  <section class="resume-section">
    <h2>Краткое резюме</h2>
    <div class="resume-content">
      <div class="resume-col">
        <img class="resume-img" src="imeg/QA.webp" alt="QA Tester">
        <h3>QA Tester</h3>
        <button class="resume-btn" data-resume="qa">Подробнее</button>
      </div>
      <div class="divider"></div>
      <div class="resume-col">
        <img class="resume-img" src="imeg/FS_Dev.webp" alt="FS Developer">
        <h3>FS Developer</h3>
        <button class="resume-btn" data-resume="fs">Подробнее</button>
      </div>
    </div>
    <p class="resume-description">
      Здесь приведено краткое резюме, подчёркивающее мой опыт в тестировании и разработке.
      Выберите специализацию для получения подробной информации.
    </p>
  </section>
</div>`;

        const backHTML = `
<div class="face back">
  <section class="resume-detail-placeholder">
    <h2>Детальное резюме</h2>
    <p>Нажмите "Подробнее" для получения информации.</p>
  </section>
</div>`;

        return `
<div class="flip-container">
  <div class="flip-inner">
    ${frontHTML}
    ${backHTML}
  </div>
</div>`;
    }

    // Привязка кнопок "Подробнее" на кратком резюме
    function bindResumeButtons() {
        const resumeButtons = document.querySelectorAll(".resume-btn");
        resumeButtons.forEach(btn => {
            btn.addEventListener("click", function () {
                const type = this.dataset.resume; // "qa" или "fs"
                showDetailedResume(type);
            });
        });
    }

    // Функция показа детального резюме с переворотом карточки
    function showDetailedResume(type) {
        // Сначала fade-out main
        main.classList.add("blur-fade-out");
        setTimeout(() => {
            let detailHTML = "";
            if (type === "qa") {
                detailHTML = `
<section class="resume-detail">
  <img class="profile-image" src="imeg/Logo.webp" alt="Profile Image" style="width:150px; margin-bottom:20px;">
  <h2>Детальное резюме: QA Tester</h2>
  <p>Мой опыт в тестировании ПО включает использование современных методик автоматизации и ручного тестирования, выявление критических ошибок и обеспечение высокого качества продукта.</p>
  <p>Я работаю с баг-трекинговыми системами, пишу авто-тесты и подробную тестовую документацию.</p>
  <button class="back-btn">Назад</button>
</section>`;
            } else {
                detailHTML = `
<section class="resume-detail">
  <img class="profile-image" src="imeg/Logo.webp" alt="Profile Image" style="width:150px; margin-bottom:20px;">
  <h2>Детальное резюме: FS Developer</h2>
  <p>Благодаря глубоким знаниям full‑stack разработки, я создаю надёжные веб-приложения, интегрирую современные технологии и оптимизирую процессы разработки для комплексных решений.</p>
  <p>Мой опыт охватывает серверную и клиентскую части, а также работу с CI/CD для быстрой и качественной поставки продукта.</p>
  <button class="back-btn">Назад</button>
</section>`;
            }

            const backFace = document.querySelector(".flip-container .face.back");
            if (backFace) {
                backFace.innerHTML = detailHTML;
            }

            // Переворачиваем всю карточку (header, main, footer)
            card.classList.add("flipped");

            main.classList.remove("blur-fade-out");
            main.classList.add("blur-fade-in");
            setTimeout(() => {
                main.classList.remove("blur-fade-in");
            }, 800);

            // Кнопка "Назад"
            const backBtn = document.querySelector(".back-btn");
            if (backBtn) {
                backBtn.addEventListener("click", function () {
                    main.classList.add("blur-fade-out");
                    setTimeout(() => {
                        card.classList.remove("flipped");
                        loadPage("resume");
                        main.classList.remove("blur-fade-out");
                        main.classList.add("blur-fade-in");
                        setTimeout(() => {
                            main.classList.remove("blur-fade-in");
                        }, 800);
                    }, 800);
                });
            }
        }, 800);
    }

    // Привязка навигационных ссылок внутри динамического контента
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
        bindResumeButtons();
    }
});
