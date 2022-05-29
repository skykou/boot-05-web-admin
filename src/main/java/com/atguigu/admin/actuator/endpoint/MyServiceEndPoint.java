package com.atguigu.admin.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * @author zhangtao
 * @date 2022/5/27 - 22:54
 */
@Component
@Endpoint(id = "myservice")
public class MyServiceEndPoint {
    @ReadOperation
    public Map getDockerInfo(){
        //端点的读操作
        return Collections.singletonMap("dockerInfo","docker started....");
    }

    @WriteOperation
    public void stopDocker(){
        System.out.println("docker stopped.....");
    }
}
