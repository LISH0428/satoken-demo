package com.example.satokendemo.satoken;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 */
@Component    // 保证此类被SpringBoot扫描，完成Sa-Token的自定义权限验证扩展
public class StpInterfaceImpl implements StpInterface {
    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return authList(loginId.toString());
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {

        return null;
    }
    private List<String> authList(String type) {
        List<String> list = new ArrayList<>();
        switch (type) {
            case "super-admin": {
                list.add("add");
            }
            case "admin": {
                list.add("delete");
            }
            default:
                list.add("search");
        }
        return list;
    }
}