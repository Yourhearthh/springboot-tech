package com.example;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URLEncoder;

@SpringBootTest
class SpringbootHttpApplicationTests {

    @Test
    void testPum() throws IOException {
        //泵站数据获取地址及请求参数
        String url = "dadsff";
        String strWY = "ndfsafd";
        HttpClient httpClient = new DefaultHttpClient();
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        StringEntity postingStringWY = new StringEntity(strWY);
        httpPost.setEntity(postingStringWY);
        HttpResponse response = httpClient.execute(httpPost);
        String str = EntityUtils.toString(response.getEntity());
        System.out.println("xxxxx" + str);
        JSONObject jsonObject = null;
        try {
            jsonObject = JSONObject.parseObject(str);
            System.out.println(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject object = jsonObject.getJSONObject("0");
        System.out.println("这个是获得的json节点" + object);
        JSONArray jsonArray = object.getJSONArray("t");
        System.out.println("数组里面的数据" + jsonArray);
        Object[] o = jsonArray.toArray();
        for (Object e : o) {
            System.out.println(e);
        }
    }

    @Test
    void contextLoads() throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://localhost:8080/type/getTypePost");
        HttpResponse response = httpClient.execute(httpPost);
        String str = EntityUtils.toString(response.getEntity());
        System.out.println("xxxxx" + str);
        JSONObject jsonObject = null;
        try {
            jsonObject = JSONObject.parseObject(str);
            System.out.println("JSON" + jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jsonObject != null && !jsonObject.equals("")) {
            String json = jsonObject.getString("message");
            System.out.println("aaaaa" + json);
        }
    }

    /**
     * GET---无参测试
     *
     * @date 2018年7月13日 下午4:18:50
     */
    @Test
    public void doGetTestOne() {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
//        HttpGet httpGet = new HttpGet("http://localhost:8080/type/getTypes");

        HttpGet httpGet = new HttpGet("http://localhost:8080/hello");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // GET有参(方式一：直接拼接URL)
    @Test
    void doGetTestWayOne() {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        // 拼接参数
        StringBuffer params = new StringBuffer();
        try {
            params.append("name=" + URLEncoder.encode("包光宇", "utf-8"));
            params.append("&");
            params.append("age=24");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpGet httpGet = new HttpGet("http://localhost:8080/doGetControllerTwo" + "?" + params);
        CloseableHttpResponse response = null;
        try {
            // 配置信息
            RequestConfig requestConfig = RequestConfig.custom()
                    // 设置连接超时时间(单位毫秒)
                    .setConnectTimeout(5000)
                    // 设置请求超时时间(单位毫秒)
                    .setConnectionRequestTimeout(5000)
                    // socket读写超时时间(单位毫秒)
                    .setSocketTimeout(5000)
                    // 设置是否允许重定向(默认为true)
                    .setRedirectsEnabled(true).build();

            // 将上面的配置信息 运用到这个Get请求里
            httpGet.setConfig(requestConfig);

            // 由客户端执行(发送)Get请求
            response = client.execute(httpGet);

            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }







}
