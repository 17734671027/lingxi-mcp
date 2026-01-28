#!/bin/bash

echo "=== 启动带SQL日志的应用程序 ==="

# 设置JVM参数以启用SQL日志
export JAVA_OPTS="-Dlogging.config=src/main/resources/logback-sql.xml \
                 -Dspring.profiles.active=sql \
                 -Dlogging.level.org.hibernate.SQL=DEBUG \
                 -Dlogging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE \
                 -Dlogging.level.org.springframework.jdbc.core.JdbcTemplate=DEBUG \
                 -Dlogging.level.com.jcloud.lingxi.repository=DEBUG"

# 设置系统属性
export SPRING_APPLICATION_JSON='{
    "logging": {
        "level": {
            "org.hibernate.SQL": "DEBUG",
            "org.hibernate.type.descriptor.sql.BasicBinder": "TRACE",
            "org.springframework.jdbc.core.JdbcTemplate": "DEBUG",
            "org.springframework.jdbc.core.StatementCreatorUtils": "TRACE",
            "com.mysql.cj.jdbc": "DEBUG",
            "com.jcloud.lingxi.repository": "DEBUG",
            "com.jcloud.lingxi.service": "DEBUG"
        }
    }
}'

echo "JVM参数: $JAVA_OPTS"
echo "启动应用程序..."

# 使用Maven启动Spring Boot应用
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.config.location=src/main/resources/application-sql.yml --logging.config=src/main/resources/logback-sql.xml"

# 或者使用Java直接启动（如果已经打包）
# java $JAVA_OPTS -jar target/lingxi-mcp-new-1.0.jar --spring.config.location=src/main/resources/application-sql.yml