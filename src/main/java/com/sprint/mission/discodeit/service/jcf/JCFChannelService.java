package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.service.ChannelService;

import java.util.*;
import java.util.stream.Collectors;

public class JCFChannelService implements ChannelService {

    private static JCFChannelService channelService;
    private final List<Channel> data;

    private JCFChannelService () {
        this.data = new ArrayList<>();
    }
    public static JCFChannelService getInstance () {
        if (channelService == null) {
            channelService = new JCFChannelService();
        }
        return channelService;
    }
    @Override
    public Channel createChannel(Channel channel) {
        data.add(channel);
        return channel;
    }

    @Override
    public void findAllChannels() {
        //            System.out.println("channelId :" + channel.getId());
        //            System.out.println("channelCreateAt :" + channel.getFormattedCreatedAt());
        //            System.out.println("channelUpdateAt :" + channel.getFormattedUpdatedAt());
        //            System.out.println("channelName :" + channel.getChannelName());
        //            System.out.println("users :" + channel.getUsers());
        //            System.out.println("messages :" + channel.getMessages());
        //            System.out.println("-----------------------------------------");
        data.forEach(channel -> System.out.println(channel.toString()));
    }

    @Override
    public Optional<Channel> findChannelById(UUID id) {
        return data.stream()
                .filter(channel -> channel.getId().equals(id))
                .findFirst();
    }

    @Override
    public void updateChannel(UUID id, String updateChannelName) {
        data.stream()
                .filter(channel -> channel.getId().equals(id))
                .findFirst()
                .ifPresent(channel -> {
                    channel.setChannelName(updateChannelName);
                    channel.setUpdatedAt(System.currentTimeMillis());
                });
    }

    @Override
    public void deleteChannel(Channel channel) {
        data.remove(channel);
    }
}
