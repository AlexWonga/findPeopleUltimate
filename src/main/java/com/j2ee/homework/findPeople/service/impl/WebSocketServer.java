package com.j2ee.homework.findPeople.service.impl;

import com.j2ee.homework.findPeople.pojo.ChatMessage;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

import javax.websocket.*;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;


@ServerEndpoint("/websocket/{nickname}")
@Component
public class WebSocketServer {
    private Session session;
    private static final HashMap<String, WebSocketServer> map = new HashMap<>();
    private String nickname;

    @OnOpen
    public void onOpen(Session session, @PathParam("nickname") String nickname) throws IOException {
        this.session = session;
        this.nickname = nickname;
        WebSocketServer server = map.get(nickname);
        if(Objects.isNull(server)) {
            map.put(nickname, this);
            broadcast(nickname + "上线");
        }
    }


    @OnClose
    public void onClose() throws IOException {
        session.close();
        map.remove(nickname);

        broadcast("当前在线人数：");
    }


    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        try {
            ChatMessage chatMessage = JSON.parseObject(message, ChatMessage.class);
            sendMessage(chatMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @OnError
    public void onError(Session session, Throwable error) throws IOException {
        error.printStackTrace();
        broadcast("有一个用户退出 id:" + session.getId());
    }


    public void sendMessage(ChatMessage msg) throws IOException {
        WebSocketServer receiverServer = map.get(msg.getReceiver());
        WebSocketServer sendServer = this;
        if (!Objects.isNull(receiverServer)) {
            receiverServer.session.getBasicRemote().sendText(msg.getSender() + "发送：" + msg.getMessage());
        } else {
            sendServer.session.getBasicRemote().sendText("该用户不在线");
        }
    }

    public void broadcast(String message) throws IOException {
        for (Map.Entry<String, WebSocketServer> item : map.entrySet()) {
            item.getValue().session.getBasicRemote().sendText(message);
        }
    }
}
