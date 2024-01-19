### Spring Controller FLow

![img](../../images/springbootControllerFlow.png)

### GET API

---
`@GetMapping`
+ 별도의 파라미터 없이 GET API를 호출하는 경우 사용

`@PathVariable`
+ GET 형식 요청에서 파라미터를 전달하기 위해 URL에 값을 담아 요청하는 방법
+ 아래 예시는 @GetMapping에서 사용된 {변수} 이름과 메서드의 매개변수와 일치시켜야 함

```java
@GetMapping(value="/variable1/{variable}")
public String getVariable1(@PathVariable String variable){
    return variable;
}
```

+ 아래 예시는 @GetMapping에서 사용된 {변수} 이름과 메서드의 매개변수가 다를 경우 사용하는 방법
+ 변수의 관리 용이를 위해 사용됨

```java
@GetMapping(value="/variable2/{variable}")
public String getVariable2(@PathVariable("variable") String var){
    return var;
}
```

`@RequestParam`
+ GET 형식 요청에서 쿼리 문자열을 전달하기 위해 사용되는 방법
+ '?'를 기준으로 우측에 {키}={값} 형태로 전달되며, 복수 형태로 전달할 경우 '&'를 사용

> http://naver.com/api/v1/request1?name=sen&email=sen@naver.com&organic=senground

```java
@GetMapping(value="/request1")
public String getRequestParam1(
    @RequestParam String name,
    @RequestParam String email,
    @RequestParam String organic){
    return name + "" + email + "" + organic;
}
```

+ 아래 예시는 어떤 요청 값이 들어올지 모를 경우 사용하는 방법

```java
@GetMapping(value="/request2")
public String getRequestParam2(@RequestParam Map<String, String> param){
    StringBuilder sb = new StringBuilder();
    
    param.entrySet().forEach(map -> {
        sb.append(map.getKey() + ":" + map.getValue() + "\n");
    });
    
    return sb.toString();
}
```

`DTO 사용`

+ GET 형식 요청에서 쿼리 문자열을 전달하기 위해 사용되는 방법
+ key와 value가 정해져있지만, 받아야할 파라미터가 많을 경우 DTO 객체를 사용

```java
@GetMapping(value="/request3")
public String getRequestParam3(MemberDTO memberDTO){
    return memberDTO.getName() + "" + memberDTO.getEmail() + "" + memberDTO.getOrganic();
}

public class MemberDTO {
    private String name;
    private String email;
    private String organic;
}
```

---
