package com.weike.weike.controller;

import com.github.pagehelper.PageInfo;
import com.weike.weike.domain.User;
import com.weike.weike.response.ResultModel;
import com.weike.weike.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultModel> getUserInfo(@RequestParam(value="currentPage",required = false,defaultValue = "1") String currentPage, @RequestParam(value="pageSize",required = false,defaultValue = "12") String pageSize) {
        return userService.getUserInfo(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
    }

}