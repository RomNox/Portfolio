document.addEventListener("DOMContentLoaded", function () {
    // Анимация текста
    const textElement = document.querySelector(".hero h1");
    const words = ["QA Tester", "Developer"];
    let wordIndex = 0;
    let charIndex = words[wordIndex].length;
    let isDeleting = true;
    let speed = 250;

    function typeEffect() {
        let currentWord = words[wordIndex];
        let displayText = currentWord.substring(0, charIndex);
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

    // Переключение страниц
    const links = document.querySelectorAll(".nav-link");
    const content = document.getElementById("content");

    links.forEach(link => {
        link.addEventListener("click", function (e) {
            e.preventDefault();
            const page = this.dataset.page;
            loadPage(page);

            links.forEach(l => l.classList.remove("active"));
            this.classList.add("active");
        });
    });

    function loadPage(page) {
        const pages = {
            "home": `<div class="hero">
                  <img class="profile-image" src="imeg/Logo.webp" alt="Profile Image">
                  <h1>I'M QA Tester</h1>
                  <p>Vladimir Romaikin</p>
               </div>`,
            "resume": `<section>
                    <h2>Резюме</h2>
                    <p>Информация о моем опыте работы и навыках.</p>
                 </section>`,
            "portfolio": `<section>
                      <h2>Портфолио</h2>
                      <p>Проекты, над которыми я работал.</p>
                    </section>`,
            "contacts": `<section class="contacts-section">
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
                    </section>`
        };

        // Применяем эффект затемнения с размытием перед сменой контента
        content.classList.add("blur-fade-out");

        setTimeout(() => {
            content.innerHTML = pages[page] || pages["home"];

            // Обновляем футер для раздела "contacts"
            const footer = document.querySelector("footer");
            if (page === "contacts") {
                footer.innerHTML = `<p>© 2025 Romaikin V.</p>`;
            } else {
                footer.innerHTML = `<div class="contact-info">
                              <p>Tel(Ukr): +38 068 2620798</p>
                              <p>Tel(Ger): +49 175 8810150</p>
                              <p>Email: romaykin@gmail.com</p>
                            </div>
                            <p>© 2025 Romaikin V.</p>
                            <div class="social-icons">
                              <a href="#"><img src="imeg/LinkedIn.webp" alt="LinkedIn"></a>
                              <a href="#"><img src="imeg/GitHub.webp" alt="GitHub"></a>
                              <a href="#"><img src="imeg/Whatsapp.webp" alt="Whatsapp"></a>
                              <a href="#"><img src="imeg/Skype.webp" alt="Skype"></a>
                            </div>`;
            }

            content.classList.remove("blur-fade-out");
            content.classList.add("blur-fade-in");

            setTimeout(() => {
                content.classList.remove("blur-fade-in");
            }, 1000);
        }, 1000);
    }
});
