# 차민욱 202030235

## 6월 14일
## 13장 입출력 스트림과 파일 입출력
### 자바의 입출력 스트림
1. 입출력 장치와 자바 응용 프로그램 연결
    - 입력 스트림 : 입력 장치로부터 자바 프로그램으로 데이터를 전달하는 객체
    - 출력 스트림 : 자바 프로그램에서 출력 장치로 데이터를 보내는 객체
2. 특징
    - 입출력 스트림 기본 단위 : 바이트
    - 단방향 스트림, 선입선출 구조

### 자바의 입출력 스트림 종류
1. 문자 스트림
    - 문자만 입출력하는 스트림
    - 문자가 아닌 바이너리 데이터는 스트림에서 처리하지 못함
    - 문자가 아닌 데이터를 문자 스트림으로 출력하면 깨진 기호가 출력
    - 바이너리 파일을 문자 스트림으로 읽으면 읽을 수 없는 바이트가 생겨서 오류 발생 
        - 예) 텍스트 파일을 읽는 입력 스트림
2. 바이트 스트림
    - 입출력 데이터를 단순 바이트의 흐름으로 처리
    - 문자 데이터 든 바이너리 데이터든 상관없이 처리 가능
        - 예) 바이너리 파일을 읽는 입력 스트림

### 스트림 연결
1. 여러 개의 스트림을 연결하여 사용할 수 있음
    - 예) 키보드에서 문자를 입력받기 위해 System.in과
2. InputStreamReader를 연결한 코드
```java
InputStreamReader rd = new InputStreamReader(System.in);
```
```java
while(true) {
    int c = rd.read(); // 입력 스트림으로부터 키 입력. c는 입력된 키 문자 값
    if(c == -1) // 입력 스트림의 끝을 만나는 경우
        break; // 입력 종료
}
```

### 문자 스트림으로 텍스트 파일 읽기
1. 텍스트 파일을 읽기 위해 문자 스트림 FileReader 클래스 이용
    - 파일 입력 스트림 생성(파일 열기)
        - 스트림을 생성하고 파일을 열어 스트림과 연결
```java
FileReader fin = new FileReader("c:\\test.txt");
```
2. 파일 읽기
    - read()로 문자 하나 씩 파일에서 읽음
```java
int c;
while((c = fin.read()) != -1) { // 문자를 c에 읽음. 파일 끝까지 반복
    System.out.print((char)c); // 문자 c 화면에 출력
}
```
3. 스트림 닫기
    - 스트림이 더 이상 필요 없으면 닫아야 함. 닫힌 스트림에서는 읽을 수 없음
    - close()로 스트림 닫기
```java
fin.close();
```

### 파일 입출력과 예외 처리
1. 파일 입출력 동안 예외 발생 가능
    - 스트림 생성 동안 : FileNotFoundException 발생 가능
        - 파일의 경로명이 틀리거나, 디스크의 고장 등으로 파일을 열 수 없음
```java
FileReader fin = new FileReader("c:\\test.txt"); // FileNotFoundException 발생가능
```
2. 파일 읽기, 쓰기, 닫기를 하는 동안 : IOException 발생 가능
    - 디스크 오동작, 파일이 중간에 깨진 경우, 디스크 공간이 모자라서 파일 입출력 불가
```java
int c = fin.read(); // IOException 발생 가능
```
3. try-catch 블록 반드시 필요
    - 자바 컴파일러의 강제 사항

### 문자 스트림으로 텍스트 파일 쓰기
텍스트 파일에 쓰기 위해 문자 스트림 FileWriter 클래스 이용
1. 파일 출력 스트림 생성(파일 열기)
    - 스트림을 생성하고 파일을 열어 스트림과 연결
```java
FileWriter fout = new FileWriter("c:\\Temp\\test.txt");
```
2. 파일 쓰기
    - write()로 문자 하나 씩 파일에 기록
    - 블록 단위로 쓰기 가능
```java
fout.write('A'); // 문자 'A'를 파일에 기록
char [] buf = new char [1024];
//블록 단위로 사용 가능
fout.write(buf, 0, buf.length); // buf[0]부터 버퍼 크기만큼 쓰기
```
3. 스트림 닫기
    - close()로 스트림 닫기
```java
fout.close(); // 스트림 닫기. 더 이상 스트림에 기록할 수 없다.
```

### 바이트 스트림으로 바이너리 파일 쓰기
1. 바이너리 값을 파일에 저장하기
    - 프로그램 내의 변수, 배열, 버퍼에 든 바이너리 값을 파일에 그대로 기록
        - FileOutputStream 클래스 이용
2. 파일 출력 스트림 생성(파일 열기)
    - 스트림을 생성하고 파일을 열어 스트림과 연결
```java
FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out");
```
3. 파일 쓰기
    - write()로 문자 하나 씩 파일에 기록
```java
byte b[] = {7,51,3,4,-1,24};
for(int i=0; i<b.length; i++) fout.write(b[i]); // 배열 b를 바이너리 그대로 기록
```
4. 스트림 닫기
    - close()로 스트림 닫기

### 바이트 스트림으로 바이너리 파일 읽기
1. 바이너리 파일에서 읽기 위해 FileInputStream 클래스 이용
2. 파일 입력 스트림 생성(파일 열기)
    - 스트림을 생성하고 파일을 열어 스트림과 연결
```java
FileInputStream fin = new FileInputStream("c:\\Temp\\test.out");
```
3. 파일 읽기
    - read()로 문자 하나 씩 파일에서 읽기
    ```java
    int n=0, c;
    while((c = fin.read()) != -1) {
        b[n] = (byte)c; // 읽은 바이트를 배열에 저장
        n++;
    }
    ```
    - 블록 단위로 읽기 가능
    ```java
    fin.read(b); // 배열 b의 바이트 크기만큼 바이너리 그대로 읽기
    ```
4. 스트림 닫기
    - close()로 스트림 닫기

### File 클래스
1. File 클래스
    - 파일의 경로명 및 속성을 다루는 클래스
        - java.io.File
        - 파일과 디렉터리 경로명의 추상적 표현
    - 파일 이름 변경, 삭제, 디렉터리 생성, 크기 등 파일 관리
    - File 객체에는 파일 읽기/쓰기 기능 없음
        - 파일 입출력은 파일 입출력 스트림 이용
2. File 객체 생성
    - 생성자에 파일 경로명을 주어 File 객체 생성
    ```java
    File f = new File("c:\\Temp\\test.txt");
    ```
    - 디렉터리와 파일명을 나누어 생성자 호출
    ```java
    File f = new File("c:\\Temp", "test.txt");
    ```
### File 클래스 활용
1. 파일 크기
    ```java
    long size = f.length();
    ```
2. 파일 경로명
    ```java
    File f = new File("c:\\windows\\system.ini");
    String filename = f.getName(); // "system.ini"
    String path = f.getPath(); // "c:\\windows\\system.ini"
    String parent = f.getParent(); // "c:\\windows"
    ```
3. 디렉터리 파일 리스트 얻기
    ```java
    if(f.isFile())
        System.out.println(f.getPath() + "는 파일입니다."); // 파일
    else if(f.isDirectory())
        System.out.println(f.getPath() + "는 디렉터리입니다."); // 디렉터리
    ```
4. 파일 타입
    ```java
    File f = new File("c:\\Temp");
    File[] subfiles = f.listFiles(); // c:\Temp의 파일 및 서브 디렉터리 리스트 얻기

    for(int i=0; i<filenames.length; i++) {
        System.out.print(subfiles[i].getName()); // 서브 파일명 출력
        System.out.println("\t파일 크기: " + subfiles[i].length()); //서브파일크기출력
    }
    ```

## 14장 자바 소켓 프로그래밍
### TCP/IP 소개
1. TCP/IP 프로토콜
    - 두 시스템 간에 데이터가 손상없이 안전하게 전송되도록 하는 통신 프로토콜
    - TCP에서 동작하는 응용프로그램 사례
        - e-mail, FTP, 웹(HTTP) 등
2. TCP/IP 특징
    - 연결형 통신
        - 한 번 연결 후 계속 데이터 전송 가능
    - 보낸 순서대로 받아 응용프로그램에게 전달

### IP 주소
1. IP 주소
    - 네트워크 상에서 유일하게 식별될 수 있는 컴퓨터 주소
        - 숫자로 구성된 주소
        - 4개의 숫자가 ‘.’으로 연결
            - 예) 192.156.11.15
    - 숫자로 된 주소는 기억하기 어려우므로 www.naver.com과 같은 문자열로 구성된 도메인 이름으로 바꿔 사용
        - DNS(Domain Name System)
            - 문자열로 구성된 도메인 이름을 숫자로 구성된 IP 주소로 자동 변환
    - 현재는 32비트의 IP 버전 4(IPv4)가 사용되고 있음
        - IP 주소 고갈로 인해 128비트의 IP 버전 6(IPv6)이 점점 사용되는 추세
    - 자신의 IP 주소를 간단히 localhost라는 이름으로 사용 가능

### 포트
1. 포트
    - 통신하는 프로그램 간에 가상의 연결단 포트 생성
        - IP 주소는 네트워크 상의 컴퓨터 또는 시스템을 식별하는 주소
        - 포트 번호를 이용하여 통신할 응용프로그램 식별
    - 모든 응용프로그램은 하나 이상의 포트 생성 가능
        - 포트를 이용하여 상대방 응용프로그램과 데이터 교환
    - 잘 알려진 포트(well-known ports)
        - 시스템이 사용하는 포트 번호
        - 잘 알려진 응용프로그램에서 사용하는 포트 번호
            - 0부터 1023 사이의 포트 번호
            - ex) SSH 22, HTTP 80, FTP 21
        - 잘 알려진 포트 번호는 개발자가 사용하지 않는 것이 좋음
            - 충돌 가능성 있음

### 소켓 프로그래밍
1. 소켓 (socket)
    - TCP/IP 네트워크를 이용하여 쉽게 통신 프로그램을 작성하도록 지원하는 기반 기술
    - 소켓
        - 두 응용프로그램 간의 양방향 통신 링크의 한쪽 끝 단
        - 소켓끼리 데이터를 주고받음
        - 소켓은 특정 IP 포트 번호와 결합
    - 자바로 소켓 통신할 수 있는 라이브러리 지원
    - 소켓 종류 : 서버 소켓과 클라이언트 소켓

### Socket 클래스, 클라이언트 소켓
1. Socket 클래스
    - 클라이언트 소켓에 사용되는 클래스
    - java.net 패키지에 포함
    - 생성자

### 클라이언트에서 소켓으로 서버에 접속하는 코드
1. 클라이언트 소켓 생성 및 서버에 접속
    - Socket의 생성자에서 128.12.1.1의 주소의 9999포트에 접속
    ```java
    Socket clientSocket = new Socket("128.12.1.1", 9999);
    ```
        - 소켓으로부터 데이터를 전송할 입출력 스트림 생성
    - 서버로 데이터 전송
        - flush()를 호출하면 스트림 속에 데이터 모두 전송
    - 서버로부터 데이터 수신
    - 네트워크 접속 종료

### ServerSocket 클래스, 서버 소켓
1. ServerSocket 클래스
    - 서버 소켓에 사용되는 클래스, java.net 패키지에 포함

### 서버에 클라이언트가 연결되는 과정
1. 서버는 서버 소켓으로 들어오는 연결 요청을 기다림(listen)
2. 클라이언트가 서버에게 연결 요청
3. 서버가 연결 요청 수락(accept)
4. 새로운 클라이언트 소켓을 만들어 클라이언트와 통신하게 함
5. 그리고 다시 다른 클라이언트의 연결을 기다림


### 서버가 클라이언트와 통신하는 과정
1. 서버 소켓 생성
    - 서버는 9999 포트에서 접속 기다리는 포트로 9999 선택
2. 클라이언트로부터 접속 기다림
    - accept() 메소드는 접속 요청이 오면 접속 후 새 Socket 객체 반환
    - 접속 후 새로 만들어진 Socket 객체를 통해 클라이언트와 통신
3. 네트워크 입출력 스트림 생성
    - Socket 객체의 getInputStream()과 getOutputStream() 메소드를 이용하여 입출력 데이터 스트림 생성

### 서버-클라이언트 채팅 프로그램 만들기
1. 간단한 채팅 프로그램
    - 서버와 클라이언트가 1:1로 채팅
    - 클라이언트와 서버가 서로 한번씩 번갈아 가면서 문자열 전송
        - 문자열 끝에 "\n"을 덧붙여 보내고 라인 단위로 수신
    - 클라이언트가 bye를 보내면 프로그램 종료

