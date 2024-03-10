package com.dehghan.publisher;

import com.dehghan.entity.MaterialPubSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Publisher {


    private RedisTemplate template;
    private ChannelTopic channelTopic;

    public Publisher( RedisTemplate redisTemplate,ChannelTopic channelTopic){
        this.channelTopic = channelTopic;
        this.template = redisTemplate;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody MaterialPubSub materialPubSub){
        template.convertAndSend(channelTopic.getTopic(), materialPubSub.toString());
        return "Event Published !!";

    }
}
