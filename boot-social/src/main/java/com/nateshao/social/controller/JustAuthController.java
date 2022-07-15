package com.nateshao.social.controller;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.request.AuthGiteeRequest;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @date Created by 邵桐杰 on 2022/2/23 18:59
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 访问：http://localhost:9093/oauth/render/gitee
 */
@RestController
@RequestMapping("/oauth")
public class JustAuthController {

    /**
     * 获取授权链接并跳转到第三方授权页面
     *
     * @param response response
     * @throws IOException response可能存在的异常
     */
    @RequestMapping("/render/{source}")
    public void renderAuth(HttpServletResponse response) throws IOException {
        AuthRequest authRequest = getAuthRequest();
        String authorizeUrl = authRequest.authorize(AuthStateUtils.createState());
        response.sendRedirect(authorizeUrl);
    }

    /**
     * 用户在确认第三方平台授权（登录）后， 第三方平台会重定向到该地址，并携带code、state等参数
     *
     * @param callback 第三方回调时的入参
     * @return 第三方平台的用户信息
     */
    @RequestMapping("/callback/{source}")
    public Object login(AuthCallback callback) {
        AuthRequest authRequest = getAuthRequest();
        return authRequest.login(callback);
    }

    /**
     * 获取授权Request
     *
     * @return AuthRequest
     */
    private AuthRequest getAuthRequest() {
        return new AuthGiteeRequest(AuthConfig.builder()
                .clientId("6a46c8bbe31b34dd4a5c54e73c828a4e3d3d022c1532cbfe652b11959538b0ce")
                .clientSecret("2d327f4c7e7081c9e9b1ee71828b9ffde9729bed3ef1def4eb25c0ff620a5dac")
                .redirectUri("http://localhost:9093/oauth/callback/gitee")
                .build());
    }

}