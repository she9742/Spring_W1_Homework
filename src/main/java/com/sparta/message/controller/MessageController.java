package com.sparta.message.controller;


import com.sparta.message.dto.MessageRequestDto;
import com.sparta.message.entity.Message;
import com.sparta.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/api/messages") //전체 게시글 조회
    public List<Message> getMessageList(){
        return messageService.getMessageAll();
    }

    @PostMapping("/api/messages") //작성
    public Message createMessage(@RequestBody MessageRequestDto requestDto) {
      // { "title": "이름", "username": "닉네임", "contents": "내용", "password": "비밀번호"}
        return messageService.createMessage(requestDto);
    }

    @GetMapping("/api/messages/{id}") //선택한 게시글 조회
    public Optional<Message> findMessage(@PathVariable Long id) {
        return messageService.findMessageById(id);
    }

    @PutMapping("/api/messages/{id}") //수정
    public String updateMessage(@PathVariable Long id, @RequestBody MessageRequestDto requestDto) {
        return messageService.updateMessage(id, requestDto);
    } //@requestboday 사용 -> requstdto에서 고객이 입력한 내용을 가져옴

    @DeleteMapping("/api/messages/{id}") //삭제
    public String deleteMessage(@PathVariable Long id, @RequestBody MessageRequestDto requestDto) {
        return messageService.deleteMessage(id, requestDto);
    }

}