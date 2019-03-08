package com.oauth.website.controller;

import com.common.common.APIResult;
import com.common.common.APIResultWithData;
import com.common.common.APIResultWithPageView;
import com.common.common.PageView;
import com.oauth.website.entity.User;
import com.oauth.website.service.UserService;
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
 * @date 2019/3/5 14:28
 */
@RestController
@RequestMapping("/api/user")
public class CustomerController {
    @Autowired
    private UserService userService;

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("getUser")
    public APIResultWithData getUser(String name){
        APIResultWithData result = new APIResultWithData();
        result.setData(userService.getByName(name));
        return  result;
    }
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
    public APIResultWithPageView list(PageView pageView, User user){
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
