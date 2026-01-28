package com.jcloud.lingxi.repository;

import com.jcloud.lingxi.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.noear.solon.annotation.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Mapper
public interface OrderRepository {


    @Select("xxxx")
    List<Order> findRecentOrders(@Param("startTime") LocalDateTime startTime);
}
