package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.MessageService;

import java.util.*;
import java.util.stream.Collectors;

public class JCFMessageService implements MessageService {

    private static JCFMessageService messageService;
    private final List<Message> data;

    private JCFMessageService() {
        this.data = new ArrayList<Message>();
    }
    public static JCFMessageService getInstance() {
        if (messageService == null) {
            messageService = new JCFMessageService();
        }
        return messageService;
    }

    @Override
    public Message createMessage(Message message) {
        data.add(message);
        return message;
    }

    @Override
    public void findAllMessages() {
        //            System.out.println("messageId :" + message.getId());
        //            System.out.println("messageCreateAt :" + message.getFormattedCreatedAt());
        //            System.out.println("messageUpdateAt :" + message.getFormattedUpdatedAt());
        //            System.out.println("messageText :" + message.getText());
        //            System.out.println("user :" + message.getUser());
        //            System.out.println("channel :" + message.getChannel());
        //            System.out.println("-----------------------------------------");
        data.forEach(message -> System.out.println(message.toString()));
    }

    @Override
    public Optional<Message> findMessageById(UUID id) {
        return data.stream()
                .filter(message -> message.getId().equals(id))
                .findFirst();
    }

    @Override
    public void updateMessage(UUID id, String updateMessage) {
        data.stream()
                .filter(message -> message.getId().equals(id))
                .findFirst()
                .ifPresent(message -> {
                    message.setText(updateMessage);
                    message.setUpdatedAt(System.currentTimeMillis());
                });

    }

    @Override
    public void deleteMessage(Message message) {
        data.remove(message);
    }
}
