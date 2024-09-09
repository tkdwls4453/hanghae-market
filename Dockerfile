# 빌드를 위한 이미지
FROM gradle:7.6-jdk17 AS build

# 작업 디렉토리 설정
WORKDIR /home/gradle/project

# 소스 코드 복사
COPY --chown=gradle:gradle . .

# Gradle 빌드 실행
RUN gradle build --no-daemon

# 애플리케이션 실행을 위한 이미지
FROM openjdk:17-jdk

# 빌드된 JAR 파일 복사
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

# 컨테이너에서 실행될 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]
