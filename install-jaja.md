# Install jaja

## 1 : Import from SOAT

**NEED JDK VERSION < 8**

1. Run `Main`
2. Go in your JDK in `bin/` directory
3. Tape `.\wsimport.exe -clientjar ../jaja.jar http://localhost:8081/ws/roomService?wsdl`
4. Get `jaja.jar` in your JDK home

## 2 : Install in maven
`mvn install:install-file -Dfile=rest-api/lib/jaja.jar -DgroupId=fr.mines.ales -DartifactId=jaja -Dversion=1.0-SNAPSHOT -Dpackaging=jar `

---

### *Import in maven (already do in this project)*

```
    <dependency>
            <groupId>fr.mines.ales</groupId>
            <artifactId>jaja</artifactId>
            <version>1.0-SNAPSHOT</version>
    </dependency>
```