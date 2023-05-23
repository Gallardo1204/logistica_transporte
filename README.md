
## Instalación

Clonar repositorio

```bash
  git clone https://github.com/Gallardo1204/logistica_transporte_backend.git
```

Generar .jar con maven desde la consola de comandos cmd ubicado en la raíz del proyecto

```bash
  mvn package
```

Ejecutar aplicación en modo local (Conectando a base de datos local)

```bash
  java -jar target/transporte-0.0.1-SNAPSHOT.jar --spring.profiles.active=local
```

## Swagger

http://localhost:8001/swagger-ui/index.html

## Tech Stack

Java 1.8, Maven, Spring Boot 2, Spring Data, Jwt, Mysql, Swagger, Lombok
