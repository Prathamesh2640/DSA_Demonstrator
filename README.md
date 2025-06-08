# 📱 DSA Demonstrator App

A sleek and interactive Android application built with **Java** and **Android Studio** to showcase the power of core data structures through hands-on visualization and operations. Perfect for students, educators, and developers learning or teaching Data Structures and Algorithms (DSA)!

![Platform](https://img.shields.io/badge/Platform-Android-green) ![Language](https://img.shields.io/badge/Language-Java-blue) ![Min SDK](https://img.shields.io/badge/Min%20SDK-30-orange) ![License](https://img.shields.io/badge/License-MIT-yellow)

---

## 🌟 Features

- 🧩 **Modular Design**: Each data structure is encapsulated in its own Activity for clarity and scalable architecture.
- 🖱️ **Interactive UI**: Intuitive buttons for operations like insertion, deletion, and display, powered by `RecyclerView` for dynamic output.
- 🎨 **Visual Feedback**: Smooth fade animations for data updates, enhancing user experience.
- 🔒 **Robust Implementation**: Custom-built data structures with edge case handling (overflow, underflow, null checks).
- 🛠️ **Unified Interface**: Leverages `StructureInterface` for consistent operations (`insert`, `delete`, `display`).
- 📱 **Modern Android**: Supports Android 11+ (API 30) with Java 30, optimized for modern devices.
- ✅ **Clean Code**: Well-documented, beginner-friendly, and maintainable codebase.

---

## 📚 Data Structures Included

Explore these fundamental data structures with real-world use cases:

1. **ArrayList** 🌐
   - **Use Case**: Dynamic arrays for flexible data storage, e.g., task lists in apps.
   - \*\*Operations: Add, remove elements.
2. **LinkedList** 🔗
   - **Use Case**: Efficient insertion/deletion, e.g., browser history navigation.
   - **Operations**: Insert, delete, display.
3. **Stack** 📚
   - **Use Case**: LIFO operations, e.g., undo functionality in editors.
   - **Operations**: Push, pop, display.
4. **Deque** 🔄
   - **Use Case**: Double-ended queue for palindromic checks or caching.
   - **Operations**: Add rear/front, remove rear/front, palindrome check.
5. **Binary Search Tree (BST)** 🌳
   - **Use Case**: Sorted data storage, e.g., database indexing.
   - **Operations**: Insert, delete, inorder traversal.

---

## 🏗️ Architecture

The app follows a **Separation of Concerns** to ensure clarity and scalability:

- **UI Layer**: `activity_data_structure.xml` with `RecyclerView` for output, `EditText` for input, and Material Design buttons.
- **Logic Layer**: Custom data structure implementations in `com.projects.data`, adhering to `StructureInterface`.
- **Visualization Layer**: `DataStructureAdapter` for `RecyclerView` and `AnimationUtils` for fade effects.
- **Utility Layer**: `InputValidator` for input validation and `AnimationUtils` for UI enhancements.

**Package Structure**:

```
com.projects
├── data
│   ├── ArrayListDS.java
│   ├── LinkedListDS.java
│   ├── StackDS.java
│   ├── DequeDS.java
│   ├── BSTDS.java
│   ├── StructureInterface.java
├── ui
│   ├── MainActivity.java
│   ├── ArrayListActivity.java
│   ├── LinkedListActivity.java
│   ├── StackActivity.java
│   ├── DequeActivity.java
│   ├── BSTActivity.java
│   ├── DataStructureAdapter.java
├── util
│   ├── AnimationUtils.java
│   ├── InputValidator.java
```

---

## 🔧 Technical Details

- **Language**: Java 11
- **Min SDK**: API 30 (Android 11)
- **Target SDK**: API 35
- **Dependencies**:
  - `androidx.appcompat:1.6.1`
  - `com.google.android.material:1.12.0`
  - `androidx.recyclerview:1.3.2`
  - `androidx.core:1.13.1`
  - Testing: JUnit, Espresso
- **Edge Cases Handled**:
  - Overflow (max size: 10 elements)
  - Underflow (empty structure checks)
  - Invalid inputs (non-numeric)
- **Animations**: Fade transitions for `RecyclerView` updates
- **Build System**: Gradle with Kotlin DSL (`build.gradle.kts`)

---

## 🎮 How to Use

1. **Launch the App**: Start from `MainActivity`, which lists all data structures.
2. **Select a Data Structure**: Tap a button to navigate to its Activity (e.g., Stack).
3. **Interact**:
   - Enter a number in the `EditText`.
   - Use buttons (`Add`, `Remove`, `Push`, `Pop`, etc.) to perform operations.
   - Watch the `RecyclerView` update with animations.
4. **Test Edge Cases**:
   - Try adding beyond 10 elements (overflow).
   - Remove from an empty structure (underflow).
   - Enter non-numeric input to see error handling.
