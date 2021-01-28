---
home: true
heroText: BullPlugin
tagline: Java plugin loading framework
actionText: Quick Start →
actionLink: /guide/
features:
- title: Very easy
  details: Just enter the path to load.
- title: Very small
  details: Less than 10KB.
- title: Very lightweight
  details: No other libraries.
footer: MIT Licensed | Copyright © 2020 Enaium
---

Add it in your root build.gradle at the end of repositories
```groovy
allprojects {
	repositories {
		maven { url 'https://maven.enaium.cn' }
	}
}
```
Add the dependency
```groovy
dependencies {
	implementation 'cn.enaium:bullplugin:LATEST'
}
```

LATEST=[![Maven URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fmaven.enaium.cn%2Fcn%2Fenaium%2Fbullplugin%2Fmaven-metadata.xml&style=flat-square)](https://cf4m.github.io/maven)