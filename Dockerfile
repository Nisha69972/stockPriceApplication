FROM openjdk:11
ADD target/StockPricesApp-0.0.1-SNAPSHOT.jar StockPricesApp.jar
ENTRYPOINT ["java", "-jar", "StockPricesApp.jar"]
EXPOSE 7777
ENV spring.datasource.url=jdbc:mysql://host.docker.internal:3306/stocks_prices_db