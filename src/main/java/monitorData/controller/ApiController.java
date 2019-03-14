package monitorData.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import monitorData.service.ApiService;
import monitorData.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/9/25.
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    /**
     * 获取电表参数
     *
     * @param response HttpServletResponse对象
     */
    @RequestMapping("/getElectricityMeterParameter")
    public void getElectricityMeterParameter(HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONArray js = apiService.getElectricityMeterParameter();
            jsonObject.put("state", true);
        } catch (Exception e) {
            jsonObject.put("state", false);
        }
        ResponseHelper.write(response, jsonObject);
    }
}
