package com.example.mybatisconfig.mapper;


import com.example.mybatisconfig.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 当 mapper 接口较多时，我们可以在 Spring Boot 主启动类上使用 @MapperScan 注解扫描指定包下的 mapper 接口，而不再需要在每个 mapper 接口上都标注 @Mapper 注解。
@Mapper
public interface UserMapper {

    //我们可以根据 SQL 的复杂程度，选择不同的方式来提高开发效率。
    //如果没有复杂的连接查询，我们可以使用注解的方式来简化配置；
    //如果涉及的 sql 较为复杂时，则使用 XML （mapper 映射文件）的方式更好一些。


    //1、通过在资源文件夹配置xml文件的方式
    //通过用户名密码查询用户数据
    User getByUserNameAndPassword1(User user);

    //2、通过注解的方式
    @Select("select * from user where user_name = #{userName,jdbcType=VARCHAR} and password = #{password,jdbcType=VARCHAR}")
    User getByUserNameAndPassword(User user);

    @Delete("delete from user where id = #{id,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer id);
    @Insert("insert into user ( user_id, user_name, password, email)" +
            "values ( #{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR})")
    int insert(User record);
    @Update(" update user" +
            "    set user_id = #{userId,jdbcType=VARCHAR},\n" +
            "      user_name = #{userName,jdbcType=VARCHAR},\n" +
            "      password = #{password,jdbcType=VARCHAR},\n" +
            "      email = #{email,jdbcType=VARCHAR}\n" +
            "    where id = #{id,jdbcType=INTEGER}")
    int updateByPrimaryKey(User record);
}
