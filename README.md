# 📚 Book Library Web Application

A simple **Spring Boot** web application demonstrating **CRUD operations** with a **Postgres database hosted on Render**.  
This project showcases backend–frontend integration, scheduled jobs, and database joins for practical book management.

---

## 🚀 Features

- **CRUD Operations** on Postgres DB hosted on Render
- **Three relational tables**:
    - **Book** → `id`, `title`, `author`, `genre`, `language`
    - **MyLibrary** → `book_id`, `readStatus` (`Completed`, `Not Started`, `In Progress`), `comment`
    - **MyWishlist** → `book_id`, `buyFrom`, `comment`
- **Single API endpoint**:
    - `/api/books` → Returns list of all books in **MyLibrary** with their read status, using a join with the **Book** table
- **Simple UI** → Displays books returned by `/api/books`
- **Scheduled Job** → Runs every 12 hours to keep Render DB active by querying the list of tables in the `public` schema (independent of future schema changes)

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot
- **Database**: Postgres (hosted on Render)
- **Frontend**: Simple HTML/CSS/JS UI
- **Deployment**: Render

---

## 🌐 Live Demo

The application is deployed on Render and accessible here:  
👉 `https://readingbliss.onrender.com/` [(book-library.onrender.com in Bing)](https://readingbliss.onrender.com/")

---

## 📂 Project Structure

```
src/
 ├── main/
 │   ├── java/com/example/booklibrary
 │   │    ├── controller/BookController.java
 │   │    ├── service/BookService.java
 │   │    ├── dao/BookDao.java
 │   │    ├── dao/DBDetailsDao.java
 │   │    ├── model/Book.java
 │   │    ├── service/BookService.java
 │   │    └── service/DBDetailsService.java
 │   └── resources/
 │        ├── application.properties
 │        └── static/index.html
 │        └── static/script.js
 │        └── static/styles.css
 └── test/
```

---

## ⚙️ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/mumashankar/ReadingBliss
   cd ReadingBliss
   ```

2. **Configure Postgres DB on Render**
    - Create a Postgres instance on Render
    - Update `application.properties` with DB connection details:
      ```properties
      spring.datasource.url=jdbc:postgresql://<render-db-url>/<dbname>
      spring.datasource.username=<username>
      spring.datasource.password=<password>
      spring.jpa.hibernate.ddl-auto=update
      ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the API**
    - `http://localhost:8080/api/books`

5. **View the UI**
    - Open `http://localhost:8080` in your browser

---

## 🔄 Scheduled Job

- Runs every **12 hours**
- Executes query:
  ```sql
  SELECT table_name FROM information_schema.tables WHERE table_schema='public';
  ```
- Ensures DB remains active even if no CRUD activity occurs

---
