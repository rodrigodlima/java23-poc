# JEP 447: Statements before super(...) (Preview)

## Summary

In constructors in the Java programming language, allow statements that do not reference the instance being created to appear before an explicit constructor invocation. This is a preview language feature.

## Goals
* Give developers greater freedom to express the behavior of constructors, enabling the more natural placement of logic that currently must be factored into auxiliary static methods, auxiliary intermediate constructors, or constructor arguments.

* Preserve the existing guarantee that constructors run in top-down order during class instantiation, ensuring that code in a subclass constructor cannot interfere with superclass instantiation.

* Do not require any changes to the Java Virtual Machine. This Java language feature relies only on the current ability of the JVM to verify and execute code that appears before explicit constructor invocations within constructors.

## Tests

The JEP-447 feature is a preview feature, so, It's necessary to use 
--enable-preview parameter to enable flexible constructors.

For example, see the file Dockerfile-java23:

```
FROM openjdk:23-oraclelinux9
LABEL authors="Rodrigo de Lima Silva"

WORKDIR /app
COPY src/Main.java .

ENTRYPOINT ["java", "Main.java"]
```

Run Docker build:

```
docker build -t java-23 -f Dockerfile-java23 .
```

And run:

```
docker run java-23
```

So, probably you should see this error:

```
 -> docker run poc-java23                   
Main.java:10: error: flexible constructors is a preview feature and is disabled by default.
        super(name); // now it's permitted after an instruction
             ^
  (use --enable-preview to enable flexible constructors)
1 error
error: compilation failed
```

This happens because this feature is in preview. So, lets change the Dockerfile-java23:

```
FROM openjdk:23-oraclelinux9
LABEL authors="Rodrigo de Lima Silva"

WORKDIR /app
COPY src/Main.java .

ENTRYPOINT ["java", "--enable-preview", "Main.java"]
```

Run the build again with tag java23-preview and execute:

```
-> docker run poc-java23                                
Preparing...
Animal: Rex
```

Now, using the parameter "--enable-preview", this feature is ok.

If you try to execute the same code with java-21 for example, it'll fail. Let's try this?

Dockerfile-java21:

```
FROM openjdk:21
LABEL authors="Rodrigo de Lima Silva"

WORKDIR /app
COPY src/Main.java .

#ENTRYPOINT ["java", "--enable-preview", "--source", "Main.java"]
ENTRYPOINT ["java", "Main.java"]
```

```
docker build -t java21 -f Dockerfile-21 .
```

And run:

```
docker run java21
Main.java:10: error: call to super must be first statement in constructor
        super(name); // now it's permitted after an instruction
             ^
1 error
error: compilation failed
```