### 수식 계산 서버-클라이언트 만들기 실습
1. 문제 개요
    - 서버 클라이언트는 1:1 통신
    - 서버를 먼저 실행시키고, 클라이언트를 실행시켜 서버에 접속
    - 클라이언트는 사용자로부터 수식을 입력 받아 서버로 전송
    - 연산자는 +, -, *의 3가지만 허용하고 정수 연산만 가능
    - 서버가 식을 받으면 식을 서버의 화면에 출력하고, 계산하여 결과를 클라이언트로 전송
    - 클라이언트는 서버로부터 받은 답을 화면에 출력
    - 클라이언트와 서버는 전송할 데이터를 문자열로 만들고 "\n"을 덧붙여 전송하며, 라인 단위로 송수신
    - 클라이언트가 "bye"를 보내면 양쪽 모두 종료

## 6월 7일
## 11장 그래픽
### 스윙 컴포넌트 그리기, paintComponent()
1. 스윙의 페인팅 기본
    - 모든 컴포넌트는 자신의 모양을 스스로 그린다.
    - 컨테이너는 자신을 그린 후 그 위에 자식 컴포넌트들에게 그리기 지시
    - 모든 스윙 컴포넌트는 자신의 모양을 그리는 paintComponent() 메소드 보유
2. public void paintComponent(Graphics g)
    - 스윙 컴포넌트가 자신의 모양을 그리는 메소드
    - JComponent의 메소드 : 모든 스윙 컴포넌트가 이 메소드를 오버라이딩함
    - 언제 호출되는가?
        - 컴포넌트가 그려져야 하는 시점마다 호출
        - 크기가 변경되거나, 위치가 변경되거나, 컴포넌트가 가려졌던 것이 사라지는 등
            - 개발자가 직접 호출하면 안 됨
    - 매개변수인 Graphics 객체
        - 그래픽 컨텍스트 : 컴포넌트 그리기에 필요한 도구를 제공하는 객체
        - 자바 플랫폼에 의해 공급
        - 색 지정, 도형 그리기, 클리핑, 이미지 그리기 등의 메소드 제공

### paintComponent()의 오버라이딩과 JPanel
1. paintComponent(Graphic g)의 오버라이딩
    - 개발자가 JComponent를 상속받아 새로운 컴포넌트 설계
    - 기존 컴포넌트의 모양에 변화를 주고자 할 때
```java
class MComponent extends JXXX {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ... 필요한 그리기 코드 작성
    }
}
```
2. JPanel
    - 비어 있는 컨테이너
    - 개발자가 다양한 GUI를 창출할 수 있는 캔버스로 적합
    - JPanel을 상속받아 개발자 임의의 모양을 가지는 패널로 많이 사용

### 그래픽 기반 GUI 프로그래밍
1. 그래픽 기반 GUI 프로그래밍
    - 스윙 컴포넌트에 의존하지 않고 선, 원 이미지 등을 이용하여 직접 화면을 구성하는 방법
    - 그래픽 기반 GUI 프로그래밍의 학습이 필요한 이유
       - 컴포넌트의 한계를 극복하고 차트, 게임 등 자유로운 콘텐트 표현
       - 그래픽은 컴포넌트에 비해 화면 출력 속도가 빠름
       - 스윙 컴포넌트들로 모두 그래픽으로 작성되어 있어, 그래픽에 대한 학습은 자바 GUI의 바탕 기술을 이해하는데 도움
       - 그래픽을 이용하여 개발자 자신만의 컴포넌트 개발

### Graphics와 문자열 출력
1. Graphics의 기능
    - 색상 선택하기
    - 문자열 그리기
    - 도형 그리기
    - 도형 칠하기
    - 이미지 그리기
    - 클리핑
2. 문자열 출력을 위한 Graphics 메소드
```java
void drawString(String str, int x, int y)
```

### 그래픽의 색과 폰트
1. 색 : Color 클래스
    - 자바의 색 : r(Red), g(Green), b(Blue) 성분으로 구성, 각 성분은 0~255(8비트) 범위의 정수
        - 예) 빨간색 : new Color(255, 0, 0), 초록색 : new Color(0x0000ff00); 노란색 : Color.YELLOW

### 도형 그리기와 칠하기
1. 도형 그리기
    - 선, 타원, 사각형, 둥근 모서리 사각형, 원호, 폐 다각형 그리기
    - 선의 굵기 조절할 수 없음
2. 도형 칠하기
    - 도형을 그리고 내부를 칠하는 기능
        - 도형의 외곽선과 내부를 따로 칠하는 기능 없음
    - 도형 칠하기를 위한 메소드
        - 그리기 메소드 명에서 draw 대신 fill로 이름 대치하면 됨. fillRect(), fillOval() 등

### 스윙에서 이미지를 그리는 2 가지 방법
1. JLabel을 이용한 이미지 그리기
```java
ImageIcon image = new ImageIcon("images/apple.jpg");
    JLabel label = new JLabel(image);
    panel.add(label);
```
    - 장점 : 이미지 그리기 간편 용이
    - 단점 : 이미지의 원본 크기대로 그리므로 이미지 크기 조절 불가
2. Graphics의 drawImage()로 이미지 출력
    - 장점 : 이미지 일부분 등 이미지의 원본 크기와 다르게 그리기 가능
    - 단점 : 컴포넌트로 관리할 수 없음, 이미지의 위치나 크기 등을 적절히 조절하는 코딩 필요

### repaint()
1. repaint()
    - 모든 컴포넌트가 가지고 있는 메소드
    - 자바 플랫폼에게 컴포넌트 그리기를 강제 지시하는 메소드
  - repaint()를 호출하면, 자바 플랫폼이 컴포넌트의 paintComponent() 호출
2. repaint()의 호출이 필요한 경우
    - 개발자가 컴포넌트를 다시 그리고자 하는 경우
        - 프로그램에서 컴포넌트의 모양과 위치를 변경하고 바로 화면에 반영시키고자 하는 경우
        - 컴포넌트가 다시 그려져야 그 때 변경된 위치에 변경된 모양으로 출력됨
        - repaint()는 자바 플랫폼에게 지금 당장 컴포넌트를 다시 그리도록 지시함
3. 부모 컴포넌트부터 다시 그리는 것이 좋음
    - 컴포넌트 repaint()가 불려지면
        - 이 컴포넌트는 새로운 위치에 다시 그려지지만 이전의 위치에 있던 자신의 모양이 남아 있음
    - 부모 컴포넌트의 repaint()를 호출하면
        - 부모 컨테이너의 모든 내용을 지우고 자식을 다시 그리기 때문에 컴포넌트의 이전 모양이 지워지고 새로 변경된 크기나 위치에 그려짐

## 12장 스레드
### 멀티태스킹(multi-tasking) 개념
1. 멀티태스킹
    - 여러 개의 작업(태스크)이 동시에 처리되는 것

### 스레드와 운영체제
1. 스레드(thread)
    - 운영체제에 의해 관리되는 하나의 작업 혹은 태스크
    - 스레드와 태스크(혹은 작업)은 바꾸어 사용해도 무관
2. 멀티스레딩(multi-threading)
    - 여러 스레드를 동시에 실행시키는 응용프로그램을 작성하는 기법
3. 스레드 구성
    - 스레드 코드
        - 작업을 실행하기 위해 작성한 프로그램 코드
        - 개발자가 작성
4. 스레드 정보
    - 스레드 명, 스레드 ID, 스레드의 실행 소요 시간, 스레드의 우선 순위 등
    - 운영체제가 스레드에 대해 관리하는 정보

### 멀티태스킹과 멀티스레딩
1. 멀티태스킹 구현 기술
    - 멀티프로세싱(multi-processing)
        - 하나의 응용프로그램이 여러 개의 프로세스를 생성하고, 각 프로세스가 하나의 작업을 처리하는 기법
        - 각 프로세스 독립된 메모리 영역을 보유하고 실행
        - 프로세스 사이의 문맥 교환에 따른 과도한 오버헤드와 시간 소모의 문제점
    - 멀티스레딩(multi-threading)
        - 하나의 응용프로그램이 여러 개의 스레드를 생성하고, 각 스레드가 하나의 작업을 처리하는 기법
        - 하나의 응용프로그램에 속한 스레드는 변수 메모리, 파일 오픈 테이블 등 자원으로 공유하므로, 문맥 교환에 따른 오버헤드가 매주 작음
        - 현재 대부분의 운영체제가 멀티스레딩을 기본으로 하고 있음

### 자바 스레드(Thread)와 JVM
1. 자바 스레드
    - 자바 가상 기계(JVM)에 의해 스케쥴되는 실행 단위의 코드 블럭
    - 스레드의 생명 주기는 JVM에 의해 관리됨 : JVM은 스레드 단위로 스케쥴링
2. JVM과 자바의 멀티스레딩
    - 하나의 JVM은 하나의 자바 응용프로그램만 실행
        - 자바 응용프로그램이 시작될 때 JVM이 함께 실행됨
        - 자바 응용프로그램이 종료하면 JVM도 함께 종료함
3. 응용프로그램은 하나 이상의 스레드로 구성 가능

### 자바 스레드 만들기
1. 스레드 만드는 2 가지 방법
    - java.lang.Thread 클래스를 상속받아 스레드 작성
    - java.lang.Runnable 인터페이스를 구현하여 스레드 작성

### Thread 클래스를 상속받아 스레드 만들기(2)
1. Thread를 상속받아 run() 오버라이딩
    - Thread 클래스 상속. 새 클래스 작성
    - run() 메소드 작성
        - run() 메소드를 스레드 코드라고 부름
        - run() 메소드에서 스레드 실행 시작
2. 스레드 객체 생성
    - 생성된 객체는 필드와 메소드를 가진 객체일 뿐 스레드로 작동하지 않음
3. 스레드 시작
    - start() 메소드 호출
        - 스레드로 작동 시작
        - 스레드 객체의 run()이 비로소 실행
        - JVM에 의해 스케쥴되기 시작함
```java
class TimerThread extends Thread {
    ....................................................
    @Override
    public void run() { // run() 오버라이딩
        .........................
    }
}
TimerThread th = new TimerThread();
th.start();
```

### Runnable 인터페이스로 스레드 만들기
1. Runnable 인터페이스 구현하는 새 클래스 작성
    - run() 메소드 구현
        - run() 메소드를 스레드 코드라고 부름
        - run() 메소드에서 스레드 실행 시작
2. 스레드 객체 생성
3. 스레드 시작
    - start() 메소드 호출
        - 스레드로 작동 시작
        - 스레드 객체의 run()이 비로소 실행
        - JVM에 의해 스케쥴되기 시작함

### main 스레드
1. main 스레드
    - JVM이 응용프로그램을 실행할 때 디폴트로 생성되는 스레드
        - main() 메소드 실행 시작
        - main() 메소드가 종료하면 main 스레드 종료

### 스레드 종료와 타 스레드 강제 종료
1. 스스로 종료
    - run() 메소드 리턴
2. 타 스레드에서 강제 종료
    - interrupt() 메소드 사용
```java
public static void main(String [] args) {
    TimerThread th = new TimerThread();
    th.start();
    th.interrupt(); // TimerThread 강제 종료
}

class TimerThread extends Thread {
    int n = 0;
    @Override
    public void run() {
        while(true) {
        System.out.println(n); // 화면에 카운트 값 출력
        n++;
            try {
                sleep(1000);
            }
            catch(InterruptedException e){
                return; // 예외를 받고 스스로 리턴하여 종료
            }
        }
    }
}
```

### 스레드 동기화(Thread Synchronization)
1. 멀티스레드 프로그램 작성시 주의점
    - 다수의 스레드가 공유 데이터에 동시에 접근하는 경우
        - 공유 데이터의 값에 예상치 못한 결과 발생 가능
2. 스레드 동기화
    - 동기화란?
        - 스레드 사이의 실행순서 제어, 공유데이터에 대한 접근을 원활하게 하는 기법
    - 멀티스레드의 공유 데이터의 동시 접근 문제 해결
        - 방법1) 공유 데이터를 접근하는 모든 스레드의 한 줄 세우기
        - 방법2) 한 스레드가 공유 데이터에 대한 작업을 끝낼 때까지 다른 스레드가 대기 하도록 함
3. 자바의 스레드 동기화 방법 - 2가지
    - synchronized 키워드로 동기화 블록 지정
    - wait()-notify() 메소드로 스레드의 실행 순서 제어

### synchronized 블록 지정
1. synchronized 키워드
    - 스레드가 독점적으로 실행해야 하는 부분(동기화 코드)을 표시하는 키워드
        - 임계 영역(criitical section) 표기 키워드
    - synchronized 블록 지정 방법
        - 메소드 전체 혹은 코드 블록
2. synchronized 블록이 실행될 때,
    - 먼저 실행한 스레드가 모니터 소유
        - 모니터란 해당 객체를 독점적으로 사용할 수 있는 권한
    - 모니터를 소유한 스레드가 모니터를 내놓을 때까지 다른 스레드 대기

### wait()-notify()를 이용한 스레드 동기화
1. wait()-notify()가 필요한 경우
    - 공유 데이터로 두 개 이상의 스레드가 데이터를 주고 받을 때
        - producer-consumer문제
