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
