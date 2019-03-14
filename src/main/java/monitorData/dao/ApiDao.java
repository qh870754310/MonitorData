package monitorData.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 数据访问接口
 * Created by Administrator on 2017/9/25.
 */
@Repository
public interface ApiDao {

    /**
     * 获取所有的电表的参数
     *
     * @return
     */
    List<Map> getElectricityMeterParameter();
}
