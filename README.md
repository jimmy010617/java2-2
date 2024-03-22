# 차민욱 202030235





## 3월 22일
1. 프로젝트 생성시 디랙토리 판별 및 주의
2. 생성 후 이전 시간에 하던 생성물들 복사 붙혀넣기 하고 자바 생성물 src파일로 옮긴 후 디버깅
3. VSC 쓰는 이유 : 깊이가 생겨서 쓰기가 편해짐

*프로그래밍 언어
1. 기계어 : 0과 1의 이진수로 구성된 언어
2. 어셈블리어 : 기계어 명령을 표현하기 쉬운 상징적인 단어(니모닉 기호)로 일대일 대응 시킨 단어
3. 고급 언어 (Pascal, Basic, C/C++, Java, C#)

*소스 : 프로그래밍 언어로 작성된 텍스트 파일
*컴파일 : 소스 파일을 컴퓨터가 이해할 수 있는 기계어로 만드는 과정
1. 자바 : .java -> .class
2. C : .obj -> .exe
3. C++ : .cpp -> .obj -> .exe

*기존 언어의 플랫폼 종속성
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

*WORA
1. 한번 작성된 코드는 모든 플랫폼에서 바로 실행되는 자바의 특징
2. C/C++ 등 기존 언어가 가진 플랫폼 종속성 극복
(OS, H/W에 상관없이 자바 프로그램이 동일하게 실행)
3. 네트워크에 연결된 어느 클라이언트에서나 실행
(웹 브라우저, 분산 지원 환경)

*WORA를 가능하게 하는 자바의 특징
1. 바이트 코드
    - 자바 소스를 컴파일한 목적 코드
    - CPU에 종속적이지 않은 중립적인 코드
    - JVM에 의해 해석되고 실행됨
2. JVM
    - 자바 바이트 코드를 실행하는 자바 가상 기계(소프트웨어)

*자바 API
1. JDK에 포함된 클래스 라이브러리
    - 중요한 기능들을 미리 구현한 클래스 라이브러리의 개발
2. 개발자는 API를 이용하여 쉽고 빠르게 자바 프로그램을 개발
    - API에서 정의한 규격에 따라 클래스 사용

*자바 패키지(package)
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

*IDE
1. 통합 개발 환경
2. 편집, 컴파일, 디버깅을 한번에 할 수 있는 통홥된 개발 환경

*이클립스
1. 자바 응용 프로그램 개발을 위한 통합 개발 환경
2. IBM에서 개발된 오픈 소스 프로젝트

*서블릿
1. 웹 서버에서 실행되는 자바 프로그램
    - 서블릿은 웹브라우저에서 실행되는 자바스크립트 코드와 통신
2. 데이터베이스 서버 및 기타 서버와 연동하는 복잡한 기능 수현 시 사용
3. 사용자 인터페이스가 필요 없는 응용
4. 웹 서버에 의해 실행 통제 받음

## 자바의 특성

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

## 3월 15일
내용