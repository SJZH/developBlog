package com.blog.website.controller;

import com.blog.website.common.APIResult;
import com.blog.website.common.APIResultWithData;
import com.blog.website.common.APIResultWithPageView;
import com.blog.website.common.PageView;
import com.blog.website.entity.User;
import com.blog.website.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangzehao
 * @date 2019/3/4 16:04
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    private Logger log = LoggerFactory.getLogger(getClass());
    @PostMapping("add")
    public APIResult add(@RequestBody User user){
        APIResult result = new APIResult();
        try {
            userService.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            result.setReturnMsg(APIResult.ERROR_MSG_FAIL);
            result.setReturnCode(APIResult.ERROR_CODE_FAIL);
        }
        return result;
    }

    @PostMapping("update")
    public APIResult update(@RequestBody User user){
        APIResult result = new APIResult();
        try {
            userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            result.setReturnMsg(APIResult.ERROR_MSG_FAIL);
            result.setReturnCode(APIResult.ERROR_CODE_FAIL);
        }
        return result;
    }

    @GetMapping("list")
    public APIResultWithPageView list(PageView pageView,User user){
        APIResultWithPageView result = new APIResultWithPageView();
        result.setPageView(userService.getList(pageView,user));
        return result;
    }

    @GetMapping("delete")
    public APIResult delete(Integer userId){
        APIResult result = new APIResult();
        try {
            userService.delete(userId);
        }catch (Exception e){
            e.printStackTrace();
            result.setReturnCode(APIResult.ERROR_CODE_FAIL);
            result.setReturnMsg(APIResult.ERROR_MSG_FAIL);
        }
        return result;
    }

    @GetMapping("detail")
    public APIResultWithData detail(Integer userId){
        APIResultWithData result = new APIResultWithData();
        try {
            result.setData(userService.getByKey(userId));
        } catch (Exception e) {
            e.printStackTrace();
            result.setData(false);
            result.setReturnCode(APIResult.ERROR_CODE_FAIL);
            result.setReturnMsg(APIResult.ERROR_MSG_FAIL);
        }
        return result;
    }
}