2. 동기화 메소드
    - wait() : 다른 스레드가 notify()를 불러줄 때까지 기다린다.
    - notify() : wait()를 호출하여 대기중인 스레드를 깨운다.
        - wait(), notify()는 Object의 메소드



## 5월 31일
## 10장 스윙 컴포넌트 활용
### 자바의 GUI 프로그래밍 방법
1. 자바의 GUI 프로그래밍 방법 2종류
    - 컴포넌트 기반 GUI 프로그래밍
        - 스윙 컴포넌트를 이용하여 쉽게 GUI구축
        - 자바에서 제공하는 컴포넌트의 한계를 벗어나지 못함
    - 그래픽 기반 GUI 프로그래밍
        - 그래픽을 이용하여 GUI 구축

### 스윙컴포넌트의 공통 메소드 , JComponent의 메소드
1. JComponent
    - 스윙 컴포넌트는 모두 상속받는 슈퍼 클래스, 추상 클래스
    - 스윙 컴포넌트들이 상속받는 공통 메소드와 상수 구현
    - JComponent의 주요 메소드 사례

### JLabel로 문자열과 이미지 출력
1. JLabel의 용도
    - 문자열이나 이미지를 화면에 출력하기 위한 목적

### 이미지 버튼 만들기
1. 하나의 버튼에 3개의 이미지 등록
    - 마우스 조작에 따라 3개의 이미지 중 적절한 이미지 자동 출력

### JCheckBox로 체크박스 만들기
1. 용도
    - 선택과 비선택 두 상태만 가지는 버튼

### JRadioButton으로 라디오 버튼 만들기
1. 용도
    - 버튼 그룹을 형성하고, 그룹에 속한 버튼중 하나만 선택되는 라디오 버튼
    - 체크박스와의 차이점
        - 체크 박스는 각각 선택/해제가 가능하지만, 라디오버튼은 그룹에 속한 버튼 중 하나만 선택

### JTextField 한 줄 입력 창 만들기
1. JTextField
    - 한 줄의 문자열을 입력 받는 창(텍스트필드)
    - 텍스트 입력 도중 <Enter>키가 입력되면 Action 이벤트 발생
    - 입력 가능한 문자 개수와 입력 창의 크기는 서로 다름

### TextArea로 여러 줄의 입력 창 만들기
1. JTextArea
    - 여러 줄의 문자열을 입력받을 수 있는 창(텍스트영역)
    - 스크롤바를 지원하지 않는다.
    - JScrollPane 객체에 삽입하여 스크롤바 지원받음

### JList< E >
1. JList< E >
    - 하나 이상의 아이템을 보여주고 아이템을 선택하도록 하는 리스트
    - Java 7부터 제네릭 리스트로 바뀜
        - < E >에 지정된 타입의 객체만 저장하는 리스트
2. JScrollPane에 JList< E >를 삽입하여 스크롤 가능
```java
import javax.swing.*;
import java.awt.*;
public class ListEx extends JFrame {
    private String [] fruits= {"apple", "banana", "kiwi", "mango",
        "pear", "peach", "berry", "strawberry", "blackberry"};
    private ImageIcon [] images = { new ImageIcon("images/icon1.png"),
    new ImageIcon("images/icon2.png"),
    new ImageIcon("images/icon3.png"),
    new ImageIcon("images/icon4.png") };

    public ListEx() {
        setTitle("리스트 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JList<String> strList = new JList<String>(fruits);
        c.add(strList);

        JList<ImageIcon> imageList = new JList<ImageIcon>();
        imageList.setListData(images);
        c.add(imageList);
        
        JList<String> scrollList = new JList<String>(fruits);
        c.add(new JScrollPane(scrollList));

        setSize(300,300); 
        setVisible(true);
    }
    public static void main(String [] args) {
        new ListEx();
    }
}
```

### JComboBox< E >
1. JComboBox< E >
    - 텍스트필드와 버튼, 그리고 드롭다운 리스트로 구성되는 콤보박스
    - 드롭다운 리스트에서 선택한 것이 텍스트필드에 나타남
```java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ComboActionEx extends JFrame {
    private String [] fruits = {"apple", "banana", "mango"};
    private ImageIcon [] images = { new ImageIcon("images/apple.jpg"),
    new ImageIcon("images/banana.jpg"),
    new ImageIcon("images/mango.jpg") };

    private JLabel imgLabel = new JLabel(images[0]);
        public ComboActionEx() {
            setTitle("콤보박스 활용 예제");
            Container c = getContentPane();
            c.setLayout(new FlowLayout());

            JComboBox<String> combo = new JComboBox<String>(fruits);

            c.add(combo); 
            c.add(imgLabel);
            // 콤보박스에 Action 리스너 등록. 선택된 아이템의 이미지 출력
            combo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JComboBox<String> cb = (JComboBox<String>)e.getSource();
                    int index = cb.getSelectedIndex();
                    imgLabel.setIcon(images[index]);
                }   
            });
            setSize(300,250);
            setVisible(true);
        }
    public static void main(String [] args) {
        new ComboActionEx();
    }
}
```
### 메뉴 구성
1. 메뉴 만들기에 필요한 스윙 컴포넌트
    - 메뉴아이템 – JMenuItem
    - 메뉴 – JMenu
        - 여러 개의 메뉴 아이템을 가짐
    - 메뉴바 – JMenuBar
        - 여러 개의 메뉴를 붙이는 바이며, 프레임에 부착됨
    - 분리선
        - 메뉴아이템 사이의 분리선으로 separator라고 부름
        - JMenu의 addSeparator()를 호출하여 삽입함
```java
import javax.swing.*;
public class MenuEx extends JFrame {
    public MenuEx() {
        setTitle("Menu 만들기 예제");
        createMenu(); // 메뉴 생성, 프레임에 삽입
        setSize(250,200);
        setVisible(true);
    }
    public void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu screenMenu = new JMenu("Screen");

        screenMenu.add(new JMenuItem("Load"));
        screenMenu.add(new JMenuItem("Hide"));
        screenMenu.add(new JMenuItem("ReShow"));
        screenMenu.addSeparator();
        screenMenu.add(new JMenuItem("Exit"));

        mb.add(screenMenu);
        mb.add(new JMenu("Edit"));
        mb.add(new JMenu("Source"));
        mb.add(new JMenu("Project"));
        mb.add(new JMenu("Run"));
        setJMenuBar(mb);
    }
    public static void main(String [] args) {
        new MenuEx();
    }
}
```
### 팝업 다이얼로그, JOptionPane
1. 팝업 다이얼로그
    - 사용자에게 메시지를 전달하거나 문자열을 간단히 입력받는 용도
    - JOptionPane 클래스를 이용하여 생성
        - static 타입의 간단한 메소드 이용
2. 입력 다이얼로그 - JOptionPane.showInputDialog()

### 확인 다이얼로그
1. 확인 다이얼로그 - JOptionPane.showConfirmDialog()
    - 사용자로부터 Yes/No 응답을 입력 받는 다이얼로그

### 메시지 다이얼로그
1. 메시지 다이얼로그 – showMessageDialog
    - 단순 메시지를 출력하는 다이얼로그


## 5월 24일
## 9장 자바의 이벤트 처리
### 이벤트 기반 프로그래밍
1. 이벤트 기반 프로그래밍
    - 이벤트의 발생에 의해 프로그램 흐름이 결정되는 방식
        - 이벤트가 발생하면 이벤트를 처리하는 루틴(이벤트 리스너)실행
        - 실행될 코드는 이벤트의 발생에 의해 전적으로 결정
    - 반대되는 개념 : 배치 실행
        - 프로그램이 개발자가 프로그램의 흐름을 결정하는 방식
    - 이벤트 종류
        - 사용자의 입력 : 마우스 드래그, 마우스 쿨릭, 키보드 누름 등
        - 센서로부터의 입력, 네트워크로부터의 데이터 송수신
        - 다른 응용프로그램이나 다른 스레드로부터의 메시지
    - 이벤트 기반 응용 프로그램의 구조
        - 각 이벤트마다 처리하는 리스너 코드 보유
    - GUI 응용프로그램은 이벤트 기반 프로그래밍으로 작성됨
        - GUI 라이브러리 종류
            - C++의 MFC, C# GUI, Visual Basic, X Window, Android 등
            - 자바의 AWT와 Swing

### 자바 스윙 프로그램에서 이벤트 처리 과정
1. 이벤트가 처리되는 과정
    - 이벤트 발생
        - 예 : 마우스의 움직임 혹은 키보드입력
    - 이벤트 객체 생성
        - 현재 발생한 이벤트에 대한 정보를 가진 객체
    - 응용프로그램에 작성된 이벤트 리스너 찾기
    - 이벤트 리스너 실행
        - 리스너에 이벤트 객체 전달
        - 리스너 코드 실행

### 이벤트 객체
1. 이벤트 객체
    - 발생한 이벤트에 관한 정보를 가진 객체
    - 이벤트 리스너에 전달됨
        - 이벤트 리스너 코드가 발생한 이벤트에 대한 상황을 파악할 수 있게 함
2. 이벤트 객체가 포함되는 정보
    - 이벤트 종류와 소스
    - 이벤트가 발생한 화면 좌표 및 컴포넌트 내 좌표
    - 이밴트가 발생한 버튼이나 메뉴 아이템의 문자열
    - 클릭된 마우스 버튼 번호 및 마우스의 클릭 횟수
    - 키의 코드 값과 문자 값
    - 체크박스, 라디오버튼 등과 같은 컴포넌트에 이벤트가 발생하였다면 체크 상태
3. 이벤트 소스를 알아 내는 메소드
    - Object getSource()
        - 발생한 이벤트의 소스 컴포넌트 리턴
        - Object 타입으로 리턴하므로 캐스팅하여 사용
        - 모든 이벤트 객체에 대해 적용

### 리스너 인터페이스
1. 이벤트 리스너
    - 이벤트를 처리하는 자바 프로그램 코드, 클래스로 작성
2. 자바는 다양한 리스너 인터페이스 제공
    - 예) ActionListener 인터페이스 - 버튼 클릭 이벤트를 처리하기 위한 인터페이스
    - 예) MouseListener 인터페이스 - 마우스 조작에 따른 이벤트를 처리하기 위한 인터페이스
3. 사용자의 이벤트 리스너 작성
    - 자바의 리스너 인터페이스를 상속받아 구현
    - 리스너 인터페이스의 모든 추상 메소드 구현

### 이벤트 리스너 작성 과정 사례
1. 이벤트와 이벤트 리스너 선택
    - 버튼 클릭을 처리하고자 하는 경우
        - 이벤트 : Action 이벤트, 이벤트 리스너 : ActionListener
2. 이벤트 리스너 클래스 작성 : ActionListner 인터페이스 구현
```java
class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {        //버튼이 클릭될 때 호출되는 메소드
        JButton b = (JButton)e.getSource();             //사용자가 클릭한 버튼 알아내기
        if(b.getText().equals("Action"))                //버튼의 문자열이 "Action"인지 비교
            b.setText("액션");                          //JButton의 setText()호출문자열변경
        else
            b.setText("Action");                        //JButton의 setText()호출문자열변경
    }
}
```
3. 이벤트 리스너 등록
    - 이벤트를 받아 처리하고자 하는 컴포넌트에 이벤트 리스너 등록
    - comnponent.addXXXListener(listener)
        - xxx : 이벤트 명, listener : 이벤트 리스너 객체

### 이벤트 리스너 작성 방법
1. 3가지 방법
    - 독립 클래스로 작성
        - 이벤트 리스너를 완전한 클래스로 작성
        - 이벤트 리스너를 여러 곳에서 사용할 떄 적합
    - 내부 클래스로 작성
        - 클래스 안에 멤버처럼 클래스 작성
        - 이벤트 리스너를 특정 클래스에서만 사용할 떄 적합
    - 익명 클래스로 작성
        - 클래스의 이름 없이 간단히 리스너 작성
        - 클래스 조차 만들 필요 없이 리스너 코드가 간단한 경우에 적합

### 익명 클래스로 이벤트 리스너 작성
1. 익명 클래스 : 이름 없는 클래스
    - (클래스 선언 + 인스턴스 선언)을 한번에 달성
```java
new 익명클래스의 슈퍼클래스 이름(생성자 인자들) {
    .............
    익명 클래스의 멤버 구현
    .............
};
```
2. 간단한 리스너의 경우 익명 클래스 사용 추천
    - 메소드의 개수가 1, 2개인 리스너(ActionListener, ItemListener)에 대해 주로 사용

### Key 이벤트와 포커스
1. 키 입력 시, 다음 세 경우 각각 Key 이벤트 발생
    - 키를 누르는 순간
    - 누른 키를 떼는 순간
    - 누른 키를 떼는 순간(Unicode 키의 경우에만)
2. 키 이벤트를 받을 수 있는 조건
    - 모든 컴포넌트
    - 현재 포커스를 가진 컴포넌트가 키 이벤트 독점
