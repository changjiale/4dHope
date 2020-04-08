package leer.hope4d.controller;

import leer.hope4d.entity.SysUser;
import leer.hope4d.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: changjiale
 * @create: 2020/01/31 22:09
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("leer");
        sysUser.setPassword("leer");
        sysUser.setSalt("123");

        userService.save(sysUser);
    }
}