package com.sparta.message.entity;

import com.sparta.message.dto.MessageRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Message extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contents;

//    public Message(String username, String contents) {
//        this.title = title;
//        this.username = username;
//        this.password = password;
//        this.contents = contents;
//    }

    public Message(MessageRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }

    public void update(MessageRequestDto messageRequestDto) {
//        this.title = messageRequestDto.getTitle();
//        this.username = messageRequestDto.getUsername();
        this.contents = messageRequestDto.getContents();
    }
}
