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

import java.util.Date;
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

        SnowflakeIdWorker idWorker1=new SnowflakeIdWorker(0,0);
        String id1 = String.valueOf(idWorker1.nextId());
        System.out.println(id1);
        Work work1=new Work(id1,"持咒诵经",user,new Date());
        System.out.println(work1);
        workMapper.insert1(work1);

        SnowflakeIdWorker idWorker2=new SnowflakeIdWorker(0,0);
        String id2 = String.valueOf(idWorker1.nextId());
        Work work2=new Work(id2,"诚心礼佛",user,new Date());
        workMapper.insert2(work2);

        userMapper.insert(user);
    }

    public void delete(String id) {
        workMapper.deleteUser(id);
        userMapper.updateGuru(id);
        userMapper.updateProvince(id);
        userMapper.updateCity(id);
        userMapper.deleteByPrimaryKey(id);
    }

    public void update(User user) {
        String salt = SaltUtils.getSalt(4);
        user.setSalt(salt);
        String pwd= Md5Util.getMd5Code(user.getPwd()+salt);
        user.setPwd(pwd);

        userMapper.updateByPrimaryKey(user);

    }

    public User queryOne(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public Page<User> queryAll(Integer pageNum,Integer rows) {
        Page<User> page = PageHelper.startPage(pageNum, rows);
        List<User> userList = userMapper.selectAll();
        System.out.println(userList+"业务层查用户");
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

    public List<User> queryAllAdd() {
        List<User> userList = userMapper.selectAll();
        return userList;
    }

}