3. 포커스(focus)
    - 컴포넌트나 응용프로그램이 키 이벤트를 독점하는 권한
    - 컴포넌트에 포커스 설정 방법 : 다음 2 라인 코드 필요
        - 자바플랫폼마다 실행 환경의 초기화가 서로 다를 수 있기 때문에 다음 코드가 필요함
            - component.setFocusable(true);
```java
component.setFocusable(true);   //component가 포커스를 받을 수 있도록 설정
component.requestFocus();       //component에 포커스 강제 지정
```

### KeyListener
1. 응용프로그램에서 KeyListener를 상속받아 키 리스너 구현

### 유니코드 키
1. 유니코드 키의 특징
    - 국제 산업 표준
    - 전 세계의 문자를 컴퓨터에서 일관되게 표현하기 위한 코드 체계
    - 문자들에 대해서만 키 코드 값 정의
        - A~Z, a~z, 0~9, !, @, & 등
    - 문자가 아닌 키 경우에는 표준화된 키 코드 값 얻음
        - Function, Home, Up, Control, Shift, Alt 키 등은 플랫폼에 따라 키 코드 값이 다를 수 있음

### 가상 키와 입력된 키 판별
1. KeyEvent 객체
    - 입력된 키 정보를 가진 이벤트 객체
    - KeyEvnet 객체의 메소드로 입력된 키 판별
2. KeyEvent 객체의 메소드로 입력된 키 판별
    - char KeyEvent.getKeyChar()
        - 키의 유니코드 문자 값 리턴
        - Unicode 문자 키인 경우에만 의미 있음
        - 입력된 키를 판별하기 위해 문자 값과 비교하면 됨
    - int KeyEvent.getKeyCode()
        - 유니코드 키 포함
        - 모든 키에 대한 정수형 키 코드 리턴
        - 입력된 키를 판별하기 위해 가상키값과 비교하여야함
        - 가상 키 가뵤은 KeyEvent클래스에 상수로 선언

### 마우스 리스너 달기와 MouseEvent객체 활용
1. 마우스 리스너 달기
    - 마우스 리스너는 컴포넌트에 다음과 같이 등록
```java
component.addMouseListener(myMouseListener)
```


## 5월 17일
### 컨테이너와 배치, 배치관리자 개념
1. 컨테이너의 배치관리자
    - 컨테이너마다 하나의 배치관리자 존재
    - 컨테이너에 부착되는 컴포넌트의 위치와 크기 결정
    - 컨테이너의 크기가 변경되면, 컴포넌트의 위치와 크기 재결정

### 배치 관리자 대표 유형 4가지
1. FlowLayout 배치관리자
    - 컴포넌트가 삽입되는 순서대로 왼쪽에서 오른쪽으로 배치
    - 배치할 공간이 없으면 아래로 내려와서 반복한다
2. BorderLayout 배치관리자
    - 컨테이너의 공간을 동(EAST), 서(WEST), 남(SOUTH), 북(NORTH), 중앙(CENTER)의 5개 영역으로 나눔
    - 5개 영역 중 응용프로그램에서 지정한 영역에 컴포넌트 배치
3. GridLayout 배치관리자
    - 컨테이너를 프로그램에서 설정한 크기와 동일한 크기의 2차원 격자로 나눔 
    - 컴포넌트는 삽입 순서대로 좌에서 우로, 다시 위에서 아래로 배치
4. CardLayout
    - 컨테이너의 공간에 카드를 쌓아 놓은 듯이 컴포넌트를 포개어 배치
5. java.awt 패키지에 구현되어 있음

### 컨테이너와 디폴트 배치관리자
1. 컨테이너의 디폴트 배치관리자
    - 컨테이너 생성시 자동으로 생성되는 배치관리자

### 컨테이너에 새로운 배치관리자 설정
1. 컨테이너에 새로운 배치관리자 설정
    - setLayout 메소드 호출
        - lm을 새로운 배치관리자로 설정
2. 사례
    - JPanel 컨테이너에 BorderLayout 배치관리자를 설정하는 예
```java
JPanel p = new JPanel();
p.setLayout(new BorederLayout());   //JPanel에 BorederLayout 설정
```



```java
Container c = frame.getConentPane();        //프레임의 컨탠트팬 알아내기
c.setLayout(new FlowLayout());              //컨탠트팬에 FlowLayout 생성
```

### FlowLayout 배치관리자
1. 배치방법
    - 컨포넌트를 컨테이너 내에 왼쪽에서 오른쪽으로 배치
        - 다시 위에서 아래로 순서대로 배치

### FlowLayout의 생성자
1. 생성자
    - FlowLayout()
    - FlowLayout(int align, int hGap, int vGap)
        - align : 컴포넌트를 정렬하는 방법 지정. 왼쪽 정렬(FlowLayout.LEFT), 오른쪽 정렬(FlowLayout.RIGHT), 중앙 정렬(FlowLayout.CENTER)
        - hGap : 좌우 두 컴포넌트 사이의 수평 간격, 픽셀 단위. 디폴트는 5
        - vGap : 상하 두 컴포넌트 사이의 수직 간격, 픽셀 단위. 디폴트는 5

### BorderLayoyt 배치관리자
1. 배치방법
    - 컨테이너 공간을 5구역으로 분할, 배치
        - 동, 서, 남, 북, 중앙
    - 배치 방법
        - add(Component comp, int index)
            - comp를 index의 공간에 배치

### BorederLayout 생성자와 add() 메소드
1. 생성자
    - BorderLayout()
    - BorderLayout(int hGap, int vGap)

### GridLayout 배치관리자
1. 배치방법
    - 컨테이너 공간을 동일한 사각형 격자(그리드)로 분할하고 각 셀에 컴포넌트 하나씩 배치
        - 생성자에 행수와 열수 지정
        - 세렝 왼쪽에서 오른쪽으로, 다시 위에서 아래로 순서대로 배치

### GridLayout 생성자
1. 생성자
    - GridLayout()
    - GridLayout(int rows, int cols)
    - GridLayout(int rows, int cols, int hGap, int vGap)

### 배치관리자 없는 컨테이너
1. 배치관리자가 없는 컨테이너가 필요한 경우
     - 응용프로그램에서 직접 컴포넌트의 크기와 위치를 결정하고자 하는 경우
        1. 컴포넌의 크기나 위치를 개발자 임의로 결정하고자 하는 경우
        2. 게임 프로그램과 같이 시간이나 마우스/키보드의 입력에 따라 컴포넌트들의 위치와 크기가 수시로 바뀌는 경우

### 컴포넌트의 절대 위치와 크기 설정
1. 배치관리자가 없는 컨테이너에 컴포넌트를 삽입할 때
    - 프로그램에서 컴포넌트의 절대 크기와 위치 설정
    - 컴포넌트들이 서로 겹치게 할 수 있음

## 5월 3일
## 7장 컬렉션과 제네릭
### 컬렉션의 개념
1. 컬렉션
    - 요소라고 불리는 가변 개수의 객체들의 저장소
        - 객체들의 컨테이너라고도 불림
        - 요소의 개수에 따라 크기 자동 조절
        - 요소의 삽입, 삭제에 따른 요소의 위치 자동 이동
    - 고정 크기의 배열을 다루는 어려움 해소
    - 다양한 객체들의 삽입, 삭제, 검색 등의 관리 용이

### 컬렉션의 특징
1. 컬렉션은 제네릭 기법으로 구현
    - 제네릭
        - 특정 타입만 다루지 않고, 여러 종류의 타입으로 변신할 수 있도록 클래스나 메소드를 일반화시키는 기법
        - 클래스나 인터페이스 이름에 < E >, < K >, < V > 등 타입매개변수 포함
    - 제네릭 컬렉션 사례 : 벡터 Vector< E >
        - < E >에서 E에 구체적인 타입을 주어 구체적인 타입만 다루는 벡터로 활용
        - 정수만 다루는 컬렉션 벡터 Vector< Integer >
        - 문자열만 다루는 컬렉션 벡터 Vector< String >
2. 컬렉션의 요소는 객체만 가능
    - int, char, double 등의 기본 타입으로 구체화 불가

### 제네릭의 기본 개념
1. 제네릭
    - JDK 1.5부터 도입
    - 모든 종류의 데이터 타입을 다룰 수 있도록 일반화된 타입 매게 변수로 클래스(인터페이스)나 메소드를 작성하는 기법
    - C++의 템플릿과 동일

### Vector< E >
1. 벡터 Vector< E >의 특성
    - < E >에 사용할 요소의 특정 타입으로 구체화
    - 배열을 가변 크기로 다룰 수 있게 하는 컨테이너
        - 배열의 길이 제한 극복
        - 요소의 개수가 넘치면 자동으로 길이 조절
    - 요소 객체들을 삽입, 삭제, 검색하는 컨테이너
        - 삽입, 삭제에 따라 자동으로 요소의 위치 조정
    - Vector에 삽입 가능한 것
        - 객체, null
        - 기본 타입의 값은 Wrapper객체로 만들어 저장
    - Vector에 객체 삽입
        - 벡터의 맨 뒤, 중간에 객체 삽입 가능
    - Vector에서 객체 삭제
        - 임의의 위치에 있는 객체 삭제 가능

### Vector< Integer > 활용 사례
```java
Vector<Integer> v = new Vector<Integer>(7); //벡터 생성
```

```java
v.add(5);
v.add(4);       //요소 삽입
v.add(-1);  
```

```java
int n = v.size();           //요소 개수 n
int c = v.capacity();      //벡터의 용량 c
```

```java
v.add(2, 100);  //요소 중간 삽입
```

```java
integer obj = v.get(1); //요소 얻어내기
int i =obj.intValue();
```

```java
v.remove(1);    //요소 삭제
```

```java
int last = v.lastElement();     //마지막 요소
```

```java
v.removeAllElements();          //모든 요소 삭제
```

### 컬렉션과 자동 박싱/언박싱
1. JDK 1.5 이전
    - 기본 타입 데이터를 Wrapper객체로 만들어 삽입
    - 컬렉션으로부터 요소를 얻어올 때, Wrapper 클래스로 캐스팅 필요
2. JDK 1.5부터
    - 자동박싱/언박싱이 작동하여 기본 타입 값 삽입 가능
        - 그러나 타입 매개 변수를 기본 타입으로 구체화할 수는 없음

### 컬렉션 생성문의 진화 : Java 7, Java 10
1. Java 7 이후
    - 컴파일러의 타입 추론 기능 추가
    - <>(다이아몬드 연산자)에 타입 매개변수 생략

### ArrayList < E >
1. 가변 크기 배열을 구현한 클래스
    - < E >에 요소로 사용할 특정 타입으로 구체화
2. 벡터와 거의 동일
    - 요소 삽입, 삭제, 검색 등 벡터 기능과 거의 동일
    - 벡터와 달리 스레드 동기화 기능 없음
        - 다수 스레드가 동시에 ArrayList에 접근할 때 동기화되지 않음. 개발자가 스레드 동기화 코드 작성

### ArrayList < String > 컬렉션 활용 사례
```java
ArrayList<String> a = new ArrayList<String>(7); //ArrayList 생성
```

```java
v.add("Hello");
v.add("Hi");       //요소 삽입
v.add("Java");  
```

```java
int n = a.size();           //요소 개수 n
int c = a.capacity();      //capacity() 메소드 없음
```

```java
a.add(2, "Sahni");  //요소 중간 삽입
```

```java
String str = a.get(1); //요소 알아내기
```

### 컬렉션의 순차 검색을 위한 Iterator
1. Iterator < E > 인터페이스
    - 리스트 구조의 컬렉션에서 요소의 순차 검색을 위한 인터페이스
        - Vector < E >, ArrayList < E >, LinkedList < E >가 상속받는 인터페이스
2. Iterator 객체 얻어내기
    - 컬렉션의 iterator() 메소드 호출
        - 해당 컬렉션을 순차 검색할 수 있는 Iterator 객체 리턴
    - 컬렉션 검색 코드
    ```java
    while(it.hasNext()) {       //모든 요소 방문
        int n = it.next();      //다음 요소 리턴
        ...
    }
    ```

### HashMap < K, V >
1. 키(Key)와 값(Value)의 쌍으로 구성되는 요소를 다루는 컬렉션
    - K : 키로 사용할 요소의 타입
    - V : 값으로 사용할 요소의 타입
    - 키와 값이 한 쌍으로 삽입
    - '값'을 검색하기 위해서는 반드시 '키' 이용
2. 삽입 및 검색이 빠른 특징
    - 요소 삽입 : put() 메소드
    - 요소 삽입 : get() 메소드

### HashMap< String, String > 컬렉션 활용 사례
```java
HashMap<String, String> h = new HashMap<String, String>();      //해시맵 생성
```

```java
h.put("baby", "아기");
h.put("love", "사랑");          //(키, 값) 삽입
h.put("apple", "사과");
```

```java
String kor = h.get("love");     //키로 값 읽기
```

