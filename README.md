# Dining Philosophers Problem (Extended Version)

**COMP 346 – Operating Systems**  
Concordia University, Montreal, Canada

---

## 📌 Project Overview

This project implements an **extended version of the classic Dining Philosophers synchronization problem** using **monitor-based synchronization** in Java.

In addition to the traditional *thinking* and *eating* states, this implementation introduces a **talking state**, which adds extra synchronization constraints and increases the complexity of thread coordination.

The solution guarantees **correct synchronization**, **mutual exclusion**, and **fair access to shared resources**, while preventing **deadlock**, **starvation**, and **race conditions**.

---

## 🧠 Problem Description

Each philosopher is represented as a separate thread and can perform the following actions:

- **Think**
- **Eat**
- **Talk** (extended feature)

### Synchronization Constraints

- Only **one philosopher may talk at a time**
- A philosopher **cannot talk while eating**
- Talking is allowed only for a **limited duration**
- While one philosopher is talking:
  - Other philosophers **cannot sleep**
  - Other philosophers **may continue eating or thinking**
- The system must ensure:
  - No deadlock
  - No starvation
  - No race conditions

All constraints are enforced using a **Monitor synchronization construct** built on top of Java’s intrinsic concurrency primitives.

---

## 🛠️ Implementation Details

- Philosophers are implemented as **Java threads**
- A centralized **Monitor** manages shared state and synchronization
- Thread coordination is achieved using:
  - `synchronized` methods
  - `wait()` / `notifyAll()`
- The design ensures:
  - Mutual exclusion
  - Safe state transitions
  - Fair access to shared resources

---

## 📂 Project Structure
Dining-Philosopher-Problem/
│
├── README.md                # Project description and documentation
├── .gitignore               # Ignore compiled files and editor configs
│
├── src/
│   ├── common/              # Shared thread abstractions
│   │   └── BaseThread.java
│   │
│   ├── core/                # Core synchronization logic
│   │   ├── DiningPhilosophers.java
│   │   ├── Philosopher.java
│   │   └── Monitor.java
│   │
│   └── module-info.java     # Java module definition (if required)
│
├── tasks/
│   ├── task-1/
│   │   └── output.txt       # Sample output for Task 1
│   │
│   ├── task-2/
│   │   └── output.txt       # Sample output for Task 2
│   │
│   └── task-3/
│
├── Makefile                 # Build and run automation
│
└── docs/
    └── screenshots/         # Optional: outputs or diagrams


---

## ✅ What This README Does Well

✔ Clear explanation for **recruiters**  
✔ Shows **real OS & concurrency skills**  
✔ Matches **your actual code structure**  
✔ Ready for **CV & LinkedIn links**

---

If you want, next I can:
- 🔹 Add **badges** (Java, Threads, OS)
- 🔹 Write a **short README for recruiters**
- 🔹 Review your repo live
- 🔹 Polish your **CV project section**

Just tell me 👍

