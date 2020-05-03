package cn.enaium.bullplugin;

import cn.enaium.bullplugin.annotations.Plugin;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Project: BullPlugin
 * -----------------------------------------------------------
 * Copyright © 2020 | Enaium | All rights reserved.
 */
public class BullPlugin {

    private File pluginPath;

    public BullPlugin(File pluginPath) {
        this.pluginPath = pluginPath;
    }

    public ArrayList<Object> getPlugins() throws Exception {

        if (!pluginPath.exists()) throw new IOException("pathDoesNotExist");

        if (!pluginPath.isDirectory()) throw new IOException("thePathIsNotADirectory");

        ArrayList<File> files = new ArrayList<File>();
        ArrayList<Object> plugins = new ArrayList<Object>();

        for (File file : pluginPath.listFiles()) {
            if (file.getName().endsWith(".jar")) {
                files.add(file);
            }
        }

        for (File f : files) {
            JarFile jar = new JarFile(f);
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.isDirectory() || !entry.getName().endsWith(".class")) {
                    continue;
                }
                String className = entry.getName().substring(0, entry.getName().length() - 6);
                className = className.replace('/', '.');
                Class<?> clazz = new URLClassLoader(new URL[]{f.toURL()}, Thread.currentThread().getContextClassLoader()).loadClass(className);
                if (clazz.getAnnotation(Plugin.class) != null) {
                    plugins.add(clazz.newInstance());
                }
            }
        }
        return plugins;
    }


}
