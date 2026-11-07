
# ==========================================
# ETAPA 1: COMPILACIÓN MAVEN + JAVA 21
# ==========================================
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar configuración Maven
COPY pom.xml .

# Copiar código fuente
COPY src ./src

# Compilar aplicación Spring Boot
RUN mvn -B clean package -DskipTests


# ==========================================
# ETAPA 2: EJECUCIÓN JAVA 21
# ==========================================
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar JAR generado
COPY --from=build /app/target/*.jar app.jar

# Puerto de Render
ENV PORT=10000

EXPOSE 10000

# Arrancar Spring Boot
ENTRYPOINT ["sh", "-c", "exec java -Dserver.port=${PORT:-10000} -jar app.jar"]
