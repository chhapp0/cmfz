

package com.baizhi.test;

import com.baizhi.dao.AdminMapper;
import com.baizhi.entity.User;
import com.baizhi.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by ljf on 2017/6/12.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class Test1 {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private CounterService counterService;
    @Autowired
    private UserService userService;

    @Autowired
    private GuruService guruService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private EssayService essayService;

    @Test
    public void aa() {
       // Admin admin=new Admin(null,"zhangsan","123456",null);
       //adminService.queryByName(new Admin(null,"zhangsan","123456",null));
       //adminService.add(new Admin(null,"zhangsan","123456",null));
       // List<Menu> menuList = menuService.queryOne();
        //System.out.println(menuList);
       //Album album=new Album(null,"/back/img/alb1.png","佛音",8.8,"小红","泰瑞宝",new Date(),null,"爱与和平");
        //albumService.add(album);
     /*   List<Album> albumList = albumService.queryAll();
        for (Album list:albumList
             ) {
            System.out.println(list);
        }*/
   /*  Banner banner1=new Banner(null,"轮播图1","back/img/lunbo1.png",1);
     Banner banner2=new Banner(null,"轮播图2","back/img/lunbo2.png",1);
     Banner banner3=new Banner(null,"轮播图3","back/img/lunbo3.png",1);
        bannerService.add(banner1);
        bannerService.add(banner2);
        bannerService.add(banner3);*/

       /* List<Banner> bannerList = bannerService.queryAll();
        System.out.println(bannerList);*/
      /*  List<Chapter> chapterList = chapterService.queryAll();
        System.out.println(chapterList);*/
       /* Province province=new Province("1","北京",null);
        City city=new City("1","北京",province);
        User user=new User(null,"张三","圆寂","男","多看书","13553112345",null,"123456",null,null,province,city,null);
        userService.add(user);*/
/*
        Guru guru1=new Guru(null,"圆通",null,null);
        guruService.add(guru1);*/
       /* List<Album> albumList = albumService.queryAll();
        for (Album album:albumList
             ) {
            System.out.println(album);
        }*/
        /*Album album = albumService.queryOne("324590853437784064");
        System.out.println(album);*/

        /*Guru guru=new Guru(null,"小毛",null);
        guruService.add(guru);*/

User user =new User(null,"昵称","法名","男","好的坏的","12341","1234","1234",null,null,null,null,null);
        userService.add(user);

    }
}