```java
h.remove("apple");          //키로 요소 삭제
```

```java
int n = h.size();           //요소 개수
```

### 제네릭 만들기
1. 제네릭 클래스 작성
    - 클래스 이름 옆에 일반화된 타입 매개 변수 추가
2. 제네릭 객체 생성 및 활용
    - 제네릭 타입에 구ㅊ적인 타입을 지정하여 객체를 생성하는 것을 구체화라고 함

### 자바의 GUI
1. GUI 응용프로그램
    - GUI
        - 사용자가 편리하게 입출력 할 수 있도록 그래픽으로 화면을 구성하고, 마우스나 키보드로 입력 받을 수 있도록 지원하는 사용자 인터페이스
    - 자바 언어에서 GUI 응용프로그램 작성
        - AWT와 Swing 패키지에 강력한 GUI 컴포넌트 제공
        - 쉬운 GUI 프로그래밍
2. AWT와 Swing 패키지
    - AWT패키지
        - 자바가 처음 나왔을때부터 배포된 GUI패키지, 최근에는 거의 사용하지 않음
    - Swing패키지
        - AWT기술을 기반으로 작성된 자바 라이브러리
        - 모든 AWT기능 + 추가된 풍부하고 화려한 고급 컴포넌트
        - AWT 컴포넌트를 모두 스윙으로 제작성. AWT 컴포넌트 이름 앞에 J자를 덧붙임
        - 순수 자바언어로 구성돰
        - 현재 자바의 GUI로 사용됨

### 컨테이너와 컴포넌트
1. 컨테이너
    - 다른 컴포넌트를 포함할 수 있는 GUI 컴포넌트
        - java.awt.Container를 상속받음
    - 다른 컨테이너에 포함될 수 있음
        - AWT 컨테이너 : Pannel, Frame, Applet, Dialog, Window
        - Swing 컨테이너 : JPannel, JFrame, JApplet, JDialog, JWindow
2. 컴포넌트
    - 컨테이너에 포함되어야 화면에 출력될 수 있는 GUI 객체
    - 다른 컴포넌트를 포함할 수 없는 순수 컴포넌트
    - 모든 GUI 컴포넌트가 상속받는 클래스 : java.awt.Component
    - 스윙 컴포넌트가 상속받는 클래스 : javax.swing.JComponent
3. 최상위 컨테이너
    - 다른 컨테이너에 포함되지 않고도 화면에 출력되며 독립적으로 존재 가능한 컨테이너
        - 스스로 화면에 자신을 출력하는 컨테이너 : JFrame, JDialog, JApplet

### 스윙 GUI 프로그램 만들기
1. 스윙 GUI프로그램을 만드는 과정
    - 스윙 프레임 만들기
    - main() 메소드 작성
    - 스윙 프레임에 스윙 컴포넌트 붙이기

### 스윙 프레임
1. 스윙 프레임 : 모든 스윙 컴포넌트를 담는 최상위 컨테이너
    - JFrame을 상속받아 구현
    - 컴포넌트들은 화면에 보이려면 스윙 프레임에 부탁되어야 함
        - 프레임을 닫으면 프레임에 부착된 모든 컴포넌트가 보이지 않게 됨
2. 스윙 프레임 기본 구성
    - 프레임
    - 메뉴바
    - 컨텐트팬

### 프레임 만들기, JFrame 클래스 상속
1. 스윙 프레임
    - JFrame클래스를 상속받은 클래스 작성
    - 프레임의 크기 반드시 지정 : setsize() 호출
    - 프레임을 화면에 출력하는 코드 반드시 필요 : setVisible(true)호출

### 스윙 응용프로그램에서 main()의 기능과 위치
1. 스윙 응용프로그램에서  main()의 기능 최소화 바람직
    - 스윙 응용프로그램이 실행되는 시작점으로서의 기능만
    - 스윙 프레임을 생성하는 정도의 코드로 최소화

### 프레임에 컴포넌트 붙이기
1. 타이틀 달기
    - super()나 setTitle() 이용
2. 컨텐트팬에 컴포넌트 달기
    - 컨텐트팬 : 스윙 컴포넌트들이 부탁되는 공간
3. 컨텐트팬 알아내기
    - 스윙 프레임에 붙은 디폴트 컨텐트팬 알아내기
4. 컨텐트팬에 컴포넌트 붙이기
5. 컨텐트팬 변경












## 4월 19일
### 메소드 오버라이딩의 개념
1. 메소드 오버라이딩
    - 서버 클래스에서 슈퍼 클래스의 메소드 중복 작성
    - 슈포 클래스의 메소드 무력화, 항상 서브 클래스에 오버라이딩한 메소드가 실행되도록 보장됨
    - "메소드 무시하기"로 번역되기도 함
2. 오버라이딩 조건
    - 슈퍼 클래스 메소드의 원형(메소드 이름, 인자 타입 및 개수, 리턴 타입) 동일하게 작성
```java
class A {
    void f() {
        System.out.println("A의 f() 호출");
    }
}
class B extends A {
    void f() {
        System.out.println("B의 f() 호출");
    }
}
```

### 오버라이딩의 목적, 다형성 실현
1. 오버라이딩으로 다형성 실현
    - 하나의 인터페이스(같은 이름)에 서로 다른 구현

### 동적 바인딩 - 오버라이딩된 메소드 호출
1. SuperObject 하나만 있는 응용프로그램의 경우 혹은 상속받은 경우 모두 동적 바인딩을 한다.

### super 키워드로 슈퍼 클래스의 멤버 접근
1. super
    - 슈퍼 클래스의 멤버를 접글할 때 사용되는 레퍼런스
    - 서브 클래스에서만 사용
    - 슈퍼 클래스의 필드 접근
    - 슈퍼 클래스의 메소드 호출 시
    - super로 이루어지는 메소드 호출 : 정적 바인딩
```java
super.슈퍼클래스의멤버
```

### 오버로딩과 오버라이딩
1. 오버로딩
    - 같은 클래스나 상속 관계에서 동일한 이름의 메소드 중복 작성
    - 동일한 클래스 내 혹은 상속 관계
    - 이름이 같은 여러 개의 메소드를 중복 선언하여 사용의 편리성 향상
    - 메소드 이름은 항상 동일함
    - 정적 바인딩. 컴파일 시에 중복된 메소드 중 호출되는 메소드 결정

### 추상 클래스
1. 추상 메소드
    - abstract로 선언된 메소드, 메소드의 코드는 없고 원형만 선언
```java
abstract public String getName(); //추상 메소드
```
2. 추상 클래스
    - 추상 메소드를 가지며, abstract로 선언된 클래스
    - 추상 메소드 없이, abstract로 선언한 클래스
```java
//추상 메소드를 가진 추상 클래스
abstract class Shape {
    public Shape() {...}
    public void edit() {...}

    abstract public void draw(); //추상 메소드
}
```
3. 추상 클래스는 온전한 클래스가 아니기 때문에 인스턴스를 생성할 수 없음

### 추상 클래스의 상속과 구현
1. 추상 클래스 상속
    - 추상 클래스를 상속받으면 추상 클래스가 됨
    - 서브 클래스도 abstract로 선언해야 함
```java
abstract class A { //추상 클래스
    abstract public int add(int x, int y);  //추상 메소드
}
abstract class B extends A { //추상 클래스
    public void show() { System.out.println("B");}
}
```
2. 추상 클래스 구현
    - 서브 클래스에서 슈퍼 클래스의 추상 메소드 구현(오버라이딩)
    - 추상 클래스를 구현한 서브 클래스는 추상 클래스 아님

### 추상 클래스의 목적
1. 추상 클래스의 목적
    - 상속을 위한 슈퍼 클래스로 활용하는 것
    - 서브 클래스에서 추상 메소드 구현
    - 다형성 실현

### 인터페이스의 필요성
1. 정해직 규격(인터페이스)에 맞기만 하면 연결 가능. 각 회사마다 구현 방법은 다름
2. 정해진 규격(인터페이스)에 맞지 않으면 연결불가

### 자바의 인터페이스
1. 자바의 인터페이스
    - 클래스가 구현해야 할 메소드들이 선언되는 추상형
    - 인터페이스 선언
        - interface 키워드로 선언
```java
public interface SerialDriver {...}
```
2. 자바 인터페이스에 대한 변화
    - Java 7까지
        - 인터페이스는 상수와 추상 메소드로만 구성
    - Java 8까지
        - 상수와 추상메소드 포함
        - default 메소드 포함(Java 8)
        - private 메소드 포함(Java 9)
        - static 메소드 포함(Java 9)
3. 여전히 인터페이스에는 필드(멤버변수) 선언불가

### 인터페이스 상속
1. 인터페이스 간에 상속 가능
    - 인터페이스를 상속하여 확장된 인터페이스 작성 가능
    - extends 키워드로 상속 선언
    - 인터페이스 다중 상속 허용

### 인터페이스 구현
1. 인터페이스의 추상 메소드를 모두 구현한 클래스 작성
    - implements 키워드 사용
    - 여러 개의 인터페이스 동시 구현 가능

## 6장 모듈과 패키지 개념, 자바 패키지 활용 
### 패키지 개념과 필요성
1. 동일한 이름의 클래스가 존재할 가능성 있음
    - 개발자가 서로 다른 디렉터리로 코드 관리

### 자바의 패키지 모듈이란?
1. 패키지
    - 서로 관련된 클래스와 인터페이스를 컴파일한 클래스 파일들을 묶어 놓은 디렉터리
    - 하나의 응용프로그램은 한 개 이상의 패키지로 작성
    - 패키지는 jar 파일로 압축할 수 있음
2. 모듈
    - 여러 패키지와 이미지 등의 자원을 모아 놓은 컨테이너
    - 하나의 모듈을 하나의 .jmod 파일에 저장
3. Java 9부터 모듈화 도입
    - 플랫폼의 모듈화
        - Java 9부터 자바 API의 모든 클래스들(자바 실행 환경)을 패키지 기반에서 모듈들로 완전히 재구성
    - 응용프로그램의 모듈화
        - 클래스들은 패키지로 만들고, 다시 패키지를 모듈로 만듦
        - 모듈 프로그래밍은 어렵고 복잡. 기존 방식으로 프로그램 작성

### 자바와 모듈화의 목적
1. 모듈화의 목적
    - Java 9부터 자바 API를 여러 모듈(99개)로 분할
        - Java 8까지는 rt.jar의 한 파일에 모든 API 저장
    - 응용프로그램이 실행할 때 꼭 필요한 모듈들로만 실행 환경 구축
        - 메모리 자원이 열악한 작은 소형 기기에 꼭 필요한 모듈로 구성된 작은 크기의 실행 이미지는 만드릭 위함
2. 모듈의 현실
    - Java 9부터 전면적으로 도입
    - 복잡한 개념
    - 큰 자바 응용프로그램에는 개발, 유지보수 등에 적합
    - 현실적으로 모듈로 나누어 자바 프로그램을 작성할 필요 없음

### 패키지 사용하기, import문
1. 다른 패키지에 작성된 클래스 사용
    - import룰 이용하지 않는 경우
        - 소스에 클래스 이름이 완전 경로명 사용
    - 필요한 클래스만 import
        - 소스 시작 부분에 클래스의 경로명 import
        - import 패키지.클래스
        - 소스에는 클래스 명만 명시하면 됨
    - 패키지 전체를 import
        - 소스 시작 부분에 패키지의 경로명 .*import

### 패키지 만들기
1. 클래스 파일(.class.)이 저장되는 위치는?
    - 클래스나 인터페이스가 컴파일되면 클래스 파일(.class) 생성
    - 클래스 파일은 패키지로 선언된 디렉터리에 저장
2. 패키지 선언
    - 소스 파일의 맨 앞에 컴파일 후 저장될 패키지 지정

### 모듈 개념
1. 모듈
    - Java 9에서 도입된 개념
    - 패키지와 이미지들의 리소스를 담은 컨테이너
    - 모듈 파일(.jmod)로 저장

### 모듈 기반의 자바 실행 환경
1. 자바 실행 환경
    - JRE : 디폴트 자바 실행 환경
        - 자바 모듈, 자바 가상 기계등으로 구성

### 자바 모듈화의 목적
1. 가장 큰 목적
    - 자바 컴포넌트들을 필요에 따라 조립하여 시용하기 위함
    - 컴퓨터 시스템의 불필요한 부담 감소
        - 세밀한 모듈화를 통해 필요 없는 모듈이 로드되지 않게 함
        - 소형 IOT 장치에도 자바 응용프로그램이 실행되고 성능을 유지하게 함

### Object 클래스
1. 특징
    - 모든 자바 클래스는 반드시 Object를 상속받도록 자동 컴파일
        - 모든 클래스의 슈퍼 클래스
        - 모든 클래스가 상속받는 공통 메소드 포함

### 객체 속성
1. Object 클래스는 객체의 속성을 나타내는 메소드 제공

