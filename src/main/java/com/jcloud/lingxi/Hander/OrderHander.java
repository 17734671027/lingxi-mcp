package com.jcloud.lingxi.Hander;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.jcloud.lingxi.service.MonitorOrderService;
import org.noear.solon.ai.annotation.ToolMapping;
import org.noear.solon.ai.mcp.McpChannel;
import org.noear.solon.ai.mcp.server.annotation.McpServerEndpoint;
import org.noear.solon.annotation.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;


//工具，会再调用 dashscope 的模型。
@McpServerEndpoint(name = "jcloud-business-mcp", channel = McpChannel.SSE, mcpEndpoint = "/mcp/order")
public class OrderHander {
    @Autowired
    private MonitorOrderService monitorOrderService;


    @ToolMapping(description = "查询订单详情")
    public String describeOrder(String orderNumber) {
        return "查询订单详情";
    }
    @ToolMapping(description = "群发处理中订单")
    public String sendOrderIng(Date startTime, Date endTime) {
        return "群发处理中订单成功";
    }

}
