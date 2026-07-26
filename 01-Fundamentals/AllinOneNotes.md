
```markdown
# 🎯 LLD Interview Core Guide: Machine Coding, Evaluation & Design Paradigms

> **Quick Summary:** 
> LLD isn't just about drawing diagrams or writing class definitions—it's about demonstrating how you structure clean, maintainable, and extensible code under real interview constraints.

---

## 1. 🥊 Low-Level Design (LLD) vs. Machine Coding Round

While both test your object-oriented design skills, the execution and expectations differ significantly:

| Feature | LLD Round (Conceptual / Discussion) | Machine Coding Round (Hands-On) |
| :--- | :--- | :--- |
| **Duration** | ~45 to 60 Minutes | ~90 to 120 Minutes |
| **Primary Deliverable** | Class diagrams, interfaces, schema, whiteboard code | **Executable, working code** with driver/main class |
| **Focus Area** | Design patterns, extensibility, trade-offs | Functionality, clean code, handling edge cases, execution |
| **Testing** | Mental walkthroughs & verbal discussion | Unit tests or console output verification |
| **Common at** | Google, Amazon, Microsoft | Uber, Swiggy, Flipkart, CRED |

> 💡 **Takeaway:** In Machine Coding, **working code comes first**. A perfect design pattern with code that doesn't run will fail the round!

---

## 2. 🎭 Types of LLD Interviews

LLD interview formats generally fall into three distinct types:

1. **Object-Oriented Design (OOD):**
   * *Focus:* Modeling real-world systems into OOP entities and relationships.
   * *Examples:* Design a Parking Lot, Design an Elevator System, Design a Vending Machine.
2. **Component / Library Design:**
   * *Focus:* API design, concurrency, thread safety, and extensibility.
   * *Examples:* Design a Rate Limiter, Design an In-Memory Cache, Design a Task Scheduler.
3. **Refactoring / Code Smells:**
   * *Focus:* Identifying poorly written code (rigid, fragile) and applying SOLID principles & design patterns to refactor it.

---

## 3. 📊 How LLD is Evaluated in Interviews

Interviewer expectations generally boil down to these 5 pillars:

* 🟢 **Correctness & Functionality:** Does the system satisfy the core requirements?
* 🟢 **SOLID Principles & Clean Code:** Are responsibilities separated? Is the code DRY (Don't Repeat Yourself) and easy to read?
* 🟢 **Extensibility & Flexibility:** Can a new feature be added with minimal changes to existing code (Open/Closed Principle)?
* 🟢 **Design Patterns Application:** Are design patterns (Strategy, Factory, Observer, etc.) used naturally, or forced unnaturally?
* 🟢 **Concurrency & Edge Cases:** How does the design handle null checks, exceptions, or multi-threaded scenarios?

---

## 4. 🔄 Functional Design vs. Object-Oriented Design (OOD)

Choosing the right paradigm depends on what changes more often in your system: **Data Types** or **Operations**.


```

```
     ┌─────────────────────────────────────────────────────────┐
     │                 How Operations Change                   │
     ├──────────────────────────┬──────────────────────────────┤
     │ Object-Oriented Design   │ Functional Design            │
     ├──────────────────────────┼──────────────────────────────┤
     │ Easy to add NEW TYPES    │ Easy to add NEW OPERATIONS   │
     │ (Add a new class)        │ (Add a new function)         │
     └──────────────────────────┴──────────────────────────────┘

```

```

* **Object-Oriented Design (OOD):**
  * Bundles **data and behavior** together in objects.
  * *Best when:* You have a fixed set of operations, but you frequently add new data types/entities (e.g., adding a new Vehicle type to a Parking Lot).
* **Functional Design (FP):**
  * Treats **data and behavior separately** (immutable data + pure functions).
  * *Best when:* Data structures are fixed, but you frequently add new operations/transformations over that data (e.g., data pipelines, analytics).

---

## 5. 🚫 When NOT to Use OOP

OOP is powerful, but over-using it leads to bloated, hard-to-maintain code. **Avoid OOP when:**

1. **Simple Data Containers (DTOs):** If a class only holds data without logic, use simple structs, POJOs, or records instead of complex inheritance hierarchies.
2. **Pure Utility Functions:** Math operations, string manipulation, or stateless helpers don't need instantiated classes (e.g., `Math.max(a, b)`).
3. **Performance-Critical Core Loops:** Deep object graphs, virtual function lookups (polymorphism overhead), and garbage collection overhead can slow down high-performance game loops or low-latency systems.
4. **When Procedural or Functional Code is Simpler:** For small scripts or simple workflows, forcing classes, factories, and interfaces introduces unnecessary complexity ("Over-engineering").

---

## 🧠 Quick Revision Checklist

* [ ] Can I turn requirements into a working class model within 15 minutes?
* [ ] Am I using interfaces for abstraction instead of concrete classes?
* [ ] Am I avoiding unnecessary patterns when simple procedural logic works better?
* [ ] Is my machine coding submission actually runnable?

```