### 객체 비교(==)와 equals()메소드
1. == 연산자
    - 객체 레퍼런스 비교
```java
Point a = new Point(2,3);
Point b = new Point(2,3);
Point c;

if(a == b)  //false
    System.out.println("a == b");
if(a == c)  //true
    System.out.println("a == c");
```
2. boolean equals(Object obj)
    - 두 객체의 내용물 비교
    - 객체의 내용물을 비교하기 위해 클래스의 멤버로 작성

### Wrapper 클래스
1. Wrapper 클래스
    - 자바의 기본 타입을 클래스화한 8개 클래스를 통칭
        - Byte, Short, Integer, Long, Character, Float, Double, Boolean
2. 용도
    - 객체만 사용할 수 있는 컬렉션 등에 기본 타입의 값을 사용하기 위해 -> Wrapper 객체로 만들어 사용

### Wrapper 객체 생성
1. 기본 타입의 값으로 Wrapper 객체 생성
2. 문자열로 Wrapper 객체 생성
3. Float 객체는 double 타입의 값으로 생성 가능

### 박싱과 언박싱
1. 박싱
    - 기본 타입의 값을 Wrapper 객체로 변환하는 것
2. 언박싱
    - Wrapper 객체에 들어 있는 기본 타입의 값을 빼내는 것
    - 박싱의 반대
3. 자동 박싱과 자동 언박싱
    - JDK 1.5부터 박싱과 언방식은 자동으로 이루어지도록 컴파일됨

### 스트링 리터럴과 new String()
1. 스트링 리터럴
    - 자바 가상 기계 내부에서 리터럴 테이블에 저장되고 관리됨
    - 응용프로그램에서 공유됨
2. new String()


## 4월 12일
### 접근 지정자
1. 자바의 접근 지정자
    - 4가지
        - private, protected, public, 디폴트(접근지정자 생략)

2. 접근 지정자의 목적
    - 클래스나 일부 멤버를 공개하여 다른 클래스에서 접근하도록 허용
    - 객체 지향 언어의 캡슐화 정책은 멤버를 보호하는것
        - 접근 지정은 캡슐화에 묶인 보호를 일부 해제할 목적

### 클래스 접근 지정
1. 클래스 접근지정
    - 다른 클래스에서 사용하도록 허용할 지 지정
    - public  클래스
        - 다른 모든 클래스에게 접근 허용
    - 디폴트 클래스(접근지정자 생략)
        - package-private라고도 함
        - 같은 패키지의 클래스에만 접근 허용
```java
public class World{//public 클래스
.........
}
```


```java
class Local{///디폴트  클래스
.........
}
```
### 맴버 접근 지정
1. public 멤버
    - 패키지에 관계 없이 모든 클래스에게 접근 허용

### static 멤버
1. static 멤버 선언
    - 멤버는 클래스당 하나 생성
    - 클래스 로딩 시에 멤버 생성
```java
class StaticSample {
    int n;                  //non-static 필드
    void g() {...}          //non-static 메소드

    static int m;           //static 필드
    static void f() {...}   //static 메소드
}
```
2. 객체 생성과 non-static 멤버의 생성
    - non-static 멤버는 객체가 생성될 때, 객체마다 생긴다
    - 멤버는 객체마다 별도 존재
```java
class A {
    int n;
    void g() {...}
}
```

### static 멤버의 생성
1. static 멤버는 클래스당 하나만 생성
2. 객체들에 의해 공유됨
```java
class StaticSample {
    int n;
    void g() {...}
    static int m;           //static 멤버 m과f()는 b1 객체가 생성되기 전에 존재
    static void f() {...}
}
```

### static 멤버 사용
1. 클래스 이름으로 접근 가능
```java
StaticSample.m = 3;     //클래스 이름으로 static필드 접근
StaticSample.f();       //클래스 이름으로 static 메소드 호출
```
2. 객체의 멤버로 접근 가능
```java
StaticSample b1 = new StaticSample();

b1.m = 3;               //객체 이름으로 static 필드 접근
b1.f();                 //객체 이름으로 static 메소드 호출
```
3. non-static 멤버는 클래스 이름으로 접근 안됨
```java
StaticSample.n = 5;     //n은 non-static이므로 컴파일 오류
StaticSample.g();       //g()는 non-static이므로 컴파일 오류
```

### static 메소드의 제약 조건 1
1. static 메소드는 오직 static 멤버만 접근 가능
    - 객체가 생성되지 않은 상황에서도 static 메소드는 실행될 수 있기 때문에, non-static 멤버 활용 불가
    - non-static 메소드는 static 멤버 사용 가능
```java
class StaticMethod {
    int n;
    void f1(int x) {n = x;}                 //정상
    void f2(int x) {m = x;}                 //정상
    static int m;
    static void s1(int x) {n = x;}     //컴파일 오류, static 메소드는 non-static 필드 n 사용불가

    static void s2(int x) {f1(3);} //컴파일 오류, static 메소드는 non-static 메소드 f1() 사용불가

    static void s3(int x) {m = x;}  //정상, static 메소드는 static 필드 m 사용 가능
    static void s4(int x) {s3(3);}  //정상, static 메소드는 static 메소드 s3() 호출 가능
}
```
### static 메소드는 this 사용불가
1. static 메소드는 객체 없이도 사용 가능하므로, this 레퍼런스를 사용할 수 없음
```java
static void f() { this.n = x; } //오류. static 메소드에서는 this 사용 불가능
static void g() { this.m = x; } //오류. static 메소드에서는 this 사용 불가능
```

### final 클래스와 메소드
1. final 클래스 - 더 이상 클래스 상속 불가능
```java
final class FinalClass {
    ....
} 
class DerivedClass extends FinalClass{      //컴파일 오류
    ....
}
```
2. final 메소드 - 더 이상 오버라이딩 불가능
```java
public class SuperClass {
    protected final int finalMethod() {...}
}
class SubClass extends SuperClass {
    protected int finalMethod {...}     //컴파일 오류, 오버라이딩 할 수 없음
}
```

### final 필드, 상수 선언
1. 상수를 선언할 때 사용
2. 상수 필드는 선언 시에 초기 값을 지정하여야 한다
3. 상수 필드는 실행 중에 값을 변경할 수 없다

## 5장
### 상속
1. 객체 지향 상속
    - 부모의 유전자를 자식이 물려받는 유전적 상속과 동일

### 클래스 상속과 객체
1. 상속 선언
    - extends 키워드로 선언
        - 부모 클래스를 물려받아 확장한다는 의미
    - 부모 클래스 -> 슈퍼 클래스
    - 자식 클래스 -> 서브 클래스

### 서브 클래스 객체의 모양
1. 슈퍼 클래스 객체와 서브 클래스의 객체는 별개
2. 서브 클래스 객체는 슈퍼 클래스 멤버 포함

### 자바 상속의 특징
1. 클래스 다중 상속 불허
    - C++는 다중 상속 가능
        - C++는 다중 상속으로 멤버가 중복 생성되는 문제 없음
    - 자바는 인터페이스의 다중 상속 허용
2. 모든 자바 클래스는 묵시적으로 object클래스를 상속받음
    - java.lang.Object는 모든 클래스의 슈퍼 클래스

### 슈퍼 클래스의 멤버에 대한 서브 클래스의 접근
1. 슈퍼 클래스의 private 멤버
    - 서브 클래스에서 접근할 수 없음
2. 슈퍼 클래스의 디폴트 멤버
    - 서브 클래스가 동일한 패키지에 있을 때 접근 가능
3. 슈퍼 클래스의 public 멤버
4. 슈퍼 클래스의 protected 멤버

### protected 멤버
1. protected 멤버에 대한 접근
    - 같은 패키지의 모든 클래스에게 허용
    - 상속되는 서브 클래스

### 서브 클래스/슈퍼 클래스의 생성자 호출과 실행
1. 서브 클래스의 객체가 생성될 때
    - 슈퍼클래스 생성자와 서브 클래스 생성자 모두 실행
    - 호출 순서
        - 서브 클래스의 생성자 먼저 호출
        - 서브 클래스의 생성자는 실행 전 슈퍼 클래스 생성자 호출
    - 실행 순서
        - 슈퍼 클래스의 생성자가 먼저 실행된 후 서브 클래스의 생성자 실행

### 서브 클래스와 슈퍼 클래스의 생성자 선택
1. 슈퍼 클래스와 서브 클래스
    - 각각 여러 개의 생성자 작성 가능
2. 서브 클래스의 객체가 생성될 때
    - 슈퍼 클래스 생성자 1개와 서브 클래스 생성자 1개가 실행
3. 서브 클래스의 생성자와 슈퍼 클래스의 생성자가 결정되는 방식
    - 개발자의 명시적 선택
        - 서브 클래스 개발자가 슈퍼 클래스의 생성자 명시적 선택
        - super() 키워드를 이용하여 선택
    - 컴파일러가 기본생성자 선택
        - 서브 클래스 개발자가 슈퍼 클래스의 생성자를 선택하지 않는 경우
        - 컴파일러가 자동으로 슈퍼 클래스의 기본 생성자 선택

### 업캐스팅
1. 업캐스팅
    - 서브 클래스의 레퍼런스를 슈퍼 클래스 레퍼런스에 대입
    - 슈퍼 클래스 레퍼런스로 서브 클래스 객체를 가리키게 되는 현상
```java
class Person {}
class Student extends Person{}

Person P;
Student s = new Student();
p = s;      //업캐스팅
```

### 다운캐스팅
1. 다운캐스팅
    - 슈퍼 클래스 레퍼런스를 서브 클래스 레퍼런스에 대입
    - 업캐스팅된 것을 다시 원래대로 되돌리는 것
    - 반드시 명시적 타입 변환 지정
```java
class Person{}
class Student extends Person{}

Person p = new Student("이재문");   //업캐스팅

Student s = (Student)p;             //다운캐스팅, 강제타입변환
```
### 업캐스팅된 레퍼런스로 객체 구별?
1. 업캐스팅된 레퍼런스로는 객체의 실체 타입을 구분하기 어려움
    - 슈퍼 클래스는 여러 서브 클래스에 상속되기 때문

### instanceof 연산자 사용
1. instanceof 연산자
    - 레퍼런스가 가리키는 객체의 타입 식별
```java
객체리퍼런스 instanceof 클래스타입
        -> 연산의 결과  true/false의 불린 값
```







## 4월 5일
### 2차원 배열
1. 2차원 배열 선언
```java
int intArray[][]; 또는 int[][] intArray;
```
2. 2차원 배열 생성
```java
intArray = new int[2][5];
int intArray[] = new int[2][5]; //배열 선언과 생성 동시
```

### 2차원 배열의 초기화
1. 배열 선언과 동시에 초기화
```java
int intArray[][] = {{0,1,2},
                     {3,4,5},
                     {6,7,8} }; //3*3 배열 생성
```
### 메소드의 배열 리턴
1. 배열 리턴
    - 배열의 래퍼런스만 리턴(배열 전체가 리턴되는 것이 아님)

2. 메소드의 리턴 타입
    - 리턴하는 배열 타입과 리턴 받는 배열 타입 일치
    - 리턴 타입에 배열의 크기를 지정하지 않음
```java
int [] intArray;
intArray = makeArray();
```

### 배열을 리턴 받아 사용하는 과정
```java
int[] makeArray() { //makeArray(); 메소드 실행
    int temp[] = new int[4]; //intArray에 temp값 치환
    return temp;
}
```
### 자바의 예외 처리
1. 에외
    - 실행 중 오동작이나 결과에 악영향을 미치는 예상치 못한 상황 발생
        - 자바에서는 싱행 중 발생하는 에러를 예외로 처리
2. 실행 중 예외가 발생하면
    - 자바 플랫폼은 응용프로그램이 예외를 처리하도록 호출
        - 응용프로그램이 예외를 처리하지 않으면 프로그램 강제 종료 시킴
3. 예외 발생 경우
    - 정수를 0으로 나누는 경우
    - 배열의 크기보다 큰 인덱스로 배열의 원소를 접근하는 경우
    - 정수를 읽는 코드가 실행되고 있을 때 사용자가 문자를 입력한 경우

### try-catch-finally문
1. 예외 처리
    - 발생한 예외에 대해 개발자가 작성한 프로그램 코드에서 대응하는 것
    - try-catch-finally문 사용
        - finally 블록은 생략 가능
```java
try {
    예외가 발생한 가능성이 잇는 실행문(try블록)
}
catch (처리할 예외 타입 선언) {
    예외 처리문(catch 블록)
}
finally {
    예외 발생 여부와 상관없이 무조건 실행되는 문장(finally 블록)
}
```

## 4장
### 세상 모든 것이 객체다
1. 세상 모든 것이 객체다.
    - TV, 의자, 책, 집, 카메라, 컴퓨터
2. 실세계 객체의 특징
    - 객체마다 고유한 특성과 행동을 가짐
    - 다른 객체들과 정보를 주고 받는 등, 상호작용하면서 살아감

