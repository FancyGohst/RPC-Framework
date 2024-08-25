package zishuo.service;

import zishuo.common.User;
public interface UserService {
    User getUserByUserId(Integer id);
    Integer insertUserId(User user);
}
