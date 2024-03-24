# Usa una imagen base que incluya Java 17
FROM openjdk:17

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR de tu aplicación Java al contenedor
COPY target/api-seguros-jmg.jar app.jar

EXPOSE 8020

# Comando para ejecutar tu aplicación Java
CMD ["java", "-jar", "app.jar"]
