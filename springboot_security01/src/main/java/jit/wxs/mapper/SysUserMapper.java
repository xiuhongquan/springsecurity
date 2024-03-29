package jit.wxs.mapper;

import jit.wxs.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author jitwxs
 * @date 2018/3/30 1:21
 */
@Mapper
public interface SysUserMapper {
    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser selectById(Integer id);

    @Select("SELECT * FROM sys_user WHERE name = #{name}")
    SysUser selectByName(String name);
    @Select("SELECT * FROM sys_user ")
    SysUser[] selectUser();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO sys_user (name, password) VALUES (#{username}, #{password})")
    void addUser(String username,String password);
}
