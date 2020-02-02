package com.example.courses.services;

import com.example.courses.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    List<Topic> topics =  new ArrayList<>(Arrays.asList(
            new Topic("spring", "Framework", "Learning spring"),
                new Topic("laravel", "Framework", "Learning laravel"),
                new Topic("spring", "Framework", "Learning spring")
        ));

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getById(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().orElse(null);
    }

    public void createTopic(Topic topic) {
        topics.add(topic);
    }

    public void update(String id, Topic topic) {
        for (Topic el: topics) {
            if (el.getId().equals(id)) {
                topics.set(topics.indexOf(el), topic);
            }
        }
    }

    public void delete(String id) {
        topics.removeIf(topic -> topic.getId().equals(id));
    }
}
