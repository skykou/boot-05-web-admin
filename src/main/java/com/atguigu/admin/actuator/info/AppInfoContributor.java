package com.atguigu.admin.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author zhangtao
 * @date 2022/5/27 - 22:35
 */
@Component
public class AppInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","你好")
                .withDetail("hello","atguigu")
                .withDetails(Collections.singletonMap("world","666000"));
    }
}
