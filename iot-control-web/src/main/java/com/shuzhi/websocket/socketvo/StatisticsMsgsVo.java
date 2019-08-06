package com.shuzhi.websocket.socketvo;

import com.shuzhi.light.entities.TLoopStateDto;
import lombok.Data;

import java.util.List;

/**
 * @ProjectName: bus-station-web
 * @Package: com.shuzhi.websocket.socketvo
 * @ClassName: StatisticsMsgVo统计能耗实体类
 * @Author: 陈鑫晖
 * @Date: 2019/7/19 14:57
 */
@Data
public class StatisticsMsgsVo {

    /**
     * 亮灯率
     */
    private String lightrate;

    /**
     * 在线率
     */
    private String onlinerate;

    /**
     * 总数
     */
    private Integer total = 0;

    /**
     * 亮灯数
     */
    private Integer onnum = 0;

    /**
     * 熄灯数
     */
    private Integer offnum = 0;

    /**
     * 故障数
     */
    private Integer errornum = 0;

    public void addLightNum(List<TLoopStateDto> tLoopStateDtos) {

        this.total = tLoopStateDtos.size();
        this.onnum = Math.toIntExact(tLoopStateDtos.stream().filter(tStatusDto -> tStatusDto.getState() == 1).count());
        this.offnum = Math.toIntExact(tLoopStateDtos.stream().filter(tStatusDto -> tStatusDto.getState() == 0).count());
        this.errornum = Math.toIntExact(tLoopStateDtos.stream().filter(tStatusDto -> tStatusDto.getState() == 0).count());

        this.onlinerate = onnum/total*100+"%";
        this.lightrate = (total-errornum)/total*100+"%";
    }
}