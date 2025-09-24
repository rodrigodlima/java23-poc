# JEP 447: Statements before super(...) (Preview)

## Summary

In constructors in the Java programming language, allow statements that do not reference the instance being created to appear before an explicit constructor invocation. This is a preview language feature.

## Goals
* Give developers greater freedom to express the behavior of constructors, enabling the more natural placement of logic that currently must be factored into auxiliary static methods, auxiliary intermediate constructors, or constructor arguments.

* Preserve the existing guarantee that constructors run in top-down order during class instantiation, ensuring that code in a subclass constructor cannot interfere with superclass instantiation.

* Do not require any changes to the Java Virtual Machine. This Java language feature relies only on the current ability of the JVM to verify and execute code that appears before explicit constructor invocations within constructors.