package com.weike.weike.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weike.weike.domain.User;
import com.weike.weike.mapper.UserMapper;
import com.weike.weike.response.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public ResponseEntity<ResultModel> getUserInfo(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> users = userMapper.findUserInfo();
        return  new ResponseEntity<>(ResultModel.ok(new PageInfo<>(users)), HttpStatus.OK);
    }

}
