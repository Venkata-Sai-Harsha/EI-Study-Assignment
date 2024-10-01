## Design Patterns

### Behavioural design pattern

1. Observer Pattern:
  - Purpose: Defines a one-to-many dependency between objects, allowing multiple observers to receive updates from a subject (or observable) when its state changes.
  - Usage: Commonly used in event handling systems, such as GUI applications or stock price monitoring systems, where multiple components need to respond to changes in data.
  - Flexibility: Promotes loose coupling between the subject and observers, making it easy to add or remove observers without modifying the subject's code.

2. Strategy Pattern:
  - Purpose: Defines a family of algorithms, encapsulates each one, and makes them interchangeable, allowing the algorithm to vary independently from clients that use it.
  - Usage: Useful in scenarios where different behaviors or strategies can be applied, such as sorting algorithms, payment methods in an e-commerce application, or routing strategies in network systems.
  - Extensibility: Makes it easy to introduce new strategies without altering the context or existing strategies, promoting the Open/Closed Principle.

______________________________________________________
### 2. Creational design pattern

3. Factory Pattern:
  - Purpose: Provides an interface for creating objects, allowing subclasses to alter the type of objects that will be created without exposing the instantiation logic to the client.
  - Usage: Commonly used in scenarios where the exact type of object is determined at runtime, such as in UI frameworks or when creating different types of products in a manufacturing system.
  - Decoupling: Promotes decoupling of code by hiding the details of object creation, enabling easier maintenance and scalability

4. Singleton Pattern:
  - Purpose: Ensures a class has only one instance and provides a global point of access to that instance, preventing multiple instantiations.
  - Usage: Ideal for resource management classes, such as logging, configuration settings, or connection pools, where a single instance is needed throughout the application.
  - Lazy Initialization: Allows for lazy initialization of the instance, which can help manage resource consumption and improve performance.



______________________________________________________
### 3. Structural design pattern

5. Adapter Pattern:
  - Purpose: Allows incompatible interfaces to work together by acting as a bridge between two incompatible types.
  - Usage: Useful in scenarios where an existing class cannot be modified but needs to integrate with another class, such as when incorporating third-party libraries or legacy code.
  - Flexibility: Provides a way to create reusable components that can adapt to varying interfaces, enhancing code flexibility.

6. Decorator Pattern:
  - Purpose: Allows behavior or properties to be added to individual objects dynamically without affecting other objects of the same class.
  - Usage: Commonly used to extend functionalities of classes in a flexible way, such as adding features to UI components or enhancing the capabilities of simple objects (like adding toppings to a basic coffee).
  - Open/Closed Principle: Supports the Open/Closed Principle by allowing new functionality to be added without modifying existing code.
