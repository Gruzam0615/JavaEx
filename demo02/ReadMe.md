# Springboot Restful API demo

##### com.demo02.board
JPA를 활용한 기본적인 CRUD 실습을 목적으로 하는 프로젝트로 게시판을 기능을 구현하고있습니다.    
database는 H2 db를 활용했고 view는 thymeleaf 를 활용했습니다.  


##### com.demo02.test01

간단한 input 예제입니다.  
사용자는 이름을 기준으로 구분합니다.  
이름이 기존 사용자와 동일할 경우에는 새로운 사용자가 추가 되지 않습니다.  
사용자 이름의 parameter는 name입니다.  
name의 기본값은 Guest 입니다.  
Request URL: http://localhost:8080/test01?name=[사용자명]  
```
