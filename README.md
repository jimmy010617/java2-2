# 차민욱 202030235


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

### 






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