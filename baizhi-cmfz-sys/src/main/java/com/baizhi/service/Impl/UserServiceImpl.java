package com.baizhi.service.Impl;

import com.baizhi.Md5Util;
import com.baizhi.SaltUtils;
import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.UserMapper;
import com.baizhi.dao.WorkMapper;
import com.baizhi.entity.User;
import com.baizhi.entity.Work;
import com.baizhi.service.UserService;
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
    private WorkMapper workMapper;
    public void add(User user) {

        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        user.setId(id);
        String salt = SaltUtils.getSalt(4);
        user.setSalt(salt);
        String pwd= Md5Util.getMd5Code(user.getPwd()+salt);
        user.setPwd(pwd);
        userMapper.insert(user);

        Work work = new Work();
        work.getUser().setId(user.getId());
        workMapper.insert(work);
    }

    public void delete(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    public User queryOne(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public List<User> queryAll() {
        List<User> userList = userMapper.selectAll();
        return userList;
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
