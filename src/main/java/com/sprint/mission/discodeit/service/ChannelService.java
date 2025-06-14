package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Channel;

import java.util.Optional;
import java.util.UUID;

public interface ChannelService {
    public Channel createChannel(Channel channel);
    public void findAllChannels();
    public Optional<Channel> findChannelById(UUID id);
    public void updateChannel(UUID id, String updateChannelName);
    public void deleteChannel(Channel channel);
}
