# Maven Uber Relocation Example

This project demonstrates how to use the Maven Shade Plugin to create an uber (shaded) JAR with and without package relocation, and with options to include or exclude the `pom.xml` file.

## How to Build the Uber (Shaded) JAR

### Default (Uber JAR, includes pom.xml, no relocation)
Builds an uber JAR with all dependencies included, no package relocation, and includes the `pom.xml`:

```sh
mvn clean package
```
The output JAR will be in `target/my-app-with-shaded-commons-1.0-SNAPSHOT.jar`.

### Exclude pom.xml from Uber JAR
To build an uber JAR without including the `pom.xml`:

```sh
mvn clean package -Pno-pom
```

### Uber JAR with Relocation
To build an uber JAR with package relocation (shading `org.apache.commons.collections` to `com.mycompany.app.shaded.collections`):

```sh
mvn clean package -Preloc
```

### Uber JAR with Relocation and Exclude pom.xml
To build an uber JAR with relocation and without the `pom.xml`:

```sh
mvn clean package -Preloc-no-pom
```

## Project Structure
- `src/main/java/com/mycompany/app/MyApp.java`: Main application class.
- `pom.xml`: Maven build configuration with multiple profiles for different shading/relocation scenarios.

## Requirements
- Java 8+
- Maven 3.5+

---

Feel free to modify the profiles in `pom.xml` to suit your needs.
