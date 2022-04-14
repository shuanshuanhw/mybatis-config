package com.example.mybatisconfig.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.mybatisconfig.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shuanshuan
 * @since 2022-04-14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
//    // 根据 ID 查询
//    User selectById(Serializable id);
//    // 根据 entity 条件，查询一条记录
//    User selectOne(@Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
//
//    // 查询（根据ID 批量查询）
//    List<User> selectBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
//    // 根据 entity 条件，查询全部记录
//    List<User> selectList(@Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
//    // 查询（根据 columnMap 条件）
//    List<User> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
//    // 根据 Wrapper 条件，查询全部记录
//    List<Map<String, Object>> selectMaps(@Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
//    // 根据 Wrapper 条件，查询全部记录。注意： 只返回第一个字段的值
//    List<Object> selectObjs(@Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
}