### 자바의 객체 지향 특성 : 캡슐화
1. 캡슐화 : 객체를 캡슐로 싸서 내부를 볼 수 없게 하는 것
    - 객체의 가장 본질적인 특징
        - 외부의 접근으로부터 객체 보호
2. 자바의 캡슐화
    - 클래스 : 객체 모양을 선언한 틀(캡슐화하는 틀)
    - 객체 : 생성된 실체(instance)
        - 클래스 내에 메소드와 필드 구현

### 자바의 객체 지향 특성 : 상속
1. 상속
    - 상위 개체의 속성이 하위 개체에 물려짐
    - 하위 개체가 상위 개체의 속성을 모두 가지는 관계    

### 자바 상속
1. 자바 상속
    - 상위 클래스의 멤버를 하위 클래스가 물려받은
        - 상위 클래스 : 수퍼 클래스
        - 하위 클래스 : 서브 클래스, 수퍼 클래스 코드의 재사용, 새로운 특성 추가 가능

### 자바의 객체 지향 특성 : 다형성
1. 다형성
    - 같은 이름의 메소드가 클래스 혹은 객체의 따라 다르게 구현되는 것
    - 다형성 사례
        - 메소드 오버로딩 : 한 클래스 내에서 같은 이름이지만 다르게 작동하는 여러 메소드
        - 매소드 오버라이딩 : 슈퍼 클래스의 메소드를 동일한 이름으로 서브 클래스마다 다르게 구현

### 객체 지향 언어의 목적
1. 소프트웨어의 생산성 향상
    - 컴퓨터 산업 발전에 따라 소프트웨어의 생명 주기 단축
        - 소프트웨어를 빠른 속도로 생산할 필요성 중대
    - 객체 지향 언어
        - 상속, 다형성, 객체, 캡슐화 등 소프트웨어 재사용을 위한 여러 장치 내장
        - 소프트웨어 재사용과 부분 수정 빠름
        - 소프트웨어를 다시 만드는 부담 대폭 줄임
        - 소프트웨어 생산성 향상

2. 실세계에 대한 쉬운 모델링
    - 초기 프로그래밍
        - 수학 계산/통계 처리를 하는 등 처리 과정, 계산 절차 중요
    - 현대 프로그래밍
        - 컴퓨터가 산업 전반에 활용
        - 실세계에서 발생하는 일을 프로그래밍
        - 실세계에서는 절차나 과정보다 물체(객체)들의 상호 작용으로 묘사하는 것이 용이
    - 객체 지향 언어
        - 실세계의 일을 보다 쉽게 프로그래밍하기 위한 객체 중심적 언어

### 절차 지향 프로그래밍과 객체 지향 프로그래밍
1. 절차 지향 프로그래밍
    - 작업 순서를 표현하는 컴퓨터 명령 집합
    - 함수들의 집합으로 프로그램 작성
2. 객체 지향 프로그래밍
    - 컴퓨터가 수행하는 작업을 객체들간의 상호 작용으로 표현
    - 클래스 혹은 객체들의 집합으로 프로그램 작성

### 클래스와 객체
1. 클래스
    - 객체의 속성과 행위 선언
    - 객체의 설계도 혹은 틀
2. 객체
    - 클래스의 틀로 찍어낸 실체
        - 프로그램 실행중에 생성되는 실체
        - 메모리 공간을 갖는 구체적인 실체
        - 인스턴스(instance)라고도 부름
3. 사례
    - 클래스:소나타자동차, 객체:출고된 실제 소나타 100대

### 자바 클래스 구성
1. 클래스
    - class 키워드로 선언
    - 멤버 : 클래스 구성 요소
        - 필드(멤버 변수)와 메소드(멤버 함수)
    - 클래스에 대한 public 접근 지정 : 다른 모든 클래스에서 사용 허락
    - 멤버에 대한 public 접근 지정 : 다른 모든 클래스에게 멤버 접근 혀용

### 생성자
1. 생성자
    - 객체가 생성될 때 초기화 목적으로 실행되는 메소드
    - 객체가 생성되는 순간에 자동 호출

### 생성자의 특징
1. 생성자 이름은 클래스 이름과 동일
2. 생성자는 여러 개 작성 가능(생성자 중복)
3. 생성자는 객체 생성 시 한번 만 호출

### 기본 생성자
1. 기본 생성자
    - 매개 변수 없고, 아무 작업 없이 단순 리턴하는 생성자
    - 디폴트 생성자라고 불림

### this 레퍼런스
1. this
    - 객체 자신에 대한 레퍼런스
        - 컴파일러에 의해 자동 관리, 개발자는 사용하기만 하면 됨
        - this.멤버 형태로 멤버를 접근할 때 사용
        - this와 this()는 다르다
2. this()
    - 같은 클래스의 다른 생성자 호출
    - 생성자 내에서만 사용 가능
    - 생성자 코드의 제일 처음에 있어야 함

### 객체 배열
1. 자바의 객체 배열
    - 객체에 대한 레퍼런스 배열임
2. 자바의 객체 배열 만들기 3단계
    - 배열 레퍼런스 변수 선언
    - 레퍼런스 배열 생성
    - 배열의 각 원소 객체 생성

### 메소드
1. 메소드 
    - 메소드는 C/C++의 함수와 동일
    - 자바의 모든 메소드는 반드시 클래스 안에 있어야 함(캡슐화 원칙)
2. 메소드 형식
    - 다른 클래스에서 메소드를 접근할 수 있는지 여부 선언
    - public, private, protected, 디폴트(접근 지정자 생략)
3. 리턴 타입
    - 메소드가 리턴하는 값의 타입

### 인자 전달 - 기본 타입의 값이 전달 되는 경우
1. 매개 변수가 byte, int, double 등 기본 타입으로 선언되었을 때
    - 호출자가 건네는 값이 매게 변수에 복사되어 전달(실인자 값은 변경되지 않음) 

### 인자 전달 - 객체가 전달되는 경우
1. 객체의 레퍼런스만 전달
    - 매개 변수가 실인자 객체 공유

### 인자 전달 - 배열이 전달되는 경우
1. 배열 레퍼런스만 매게 변수에 전달
    - 배열 통째로 전달되지 않음
2. 객체가 전달되는 경우와 동일
    - 매개 변수가 실인자의 배열 공유

### 메소드 오버로딩
1. 오버로딩
    - 한 클래스 내에서 두 개 이상의 이름이 같은 메소드 작성
        - 메소드 이름이 동일하여야 함
        - 매개 변수의 개수가 서로 다르거나, 타입이 서로 달라야 함
        - 리턴 타입은 오버로딩과 관련 없음

### 객체 치환 시 주의할 점
     객체 치환은 객체 복사가 아니며, 레퍼런스의 복사이다.

### 객체 소멸
1. 객체 소멸
    - new에 의해 할당 받은 객체와 배열 메모리를 자바 가상 기계로 되돌려 주는 행위
    - 소멸된 객체 공간은 가용 메모리에 속함
2. 자바에서 사용자 임의로 객체 소멸안됨
    - 자바는 객체 소멸 연산자 없음
        - 객체 생성 연산자 : new
3. 객체 소멸은 자바 가상 기계의 고유한 역할
4. 자바 개발자에게는 매우 다행스러운 기능
    - C/C++에서는 할당 받은 객체를 개발자가 프로그램 내에서 삭제해야 함
    - C/C++의 프로그램 작성을 어렵게 만드는 요인
    - 자바에서는 사용하지 않는 객체나 배열을 돌려주는 코딩 책임으로부터 개발자 해방

### 가비지
1. 가비지
    - 가리키는 레퍼런스가 하나도 없는 객체
        - 더 이상 접근할 수 없어 사용할 수 없게 된 메모리
2. 가비지 컬렉션
    - 자바 가상 기계의 가비지 컬렉터가 자동으로 가비지 수집, 반환

### 가비지 컬렉션
1. 가비지 컬렉션
    - 자바 가상 기계가 가비지 자동 회수
        - 가용 메모리 공간이 일정 이하로 부족해질 떄
        - 가비지를 수거하여 가용 메모리 공간 확보
    - 가비지 컬렉터에 의해 자동 수행
2. 강제 가비지 컬렉션 강제 수행
    - System 또는 Runtime 객체의 gc()메소드 호출
        - 이 코드는 자바 가상 기계에 강력한 가비지 컬렉션 요청
        - 그러나 자바 가상 기계가 가비지 컬렉션 시점을 전적으로 판단 
```java
System.gc();  //가비지 컬렉션 자동요청
```

### 자바의 패키지 개념
1. 패키지
    - 상호 관련 있는 클래스 파일(컴파일된 .class)을 저장하여 관리하는 디렉터리
    - 자바 응용프로그램은 하나 이상의 패키지로 구성





## 3월 29일
### 실수 리터럴
1. 소수점 형태나 지수 형태로 표현한 실수
    - 12. 12.0 .1234 0.1234 1234E-4

### 문자 리터럴
1. 단일 인용부호('')로 문자 표현
    - 'a', 'W', '가', '*', '7', '글'

### 기본 타입 이외 리터럴
1. null 리터럴
    - 레퍼런스에 대입 사용
        - int n = null;(오류) //기본 타입에 사용불가
        - String str = null;
2. 문자열 리터럴(스트링 리터럴)
    - 이중 인용부호로 묶어 표현
    - 문자열 리터럴은 String 객체로 자동 처리

### 상수
1. 상수 선언
    - final 키워드 사용
    - 선언시 초깃값 지정
    - 실행 중 값 변경 불가

### var 키워드
1. java 10부터 도입
2. 기존의 변수 선언 방식 : 변수의 타입 반드시 지정
3. var 키워드
    -   타입을 생략하고 변수 선언 가능
    - 컴파일러가 추론하여 변수 타입 결정
    - 변수 선언시 조깃값이 주어지지 않으면 컴파일 오류
    - var는 지역 변수 선언에만 한정

### 타입 변환
1. 타입 변환
    - 한 타입의 값을 다른 타입의 값으로 변환

2. 자동 타입 변환
 - 컴파일러에 의해 원래의 타입보다 큰 타입으로 자동 변횐
 - 치환문(=)이나 수식 내에서 타입이 일치하지 않을 때

### 강제 타입 변환
 1. 강제 타입 변환
    - 개발자의 의도적 타입 변환
    - ()안에 개발자가 명시적으로 타입 변환 지정
    - 강제 변환은 값 손실 우려

### 자바의 키 입력과 System.in
1. System.in
    - 키보드와 연결된 자바의 표준 입력 스트림
    - 입력되는 키를 바이트(문자 아님)로 리턴하는 저수준 스트림

### Scanner
1. Scanner 클래스
    - 읽은 바이트를 문자, 정수, 실수, 불린, 문자열 등 다양한 타입으로 변환하여 리턴
        - java.util.Scanner
    - 객체 생성
        - import java.util.Scanner; //임포트 문 필요
        - 키보드에 연결된 System.in에게 키를 읽게 하고, 원하는 타입으로 변환하여 리턴

### 식과 연산자
1. 연산
    - 주어진 식을 계산하여 결과를 얻어내는 과정

### 산술 연산자
1. 산술 연산자
    - 더하기(+), 빼기(-), 곱하기(*), 나누기(/), 나머지(%)

### 증감 연산
1. 1증가 혹은 감소 시키는 연산
    - ++,--
        - (a)전위 연산자 -> a = 1; b = ++a; (b=1, a=2)
        - (b)후위 연산자 -> a = 1; b = a++; (b=1, a=2)

### 대입 연산
1. 연산의 오른쪽 결과는 왼쪽 변수에 대입
```java
int a = 1, b = 3;
a = b;      //b 값을 a에 대입하여 a=3
a += b;     //a = a + b의 연산이 이루어져, a = 6, b는 3 그대로
```

### 비교 연산, 논리 연산
1. 비교연산자 : 두 개의 값을 비교하여 true/false 결과
2. 논리연산자 : 두 개의 논리 값에 논리 연산, 논리 결과

```java
(age >= 20) && (age<30>)                //나이(int age)가 20대인 경우
(c >= 'A') && (c <= 'Z')                //문자(char c)가 대문자인 경우
(x >= 0) && (x <= 50) && (y ,= 50)      //(x,y)가 (0,0)과 (50,50)의 사각형 내에 있음
```

### 조건 연산
1. 3개의 피연산자로 구성된 삼항 연산자
    - opr1?opr2:opr3
    - opr1이 true이면, 연산식의 결과는 opr2, false이면 opr3
2. if-else을 조건 연산자로 간결하게 표현 가능
```java
int x = 5;
int y = 3;

int big;
if(x>y)
    big = x;
else
    big = y;
```

### 비트 연산
1. 비트 개념
    - byte x = 10;
2. 비트 연산
    - 비트끼리 AND, OR, XOR, NOT 연산

### 조건문
1. 단순 if문
    - if의 괄호 안에 조건식(논리형 변수나 논리 연산)
        - 실행문장이 단일 문장인 경우 둘러싸는 {,} 생략 가능

