package com.jcloud.lingxi.service;


import com.jcloud.lingxi.repository.OrderRepository;
import com.jcloud.order.client.dictionary.OrderStatusEnum;
import io.micrometer.common.util.StringUtils;
import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.ArrayList;

@Component
public class MonitorOrderService {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Db("db1")
    private OrderRepository orderRepository;


   //支持查库
    public String monitorOrderStatus(Date startTime, Date endTime)  {
        return "查询订单详情";
    }
}
