# Java 23 JEP 476

The new module import declarations in JDK 23 simplify module management by allowing modules to declare dependencies more flexibly. This feature is particularly useful for large projects, enabling finer control over module dependencies and improving the modularization of Java applications. By allowing the imports statement in module declarations, developers can manage dependencies in a more organized way.

Ref: https://www.geeksforgeeks.org/java/jdk-23-new-features-of-java-23/


# Diferences between Java 23 and old versions

In the src dir, we have 3 files:

- Example.java
- ExampleJava21.java

Lets check the difference beetween them:

```
✗ diff Example.java ExampleJava21.java 
1c1,4
< import module java.base;
---
> import java.util.List;
> import java.util.Map;
> import java.util.stream.Collectors;
> import java.util.stream.Stream;
```

How you can see, on the ExampleJava21.java file, there are many lines of imports, and on Example.java, only 1 (java.base)

