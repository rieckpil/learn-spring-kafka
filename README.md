# learn-spring-kafka

Part of the Udemy course for learning Kafka with Spring

### Using multiple spring application properties via a properties.yml

```yaml
spring:
  profiles:
    active: stage

---

spring:
  profiles: dev

  message.response:   Hello from DEV spring boot properties

  kafka.broker: localhost:9092,localhost:9093,localhost:9094
  enable.auto.commit: true
  auto.commit.interval.ms:  100
  group.id: group1
  kafka.auto.offset.reset: earliest
  kafka.topic: my-topic

---

spring:
  profiles: stage

  message.response:   Hello from STAGE spring boot properties

---

spring:
  profiles: prod

  message.response:   Hello from PROD spring boot properties

---
```

Environment variable can be set through this .yml file or during start up of the app:
```bash
java -jar -Dspring.profiles.active=dev mySpringApplication.jar
```

These value can be accessed through a environment bean 
```java
@Autowired
private Environment env;

public static void main(String[] args){
  env.getProperty(value);
}
```
