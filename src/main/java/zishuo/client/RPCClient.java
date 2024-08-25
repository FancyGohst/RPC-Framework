package zishuo.client;

import zishuo.common.User;
import zishuo.service.UserService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class RPCClient {
    public static void main(String[] args) {

        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8899);
        UserService proxy = clientProxy.getProxy(UserService.class);

        User userByUserId = proxy.getUserByUserId(10);
        System.out.println("Found user from server to be" + userByUserId);

        User user = User.builder().userName("jack").id(100).sex(true).build();
        Integer integer = proxy.insertUserId(user);
        System.out.println("Giver server" + integer);
    }
}