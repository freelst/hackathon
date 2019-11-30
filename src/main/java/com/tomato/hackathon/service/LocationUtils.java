package com.tomato.hackathon.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LocationUtils {
    public static String httpURLConectionGET(String latitude, String longitude) {
        String getUrl = "https://restapi.amap.com/v3/place/around?key=775d3ae3e93fb1af5934f98daf9e8cad&location=" + latitude +"," + longitude +"&keywords=%E7%BE%8E%E9%A3%9F&offset=20&page=1&extensions=base";
        try {
            URL url = new URL(getUrl);    // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            System.out.println("Get=="+sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
        }
        return null;
    }
}
