package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;

import java.util.*;

public class JCFUserService implements UserService {

    private static JCFUserService userService;
    private final List<User> data;

    private JCFUserService() {
        data = new ArrayList<>();
    }
    public static JCFUserService getInstance() {
        if (userService == null) {
            userService = new JCFUserService();
        }
        return userService;
    }

    @Override
    public User createUser(User user) {
        data.add(user);
        return user;
    }

    @Override
    public void findAllUsers() {
        //            System.out.println("userId :" + user.getId());
        //            System.out.println("userCreateAt :" + user.getFormattedCreatedAt());
        //            System.out.println("userUpdateAt :" + user.getFormattedUpdatedAt());
        //            System.out.println("userName :" + user.getUserName());
        //            System.out.println("channels :" + user.getChannels());
        //            System.out.println("messages :" + user.getMessages());
        data.forEach(user -> System.out.println(user.toString()));
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        return data.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public void updateUser(UUID id, String updateUser) {
        data.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .ifPresent(user -> {
                    user.setUserName(updateUser);
                    user.setUpdatedAt(System.currentTimeMillis());
                });
    }

    @Override
    public void deleteUser(User user) {
        data.remove(user);
    }

    @Override
    public void joinChannel(User user, Channel channel) {
        user.addChannel(channel);
        channel.addUser(user);
    }
    @Override
    public void leaveChannel(User user, Channel channel) {
        user.removeChannel(channel);
        channel.removeUser(user);
    }
}
