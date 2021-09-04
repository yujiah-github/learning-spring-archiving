## 1. 인터넷 네트워크
### 1-1. 인터넷 통신
- 우리가 개발하는 모든 웹은 **HTTP** 위에서 동작합니다.
- 평생 HTTP 위에서 일하기 때문에, 개발자들은(특히 백엔드 개발자들은) **사용 목적과 기능**을 깊이 있게 이해하는 것이 필요합니다.

### 1-2. IP(Internet Protocol)
- 인터넷 프로토콜이 클라이언트와 서버에 IP 주소를 부여합니다.
- 지정한 **IP 주소(IP Address)**에 **데이터 전달 패킷(Packet)**이라는 통신 단위로 데이터 전달

![](https://images.velog.io/images/cil05265/post/c8fddafd-020a-44bf-93bc-579455257bf8/image.png)IP패킷은 출발지, 목적지, 전송 데이터 등으로 이루어집니다.

![](https://images.velog.io/images/cil05265/post/26362124-288f-4b92-9a1a-dae8988ccddc/image.png)그림과 같이 노드끼리 서로 패킷을 전달하면서 클라이언트에서 서버까지 도달하게 됩니다.

그런데 여기서 **3가지 문제점**이 발생합니다.
- **비연결성**
패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷을 전송합니다.
- **비신뢰성**
중간에 패킷이 사라지거나 패킷이 순서대로 오지 않아도 책임지지 않습니다.
- **프로그램 구분**
같은 IP를 사용하는 서버에서 통신하는 애플리케이션이 둘 이상일 때 구별하기 어렵습니다.(예를 들어 음악을 들으면서 게임을 하는 경우)

이를 보완하기 위해 탄생한 것이 **TCP/UDP** 입니다.

### 1-3. TCP,UDP
TCP,UDP 를 설명하기 전에 잠시 인터넷 프로토콜 스펙 계층에 대해 설명하겠습니다.
![](https://images.velog.io/images/cil05265/post/f7b955a9-c94c-4eb4-8c8b-43d03347a71c/image.png)그림과 같이 인터넷 프로토콜 스택은 여러 계층으로 이루어져있습니다.

애플리케이션 계층, 전송 계층, 인터넷 계층, 네트워크 인터페이스 계층이 있으며 각 계층마다 HTTP, FTP ,TCP, UDP, IP 등이 있습니다.

그림의 패킷 전달 과정을 설명하면
1. 프로그램이 Hello, world! 메시지 생성하고
2. SOCKET 라이브러리를 통해 전달을 한 후
3. TCP 정보를 생성하면서 메시지 데이터도 포함합니다.
4. 마찬가지로 IP 패킷을 생성한 후에 TCP 데이터도 포함합니다.

다시 말해 기존의 패킷에 **TCP 관련 정보**를 포함시킨 것이죠.
![](https://images.velog.io/images/cil05265/post/35604cdd-a6f6-4b18-8b89-5f853a3c51c9/image.png)택배 상자를 떠올리시면 쉽게 이해가 가능하실 겁니다.(IP 패킷이라는 **상자** 안에 데이터라는 **내용물** 포함)

**TCP**는 **전송 제어 프로토콜(Transmission Control Protocol)**의 약자입니다.

**TCP 특징**은 다음과 같습니다.
- **연결지향(TCP 3 way handshake)**적 입니다.
- 데이터 전달을 보증합니다.(잘 전달 받았는지 확인합니다.)
- 전달의 순서를 보장합니다.(순서가 어긋나면 어긋난 곳부터 다시 보내도록 요청합니다.)
- 신뢰할 수 있는 프로토콜이며 현재는 대부분 TCP 사용합니다.

다음은 **연결지향(TCP 3 way handshake)**에 대한 추가적인 설명입니다.

![](https://images.velog.io/images/cil05265/post/591a4f54-6607-4cc5-899f-cc88deff5c00/image.png) **연결지향(TCP 3 way handshake)**은 실제 연결이 아닌 가상 연결입니다. 개념적인 연결일 뿐 물리적인 연결은 아닙니다.

그림 설명을 하면,

1. 클라이언트가 우선 접속 요청을 하면
2. 서버는 요청을 수락함과 동시에 접속 요청을 다시 보냅니다.(요즘은 2번 과정에서 데이터를 전송하는 경우가 많다고 합니다.)
3. 클라이언트는 서버가 보낸 접속 요청을 수락합니다.

위와 같은 일련의 과정 속에 요청과 수락이 3번 이루어진다고 해서 **TCP 3 way handshake**라고 이름이 붙여졌습니다.

**UDP**는 **사용자 데이터그램 프로토콜(User Datagram Protocol)**의 약자입니다.

**UDP 특징**은 다음과 같습니다.
- 기능이 거의 없기 때문에, 하얀 도화지에 비유되곤 합니다.**(IP와 거의 같으며 PORT와 체크섬 정도만 추가됩니다.)**
**- TCP의 특징인 연결지향(TCP 3 way handshake), 데이터 전달 보증
순서 보장 등을 모두 가지고 있지 않습니다.**
- 대신에 TCP에 비해 단순하고 빠릅니다.
- 애플리케이션에서 추가 작업 필요

### 1-4. PORT
2-2 에서 보았던 패킷 그림을 자세히 보면 포트가 있음을 확인할 수 있습니다.

**PORT**의 기능에 대해 설명하겠습니다.
- **PORT**란 하나의 **IP**에서 여러 개의 동작을 할 때 구분하는 것입니다.(2-1의 예시처럼 음악을 들으며 게임을 하는 경우)
- **PORT**는 같은 **IP** 내에서 프로세스를 구분합니다.
- **IP는 아파트**, **PORT는 아파트의 동,호수** 라고 생각하시면 쉽게 이해가 가실 겁니다.
- PORT는 0번 부터 65535번까지 할당 가능합니다. 0번 부터 1023번 까지는 잘 알려진 포트로 사용하지 않는 것이 좋습니다.

### 1-5. DNS
**DNS**는 도메인 네임 시스템(Domain Name System)의 약자입니다.
- IP는 기억하기 어렵고 변경될 수 있습니다.
- DNS를 사용하면, 도메인 명을 IP 주소로 변환해줍니다.(**전화번호부**라고 생각하면 이해가 쉽습니다.)
![](https://images.velog.io/images/cil05265/post/b688d97d-e685-4db3-84c3-5398b8197034/image.png)

## 2. URI 웹 브라우저
### 2.1 URI
- URI는 **URI(Uniform Resource Identifier)**의 약자입니다.
- URI는 **로케이터(locator)**, **이름(name)** 또는 둘 다 추가로 분류될 수 있습니다.

URI 설명
- **Uniform**: 리소스 식별하는 통일된 방식을 뜻합니다.
- **Resource**: 자원, URI로 식별할 수 있는 모든 것(제한 없음)을 의미합니다.
- **Identifier**: 다른 항목과 구분하는데 필요한 정보를 나타냅니다.

단어 뜻
URL 설명
- URL는 **Uniform Resource Locator**의 약자입니다.
- Locator: 리소스가 있는 **위치**를 지정합니다.

URN 설명
- URN은 **Uniform Resource Name**의 약자입니다.
- Name: 리소스에 **이름**을 부여합니다.
- **위치는 변할 수 있지만, 이름은 변하지 않는다.**
- URN 이름만으로 실제 리소스를 찾을 수 있는 방법이 보편화 되지 않았습니다.

이 글에서는 URI를 URL과 같은 의미로 다루겠습니다.

다음 URL를 분석 해보도록 하겠습니다.

> scheme://[userinfo@]host[:port][/path][?query][#fragment] https://www.google.com:443/search?q=hello&hl=ko


**프로토콜(https)**
> **scheme**://[userinfo@]host[:port][/path][?query][#fragment] **https** ://www.google.com:443/search?q=hello&hl=ko

- 어떤 방식으로 자원에 접근할 것인가 하는 약속 규칙입니다.
예) http, https, ftp 등등
http는 80 포트, https는 443 포트를 주로 사용합니다.(포트는 생략 가능)
- https는 http에 보안을 추가한 것입니다. (HTTP Secure)

**userinfo**
> scheme://**[userinfo@]** host[:port][/path][?query][#fragment] https://www.google.com:443/search?q=hello&hl=ko

- URL에 사용자정보를 포함해서 인증합니다. 최근에는 거의 사용하지 않습니다.

**호스트명(www.google.com)**
> scheme://[userinfo@] **host** [:port][/path][?query][#fragment] https:// **www.google.com** :443/search?q=hello&hl=ko

- 도메인명 또는 IP 주소를 직접 사용하는 것이 가능합니다.

**포트 번호(443)**
> scheme://[userinfo@]host **[:port]** [/path][?query][#fragment] https://www.google.com: **443** /search?q=hello&hl=ko

- 일반적으로 생략합니다. 생략시 http는 80, https는 443입니다.

**패스(/search)**
> scheme://[userinfo@]host[:port] **[/path]** [?query][#fragment] https://www.google.com:443**/search**?q=hello&hl=ko

- 리소스 경로(path), 계층적 구조를 보여줍니다.

>예)
/home/file1.jpg
/members
/members/100, /items/iphone12

**쿼리 파라미터(q=hello&hl=ko)**
> scheme://[userinfo@]host[:port][/path] **[?query]** [#fragment] https://www.google.com:443/search? **q=hello&hl=ko**

- key=value 형태입니다.
- ?로 시작, &로 추가 가능합니다. (예를 들면 ?keyA=valueA&keyB=valueB)
- query parameter, query string 등으로 불립니다. 웹서버에 제공하는 파라미터, 문자 형태 입니다.

**fragment**
> scheme://[userinfo@]host[:port][/path][?query]**[#fragment]**
https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html  **#getting-started-introducing-spring-boot fragment**

- html 내부 북마크 등에 사용합니다.
- 서버에 전송하는 정보 아닙니다.

### 2.2 웹 브라우저 요청 흐름
웹 브라우저 요청 흐름을 다음과 같이 그림으로 보겠습니다.
![](https://images.velog.io/images/cil05265/post/7792fcd1-7c97-47b2-b02d-456cb465b031/image.png)
![](https://images.velog.io/images/cil05265/post/7023be82-fb0a-4efc-b97d-2c2a385f14aa/image.png)
클라이언트와 서버는 전송 데이터와 HTTP 메시지가 담겨있는 패킷을 주고 받게 됩니다.

## 3. HTTP
### 3.1 모든 것이 HTTP
- **HTTP**는 **HyperText Transfer Protocol**의 약자입니다.
- HTTP 메시지에 HTML, TEXT, IMAGE, 음성, 영상, 파일 ,JSON, XML 등 거의 모든 형태의 데이터를 전송 할 수 있습니다.
- 서버간에 데이터를 주고 받을 때도 대부분 HTTP를 사용합니다.
- **TCP**는 **HTTP/1.1, HTTP/2** 를 기반으로 하며 **UDP**는 **HTTP/3** 을 기반으로 합니다.
- **HTTP/1.1는 가장 많이 사용을 하며 가장 중요한 버전입니다.**

### 3.2 클라이언트 서버 구조

간단하게 그림으로 나타낼 수 있습니다.
![](https://images.velog.io/images/cil05265/post/da38a5c8-7c2d-4407-a11f-aabf80921d2b/image.png)

### 3.3 Stateful, Stateless

**Stateful, Stateless 차이 정리**
**상태 유지**
- 중간에 다른 서버로 바뀌면 안됩니다.
- 중간에 다른 서버로 바뀔 때 상태 정보를 다른 서버에게 미리 알려줘야 한다.

**무상태**
- 중간에 다른 서버로 바뀌어도 됩니다.
- 갑자기 요청이 증가해도 서버를 대거 투입할 수 있습니다.
- 갑자기 클라이언트 요청이 증가해도 서버를 대거 투입할 수 있습니다.
- 무상태는 응답 서버를 쉽게 바꿀 수 있기 때문에 무한한 서버 증설이 가능합니다.
- 서버의 확장성이 높으나 클라이언트가 추가 데이터를 전송해야 하는 단점이 있습니다.

이해하기 쉽게 그림 자료를 함께 첨부하겠습니다.
![](https://images.velog.io/images/cil05265/post/9ffc4e5f-55d5-4ec1-a1cc-d2d2bd7c2f00/image.png)

![](https://images.velog.io/images/cil05265/post/5d5640f2-8037-4544-88f3-139323a0d345/image.png)
![](https://images.velog.io/images/cil05265/post/c60d7ea5-1fc6-44f0-a603-a5674f1e111f/image.png)
![](https://images.velog.io/images/cil05265/post/dfc6a9b2-b9e1-4561-b9ef-30bc52beec95/image.png)
![](https://images.velog.io/images/cil05265/post/64cf540a-7458-4ac6-95d7-f096a8368124/image.png)

**Stateless의 실무 한계**
- 모든 것을 무상태로 설계 할 수 있는 경우도 있고 없는 경우도 있습니다.
- 예) 무상태가 필요한 경우: 로그인이 필요 없는 단순한 서비스 소개 화면
- 예) 상태 유지가 필요한 경우: 로그인
- 로그인한 사용자의 경우 로그인 했다는 상태를 서버에 유지합니다.
- 일반적으로 브라우저 쿠키와 서버 세션등을 사용해서 상태 유지를 합니다.
- 상태 유지는 최소한만 사용합니다.

### 3.4 비 연결성(connectionless)
이해하기 쉽게 그림을 첨부했습니다.
![](https://images.velog.io/images/cil05265/post/72f1f6c9-3c58-4747-86c1-5c30445defb4/image.png)연결이 지속되면 그만큼 서버 자원을 낭비하게 됩니다.

![](https://images.velog.io/images/cil05265/post/6b6e3cfb-8588-4af1-8902-f9e86689bb0f/image.png)반면에 요청과 응답이 이루어지고 난 후, 연결을 종료하게 되면 서버 자원의 낭비를 막을 수 있습니다.

**비 연결성**
- HTTP는 기본이 연결을 유지하지 않는 모델입니다.
- 일반적으로 초 단위의 이하의 빠른 속도로 응답합니다.
- 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청은 수십개 이하로 매우 작습니다.(웹 브라우저에서 계속 연속해서 검색 버튼을 누르지는 않음. 서버 자원을 매우 효율적으로 사용할 수 있음.)

**한계와 극복**
- TCP/IP 연결을 새로 맺어야 합니다. **(해결책:3 way handshake 시간 추가)**
- 웹 브라우저로 사이트를 요청하면 HTML 뿐만 아니라 자바스크립트, css, 추가 이미지 등등 수 많은 자원이 함께 다운로드 됩니다. **(해결책: HTTP 지속 연결(Persistent Connections), HTTP/2, HTTP/3에서 더 많은 최적화)**

![](https://images.velog.io/images/cil05265/post/294b1585-313a-4680-b924-0e77e930156b/image.png)

### 3.5 HTTP 메시지
다음 그림은 HTTP 메시지 구조를 나타냅니다.
![](https://images.velog.io/images/cil05265/post/43127ec3-a0d3-4cb8-8952-9c68afb46d8f/image.png)

## 4.HTTP-WEBBROWSER
### 4.1 HTTP API를 만들어보자
**API URI 설계해보기**
- 리소스에는 명사가 와야합니다.
예) 미네랄을 캐라 -> 미네랄이 리소스
-회원 리스트가 있다고 가정하면, 여기서 회원이라는 개념 자체가 바로 리소스입니다.

리소스를 어떻게 식별하는게 좋을까요?
- 회원을 등록하고 수정하고 조회하는 것을 모두 배제합니다.
- 회원이라는 리소스만 식별하면 됩니다. -> 회원 리소스를 URI에 매핑합니다.

예시를 들면 다음과 같습니다.
> 회원 목록 조회 /members
회원 조회 /members/{id}
회원 등록 /members/{id}
회원 수정 /members/{id}
회원 삭제 /members/{id}

참고 사항: 계층 구조상 상위를 컬렉션으로 보고 복수단어 사용 권장합니다.(member -> members)

그러면 여기서 행위(조회, 등록, 수정, 삭제)는 어떻게 구별해야 할까요?
여기서 HTTP 메서드 개념이 등장합니다.

### 4.2 HTTP 메서드 / GET, POST
**GET:** 리소스 조회
**POST:** 요청 데이터 처리, 주로 등록에 사용

**GET**
- 서버에 전달하고 싶은 데이터는 query(쿼리 파라미터, 쿼리 스트링)를 통해서 전달합니다.
- 메시지 바디를 사용해서 데이터를 전달할 수 있지만, 지원하지 않는 곳이 많아서 권장하지 않습니다.
![](https://images.velog.io/images/cil05265/post/cd7651a6-f247-4088-ba79-ae8fa1351d68/image.png)
![](https://images.velog.io/images/cil05265/post/da8acfd0-60e7-40d7-ba5f-239dc518bb69/image.png)
![](https://images.velog.io/images/cil05265/post/b19f686b-237b-4825-9a7b-8b31e679b811/image.png)

**POST**
- 메시지 바디를 통해 서버로 요청합니다.
- 데이터 전달 서버는 요청 데이터를 처리합니다.
- 메시지 바디를 통해 들어온 데이터를 처리하는 모든 기능을 수행합니다.
- 주로 전달된 데이터로 신규 리소스 등록, 프로세스 처리에 사용합니다.
- **다른 메서드로 처리하기 애매한 경우에 POST를 사용하면 됩니다.(거의 웬만하면 POST 입니다.)**

![](https://images.velog.io/images/cil05265/post/ce5e013f-ca8a-4878-952a-8eae23ad0d84/image.png)
![](https://images.velog.io/images/cil05265/post/d82ad0f1-7b10-45f3-9c54-9a4b9b359801/image.png)
![](https://images.velog.io/images/cil05265/post/699320eb-bbc7-462f-a22a-730895681c95/image.png)

### 4.3 HTTP 메서드 / PUT, PATCH, DELETE
**PUT**
- 리소스가 있으면 대체하지만 리소스가 없으면 생성합니다.(덮어버림)
- 클라이언트가 리소스를 식별합니다. 클라이언트가 리소스 위치를 알고 URI 지정합니다. (POST와 차이점)

**PATCH**
- 리소스를 부분 수정합니다.

**DELETE**
- 리소스를 삭제합니다.

### 4.4 HTTP 메서드의 속성
- HTTP 메서드는 크게 세 가지의 속성을 가지고 있습니다.
  - 안전(Safe Methods)
  - 멱등(Idempotent Methods)
  - 캐시가능(Cacheable Methods)
![](https://images.velog.io/images/cil05265/post/94d7d7e2-d6e0-4f2d-9998-245c388780d9/image.png)

**안전(Safe)**
- 호출해도 리소스를 변경하지 않습니다.
- 그래도 계속 호출해서 로그 같은게 쌓여서 장애가 발생한다면, 안전은 해당 리소스만 고려합니다.

**멱등(Idempotent)**
- f(f(x)) = f(x)
- 한 번 호출하든 두 번 호출하든 100번 호출하든 결과가 똑같습니다.
> GET: 한 번 조회하든, 두 번 조회하든 같은 결과가 조회된다.
PUT: 결과를 대체한다. 따라서 같은 요청을 여러번 해도 최종 결과는 같다. DELETE: 결과를 삭제한다. 같은 요청을 여러번 해도 삭제된 결과는 똑같다. **POST: 멱등이 아니다! 두 번 호출하면 같은 결제가 중복해서 발생할 수 있다.**

**멱등의 활용**
- 서버가 TIMEOUT 등으로 정상 응답을 못주었을 때, 클라이언트가 같은 요청을 다시 해도 되는가의 판단 근거가 됩니다.

> Q: 재요청 중간에 다른 곳에서 리소스를 변경해버리면?
사용자1: GET -> username:A, age:20
사용자2: PUT -> username:A, age:30
사용자1: GET -> username:A, age:30 -> 사용자2의 영향으로 바뀐 데이터 조회
A: 멱등은 외부 요인으로 중간에 리소스가 변경되는 것 까지는 고려하지는 않는다.


**캐시가능 (Cacheable)**
- GET, HEAD, POST, PATCH는 응답 결과 리소스를 캐시해서 사용할 수 있으나, 실제로는 **GET, HEAD** 정도만 캐시로 사용합니다.
- POST, PATCH는 본문 내용까지 캐시 키로 고려해야 하는데, 구현이 쉽지 않습니다.

## 5. HTTP 메서드 활용
### 5.1 클라이언트에서 서버로 데이터 전송
- 클라이언트에서 서버로 데이터 전송 데이터 전달 방식은 크게 2가지입니다.
- **쿼리 파라미터를 통한 데이터 전송**
  - GET: 주로 정렬 필터(검색어)
- **메시지 바디를 통한 데이터 전송**
  - POST, PUT, PATCH: 회원 가입, 상품 주문, 리소스 등록, 리소스 변경

**클라이언트에서 서버로 데이터 전송 4가지 상황**
- **정적 데이터 조회:** 이미지, 정적 텍스트 문서
- **동적 데이터 조회:** 주로 검색, 게시판 목록에서 정렬 필터(검색어)
- **HTML Form을 통한 데이터 전송:** 회원 가입, 상품 주문, 데이터 변경
- **HTTP API를 통한 데이터 전송:** 회원 가입, 상품 주문, 데이터 변경, 서버 to 서버, 앱 클라이언트, 웹 클라이언트(Ajax)

**정적 데이터 조회 정리**
- 이미지, 정적 텍스트 문서
- 조회는 GET 사용
- 정적 데이터는 일반적으로 쿼리 파라미터 없이 리소스 경로로 단순하게 조회 가능

**동적 데이터 조회 정리**
- 주로 검색, 게시판 목록에서 정렬 필터(검색어)
- 조회 조건을 줄여주는 필터, 조회 결과를 정렬하는 정렬 조건에 주로 사용, 조회는 GET 사용
- GET은 쿼리 파라미터 사용해서 데이터를 전달

**HTML Form 데이터 전송 정리**
예) 회원 가입, 상품 주문, 데이터 변경
- HTML Form submit시 POST 전송
- Content-Type: application/x-www-form-urlencoded 사용
- form의 내용을 메시지 바디를 통해서 전송(key=value, 쿼리 파라미터 형식)
- 전송 데이터를 url encoding 처리

예) abc김 -> abc%EA%B9%80 HTML Form은 GET 전송도 가능
- Content-Type: multipart/form-data
- 파일 업로드 같은 바이너리 데이터 전송시 사용
- 다른 종류의 여러 파일과 폼의 내용 함께 전송 가능(그래서 이름이 multipart) 참고: HTML Form 전송은 GET, POST만 지원
![](https://images.velog.io/images/cil05265/post/0b1c360b-a76d-4245-a87a-0095cf70d67a/image.png)
![](https://images.velog.io/images/cil05265/post/3878d9d8-cd8f-4ba4-af93-5949a12a6aa8/image.png)
![](https://images.velog.io/images/cil05265/post/15687d22-9f57-4f23-8237-4b0910321df0/image.png)
![](https://images.velog.io/images/cil05265/post/a9f1e5b4-f881-4f94-a7cd-448ed2fc8fe0/image.png)

**HTTP API 데이터 전송 정리**
- 서버 to 서버
- 백엔드 시스템 통신 앱 클라이언트
- 아이폰, 안드로이드 웹 클라이언트
- HTML에서 Form 전송 대신 자바 스크립트를 통한 통신에 사용(AJAX)
예) React, VueJs 같은 웹 클라이언트와 API 통신
- POST, PUT,PATCH: 메시지 바디를 통해 데이터 전송
- GET: 조회, 쿼리 파라미터로 데이터 전달
- Content-Type: application/json을 주로 사용 (사실상 표준) TEXT, XML, JSON 등등
![](https://images.velog.io/images/cil05265/post/08bbf4dc-d003-44a6-b713-c880793ea62e/image.png)
### 5.2 HTTP API 설계 예시
**HTTP API - 컬렉션**
- POST 기반 등록 **(서버가 리소스 URI 결정)**
  - 예) 회원 관리 API 제공

**HTTP API - 스토어**
- PUT 기반 등록 **(클라이언트가 리소스 URI 결정)**
  - 예) 정적 컨텐츠 관리, 원격 파일 관리

**HTML FORM 사용**
- 웹 페이지 회원 관리 **(GET, POST만 지원)**
순수 HTML + HTML form 사용

**회원 관리 시스템 API 설계 - POST 기반 등록**
>(예시)
회원 목록 /members -> GET
회원 등록 /members -> POST
회원 조회 /members/{id} -> GET
회원 수정 /members/{id} -> PATCH, PUT, POST
회원 삭제 /members/{id} -> DELETE


회원 관리 시스템 POST - 신규 자원 등록 특징
- 회원 등록 /members -> POST

- 클라이언트는 등록될 리소스의 **URI를 모른다.**
POST /members

- 서버가 새로 등록된 리소스 **URI를 생성해준다.**
HTTP/1.1 201 Created
Location: /members/100

- 컬렉션(Collection)
**서버가 관리하는 리소스 디렉토리**
서버가 리소스의 URI를 생성하고 관리 여기서 컬렉션은 **/members**

**파일 관리 시스템 API 설계 - PUT 기반 등록**

> (예시)
파일 목록 /files -> GET
파일 조회 /files/{filename} -> GET
파일 등록 /files/{filename} -> PUT
파일 삭제 /files/{filename} -> DELETE
파일 대량 등록 /files -> POST

**파일 관리 시스템 PUT -신규자원등록특징**
- 파일 등록 /files/{filename} -> PUT

**클라이언트가 리소스 URI를 알고 있어야 한다.**
- PUT /files/star.jpg
클라이언트가 직접 리소스의 URI를 지정한다.

**스토어(Store)**
- 클라이언트가 관리하는 리소스 저장소
클라이언트가 리소스의 URI를 알고 관리
**여기서 스토어는 /files**

**HTML FORM 사용**
- HTML FORM은 GET, POST만 지원
- AJAX 같은 기술을 사용해서 해결 가능 -> 회원 API 참고 **(여기서는 순수 HTML, HTML FORM 이야기)**
- GET, POST만 지원하므로 제약이 있음

**HTML FORM 사용**
> 예시
회원 목록  /members -> GET
회원 등록 폼 /members/new -> GET
회원 등록 /members/new, /members -> POST
회원 조회/members/{id} -> GET
회원 수정 폼 /members/{id}/edit -> GET
회원 수정 /members/{id}/edit, /members/{id} -> POST
회원 삭제/members/{id}/delete -> POST

**HTML FORM 사용**
- HTML FORM은 GET, POST만 지원 컨트롤 URI
- GET, POST만 지원하므로 제약이 있음
  - 이런 제약을 해결하기 위해 동사로 된 리소스 경로 사용 ***(POST의 /new, /edit, /delete가 컨트롤 URI)***
- HTTP 메서드로 해결하기 애매한 경우 사용(HTTP API 포함)

### 5.2(참고) 참고하면 좋은 URI 설계 개념

**문서(document)**
- 단일 개념(파일 하나, 객체 인스턴스, 데이터베이스 row)
예) /members/100, /files/star.jpg

**컬렉션(collection)**
- 서버가 관리하는 리소스 디렉터리 서버가 리소스의 URI를 생성하고 관리
예) /members

**스토어(store)**
- 클라이언트가 관리하는 자원 저장소 클라이언트가 리소스의 URI를 알고 관리 예) /files

**컨트롤러(controller), 컨트롤 URI**
- 문서, 컬렉션, 스토어로 해결하기 어려운 추가 프로세스 실행 동사를 직접 사용
예) /members/{id}/delete

## 6. HTTP 상태코드
**상태 코드**
- 클라이언트가 보낸 요청의 처리 상태를 응답에서 알려주는 기능
>
1xx (Informational): 요청이  **수신되어 처리중**
2xx (Successful): 요청   **정상**  처리
3xx (Redirection): 요청을 완료하려면  **추가 행동이 필요**
4xx (Client Error): 클라이언트 오류, 잘못된 문법등으로  **서버가 요청을 수행할 수 없음**
5xx (Server Error): 서버 오류,  **서버가 정상 요청을 처리하지 못함**

Q.만약 모르는 상태 코드가 나타나면? 클라이언트가 인식할 수 없는 상태코드를 서버가 반환하면?
A.클라이언트는 **상위 상태코드로 해석**해서 처리하므로, 새로운 상태 코드가 추가되어도 클라이언트를 변경하지 않아도 된다.
> 예)299 ??? -> 2xx (Successful)
451 ??? -> 4xx (Client Error)
599 ??? -> 5xx (Server Error)

참고) 1xx (Informational)는 **'요청이 수신되어 처리중'**이라는 의미로, 거의 사용하지 않으므로 생략하고 2xx (Successful)부터 설명하겠다.

### 6.1 2xx (Successful)
**클라이언트의 요청을 성공적으로 처리**
- 200 OK: 요청 성공
- 201 Created: 요청 성공해서 새로운 리소스가 생성됨
- 202 Accepted: 요청이 접수되었으나 처리가 완료되지 않았음
- 204 No Content: 서버가 요청을 성공적으로 수행했지만, 응답 페이로드 본문에 보낼 데이터가 없음 ***(결과 내용이 없어도 2xx 메세지 만으로 성공으로 인식할 수 있다.)***

### 6.2 3xx (Redirection)
**요청을 완료하기 위해 유저 에이전트의 추가 조치 필요**
- 300 Multiple Choices
- 301 Moved Permanently **(영구 리다이렉션)**
- 302 Found **(일시적인 리다이렉션)**
- 303 See Other **(일시적인 리다이렉션)**
- 304 Not Modified
- 307 Temporary Redirect **(일시적인 리다이렉션)**
- 308 Permanent Redirect **(영구 리다이렉션)**

리다이렉션 이란?
웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동 (리다이렉트)

리다이렉션의 종류
- 영구 리다이렉션 - 특정 리소스의 URI가 영구적으로 이동
예) /members -> /users
예) /event -> /new-event

- 일시 리다이렉션 - 일시적인 변경
주문 완료 후 주문 내역 화면으로 이동

- PRG: Post/Redirect/Get
특수 리다이렉션
결과 대신 캐시를 사용

**영구 리다이렉션(301, 308)**
- 리소스의 URI가 영구적으로 이동
- 원래의 URL를 사용X, 검색 엔진 등에서도 변경 인지
- 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음(MAY)

- 301 Moved Permanently
리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음(MAY)

- 308 Permanent Redirect
301과 기능은 같음
리다이렉트시 요청 메서드와 본문 유지(처음 POST를 보내면 리다이렉트도 POST 유지)

**일시적인 리다이렉션(302, 307, 303)**
- 리소스의 URI가 일시적으로 변경
- 따라서 검색 엔진 등에서 URL을 변경하면 안됨

- 302 Found
리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음(MAY)

- 307 Temporary Redirect
302와 기능은 같음
리다이렉트시 요청 메서드와 본문 유지(요청 메서드를 변경하면 안된다. MUST NOT)

- 303 See Other
302와 기능은 같음
리다이렉트시 요청 메서드가 GET으로 변경

**PRG: Post/Redirect/Get 일시적인 리다이렉션**
- POST로 주문후에 새로 고침으로 인한 중복 주문 방지
- POST로 주문후에 주문 결과 화면을 GET 메서드로 리다이렉트
- 새로고침해도 결과 화면을 GET으로 조회
- 중복 주문 대신에 결과 화면만 GET으로 다시 요청

>예시
POST로 주문후에 웹 브라우저를 새로고침하면? 새로고침은 다시 요청
중복 주문이 될 수 있다.
PRG: Post/Redirect/Get 일시적인 리다이렉션 - 예시


**302, 307, 303 중에 어느 것을 사용해야 하는가?**

> 302 Found -> GET으로 변할 수 있음
307 Temporary Redirect -> 메서드가 변하면 안됨
303 See Other -> 메서드가 GET으로 변경

- 처음 302 스펙의 의도는 **HTTP 메서드를 유지**하는 것
- 그런데 웹 브라우저들이 대부분 GET으로 바꾸어버림(일부는 다르게 동작)
- 그래서 **모호한 302를 대신**하는 명확한 **307, 303이 등장**함(301 대응으로 308도 등장)
- 307, 303을 권장하지만 현실적으로 이미 **많은 애플리케이션 라이브러리들이 302를 기본값으로 사용**
- **자동 리다이렉션시에 GET으로 변해도 되면 그냥 302를 사용해도 큰 문제 없음**

**기타 리다이렉션(300 304)**
- 300 Multiple Choices: 안쓴다.
- 304 Not Modified
캐시를 목적으로 사용
클라이언트에게 리소스가 수정되지 않았음을 알려준다.
따라서 클라이언트는 로컬PC에 저장된 캐시를 재사용한다. **(캐시로 리다이렉트 한다.)**
304 응답은 응답에 메시지 바디를 포함하면 안된다. **(로컬 캐시를 사용해야 하므로)**
조건부 GET, HEAD 요청시 사용

### 6.3 4xx (Client Error)
**클라이언트 오류**
- 클라이언트의 요청에 **잘못된 문법**등으로 서버가 요청을 수행할 수 없음
- 오류의 원인이 **클라이언트**에 있음
- **클라이언트가 이미 잘못된 요청, 데이터를 보내고 있기 때문에, 똑같은 재시도가 실패함**

**400 Bad Request**
- 클라이언트가 잘못된 요청을 해서 서버가 요청을 처리할 수 없음
  - 요청 구문, 메시지 등등 오류
- 클라이언트는 요청 내용을 다시 검토하고, 보내야함 ***(요청 파라미터가 잘못되거나, API 스펙이 맞지 않을 때)****

**401 Unauthorized**
- 클라이언트가 해당 리소스에 대한 인증이 필요함, 인증(Authentication) 되지 않음
- 401 오류 발생시 응답에 **WWW-Authenticate 헤더와 함께 인증 방법을 설명**
- 오류 메시지가 Unauthorized 이지만 인증 되지 않음 (이름이 아쉬움)

>인증과 인가는 무엇인가?
**인증(Authentication):** 본인이 누구인지 확인 (로그인)
**인가(Authorization):**  권한부여 (ADMIN 권한처럼 특정 리소스에 접근할 수 있는 권한, 인증이 있어야 인가가 있음)

**403 Forbidden**
- 서버가 요청을 이해했지만 승인을 거부함
- 주로 인증 자격 증명은 있지만, 접근 권한이 불충분한 경우
예) 어드민 등급이 아닌 사용자가 로그인은 했지만, 어드민 등급의 리소스에 접근하는 경우

**404 Not Found**
- 요청 리소스가 서버에 없음
- 클라이언트가 권한이 부족한 리소스에 접근할 때 해당 리소스를 숨기고 싶을 때도 사용

### 6.4 5xx (Server Error)
**서버 문제로 오류 발생**
- 서버에 문제가 있기 때문에 재시도 하면 성공할 수도 있음(복구가 되거나 등등)
- 정말 심각한 오류이므로, 발생하지 않는 것이 좋음

**500 Internal Server Error**
- 서버 내부 문제로 오류 발생 애매하면 500 오류

**503 Service Unavailable**
- 서비스 이용 불가
- 서버가 일시적인 과부하 또는 예정된 작업으로 잠시 요청을 처리할 수 없음
- Retry-After 헤더 필드로 얼마뒤에 복구되는지 보낼 수도 있음
