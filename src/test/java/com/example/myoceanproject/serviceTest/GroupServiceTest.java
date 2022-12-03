package com.example.myoceanproject.serviceTest;


import com.example.myoceanproject.entity.Group;
import com.example.myoceanproject.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class GroupServiceTest {

    @Autowired
    private GroupService groupService;

    @Test
    public void showTest(){
        groupService.show().stream().map(Group::toString).forEach(log::info);
    }
}