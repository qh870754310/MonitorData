package monitorData.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import monitorData.dao.ApiDao;
import monitorData.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 业务逻辑实现
 * Created by Administrator on 2017/9/25.
 */
@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ApiDao apiDao;

    /**
     * 获取所有的电表参数
     *
     * @return 列表数据
     */
    @Override
    public JSONArray getElectricityMeterParameter() {
        List<Map> maps = apiDao.getElectricityMeterParameter();
        return (JSONArray) JSON.toJSON(maps);
    }
}
