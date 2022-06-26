# spring socket Test
- SockJS, STOMP 활용
- application.properties option ref  
    https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html

- Spring WebSocket 채팅구현 참조  
    https://daddyprogrammer.org/post/4077/spring-websocket-chatting/  
    https://daddyprogrammer.org/post/4691/spring-websocket-chatting-server-stomp-server/
 

- 용어관련 메모  
<b>payload</b> - 실제로 사용자가 보는 채팅메시지  
<b>Stomp</b> - 메시징 전송을 효율적으로 하기 위한 프로토콜이다.   
기본적으로 pub/sub 구조로 구성되며 메시지를 송신, 수신이 구분되어있다.  
<b><i>Stomp</i></b>를 활용하면 메시지 헤더를 설정할 수 있어 헤더기반의 통신을 수행할 때 인증처리를 구현할수 있다.  
<b>pub/sub</b>는 메시지를 공급하는 주체와 소비하는 주체로 분리해 제공하는 메시징 방법이다.  
각각 <i>publisher</i>와 <i>subscriber</i>라는 의미라고 한다.  
채팅 과정 간략화  
채팅방을 생성 - pub/sub 구현을 위한 Topic이 하나 생성됨  
채팅방에 입장 - Topic을 구독(subscribe)한다.  
채팅방에서 메시지를 보내고 받는다 - 해당 Topic으로 메시지를 송신(pub) 또는 메시지를 수신(sub)한다.  

- 메모  
사용자가 서버에 접속할때 각자 WebSocket Session을 발급 받는다.  
사용자의 WebSocket Session 정보를 채팅방 정보와 연계해 보관하면  
서버에 전달된 메시지를 특정 방의 WebSocket Session으로 보낼 수 있어서  
여러개의 채팅방을 구현할 수 있다.

<br>

### SocketTest01
#### EnterChattingRoom ex)  
{  
  "type": "ENTER",  
  "roomId":  "{session-id}",  
  "sendPeople": "{user-name}",  
  "message": ""  
}
#### SendMessage ex)
{  
  "type": "TALK",  
  "roomId":  "{session-id}",  
  "sendPeople": "{user-name}",  
  "message": ""  
}