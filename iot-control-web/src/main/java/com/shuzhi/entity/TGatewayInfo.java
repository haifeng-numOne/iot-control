package com.shuzhi.entity;

import lombok.Data;

import java.io.Serializable;
/**
* @Program: TGatewayInfo页面调用接口获取集中控制器位置信息
* @Description: 
* @Author: YuJQ
* @Create: 2019/8/13 13:20
**/
@Data
public class TGatewayInfo implements Serializable {
    private Long id;

    //private String lamppostid;

    //private String did;

    private Double latitude;

    private Double longitude;

    //为了前端好调用,所以把网关改成灯杆字段,

    private Integer lamppostid;

    private String lamppostname;

    private Double height;


}
