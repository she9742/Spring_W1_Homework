package com.sparta.message.dto;

import lombok.Getter;

@Getter
public class MessageRequestDto {
    private String title;
    private String username;
    private String contents;
    private String password;
}
