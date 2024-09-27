# 1주차 과제 - 21기 코테 자바로 구현하기

- enum 클래스는 enums 디렉토리 안에 있습니다
- 출력 클래스는 output 디렉토리 안에 Printer 클래스로 구현하였습니다

---

### 챌린지 과제

✅ 클래스 5개 이상으로 구성되도록 클래스 나누기 

❌ 패키지 개수가 3개 이상으로 구성되도록 패키지 나누기 

✅ 모든 수치값들을 하나의 ENUM 클래스에 정의하여 사용하기 

✅ 모든 출력문들을 다른 클래스에 정의하여 사용하기

---

# 2주차 과제 - 댓글 및 대댓글 구현

`ERD` 

- 댓글과 대댓글 테이블을 분리해야 하나 고민을 했는데 여러 계층의 댓글을 생각하니 하나의 테이블에서 부모 댓글 아이디 필드를 추가하는 것이 더 좋을 것 같아서 하나의 테이블로 만들었습니다

  ![스크린샷 2024-09-19 111536](https://github.com/user-attachments/assets/0f37a0d8-8b03-407b-95dc-98330ab31ee1)

`Swagger` 

![swagger](https://github.com/user-attachments/assets/4732b388-f3e5-4069-aec3-4ef971b8d146)

`예외 처리`

- topic 단건 조회 시 id null 검증
    
    ![스크린샷 2024-09-19 104041](https://github.com/user-attachments/assets/fb2eea5d-6153-4a60-9d9f-6730806bc57b)
    
- comment 수정 시 id null 검증
    
    ![스크린샷 2024-09-19 104643](https://github.com/user-attachments/assets/d8d2348c-68d3-4c99-829c-fadcb249b62f)
    
    ![스크린샷 2024-09-19 104655](https://github.com/user-attachments/assets/782b5c12-9763-42f1-8985-9926ad2f34a5)
    
- comment 단건 조회 시 id null 검증
    
    ![스크린샷 2024-09-19 104718](https://github.com/user-attachments/assets/1e7f1f65-eb44-4e1a-8dd7-8e6734065c8c)
    
- comment 삭제 시 id null 검증
    
    ![스크린샷 2024-09-19 104736](https://github.com/user-attachments/assets/25179855-625d-45cb-845f-96fbd60575a6)
    
- 대댓글 조회 시 comment id null 검증
    
    ![스크린샷 2024-09-19 104758](https://github.com/user-attachments/assets/93d35ada-5ffd-4214-bf26-f851938ca3ab)
    
- comment 생성 시 부모 댓글의 id null  검증
    
    ![스크린샷 2024-09-19 105335](https://github.com/user-attachments/assets/4dcdf42f-10e4-4bb0-81b6-bc00a9934ab3)
    
    ![스크린샷 2024-09-19 105343](https://github.com/user-attachments/assets/591b6016-06c2-4d1d-b1a5-6aaf40bb5be2)
    

---

### 과제를 하며 생긴 궁금한 점

1. **예외 처리를 잘 한 것인가?**
    - 처음에는 **service** 계층에서 **throw** 하고 **controller**에서 예외들을 **catch** 해서 처리하는 코드를 작성했는데, 이때 생긴 고민
        - controller 코드가 길어지니 **가독성**이 떨어지는 느낌이라 controller는 최대한 깔끔하게 유지 하고 싶었다
        - 모든 controller에 비슷한 try, catch 를 사용하니 너무 비효율적인 느낌이 들었다
    - 그래서 exception 디렉토리에 **GlobalExceptionHandler** 클래스를 만들고 `@ExceptionHandler` 를 사용하여 발생한 예외를 처리했다
    - 나름 신경 썼지만 결론적으론 이러한 흐름의 예외 처리 방식이 좋은 방식인지에 대한 궁금증..
2. **mapper**
    - mapper를 사용해본 적이 없어서 그런지 mapper의 사용 이유가 궁금했다..
    - repository 계층에서 builder를 사용해서 저장하는 것에 익숙했는데 mapper를 사용하면 어떤 이점이 있을까?
    - 이유를 찾아보니 바로 납득했다
        - **명확한 역할 분리** → dto와 entity 간의 변환을 mapper가 해줘서 계층에서의 역할이 뚜렷해지고 가독성도 좋아진다
        - **중복 코드 감소**, **재사용성 증가** 등등..


# 3주차 과제 - 나만의 템플릿 코드 만들기, SQL

`나만의 컨벤션`

### 응답

- 프로젝트 구조

```java
├───board
│   ├───controller
│   ├───dto
│   │   └───request
│   ├───entity
│   ├───mapper
│   ├───repository
│   └───service
├───global
│   ├───config
│   ├───dto
│   │   └───response
│   │       └───result
│   ├───exception
│   ├───jwt
│   └───service
└───member
    ├───controller
    ├───dto
    │   ├───request
    │   └───response
    ├───entity
    ├───mapper
    ├───repository
    └───service

```

- 루트 디렉토리 아래에 필요한 도메인별로 디렉토리를 분리한다
    - 기존에는 루트 아래에 controller에 모든 controller를 몰아 넣었는데 정리할 필요성을 느끼다가 위 방식을 써보니 매우 좋습니다..
- 도메인 안에 있는 dto는 해당 도메인의 계층 간 데이터 이동할 때 사용
- global의 dto에서는 각 컨트롤러에서의 응답을 규격화하는 response와 result로 감싸서 반환하는 역할
    - result는 크게 Exception, 단일 값 결과, 리스트 값 결과로 나눠져 있다
    - response는 Error와 정상 응답에 대한 값을 감싸서 같은 형식으로 반환할 수 있게 한다
    
    > ❓response에서 **of()** 와 **ok()**가 나눠져 있는 이유를 모르겠습니다
    > 
    > - 찾아보니 of() 함수는 객체를 생성하는 역할을 하고
    > - ok()는 성공 응답을 반환할 때 사용한다고 이해했는데 맞을까요??
    
- 패키지는 도메인 중심으로 묶는다
    
    > 도메인이 많아질 경우 찾아보기 어렵기 때문에
    > 
- Controller 간소화한다
    
    > controller에서는 로직을 작성하지 않고 service 호출만 하여 간소화
    > 
    > 
    > controller가 하는 일을 쉽게 파악하기 위해서 
    > 
- 클래스와 메소드는 최대한 작게 작게 만든다
    
    > 책임을 나누고 공통되는 코드들은 메서드로 관리한다
    > 
- 가독성이 좋은 코드 작성한다
    
    > 과도하게 줄여서 작성하지 않는다
    > 
- 예외는 Custom Exception으로 자세하게 처리한다
    
    > ErrorResponse DTO를 통해 응답을 규격화한다
    > 
- Swagger와 주석을 잘 작성한다
    
    > 주석은 너무 세세하게 적기보단 설명이 필요한 곳에만 적는다
    > 
- 테스트 코드를 작성한다
    
    > 기능별로 작성한다
    > 
- url은 명사의 복수형으로
    
    ```java
    // 예시
    /api/members/{id}
    ```
    
    > ❓ 저는 명사의 복수형(members) 으로 사용하고 있는데 보통 단수형(member) 으로 사용하나요??
    > 

---

`sql lv3 이상 10문제 풀고 인증하기` 

![스크린샷 2024-09-27 134019](https://github.com/user-attachments/assets/c1923bed-f535-4d90-b405-e34c5d2e8bc6)
