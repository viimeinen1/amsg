# aMsg

Small messaging library to send messages with prefixes for players.

## Add as dependency

To use the library in your project, add it as a dependency

build.gradle.kts:
```java
dependencies {
    implementation("io.github.viimeinen1:amsg:1.0.1")
}
```

## Usage

```java
/* Default usage */

// set prefix for all messages globally
aMsg.prefix(MiniMessage.minimessage().deserialize("<gold>[prefix] "))

// or use aMsg.mm() {= MiniMessage.minimessage().deserialize()} for deserializing

// send messages
aMsg.send(player, "<green>Hello, world!") // -> [prefix] Hello, world!
aMsg.send(player, "Multiline", "message")
/*
    -> [prefix] Multiline
    -> [prefix] message
*/

// send single message with different prefix
aMsg.send(aMsg.mm("<red>[another prefix] "), player, Component.text("hello"), "<red>hi!");
/*
    -> [another prefix] hello
    -> [another prefix] hi!
*/
```

```java
/* Multiple prefixes */

// if you require multiple prefixes for different functions, use aMsg.Msg instead of aMsg
Msg defaultMsg = new Msg(aMsg.mm("<green>[default] "));
Msg adminMsg = new Msg(aMsg.mm("<gold>[admin] "));

defaultMsg.send(player, "Hello admins") // -> [default] Hello admins
adminMsg.send(player, "Hello defaults") // -> [admin] Hello defaults
```