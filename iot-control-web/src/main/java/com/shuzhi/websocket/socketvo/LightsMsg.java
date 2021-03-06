package com.shuzhi.websocket.socketvo;

import com.shuzhi.entity.ControllerLights;
import com.shuzhi.entity.GroupLightpoleDev;
import lombok.Data;

import java.util.List;

/**
 * @author hulinag
 * @description 照明首次连接数据
 * @date 2019-07-15 16:30
 */
@Data
public class LightsMsg {

//    private List<Groups> groups;
//
//    public LightsMsg(List<Groups> groups) {
//        this.groups = groups;
//    }


    private List<GroupLightpoleDev> groups;

    public LightsMsg(List<GroupLightpoleDev> groups) {
        this.groups = groups;
    }

}
