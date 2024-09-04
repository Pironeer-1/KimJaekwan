//== 3-1 숫자 ==//
/*
int와 long은 둘 다 숫자형 자료형이지만 표현의 범위에 차이가 있다.
int의 최댓값은 2147483647이기 때문에 큰 수를 다룰 가능성이 있으면 long으로 선언하자

마찬가지로 실수형도 float과 double이 있다
 */


//== 3-2 불 ==//
/*
bool 자료형은 true와 false를 가지는 자료형이다.
단순히 true, false 값만 넣는 것이 아니라 여러 조건문을 사용하여 상황별로 true, false 값을 판단하도록 사용할 수 있다
 */


//== 3-3 문자 ==//
/*
문자형 자료형으로는 char 가 있는데 값을 넣을 때 'a' 형식으로 넣어야 한다
 */

//== 3-4 문자열 ==//
/*
문자열 자료형은 String이 있다.
String 자료형에는 내장 메서드가 있다.
    - equals : 값을 비교하여 true/false 반환
    - indexOf : 특정 문자열이 시작하는 인덱스 값을 반환
    - contains : 특정 문자열을 포함하는지 여부 반환
    - charAt : 문자열에서의 특정 인덱스 값 반환
    - replaceAll : 특정 문자열을 바꿀 때 사용
    - subString : 특정 문자열을 뽑아낼 때 사용
 */


//== 3-5 StringBuffer ==//
/*
문자열을 추가하거나 변경할 때 주로 사용하는 자료형
    - append : 문자열을 추가할 때 사용
    - insert : 문자열을 특정 위치에 추가할 때 사용
    - subString : 문자열을 뽑아낼 때
 */


//== 3-6 배열 ==//
/*
자료형의 집합이라 생각하자
따라서 사용할 때
String[] week = {"1", ...} 방식으로 사용한다

배열에 접근할 땐 week[1] 이런식으로 한다
 */


//== 3-7 리스트 ==//
/*
배열과 비슷하지만 크기가 정해져있지 않다는 특징이 있다. 유용하게 사용할 수 있을 것 같다!
일반적으로 ArrayList를 많이 사용한다

    - add : 추가
    - get : 값 얻기
    - size : 크기 반환
    - contains : 포함 여부 반환
    - remove : 삭제

제네릭스 - 자료형을 안전하게 사용할 수 있도록 만들어 주는 기능
ArrayList<String> pitches = new ArrayList<>();
이 형식으로 사용하여 이 후에 형변환 하는 과정을 필요로 하지 않고 String 자료형만을 요구한다
 */


//== 3-8 맵 ==//
/*
key-value 형식의 자료형. python의 dictionary와 유사하다
맵 자료형에는 HashMap, LinkedHashMap, TreeMap 등이 있다
    - put : 추가
    - get : key에 해당하는 value를 반환
    - remove : 삭제
 */

//== 3-11 형 변환과 final ==//
/*
final - 자료형에 값을 한번만 할당 받도록 하는 키워드
 */