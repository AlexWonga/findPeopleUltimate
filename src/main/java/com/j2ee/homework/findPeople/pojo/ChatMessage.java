package com.j2ee.homework.findPeople.pojo;

import lombok.Data;

@Data
public class ChatMessage {
    private String sender;
    private String receiver;
    private String message;
}
