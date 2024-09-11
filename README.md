# 스프링부트 테스트
<br>
 
## 1차 요구사항 구현
- [✅] 유저가 루트 url로 접속시에 게시글 리스트 페이지(http://주소:포트/article/list)가 나온다.
- [✅] 리스트 페이지에서는 등록 버튼이 있고 버튼을 누르면 http://주소:포트/article/create 경로로 이동하고 등록 폼이 나온다.
- [✅] 게시글 등록을 하면 http://주소:포트/article/create로 POST 요청을 보내어 DB에 해당 내용을 저장한다.
- [✅] 게시글 등록이 되면 해당 게시글 리스트 페이지로 리다이렉트 된다. 페이지 URL 은 http://주소:포트/article/list 이다.
- [✅] 리스트 페이지에서 해당 게시글을 클릭하면 상세페이지로 이동한다. 해당 경로는 http://주소:포트/article/detail/{id} 가 된다.
- [✅] 게시글 상세 페이지에는 id에 맞는 게시글 데이터와 목록 버튼이 있다. 목록 버튼을 누르면 게시글 리스트 페이지로 이동하게 된다.

- (추가 기능이나 구현기능설명이 필요한 경우 서술)
  - 글 등록 시 검증기능 추가
<br>
 
## 미비사항 or 막힌 부분
- html 소스코드 부분. css 클래스를 아직 숙지하지 못해서 복사붙여넣기를 할 수 밖에없었다. 
<br>
 
## UI/UX
- 게시글 리스트 페이지
![image](https://github.com/user-attachments/assets/a9331fed-8e28-4426-9d22-d83d51b46390)
- 게시글 등록 폼 페이지
![image](https://github.com/user-attachments/assets/f424c1e7-e315-4e27-ae2a-127d57f809a0)
- 게시글 상세 페이지
![image](https://github.com/user-attachments/assets/65b86ab1-41df-409b-baf6-579ad934a0ec)
<br>
 
## MVC 패턴
- 소프트웨어 디자인 패턴
- 모델(Model), 뷰(View), 컨트롤러(Controller)로 역할을 나누어 유지보수와 효율성을 높여준다.
<br>
 
## 스프링에서 의존성 주입(DI) 방법 3가지 방법
- 의존성 주입: 객체 간의 의존 관계를 관리하는 기법. 스프링은 이를 통해 객체의 생명 주기를 관리하고, 결합도를 줄여서 유연한 코드를 작성할 수 있게 한다.
- 1. 생성자 주입
  - 생성자를 통해 의존성을 주입한다.
  - 의존성이 필수일 때 사용
  - 객체를 생성할 때 ```final```로 선언하여 필요한 의존성을 생성자의 매개변수로 전달한다.
- 2. 세터 주입
  - 세터 메소드를 통해 의존성을 주입한다.
  - 의존성이 선택적일 때 사용
  - 주로 ```@Autowired```로 의존성을 주입하며, 본인은 롬복 라이브러리를 이용해 ```@RequiredArgsConstructor```로 의존성을 주입하였다.
- 3. 필드 주입
  - 클래스의 필드에 ```@Autowired```로 직접 의존성을 주입한다.
<br>
 
## JPA의 장점과 단점
- 장점
  - JPA는 객체와 관계형 데이터베이스 간의 상호작용을 간소화하고, 데이터베이스 작업을 객체 지향적으로 수행할 수 있게 해준다.
- 단점
  - 복잡한 쿼리문을 소화할 수 없으며, 유지보수 또한 어렵다.

## HTTP GET 요청과 POST 요청의 차이
- GET 요청
  - URL을 통해 데이터 요청을 하고 파라미터 또한 URL에 삽입되어 전달이 된다.
  - URL을 통해 데이터가 보이므로 보안이 약하다.
  - 서버 리소스를 검색하는데 주로 사용된다.
- POST 요청
  - 파라미터를 HTTP body에 담아 요청을 한다.
  - 겉으로 데이터가 드러나지 않으므로 비교적 보안이 좋다.
  - 서버 데이터를 변경할 때 주로 사용된다.   