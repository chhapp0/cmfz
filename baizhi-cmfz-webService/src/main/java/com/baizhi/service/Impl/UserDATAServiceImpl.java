package com.baizhi.service.Impl;

import com.baizhi.dao.UserDATAMapper;
import com.baizhi.dao.WorkMapper;
import com.baizhi.entity.UserDATA;
import com.baizhi.entity.Work;
import com.baizhi.service.UserService;
import com.baizhi.util.Md5Util;
import com.baizhi.util.SaltUtils;
import com.baizhi.util.SnowflakeIdWorker;
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
public class UserDATAServiceImpl implements UserService {
    @Autowired
    private UserDATAMapper userMapper;
    @Autowired
    private WorkMapper workMapper;
    public void add(UserDATA user) {

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
       /* workMapper.deleteUserDATA(id);
        userMapper.updateGuru(id);
        userMapper.updateProvince(id);
        userMapper.updateCity(id);
        userMapper.deleteByPrimaryKey(id);*/
    }

    public void update(UserDATA user) {
        String salt = SaltUtils.getSalt(4);
        user.setSalt(salt);
        String pwd= Md5Util.getMd5Code(user.getPwd()+salt);
        user.setPwd(pwd);

        userMapper.updateByPrimaryKey(user);

    }

    public UserDATA queryOne(String id) {
        UserDATA user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public Page<UserDATA> queryAll(Integer pageNum,Integer rows) {
        Page<UserDATA> page = PageHelper.startPage(pageNum, rows);
        List<UserDATA> userList = userMapper.selectAll();
        System.out.println(userList+"业务层查用户");
        return page;
    }

    public UserDATA queryByName(UserDATA user) {
        UserDATA userDATA1=new UserDATA();
        UserDATA userDB = userMapper.selectByUserDATAname(user.getPhone());
        if(userDB!=null){
            String md5Code = user.getPwd() + userDB.getSalt();
            if(md5Code.equals(userDB.getPwd())){
                userDATA1.setId(userDB.getId());
                userDATA1.setCity(userDB.getCity());
                userDATA1.setDescription(userDB.getDescription());
                userDATA1.setFarmington(userDB.getFarmington());
                userDATA1.setGender(userDB.getGender());
                //String location1=userDB.getProvince().getPname()+userDB.getCity().getName();
                String location1=userDB.getPpid().getPname()+userDB.getCcid().getName();
                userDATA1.setLocation(location1);
                userDATA1.setNickname(userDB.getNickname());
                userDATA1.setPhone(userDB.getPhone());
                userDATA1.setPwd(userDB.getPwd());
                userDATA1.setProvince(userDB.getProvince());
                userDATA1.setCity(userDB.getCity());
                return userDATA1;
            }
            throw new RuntimeException("密码错误");
        }
        throw new RuntimeException("手机号不存在");
    }

    public List<UserDATA> queryAllAdd() {
        List<UserDATA> userList = userMapper.selectAll();
        return userList;
    }

    public UserDATA queryUser(String phone) {
        UserDATA userDATA = userMapper.selectByUserDATAname(phone);
        return userDATA;
    }

    public UserDATA queryUserDATA(String id) {
        UserDATA userDATA = userMapper.selectByUserDATA(id);
        return userDATA;
    }

}
