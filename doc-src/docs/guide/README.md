---
sidebar: auto
---

# Guide

## Install

### Maven

```xml
<repositories>
    <repository>
        <name>Enaium</name>
        <id>Enaium</id>
        <url>https://enaium.gitee.io/maven/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>cn.enaium</groupId>
        <artifactId>bullplugin</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

### Gradle

```groovy
dependencies {
    compile group: 'cn.enaium', name: 'bullplugin', version: '1.0.0'
}

repositories {
	maven {url 'https://enaium.gitee.io/maven/'}
}
```

### Libraries

[releases](https://github.com/Enaium/BullPlugin/releases)

## Usage

### Load plugin

Define a `PluginInitializer` interface.

```java
public interface PluginInitializer {
    default void onInitializer() {};
}
```

Then load this plugin.

```java
public static void main(String[] args) throws Exception {
    BullPlugin bullPlugin = new BullPlugin(new File("plugins"));
    ArrayList<PluginInitializer> plugins = new ArrayList<PluginInitializer>();

    for (Object c : bullPlugin.getPlugins()) {
        plugins.add((PluginInitializer) c);
    }

    for (PluginInitializer p : plugins) {
            p.onInitializer();
    }
}
```

### Make plugin

Create a new class.

Add the annotation `@Plugin`.

```java
@Plugin
public class Example implements PluginInitializer {
    @Override
    public void onInitializer() {
        System.out.println("Already loaded!");
    }
}
```


