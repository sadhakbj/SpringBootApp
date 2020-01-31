package com.example.courses;

import core.BaseController;
import core.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicsController extends BaseController {

    @GetMapping(value = "/topics")
    public ResponseEntity<BaseResponse<List<Topic>>> allTopics() {
        List<Topic> topics = Arrays.asList(
                new Topic("spring", "Framework", "Learning spring"),
                new Topic("spring", "Framework", "Learning spring"),
                new Topic("spring", "Framework", "Learning spring")
        );

        return sendResponse("Topics fetched successfully", topics);
    }

    @GetMapping(value = "/topics/{id}")
    public BaseResponse<String> topicDetail(){
        return sendResponse("Hello world");
    }
}
