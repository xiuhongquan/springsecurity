package jit.wxs.service;

import jit.wxs.entity.SysUser;
import jit.wxs.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jitwxs
 * @date 2018/3/30 1:26
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
    public SysUser[] selectUser() {
        return userMapper.selectUser();
    }

    public void addUser(String username,String password){
         userMapper.addUser(username,password);
    }
}
