package zishuo.server;

import zishuo.common.User;
import zishuo.service.UserService;

import java.util.Random;
import java.util.UUID;

public class UserServiceImpl implements UserService{
    @Override
    public User getUserByUserId(Integer id) {
        System.out.println("client searched" +id+"user");
        Random random = new Random();
        User user = User.builder().userName(UUID.randomUUID().toString()).id(id).sex(random.nextBoolean()).build();
        return user;
    }
    @Override
    public Integer insertUserId(User user) {
        System.out.println("insert successfully" + user);
        return 1;
    }
}