### 다중 if문
1. 조건문이 너무 많은 경우, switch문 사용 권장

### 중첩 if-else문
1. if문이나 else문, 혹은 if-else문에 if문이나 if-else문을 내포할 수 있다

### switch문
1. switch문은 식과 case 문의 값과 비교
    - case의 비교 값과 일치하면 해당 case의 실행문장 수행
        - break를 만나면 switch문을 벗어남
    - case의 비교 값과 일치하는 것이 없으면 default문 실행
        - default문은 생략 가능

### switch문에서 break문의 역할
1. switch문 내의 break문
    - break문을 만나면 switch문 벗어남
    - case 문에 break문이 없다면, 다음 case 문으로 실행 계속
        - 언젠가 break를 만날때까지 계속 내려 가면서 실행

### case 문의 값
1. case 문의 값
    - 문자, 정수, 문자열 리터럴(JDK 1.7부터)만 허용
    - 실수 리터럴은 허용되지 않음
 
## 3장. 반복문과 배열 그리고 예외 처리

### 반복문
1. 자바 반복문 - for문, while문, do-while문
    - for문 : 가장 많이 사용하는 반복문

### while문
1. while 문의 구성과 코드 사례
    - 조건식이 '참'인 동안 반복 실행
```java
int 1=0;
while(1<10) {   //1에서 9까지 의 합
    System.out.print(i);
    i++;
}
```

### 중첩 반복
1. 중첩 반복
    - 반복문이 다른 반복문을 내포하는 구조

### continue문
1. continue문
    - 반복문을 빠져나가지 않고, 다음 반복으로 제어 변경

### break문
1. break문

### 자바 배열
1. 배열
    - 인덱스와 인덱스에 대응하는 데이터들로 이루어진 자료구조
        - 배열을 이용하면 한 번에 많은 메모리 공간 선언 가능
    - 배열은 같은 타입의 데이터들이 순차적으로 저장되는 공간
        - 원소 데이터들이 순차적으로 저장됨
        - 인덱스를 이용하여 원소 데이터 접근
        - 반복문을 이용하여 처리하기에 적합한 자료 구조
    - 배열 인덱스
        - 0부터 시작
        - 인덱스는 배열의 시작 위치에서부터 데이터가 있는 상대 위치

### 배열 선언 및 생성 디테일
1. 배열 선언과 배열 생성의 두 단계 필요
2. 배열 선언
    - 배열의 이름 선언(배열 레퍼런스 변수 선언)
```java
int intArray[]; 또는 
int[] Array; 
```
3. 배열 생성
    - 배열 공간 할당 받는 과정
```java
intArray = new int[5]; 또는
int intArray[] = new int[5]; //선언과 동시에 배열 생성
```
4. 배열 초기화
    - 배열 생성과 값 초기화
```java
int intArray[] = {4, 3, 2, 1, 0}; //5개의 정수 배열 및 값 초기화
double doubleArray[]  = {0.01, 0.02, 0.03, 0.04}; //5개의 실수 배열 생성 및 값 초기화
```

### 레퍼런스 치환과 배열 공유
1. 레퍼런스 치환으로 두 레퍼런스가 하나의 배열 공유

### 배열의 크기, length 빌드
1. 자바의 배열은 객체로 처리
    - 배열 객체의 length 필드
        - 배열의 크기는 배열 객체의 length 필드에 저장
        - length 필드를 이용하여 배열의 모든 값을 출력하는 사례
```java
for(int i=0; i<intArray.length; i++) //배열 크기만큼 루프를 돈다.
System.out.prinln(intArray[i]);
```

### 배열과 for-each 문
1. for-each문
    - 배열이나 나열의 원소를 순차 접근하는데 유용한 for문

## 3월 22일
1. 프로젝트 생성시 디랙토리 판별 및 주의
2. 생성 후 이전 시간에 하던 생성물들 복사 붙혀넣기 하고 자바 생성물 src파일로 옮긴 후 디버깅
3. VSC 쓰는 이유 : 깊이가 생겨서 쓰기가 편해짐

### 프로그래밍 언어
1. 기계어 : 0과 1의 이진수로 구성된 언어
2. 어셈블리어 : 기계어 명령을 표현하기 쉬운 상징적인 단어(니모닉 기호)로 일대일 대응 시킨 단어
3. 고급 언어 (Pascal, Basic, C/C++, Java, C#)

### 소스 : 프로그래밍 언어로 작성된 텍스트 파일
### 컴파일 : 소스 파일을 컴퓨터가 이해할 수 있는 기계어로 만드는 과정
1. 자바 : .java -> .class
2. C : .obj -> .exe
3. C++ : .cpp -> .obj -> .exe

### 기존 언어의 플랫폼 종속성
    - 플랫폼 = 하드웨어 플랫폼 + 운영체제 플랫폼
    - 프로그램의 플랫폼 호환성이 없는 이유
1. 기계어가 CPU마다 다름
2. 운영체제마다 API가 다름
3. 운영체제마다 실행파일 형식이 다름
(예시)
인텔 CPU를 가진 리눅스 환경에서 개발 -> C/C++ 응용 프로그램 개발
    - Intel CPU + 리눅스(실행됨)
    - Apple 사의 MAC PC(실행되지 않음)
    - Intel CPU + 윈도우 노트북(실행되지 않음)

### WORA
1. 한번 작성된 코드는 모든 플랫폼에서 바로 실행되는 자바의 특징
2. C/C++ 등 기존 언어가 가진 플랫폼 종속성 극복
(OS, H/W에 상관없이 자바 프로그램이 동일하게 실행)
3. 네트워크에 연결된 어느 클라이언트에서나 실행
(웹 브라우저, 분산 지원 환경)

### WORA를 가능하게 하는 자바의 특징
1. 바이트 코드
    - 자바 소스를 컴파일한 목적 코드
    - CPU에 종속적이지 않은 중립적인 코드
    - JVM에 의해 해석되고 실행됨
2. JVM
    - 자바 바이트 코드를 실행하는 자바 가상 기계(소프트웨어)

### 자바 API
1. JDK에 포함된 클래스 라이브러리
    - 중요한 기능들을 미리 구현한 클래스 라이브러리의 개발
2. 개발자는 API를 이용하여 쉽고 빠르게 자바 프로그램을 개발
    - API에서 정의한 규격에 따라 클래스 사용

### 자바 패키지(package)
1. 서로 관련된 클래스들을 분류하여 묶어 놓은 것
2. 계층 구조로 되어 있음
    - 클래스의 이름에 패키지 이름도 포함
    - 다른 패키지에 동일한 이름의 클래스 존재 가능
3. 자바 API(클래스 라이브러리)는 JDK에 패키지 형태로 제공됨
    - 필요한 클래스가 속한 패키지만 import하여 사용
4. 개발자 자신의 패키지 생성 가능

### 코드 블럭
```java
public class Foo {

    public static void main(String[] args) {
        System.out.println("Hello!!");
    }
}
```
터미널에서 출력

### IDE
1. 통합 개발 환경
2. 편집, 컴파일, 디버깅을 한번에 할 수 있는 통홥된 개발 환경

### 이클립스
1. 자바 응용 프로그램 개발을 위한 통합 개발 환경
2. IBM에서 개발된 오픈 소스 프로젝트

### 서블릿
1. 웹 서버에서 실행되는 자바 프로그램
    - 서블릿은 웹브라우저에서 실행되는 자바스크립트 코드와 통신
2. 데이터베이스 서버 및 기타 서버와 연동하는 복잡한 기능 수현 시 사용
3. 사용자 인터페이스가 필요 없는 응용
4. 웹 서버에 의해 실행 통제 받음

### 자바의 특성

1. 플랫폼 독립성
    - 하드웨어, 운영체제에 종속되지 않는 바이트 코드로 플랫폼 독립성
2. 객체지향
    - 캡술화, 상속, 다형성 지원
3. 클래스로 캡슐화
    - 자바의 모든 변수나 함수는 클래스 내에 선언
    - 클래스 안에서 클래스(내부 클래스) 작성 가능
4. 소스(.java)와 클래스(.class)파일
    - 하나의 소스 파일에 여러 클래스를 작성 가능
        - public 클래스는 하나만 가능
    - 소스 파일의 이름과 public으로 선언한 클래스 이름은 같아야 함
    - 클래스 파일에는 하나의 클래스만 존재
        - 다수의 클래스를 가진 자바 소스를 컴파일하면 클래스마다 별도 클래스 파일 생성
### 예시
file.java -> 
- classFile(    ){  }
- classFile A(  ){  }
- classFile B(  ){  }

5. 실행 코드 배포
    - 구성
        - 한 개의 class 파일 또는 다수의 class 파일로 구성
        - 여러 폴더의 걸쳐 다수의 클래스 파일로 구성된 경우 : jar 압축 파일로 배포
    - 자바 응용프로그램의 실행은 main() 메소드에서 시작
        - 하나의 클래스 파일에 두 개 이상의 main() 메소드가 있을 수 없음
            - 각 클래스 파일이 main() 매소드를 포함하는 것은 상관없음
6. 패키지
    - 서로 관련 있는 여러 클래스를 패키지로 묵어 관리
    - 패키지는 폴더 개념
7. 멀티스레드
    - 여러 스레드의 동시 수행 환경 지원
        - 자바는 운영체제의 도움 없이 자체적으로 멀티스레드 지원
        - C/C++ 프로그램은 멀티스레드를 위해 운영체제 API를 호출
8. 가비지 컬렉션
    - 자바 언어는 메모리 할당 기능은 잇어도 메모리 반환 기능 없음
    - 사용하지 않는 메모리는 자바 가상 기계(JVM)에 의해 자동 반환 - 가비지 컬렉션
9. 실시간 응용프로그램에 부적합
    - 실행 도중 예측할 수 없는 시점에 가비지 컬렉션 실행 때문
        - 응용프로그램의 일시적 중단 발생
10. 자바 프로그램은 안전
    - 타임 체크 엄격
    - 물리적 주소를 사용하는 포인터 개념 없음
11. 프로그램 작성 쉬움
    - 포인터 개념이 없음
    - 동적 메모리 반환 하지 않음
    - 다양한 라이브러리를 지원
12. 실행 속도 개선을 위한 JIT 컴파일러 사용
    - 자바는 바이트 코드를 인터프리터 방식으로 실행
        - 기계어가 실행되는 것보다 느림
    - JIT 컴파일 기법으로 살행 속도 개선
        - JIT 컴파일 : 실행 중에 바이트 코드를 기계어 코드로 컴파일하여 기계어를 실행하는 기법

### 자바 프로그램의 기본 구조
```java
/*
* 소스파일 : Hello.java
*/
public class Hello {

    public static int sum(int n, int m) {
        return n + m; // ;로 마무리 인식
    }

    // main() 메소드에서 실행 시작
    public static void main(String[] args) {
        int i = 20; // 변수 타입과 변수 이름 선언
        int s;
        char a;

        s = sum(i, 10); // sum() 메소드 호출
        a = '?';
        System.out.println(a); // 문자 '?' 화면 출력
        System.out.println("Hello"); // "Hello" 문자열 화면 출력 
        System.out.println(s);// 정수 s값 화면 출력
    }
}
```
### 식별자
1. 식별자란?
    - 클래스, 변수, 상수, 매소드 등에 붙이는 이름
    - 식별자의 원칙
        - @, #, !와 같은 특수 문자, 공백 또는 탭은 식별자로 사용할 수 없으나 _, $는 사용 가능
        - 유니코드 문자 사용 가능, 한글 사용 가능
        - 자바 언어의 키워드는 식별자로 사용불가
        - 식별자의 첫 번째 문자로 숫자는 사용불가

### 문자열
1. 문자열은 기본 타입이 아님
2. String 클래스로 문자열 표현
    - 문자열 리터럴 - "JDK", "한글" , "계속하세요"

### 변수의 선언
1. 변수
    - 프로그램 실행 중에 값을 임시 저장하기 위한 공간
        - 변수 값은 프로그램 수행 중 변경될 수 있음
2. 변수 선언
    - 데이터 타입에서 정한 크기의 메모리 할당

### 리터럴과 정수 리터럴
1. 리터럴
    - 프로그램에서 직접 표현한 값
    - 정수, 실수, 문자, 논리, 문자열 리터럴 있음
2. 정수 리터럴
    - 10진수, 8진수, 16진수, 2진수 리터럴
        - 15 -> 10진수 15
        - 015 -> 0으로 시작하면 8진수, 십진수로 13
        - 0x15 -> 0x로 시작하면 16진수, 십진수로 21
        -0b0101 -> 0b로 시작하면 2진수, 십진수로 5
    - 정수 리터럴은 int 형으로 컴파일
    - long 타입 리터럴은 숫자 뒤에 L 또는 l을 붙여 표시
        - ex) long g = 24L;
## 3월 15일
내용