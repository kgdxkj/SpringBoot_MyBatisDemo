package cn.wq.demo.service.impl;

import cn.wq.demo.mapper.UserMapper;
import cn.wq.demo.model.User;
import cn.wq.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: SpringBoot_MyBatisDemo
 * @description: 用户service实现层
 * @author: Mr.Wu
 * @create: 2019-02-11 17:29
 **/
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    //@Transactional   //事务
    public int addUser(User user) {

        userMapper.insertSelective(user);

        int a = 1/0;
        user.setUserid(999);
        user.setUsername("中国");
        user.setPassword("4444444");
        user.setPhone("110");
        userMapper.insertSelective(user);

        return 2;
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }
}

