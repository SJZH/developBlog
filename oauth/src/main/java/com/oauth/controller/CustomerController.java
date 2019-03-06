package com.oauth.controller;

import com.blog.website.common.APIResultWithData;
import com.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangzehao
 * @date 2019/3/5 14:28
 */
@RestController
@RequestMapping("/api/user")
public class CustomerController {
    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    public APIResultWithData getUser(String name){
        APIResultWithData result = new APIResultWithData();
        result.setData(userService.getByName(name));
        return  result;
    }

}
