---
sidebar: auto
---

# Guide

## Install

### Maven

[![](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fmaven.enaium.cn%2Fcn%2Fenaium%2Fbullplugin%2Fmaven-metadata.xml&style=flat-square)]()

### JitPick

[![](https://img.shields.io/jitpack/v/github/Enaium/BullPlugin?style=flat-square)](https://jitpack.io/#Enaium/BullPlugin)

### Libraries

[![](https://img.shields.io/github/v/release/enaium/bullplugin?style=flat-square)](https://github.com/Enaium/BullPlugin/releases)

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


