# Upgrade To Java 21

> This is a tutorial course covering new features and upgrade to Java 21 LTS version.

![Java21Thumbnail](Java21Thumbnail.png)

Tools used:

- JDK 21
- Maven
- JUnit 5, Mockito
- IntelliJ IDE

Java 21 is released on **19-Sep-2023** as the next long-term support (**LTS**) release of Oracle's standard Java
implementation.

Java 21 has the following **15** features:

- String Templates (Preview) [JEP-430](https://openjdk.org/jeps/430)
- Sequenced Collections [JEP-431](https://openjdk.org/jeps/431)
- Generational ZGC [JEP-439](https://openjdk.org/jeps/439)
- Record Patterns [JEP-440](https://openjdk.org/jeps/440)
- Pattern Matching for switch [JEP-441](https://openjdk.org/jeps/441)
- Foreign Function & Memory API (Third Preview) [JEP-442](https://openjdk.org/jeps/442)
- Unnamed Patterns and Variables (Preview) [JEP-443](https://openjdk.org/jeps/443)
- Virtual Threads [JEP-444](https://openjdk.org/jeps/444)
- Unnamed Classes and Instance Main Methods (Preview) [JEP-445](https://openjdk.org/jeps/445)
- Scoped Values (Preview) [JEP-446](https://openjdk.org/jeps/446)
- Vector API (Sixth Incubator) [JEP-448](https://openjdk.org/jeps/448)
- Deprecate the Windows 32-bit x86 Port for Removal [JEP-449](https://openjdk.org/jeps/449)
- Prepare to Disallow the Dynamic Loading of Agents [JEP-451](https://openjdk.org/jeps/451)
- Key Encapsulation Mechanism API [JEP-452](https://openjdk.org/jeps/452)
- Structured Concurrency (Preview) [JEP-453](https://openjdk.org/jeps/453)

## Table of contents

1. [Java Installation and Project Setup](https://github.com/backstreetbrogrammer/38_UpgradeToJava21#chapter-01-java-installation-and-project-setup)
    - [Java 21 installation](https://github.com/backstreetbrogrammer/38_UpgradeToJava21#java-21-installation)
    - [Maven installation](https://github.com/backstreetbrogrammer/38_UpgradeToJava21#maven-installation)
    - [IntelliJ installation](https://github.com/backstreetbrogrammer/38_UpgradeToJava21#intellij-installation)
    - [Project Setup](https://github.com/backstreetbrogrammer/38_UpgradeToJava21#project-setup)
2. Project Loom
    - Virtual Threads
    - Scoped Values
    - Structured Concurrency
3. Project Amber
    - String Templates
    - Record Patterns
    - Pattern matching for switch
    - Unnamed Patterns and Variables
    - Unnamed Classes and Instance Main Methods
4. Project Panama
    - Foreign Function & Memory API
    - Vector API
5. Core Libraries
    - Sequenced Collections
6. Performance Updates
    - Generational ZGC
    - Key Encapsulation Mechanism API
7. Maintenance and Deprecation
    - Deprecate the Windows 32-bit x86 Port for Removal
    - Prepare to Disallow the Dynamic Loading of Agents

## Youtube

[Upgrade To Java 21 playlist](https://www.youtube.com/playlist?list=PLQDzPczdXrTjGmXvnHtnQ6S1i5pO0-NvK)

- [01 - Upgrade to Java 21 - Tutorial Series](https://youtu.be/5IPiXr95nrA)
- [02 - Upgrade to Java 21 - Table Of Contents](https://youtu.be/QmZ8Uy0uy7w)

---

## Chapter 01. Java Installation and Project Setup

### Java 21 installation

Search **Java 21 download** in [Google](https://www.google.com/) and navigate to Oracle
[Java Downloads](https://www.oracle.com/hk/java/technologies/downloads/) page.

Based on the OS, we can download installation file.

For **Windows**, download exe file:
[x64 Installer](https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe)

Double-click the installer exe file and follow the default instructions to install JDK 21.

Once complete, JDK 21 will be installed in `C:\Program Files\Java\jdk-21`.

Set `JAVA_HOME` system variable and also set it in `Path`.

![JAVA_HOME](JAVA_HOME.PNG)

![Path](Path.PNG)

Open `cmd` and verify Java version:

![JavaVersionCmd](JavaVersionCmd.PNG)

### Maven installation

Search **maven download** in [Google](https://www.google.com/) and navigate to
[Download Apache Maven](https://maven.apache.org/download.cgi) page.

Based on the OS, we can download installation file.

For **Windows**, download zip file:
[Binary zip archive](https://dlcdn.apache.org/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.zip)

Extract the folder in any local directory: `C:\Maven\apache-maven-3.9.4`.

Set `M2_HOME` and `MAVEN_HOME` system variables and also set it in `Path`.

![MAVEN_HOME](MAVEN_HOME.PNG)

![Path_Maven](Path_Maven.PNG)

Open `cmd` and verify Maven version:

![MavenVersionCmd](MavenVersionCmd.PNG)

### IntelliJ installation

Search **intellij download** in [Google](https://www.google.com/) and navigate to
[IntelliJ IDEA Download](https://www.jetbrains.com/idea/download/#section=windows) page.

Based on the OS, we can download IntelliJ **Community** Edition:

[Windows IntelliJ](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC)

Please note that latest IntelliJ IDEA **2023.2.2** version already supports JDK 21.

If IntelliJ was already installed before, we can just Update it to latest version from:

```
Help -> Check for Updates...
```

### Project Setup

Once the new project is created in IntelliJ using Java 21, **Open Module Settings** of the project and set as following:

![ProjectSettings](ProjectSettings.PNG)

![ProjectModules](ProjectModules.PNG)

![ProjectSDKs](ProjectSDKs.PNG)

We need to configure the **latest** versions of each maven [dependency](https://mvnrepository.com/) and maven
[plugins](https://maven.apache.org/plugins/) to ensure that its compatible with Java 21.

[JEP 11: Incubator Modules](https://openjdk.org/jeps/11)

**Summary**

Incubator modules are a means of putting **non-final** APIs and non-final tools in the hands of developers, while the
APIs/tools progress towards either finalization or removal in a future release.

**Goals**

Enable JDK Release Projects to distribute a limited set of APIs and tools that not final and complete, and which would
benefit from developer or user feedback. This will reduce the chance of costly mistakes in the Java SE Platform and the
JDK.

[JEP 12: Preview Features](https://openjdk.org/jeps/12)

**Summary**

A preview feature is a new feature of the Java language, Java Virtual Machine, or Java SE API that is fully specified,
fully implemented, and yet impermanent. It is available in a JDK feature release to provoke developer feedback based on
real world use; this may lead to it becoming permanent in a future Java SE Platform.

**Goals**

- Allow Java platform developers to communicate whether a new feature is "coming to Java" in approximately its current
  form within the next 12 months.
- Define a model for partitioning new language, VM, and API features based on whether they are permanent or
  impermanent in
  the Java SE Platform (that is, whether they will exist in the same form for all future releases, or will exist in a
  different form or not at all).
- Communicate the intent that code which uses preview features from an older release of the Java SE Platform will not
  necessarily compile or run on a newer release.
- Outline the relationship between preview features on the one hand, and "experimental" (HotSpot) / "incubating" (API)
  features on the other hand.

**Difference between Incubator Module and Preview Feature**

- Incubation applies to modules, and a preview feature is something that is more closely tight in with the language and
  the libraries. ~ **_Stuart Marks_**
- Preview features are really finished but are waiting for a round of feedback whereas the incubator mechanism has more
  room to iterate over the api several times to get feedback. ~ **_Brian Goetz_**

[JEP-451: Prepare to Disallow the Dynamic Loading of Agents](https://openjdk.org/jeps/451)

The procedure of loading a Java agent into an already running JVM is called **dynamic load**. The agent is attached
using the `Java Attach API`.

**Summary**

Issue warnings when agents are loaded dynamically into a running JVM. These warnings aim to prepare users for a future
release which **disallows** the **dynamic loading of agents** by default in order to improve integrity by default.
Serviceability tools that load agents at startup will not cause warnings to be issued in any release.

**Goals**

- Prepare for a future release of the JDK that will, by default, disallow the loading of agents into a running JVM.
- Reassess the balance between serviceability, which involves ad-hoc changes to running code, and integrity, which
  assumes that running code is not arbitrarily changed.
- Ensure that the majority of tools — which do not need to load agents dynamically — are unaffected.
- Align the ability to load agents dynamically with other so-called "superpower" capabilities, such as deep reflection.

Use the given [pom.xml](https://github.com/backstreetbrogrammer/38_UpgradeToJava21/blob/main/pom.xml) file as a template
for creating and building Java Maven project in IntelliJ.

From Maven gutter in the right pane of IntelliJ IDE -> click on `Lifecycle -> verify`

![MavenVerify](MavenVerify.PNG)

**Smoke Test to verify all the project setup is good**

```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.StringTemplate.STR;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTemplateTest {

    @Test
    @DisplayName("Test String Templates (Preview) [JEP-430]")
    void testStringTemplates() {
        final String java = "Java 21";
        final String comment = STR."\{java} is awesome";
        assertEquals("Java 21 is awesome", comment);
    }
}
```

Run the above unit test case from IntelliJ or alternatively from **Terminal**: `mvn clean test`

Successful run of the above unit test case will confirm the whole project setup is good.

### Youtube

- [03 - JDK 21, Maven, IntelliJ installation and project setup](https://youtu.be/nJ2mEUrYiS4)

---

