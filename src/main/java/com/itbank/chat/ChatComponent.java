package com.itbank.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatComponent extends TextWebSocketHandler {

	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override		// 연결이 성립되면 (접속이 유지되면) 호출되는 함수
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		
	}
	
	@Override		// 메시지를 받으면 서버가 수행하는 메서드
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload()); 	// 자바스크립트가 전송한 메시지 내용
		
		// 상대방 ip주소 찍어내기
		System.out.println(session.getRemoteAddress());
		
		// 보내는 과정
		for(WebSocketSession wss : sessionList) {
			wss.sendMessage(new TextMessage(message.getPayload()));
		}
	}
	
	@Override		// 연결이 종료되면 수행되는 메서드  -> 나가면 해당 세션을 지워준다
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
	}
}
