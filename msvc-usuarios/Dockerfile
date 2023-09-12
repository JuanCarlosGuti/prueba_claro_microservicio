# Etapa de compilación (build stage)
FROM openjdk:17-jdk-alpine as builder

ARG MSVC_NAME=msvc-usuarios
WORKDIR /app

# Copiar solo el archivo pom.xml primero para aprovechar el caché de Docker
COPY ./pom.xml .

# Copiar el archivo mvnw y los archivos de configuración de Maven
COPY ./mvnw .
COPY ./.mvn ./.mvn

# Cambiar permisos para que mvnw sea ejecutable
RUN chmod +x mvnw

# Descargar dependencias de Maven (si cambió el archivo pom.xml)
RUN ./mvnw dependency:go-offline -B

# Copiar todo el código fuente y compilar la aplicación
COPY . .
RUN ./mvnw package -DskipTests

# Etapa de empaquetado final
FROM openjdk:17-jdk-alpine

ARG MSVC_NAME=msvc-usuarios
WORKDIR /app

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=builder /app/target/${MSVC_NAME}-0.0.1-SNAPSHOT.jar ./app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]



# Comando para iniciar la aplicación Spring Boot
#CMD ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]

