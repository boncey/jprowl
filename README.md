JProwl is a Java interface for working with [Prowl](http://www.prowlapp.com).

- It can be used with Spring or without
- XML marshalling is done with JAXB (JSE)
- Logging is done with SLF4J
- The [Prowl API](http://www.prowlapp.com/api.php) is incomplete, but can easily be extended (see `org.antbear.prowl.SimpleProwlClient`)

# Usage

## General
Depending on the inteded use, either via spring or not, the JProwl package needs to be configured (see below).

Posting a message to Prowl is a simple:

```java

        final ProwlNotification notification = new ProwlNotification();
        notification.setApiKey("your-api-key");
        notification.setPriority(ProwlPriority.NORMAL);
        notification.setApplicationName("name-of-your-application");
        notification.setSubject("your subject);
        notification.setDescription("your message description, long text");

        final ProwlResponse response = prowlClient.postNotification(notification);
```

The variable `prowlClient` is of type `org.antbear.jprowl.SimpleProwlClient`. It can be obtained manually or via Spring DI (see below).

## With Springframework
In your spring context configuration, add:

```xml
    <context:component-scan base-package="org.antbear.jprowl,com.yourcompoany.yourpackage"/>
    <context:annotation-config/>
```

Define a bean of type `org.antbear.jprowl.SpringProwlContext` and feed it with the API URL of Prowl:

```xml
    <bean id="ProwlContext" class="org.antbear.jprowl.SpringProwlContext">
        <property name="serviceURL" value="https://api.prowlapp.com/publicapi/"/>
    </bean>
```

Define a bean of type `org.antbear.jprowl.RawProwlClient` and feed it the define `ProwlContext` defined in the previous step:

```xml
    <bean class="org.antbear.jprowl.RawProwlClient">
        <property name="context" ref="ProwlContext"/>
    </bean>
``

In your class, add a setter to consume the now configured `ProwlClient`:

```java

    @Autowired
    public void setProwlClient(@NotNull final SimpleProwlClient prowlClient) {
        this.prowlClient = prowlClient;
    }
```

## Without Springframework

```java
DefaultProwlContext context = new DefaultProwlContext();
RawProwlClient client = new RawProwlClient();
client.setContext(context);

// setup ProwlNotification object and post
final ProwlResponse response = client.postNotification(notification);
```

The default prowl context loads its service URL from a properties file in the classpath (provided).

You can either work with the `RawProwlClient` class, or with more comfortable `SimpleProwlClient` class which provides
default error checking. In the case of errors or failures it throws an `ProwlException`.

```java
SimpleProwlClient simpleClient = new SimpleProwlClient();
simpleClient.setClient(client);

// setup ProwlNotification object and post
final ProwlResponse response = simpleClient.postNotification(notification);
``