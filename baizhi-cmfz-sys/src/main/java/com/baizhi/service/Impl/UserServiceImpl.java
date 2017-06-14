package com.baizhi.service.Impl;

import com.baizhi.Md5Util;
import com.baizhi.SaltUtils;
import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.UserMapper;
import com.baizhi.dao.WorkMapper;
import com.baizhi.entity.User;
import com.baizhi.entity.Work;
import com.baizhi.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private WorkMapper workMapper;
    public void add(User user) {

        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        user.setId(id);
        String salt = SaltUtils.getSalt(4);
        user.setSalt(salt);
        String pwd= Md5Util.getMd5Code(user.getPwd()+salt);
        user.setPwd(pwd);

        System.out.println(user);
        List<Work> workList = user.getWork();

        System.out.println(workList);
        for (Work work:workList
             ) {
            work.getUser().setId(user.getId());
        }


        userMapper.insert(user);
    }

    public void delete(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public void update(User user) {
        List<Work> workList = user.getWork();
        for (Work work:workList
                ) {
            work.getUser().setId(work.getId());
        }
        userMapper.updateByPrimaryKey(user);

    }

    public User queryOne(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public Page<User> queryAll(Integer pageNum,Integer rows) {
        Page<User> page = PageHelper.startPage(pageNum, rows);
        List<User> userList = userMapper.selectAll();
        return page;
    }

    public User queryByName(User user) {
        User userDB = userMapper.selectByUsername(user.getPhone());
        if(userDB!=null){
            String md5Code = user.getPwd() + userDB.getSalt();
            if(md5Code.equals(userDB.getPwd())){
                return userDB;
            }
            throw new RuntimeException("密码错误");
        }
        throw new RuntimeException("手机号不存在");
    }
}
