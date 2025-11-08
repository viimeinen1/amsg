# aMsg

Small messaging library to send messages with prefixes for players.

## Add as dependency

To use the library in your project, add it as a dependency

Gradle:
```java
repositories {
    mavenCentral()
    maven { url = uri("https://www.jitpackio") }
}

dependencies {
    implementation("com.github.viimeinen1:amsg:1.0.0")
}
```

## Usage

```java
// set prefix for all messages
aMsg.prefix(MiniMessage.minimessage().deserialize("<gold>[prefix] "))

// or use aMsg.mm() {= MiniMessage.minimessage().deserialize()}

// send messages
aMsg.send(player, "<green>Hello, world!") // -> [prefix] Hello, world!
aMsg.send(player, "Multiline", "message")
/*
    -> [prefix] Multiline
    -> [prefix] message
*/

// supports other prefixes and components as well
aMsg.send(aMsg.mm("<red>[another prefix] "), player, Component.text("hello"), "<red>hi!");
/*
    -> [another prefix] hello
    -> [another prefix] hi!
*/
```