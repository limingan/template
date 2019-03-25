package com.city.management.common;

import com.city.management.collection.model.base.Permission;
import com.city.management.collection.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionnApplicationTests {

    @Autowired
    PermissionService permissionService;

    @Test
    public void contextLoads() {
        List<Permission> list = permissionService.queryAll();
        System.out.println(list);
    }

}
