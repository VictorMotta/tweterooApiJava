FROM openjdk:17-jdk-alpine

EXPOSE 8080

ARG MAVEN_VERSION=3.9.5


# Instala o curl e o Apache Maven
RUN apk add --no-cache curl && \
    mkdir -p /usr/share/maven && \
    curl -fsSL http://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar -xzC /usr/share/maven --strip-components=1 && \
    ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# Cria a pasta principal
RUN mkdir /usr/app

# vai até a pasta principal
WORKDIR /usr/app

# Copia todos os arquivos da pasta do pc para pasta atual do container
COPY . .

# Execute o comando 'mvn clean package' para compilar o aplicativo
RUN mvn clean package -DskipTests

#copia o arquivo .jar para pasta atual
RUN cp target/tweteroo*.jar ./api.jar


# inicia o arquivo .jar (a api)
CMD [ "java", "-jar", "api.jar"]