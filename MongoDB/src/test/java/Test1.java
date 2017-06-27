import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.mongodb.DBObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ljf on 2017/6/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class Test1 {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    public void testSave(){
        User user = new User("lisi", new Date(), 20);
        mongoTemplate.save(user);
    }
    @Test
    public void query(){
        User byId = mongoTemplate.findById("59510387c25f040215bb4697", User.class);
        System.out.println(byId);
    }
    @Test
    public void queryAll(){
        List<User> all = mongoTemplate.findAll(User.class);
        for (User u:all
             ) {
            System.out.println(u);
        }
    }

    @Test
    public void queryByName(){
        Query query=new Query();
        //添加查询条件
        Criteria criteria=new Criteria("name");
        criteria.is("zhangsan");
        query.addCriteria(criteria);


        DBObject queryObject = query.getQueryObject();
        System.out.println(queryObject);
        List<User> users = mongoTemplate.find(query, User.class);
        for (User u:users
             ) {
            System.out.println(u);
        }
    }

    @Test
    public void queryByPage(){
        //skip 是跳过几条数据.  limit最大数据
        Query query=new Query();
        query.skip(1);
        query.limit(3);
        query.with(new Sort(Sort.Direction.DESC,"age"));
        List<User> users = mongoTemplate.find(query, User.class);
        for (User u:users
             ) {
            System.out.println(u);
        }
    }
    @Test
    public void update(){
        //skip 是跳过几条数据.  limit最大数据
        Query query=new Query();
        Criteria criteria=new Criteria("zhangsan");
        System.out.println(criteria);
      /*  //添加查询条件
        Criteria criteria=new Criteria("name");
        criteria.is("zhangsan");
        criteria.and("age").is(222);
        query.addCriteria(criteria);*/
        //System.out.println(query.getQueryObject());
     /*   Update update=new Update();
        update.set("name","zhangsan");
        update.inc("age",222);
        WriteResult writeResult = mongoTemplate.updateMulti(query, update, User.class);*/
       // System.out.println(writeResult);
        //Criteria criteria1 = new Criteria("age");
        //criteria1.is(19);
    }
    @Test
    public void delete(){
        User user=new User();
        user.setId("595177e8beadcdcd6a49b51d");
        mongoTemplate.remove(user);
    }
    @Test
    public void delete2(){
        Query query=new Query();
        mongoTemplate.remove(query,User.class);
    }
    @Test
    public void save2(){
        User user=new User("天气",new Date(),30);
        Order order=new Order("水果",3.5);
        user.setOrderList(Arrays.asList(order));
        for (Order o:user.getOrderList()
             ) {
            mongoTemplate.save(o);
        }
        //先保存孩子，在保存父亲
        mongoTemplate.save(user);
        System.out.println(user);
    }
    @Test
    public void query2(){
        User byId = mongoTemplate.findById("595117e9c25fbe41fb77140c", User.class);
        System.out.println(byId);
        for (Order o:byId.getOrderList()
             ) {
            System.out.println(o);
        }
    }
}
