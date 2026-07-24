# 🏛️ Low-Level Design (LLD) vs. High-Level Design (HLD)

> **Quick Summary:** 
> * **HLD** answers **"WHAT"** components are needed and **HOW** they scale, connect, and persist data across networks.
> * **LLD** answers **"EXACTLY HOW"** each individual component is written in code using classes, interfaces, and design patterns.

---

## 💡 The Real-World Analogy

* **Building a House:**
  * **HLD (Architect Blueprint):** "We need 3 bedrooms, 1 kitchen, main power connection, and a septic tank layout."
  * **LLD (Electrical & Plumbing Spec):** "Use a 15-amp breaker here, a 2-inch PVC pipe with a 90° elbow joint connecting sink to drainage."

---

## ⚖️ Key Differences at a Glance

| Aspect | High-Level Design (HLD) | Low-Level Design (LLD) |
| :--- | :--- | :--- |
| **Primary Question** | *What are the systems and how do they communicate?* | *How do classes and methods interact internally?* |
| **Main Focus** | Scalability, Availability, Storage, Latency, API Contracts | OOP Principles, SOLID Rules, Design Patterns, Memory Efficiency |
| **Key Artifacts** | Architecture Diagrams, DB Schemas, Data Flow Diagrams | UML Class Diagrams, Sequence Diagrams, Working Code |
| **Common Components** | Load Balancers, Caching (Redis), Message Queues (Kafka), DB Shards | Interfaces, Abstract Classes, Concrete Strategy Classes, Repositories |
| **Interview Types** | System Design / HLD Round | Machine Coding / LLD Round |

---

## 🔍 Case Study: URL Shortener

### 🌐 1. High-Level Design (HLD) Scope
In an HLD round, designing a URL shortener focuses on **scale & reliability**:
* **Traffic:** Handling 10k requests/second.
* **Database:** NoSQL vs. Relational DB for storing `<ShortKey, LongUrl>`.
* **Caching:** Adding a Redis cache layer for popular links to achieve $<10\text{ms}$ latency.
* **API Gateway:** Load balancing incoming traffic across 10 service instances.

### 🧩 2. Low-Level Design (LLD) Scope
In an LLD round, designing a URL shortener focuses on **extensibility & clean code**:
* **`KeyGenerationStrategy` (Strategy Pattern):** An interface allowing `Base62Strategy` or `MD5Strategy` to be swapped without modifying core logic.
* **`UrlRepository` (Repository Pattern):** An interface abstracting storage (`InMemoryUrlRepository` vs. `DatabaseUrlRepository`).
* **`UrlShortenerService`:** The orchestrator class applying rules and combining strategy + repository.

---

## 🎯 How to Identify Prompts in Interviews

### 🚨 HLD Signals
* *"How would you handle 10 Million Users?"*
* *"Design Twitter / Uber / YouTube / WhatsApp"*
* *"Where would you store this data and how do you replicate it?"*

### 🚨 LLD Signals
* *"Write the classes and interfaces for this system."*
* *"Design a Parking Lot / Elevator System / Snake Game"*
* *"Show how you would apply SOLID principles or a specific design pattern here."*

---

## 📝 Key Takeaways for Revision

1. **Don't over-engineer LLD with HLD tools:** A Parking Lot LLD doesn't need Kafka queues or Database Sharding unless explicitly asked.
2. **Focus on clean code in LLD:** Maintainability, loose coupling, and applying design patterns (e.g., Strategy, Factory, Observer) matter most.
3. **Always clarify intent:** If given a vague prompt, ask: *"Are we focusing on high-level architecture and scaling, or object-oriented class design?"*