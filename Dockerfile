# Imagen base con OpenJDK 17
FROM eclipse-temurin:17-jre-alpine

# Configuración de directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR generado al contenedor
COPY target/lectorqr-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto usado por la aplicación
EXPOSE 8080

# Configurar variables de entorno (opcional)
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/productos
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=1234

# Ejecutar el archivo JAR
ENTRYPOINT ["java", "-jar", "app.jar"]