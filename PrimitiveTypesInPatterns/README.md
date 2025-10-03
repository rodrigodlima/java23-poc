# JEP 455: Primitive Types in Patterns, instanceof, and switch (Preview)

## Summary

Enhance pattern matching by allowing primitive type patterns in all pattern contexts, and extend instanceof and switch to work with all primitive types. This is a preview language feature.

## Goals
* Enable uniform data exploration by allowing type patterns for all types, whether primitive or reference.

* Align type patterns with instanceof, and align instanceof with safe casting.

A* llow pattern matching to use primitive type patterns in both nested and top-level contexts.

* Provide easy-to-use constructs that eliminate the risk of losing information due to unsafe casts.

F* ollowing the enhancements to switch in Java 5 (enum switch) and Java 7 (string switch), allow switch to process values of any primitive type.
## Tests

The JEP-455 feature is a preview feature, so, It's necessary to use 
--enable-preview parameter in java command to enable flexible constructors.

For example, see the file Dockerfile:

```
FROM openjdk:23
LABEL authors="Rodrigo de Lima Silva"

WORKDIR /app
COPY src/Main.java .

ENTRYPOINT ["java", "Main.java"]
```

Run Docker build:

```
docker build -t poc-java23 .
```

And run:

```
docker run poc-java23
```

So, probably you should see this error:

```
 -> docker run --rm poc-java23  
Main.java:6: error: primitive patterns are a preview feature and are disabled by default.
            case int i -> System.out.println("It`s an int: " + i);
                 ^
  (use --enable-preview to enable primitive patterns)
1 error
error: compilation failed
```

This happens because this feature is in preview. So, lets change the Dockerfile now:

```
FROM openjdk:23-oraclelinux9
LABEL authors="Rodrigo de Lima Silva"

WORKDIR /app
COPY src/Main.java .

ENTRYPOINT ["java", "--enable-preview", "Main.java"]
```

Run the build again with tag poc-java23-preview and execute:

```
-> docker run --rm poc-java23-preview  
It`s an int: 42
```

Now, using the parameter "--enable-preview", this feature is ok.

If you try to execute the same code with java-21 for example, it'll fail.

# Conclusion

The StatementBeforeSuper is a great feature to avoid to create new auxiliary methods.

For exemple, if you want to test or verify any data, variable, etc.. before the super(),
on Java 21 for example, it's not possible, so you need to create an auxiliary method.

Let's show the difference between Java21 and Java23:

### Java 23

```
class Animal {
    Animal(String name) {
        System.out.println("Animal criado: " + name);
    }
}

class Dog extends Animal {
    Dog(String name) {
        if (name == null || name.isBlank()) {
            name = "Desconhecido"; 
        }
        super(name); 
    }
}

```
So, in this case, was created a conditional if to validate the name. This can't be done by Java 21

### How the same code works on Java 21

```
class Animal {
    Animal(String name) {
        System.out.println("Animal criado: " + name);
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(validateName(name)); 
    }

    private static String validateName(String name) {
        if (name == null || name.isBlank()) {
            return "Desconhecido";
        }
        return name;
    }
}
```





