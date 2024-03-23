## 1번문제

### Skills

- Java 21
- Spring Boot 3.2.3
- MySQL
- Flyway

### Naming

- 카테고리 : Category
- 카테고리 간 관계 데이터 : CategoryRelationship
- 게시판 : Board

### Features

- 카테고리
  - 카테고리 생성
  - 카테고리 전체 조회
    - 이름 검색
    - 전체 조회
  - 카테고리 아이디 조회
  - 카테고리 삭제

- 게시판
  - 게시판 생성
  - 게시판 전체 조회
    - 카테고리 이름 검색
    - 전체 조회
  - 게시판 아이디 조회
  - 게시판 삭제

### 애플리케이션 실행 절차

#### 환경 세팅

- Mysql
  - scheme 생성
    - board
  - url
    - localhost:3306
  - username
    - root
  - password
    - 1234

#### Local Database setup with Docker

```$ docker pull mysql```

```$ docker run --name hanteo-mysql -e MYSQL_ROOT_PASSWORD=1234 -d -p 3306:3306 mysql:latest```

```$ docker exec -it hanteo-mysql bash```

```# mysql -u root -p```

```비밀번호 입력```

```mysql> CREATE SCHEMA board```

#### Application 실행 순서

1. git clone
2. BootRun

### Swagger

- localhost:8080/swagger-ui/index.html 접속 후 사용

### 구현 및 추가 설명

- 편의를 위해 create table sql을 작성하여 코드 내 flyway로 생성될 수 있도록 하였습니다.
- 편한 환경 설정을 위해 database username, password는 간단하게 정하였습니다.
- 추가적으로 application yml도 환경변수 사용을 안하는 등 바로 실행할 수 있도록 구성하였습니다.

## 2번 문제

언어는 ```java```를 사용하였으며

```dynamic programming```을 활용하여 문제를 풀어보았습니다.
