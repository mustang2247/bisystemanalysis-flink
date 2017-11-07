package com.mybitop.biaflink.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * HTTP工具类
 */
public class HttpUtils {

    private static String CHAR_SET = "UTF-8";
    // -------------------------http Get--------------------------

    /**
     * get 请求
     *
     * @param host 地址
     * @param pars 参数
     * @return
     * @throws Exception
     *
     * 从网络获取json数据
     */
    public static String Get(String host, Map<String, String> pars)
            throws Exception {

        String query = null;
        if(pars != null){
            pars.put("sign_type", "md5");
            query = Create_linkString(pars, CHAR_SET);
        }

        if (host.indexOf("?") != -1)
            host += "&_charset=" + CHAR_SET;
        else
            host += "?_charset=" + CHAR_SET;

        return getRequest(host, query, CHAR_SET);
    }

    /**
     * get 请求
     *
     * @param url
     * @param param
     * @param _input_charset
     * @return
     * @throws Exception
     */
    private final static String getRequest(String url, String param,
                                           String _input_charset) throws Exception {
        BufferedReader in = null;
        String result = "";
        try {
            if (param != null && !param.isEmpty()){
                url += param;
            }
            URL realUrl = new URL(url.trim());
            // 打开和URL之间的连接
            HttpURLConnection httpURLConnection = (HttpURLConnection) realUrl
                    .openConnection();
            httpURLConnection.setRequestMethod("GET");

            // 设置连接主机超时时间
            httpURLConnection.setConnectTimeout(5 * 1000);
            //设置从主机读取数据超时
            httpURLConnection.setReadTimeout(5 * 1000);
            // 设置是否使用缓存  默认是true
            httpURLConnection.setUseCaches(true);

            // 设置通用的请求属性
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty("content-type",
                    "application/x-www-form-urlencoded;charset="
                            + _input_charset);

            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    httpURLConnection.getInputStream(), _input_charset));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            throw e;
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    // -------------------------http Post--------------------------

    /**
     * http 请求
     *
     * @param host 地址
     * @param pars 参数
     * @return
     * @throws Exception
     */
    public static String Post(String host, Map<String, String> pars)
            throws Exception {

        pars.put("sign_type", "md5");

        // String sign = Build_mysign(pars, key, CHAR_SET);
        // pars.put("_sign", sign);
        String query = Create_linkString(pars, CHAR_SET);

        if (host.indexOf("?") != -1)
            host += "&_charset=" + CHAR_SET;
        else
            host += "?_charset=" + CHAR_SET;

        return PostRequest(host, query, CHAR_SET);
    }

    /**
     * post 请求
     *
     * @param url
     * @param param
     * @param _input_charset
     * @return
     * @throws Exception
     */
    private final static String PostRequest(String url, String param,
                                            String _input_charset) throws Exception {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url.trim());
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl
                    .openConnection();
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("content-type",
                    "application/x-www-form-urlencoded;charset="
                            + _input_charset);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);//使用 URL 连接进行输出
            conn.setDoInput(true);//使用 URL 连接进行输入
            conn.setUseCaches(false);// 忽略缓存
            // 获取URLConnection对象对应的输出流

            out = new OutputStreamWriter(conn.getOutputStream(), _input_charset);
            // 发送请求参数
            out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), _input_charset));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            throw e;
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 创建连接
     *
     * @param dicArray
     * @param _input_charset
     * @return
     */
    private static String Create_linkString(Map<String, String> dicArray,
                                            String _input_charset) {
        StringBuilder prestr = new StringBuilder();
        try {
            for (String key : dicArray.keySet()) {
                String value = dicArray.get(key);
                if (value == null || value.isEmpty())
                    continue;
                prestr.append("&" + key + "="
                        + URLEncoder.encode(value, _input_charset));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (prestr.length() > 0)
            return prestr.substring(1);
        return prestr.toString();
    }


    //=============================================================

    public static void main(String[] args) throws Exception {
        String url = "http://bi.mybi.top:9009/versionSelect/getAccountById/1";
        System.out.println(Get(url, null));
    }

}
