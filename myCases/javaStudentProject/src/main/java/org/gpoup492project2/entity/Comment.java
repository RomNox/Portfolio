package org.gpoup492project2.entity;
import java.time.LocalDate;


public class Comment {

     /**
     Представляет комментарий к задаче или проекту.
     */


        private String id;           // Уникальный идентификатор комментария
        private String text;         // Текст комментария
        private LocalDate date;      // Дата создания комментария
        private User author;         // Пользователь, оставивший комментарий

         //Конструктор для инициализации всех полей комментария.

        public Comment(String id, String text, LocalDate date, User author) {
            this.id = id;
            this.text = text;
            this.date = date;
            this.author = author;
        }

        // Геттеры и сеттеры для всех полей

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public User getAuthor() {
            return author;
        }

        public void setAuthor(User author) {
            this.author = author;
        }

}
