package com.example.grpcserver.baidu.ocr;

/**
 * @ Description:通用票据识别
 * @ author: Joy
 * @ date:2018年9月16日下午9:06:31
 */

import java.net.URLEncoder;


import com.baidu.aip.util.Base64Util;
import com.example.grpcserver.Util.FileUtil;
import com.example.grpcserver.Util.HttpUtil;
import com.example.grpcserver.service.AuthService;

/**
 * @author Joy
 *
 */
public class Receipt {
    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static void main(String[] args) {
        // 通用票据识别url
        String receipt = "https://aip.baidubce.com/rest/2.0/ocr/v1/receipt";
        // 本地图片路径
        String filePath = "E://FP.jpg";//"#####本地文件路径#####"
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            String accessToken = AuthService.getAuth();//"#####调用鉴权接口获取的token#####"
            String result = HttpUtil.post(receipt, accessToken, params);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
