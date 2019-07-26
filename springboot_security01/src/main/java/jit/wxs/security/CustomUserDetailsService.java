package jit.wxs.security;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import jit.wxs.entity.SysUser;
import jit.wxs.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 自定义userDetailsService
 *
 * @author jitwxs
 * @since 2018/5/9 9:36
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        // 从数据库中取出用户信息
        SysUser user = userService.selectByName(username);
      //  System.out.println("当前用户："+user.getName());
        //System.out.println("当前用户："+user.getPassword());
        //System.out.println(authorities.size());
        // 判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }


        // 返回UserDetails实现类
        return new User(username,user.getPassword(), authorities);
    }
}
