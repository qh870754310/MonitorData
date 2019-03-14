package monitorData.service;

import com.alibaba.fastjson.JSONArray;

/**
 * 业务逻辑接口
 * Created by Administrator on 2017/9/25.
 */

public interface ApiService {

    /**
     * 获取所有的电表参数
     *
     * @return 列表数据
     */
    JSONArray getElectricityMeterParameter();
}
