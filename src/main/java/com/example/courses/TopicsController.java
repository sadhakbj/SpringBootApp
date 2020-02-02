package com.example.courses;

import com.example.courses.services.TopicService;
import core.BaseController;
import core.BaseResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unbescape.xml.XmlEscapeType;

import java.util.List;

@RestController
public class TopicsController extends BaseController {

    private final TopicService topicService;

    public TopicsController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping(value = "/topics")
    public ResponseEntity<BaseResponse<List<Topic>>> allTopics() {
        List<Topic> topics = topicService.getTopics();

        return sendResponse("Topics fetched successfully", topics);
    }

    @GetMapping(value = "/topics/{id}")
    public HttpEntity<? extends BaseResponse<? extends Object>> getById(@PathVariable String id){

            Topic topic = topicService.getById(id);

            if (topic == null) {
                return notFound("Not found.");
            }

            return  sendResponse("Successfully fetched topic", topic);
    }

    @PostMapping(value = "/topics")
    public void create(@RequestBody Topic topic){
        topicService.createTopic(topic);
    }

    @PutMapping(value = "/topics/{id}")
    public void update(@RequestBody Topic topic, @PathVariable String id) {
        topicService.update(id, topic);
    }

    @DeleteMapping(value = "/topics/{id}")
    public void delete(@PathVariable String id) {
        topicService.delete(id);
    }
}
