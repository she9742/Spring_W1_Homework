package com.sparta.message.service;

import com.sparta.message.dto.MessageRequestDto;
import com.sparta.message.entity.Message;
import com.sparta.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;


    @Transactional(readOnly = true) //db 수정 불가!
    public List<Message> getMessageAll() {
        return messageRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Message createMessage(MessageRequestDto requestDto) {
        Message message = new Message(requestDto);
        return messageRepository.save(message);
    }


    @Transactional
    public Optional<Message> findMessageById(Long id) {
        return Optional.ofNullable(messageRepository.findById(id)).orElseThrow(
                () -> new IllegalArgumentException("찾으시는 글이 없습니다.")
        );
    }

    @Transactional
    public String updateMessage(Long id, MessageRequestDto requestDto) {
        Message message = messageRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("수정하려는 글이 없습니다.")
        );
        if (!message.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        message.update(requestDto); //수정하는 부분
        return message.getContents();
    }


    public String deleteMessage(Long id, MessageRequestDto requestDto) {
        Message message = messageRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("삭제하려는 글이 없습니다.")
        );
        if (!message.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        messageRepository.deleteById(id);
        return "삭제되었습니다.";
    }
}






