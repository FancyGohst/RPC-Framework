

package zishuo.server;

import zishuo.common.RPCRequest;
import zishuo.common.RPCResponse;
import zishuo.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class RPCServer {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            System.out.println("server have launched");
            // listens to the Socket
            while (true){
                Socket socket = serverSocket.accept();
                // have a new thread to take care of this
                new Thread(()->{
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        RPCRequest request = (RPCRequest) ois.readObject();
                        Method method = userService.getClass().getMethod(request.getMethodName(),request.getParamsTypes());
                        Object invoke = method.invoke(userService,request.getParams());
                        // tell the user that they asked for
                        oos.writeObject(RPCResponse.success(invoke));
                        oos.flush();
                    } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                             InvocationTargetException e) {
                        e.printStackTrace();
                        System.out.println("IO error");
                    }
                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server launch error");
        }
    }
}