# Object-Oriented Programming: Aggregation

## 📌 Overview
**Aggregation** is a specialized form of **Association** that represents a **"has-a"** or **"whole-part"** relationship between two classes. In aggregation, one object acts as a container (**whole**), and another object acts as its content (**part**).

Unlike Composition, the child objects in an aggregation relationship **have an independent lifecycle** and can exist without the container.

---

## 🔑 Key Characteristics
* **No Ownership:** The container references its parts but does not own them.
* **Independent Existence:** Deleting the container object does **not** destroy the contained objects.
* **No Lifecycle Control:** The container does not create or destroy the parts.
* **Shared Reference:** The same object can belong to multiple containers simultaneously.

---

## 💡 Real-World Analogies
* **Library & Books:** A `Library` contains `Book` objects. If the library closes down, the books still exist and can be moved elsewhere.
* **Sports Team & Players:** A `Team` has `Player`s. If the team disbands, the players continue to exist and can join other teams.

---

## 📐 UML Representation
* **Symbol:** Represented by a **hollow (open) diamond** ($\diamondsuit$) on the container ("whole") side.
* **Multiplicity:** Indicates cardinality (e.g., `1` to `*` for one container to many parts).

---

## 💻 Java Code Example

```java
import java.util.List;

// Independent Part
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}

// Container (Whole)
class Library {
    private String name;
    private List<Book> books; // Holds reference to external objects

    // Books are passed in, not created inside Library
    public Library(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public void showBooks() {
        System.out.println("Books in " + name + ":");
        for (Book b : books) {
            System.out.println("- " + b.getTitle() + " by " + b.getAuthor());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Books created independently
        Book b1 = new Book("Clean Code", "Robert C. Martin");
        Book b2 = new Book("Design Patterns", "Erich Gamma");

        // Passed into container
        Library library = new Library("City Library", List.of(b1, b2));
        library.showBooks();

        // If 'library' is deleted or garbage collected,
        // 'b1' and 'b2' still exist in memory!
    }
}