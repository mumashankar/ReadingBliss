document.addEventListener("DOMContentLoaded", () => {
  const bookGrid = document.getElementById("bookGrid");

  fetch("/api/books")
    .then(response => response.json())
    .then(books => {
      books.forEach(book => {
        const card = document.createElement("div");
        card.className = "book-card";

        const title = document.createElement("div");
        title.className = "book-title";
        title.textContent = book.bookTitle;

        const author = document.createElement("div");
        author.className = "book-author";
        author.textContent = book.author;

        const status = document.createElement("div");
        status.className = "book-status " + (book.bookRead ? "completed" : "not-completed");
        status.textContent = "Completed: " + (book.bookRead ? "Yes" : "No");

        card.appendChild(title);
        card.appendChild(author);
        card.appendChild(status);

        bookGrid.appendChild(card);
      });
    })
    .catch(error => {
      console.error("Error loading books:", error);
    });
});