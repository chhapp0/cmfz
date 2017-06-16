/*
package com.baizhi.service.Impl;

import com.baizhi.Md5Util;
import com.baizhi.SaltUtils;
import com.baizhi.SnowflakeIdWorker;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

*/
/**
 * Created by ljf on 2017/6/12.
 *//*

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public void add(Admin admin) {
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        admin.setId(id);
        System.out.println(admin.getId());
        String salt= SaltUtils.getSalt(4);
        admin.setSalt(salt);
        System.out.println(admin.getSalt());
        String pwd=Md5Util.getMd5Code(admin.getPassword()+salt);
        admin.setPassword(pwd);
        System.out.println(admin.getUsername());
        adminMapper.insert(admin);
    }

    public void update(Admin admin) {
       adminMapper.updateByPrimaryKey(admin);
    }

   */
/* public void delete(String id) {
    }*//*


    public Admin queryOne(String id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        return admin;
    }

    public Admin queryByName(Admin admin) {
        Admin adminDB = adminMapper.selectByadminName(admin.getUsername());
        if(adminDB!=null){
            String md5Code = Md5Util.getMd5Code(admin.getPassword() + adminDB.getSalt());
            if(md5Code.equals(adminDB.getPassword())){
                return adminDB;
            }
            throw new RuntimeException("密码错误!");
        }
        throw new RuntimeException("账户名不存在");
    }
}
*/
