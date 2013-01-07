JProwl is a Java interface for working with [Prowl](http://www.prowlapp.com).

- It can be used with Spring or without
- XML marshalling is done with JAXB (JSE)
- Logging is done with SLF4J
- The [Prowl API](http://www.prowlapp.com/api.php) is incomplete, but can easily be extended (see `org.antbear.prowl.SimpleProwlClient`)

# Usage

## Requirements
jprowl uses slf4j without specifying a logging backend. You need to choose a backend like {logback, log4j}.

## General
Depending on the inteded use, either via spring or not, the JProwl package needs to be configured (see below).

Posting a message to Prowl is a simple:

```java
final ProwlNotification notification = new ProwlNotification();
notification.setApiKey("your-api-key");
notification.setPriority(ProwlPriority.NORMAL);
notification.setApplicationName("name-of-your-application");
notification.setSubject("your subject");
notification.setDescription("your message description, long text");

final ProwlResponse response = prowlClient.postNotification(notification);
```

The variable `prowlClient` is of type `org.antbear.jprowl.SimpleProwlClient`. It can be obtained manually or via Spring DI (see below).

## With Springframework
In your spring context configuration, add:

```xml
<bean id="prowlContext" class="org.antbear.jprowl.DefaultProwlContext"/>
<bean id="rawProwlClient" class="org.antbear.jprowl.RawProwlClient"
    p:context-ref="prowlContext"/>
<bean id="prowlClient" class="org.antbear.jprowl.SimpleProwlClient"
    p:client-ref="rawProwlClient"/>
```

In your class, add a setter to consume the now configured `SimpleProwlClient`:

```java
@Autowired
public void setProwlClient(@NotNull final SimpleProwlClient prowlClient) {
	this.prowlClient = prowlClient;
}
```

## Without Springframework
Without spring, the wiring of the dependencies must be done manually. But it's trivial:

```java
final ProwlContext context = new DefaultProwlContext();
final ProwlClient client = new SimpleProwlClient(new RawProwlClient(context));

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
```

EOF
