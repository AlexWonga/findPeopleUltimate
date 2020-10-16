package com.j2ee.homework.findPeople.utils;

import com.j2ee.homework.findPeople.pojo.FaceMatchData;
import com.j2ee.homework.findPeople.utils.baiduUtils.FileUtil;
import com.j2ee.homework.findPeople.utils.baiduUtils.GsonUtils;
import com.j2ee.homework.findPeople.utils.baiduUtils.HttpUtil;
import sun.misc.BASE64Encoder;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;

/**
 * 人脸对比
 */
public class FaceMatch {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static int faceMatch(String path1,String path2) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            byte[] imgData1 = FileUtil.readFileByBytes(path1);
            byte[] imgData2 = FileUtil.readFileByBytes(path2);
            String imgStr1 = encoder.encode(imgData1);
            String imgStr2 = encoder.encode(imgData2);
            ArrayList faceMaths = new ArrayList();
            FaceMatchData faceMatch1 = new FaceMatchData(imgStr1,"BASE64");
            FaceMatchData faceMatch2 = new FaceMatchData(imgStr2,"BASE64");
            faceMaths.add(faceMatch1);
            faceMaths.add(faceMatch2);
            String param = GsonUtils.toJson(faceMaths);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.8d7aa0b70109d63e7677e0c54545822e.2592000.1605438916.282335-22821776";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            JSONObject o = JSONObject.parseObject(result);
            return o.getJSONObject("result").getInteger("score");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        FaceMatch.faceMatch("E://findPeopleUltimate/src/main/resources/static/face.jpg","E://findPeopleUltimate/src/main/resources/static/face.jpg");
    }
}