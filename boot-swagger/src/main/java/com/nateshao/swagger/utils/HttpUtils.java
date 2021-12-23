package com.nateshao.swagger.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Set;

/**
 * @date Created by 邵桐杰 on 2021/11/16 16:11
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class HttpUtils {
    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    private static final String CTYPE_FORM = "application/x-www-form-urlencoded;charset=utf-8";
    private static final String CTYPE_JSON = "application/json; charset=utf-8";
    private static final String charset = "utf-8";
    private static final int timeout = 15000;  //超时单位：毫秒

    private static HttpUtils instance = null;

    public static HttpUtils getInstance() {
        if (instance == null) {
            return new HttpUtils();
        }
        return instance;
    }


    /**
     * 以application/json; charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String postJson(String url, String jsonContent) {
        return doRequest("POST", url, jsonContent, 15000, 15000, CTYPE_JSON,
                null);

    }

    /**
     * 以application/json; charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String postJson(String url, Map<String, String> params) {
        String jsonContent = JSON.toJSONString(params);
        return doRequest("POST", url, jsonContent, 15000, 15000, CTYPE_JSON,
                null);
    }

    /**
     * POST 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String postForm(String url) {
        return doRequest("POST", url, "", 15000, 15000, CTYPE_FORM,
                null);
    }

    /**
     * POST 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String postForm(String url, Map<String, String> params) {
        return doRequest("POST", url, buildQuery(params), 15000, 15000,
                CTYPE_FORM, null);
    }

    /**
     * GET 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String getForm(String url, Map<String, String> params) {
        return doRequest("GET", url, buildQuery(params), 15000, 15000,
                CTYPE_FORM, null);
    }

    /**
     * GET 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String get(String url) {
        return doRequest("GET", url, "", 15000, 15000, CTYPE_FORM,
                null);
    }

    /**
     * GET 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String get(String url, Map<String, String> params) {
        return doRequest("GET", url + "?" + buildQuery(params), "",
                15000, 15000, CTYPE_FORM, null);
    }

    /**
     * <p>@Description: </p>
     *
     * @param method         请求的method post/get
     * @param url            请求url
     * @param param          请求参数
     * @param connectTimeout 请求超时
     * @param readTimeout    响应超时
     * @param ctype          请求格式  xml/json等等
     * @param headerMap      请求header中要封装的参数
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     * @Title doRequest
     */
    private static String doRequest(String method, String url, String param,
                                    int connectTimeout, int readTimeout, String ctype, Map<String, String> headerMap) {
        HttpURLConnection conn = null;
        OutputStream out = null;
        String rsp = null;
        try {
            long millis = System.currentTimeMillis();
            log.info("请求：" + url + ",参数：[ " + param + " ]" + (headerMap == null ? "" : ",header：" + headerMap));
            conn = getConnection(new URL(url), method, ctype, headerMap);
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);
            if (param != null && param.trim().length() > 0) {
                out = conn.getOutputStream();
                out.write(param.getBytes(charset));
            }
            rsp = getResponseAsString(conn);
            long time = System.currentTimeMillis() - millis;
            log.info("响应结果(耗时:" + time + ")：\n" + rsp.replaceAll("\n", ""));
        } catch (ConnectException e) {
            log.error("调用HttpUtils.doRequest ConnectException, url=" + url + ",param=" + param, e);
        } catch (SocketTimeoutException e) {
            log.error("调用HttpUtils.doRequest SocketTimeoutException, url=" + url + ",param=" + param, e);
        } catch (IOException e) {
            log.error("调用HttpUtils.doRequest IOException, url=" + url + ",param=" + param, e);
        } catch (Exception e) {
            log.error("调用HttpsUtil.doRequest Exception, url=" + url + ",param=" + param, e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException ex) {
                log.error("调用in.close Exception, url=" + url + ",param=" + param, ex);
            }
            conn = null;
        }
        return rsp;
    }

    private static HttpURLConnection getConnection(URL url, String method,
                                                   String ctype, Map<String, String> headerMap) throws IOException {
        HttpURLConnection conn;
        if ("https".equals(url.getProtocol())) {
            SSLContext ctx;
            try {
                ctx = SSLContext.getInstance("TLS");
                HttpUtils.DefaultTrustManager defaultTrustManager = new HttpUtils().new DefaultTrustManager();
                ctx.init(new KeyManager[0],
                        new TrustManager[]{defaultTrustManager},
                        new SecureRandom());
            } catch (Exception e) {
                throw new IOException(e);
            }
            HttpsURLConnection connHttps = (HttpsURLConnection) url
                    .openConnection();
            connHttps.setSSLSocketFactory(ctx.getSocketFactory());
            connHttps.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            conn = connHttps;
        } else {
            conn = (HttpURLConnection) url.openConnection();
        }
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept",
                "text/xml,text/javascript,text/html,application/json");
        conn.setRequestProperty("Content-Type", ctype);
        if (headerMap != null) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return conn;
    }

    private static String getResponseAsString(HttpURLConnection conn)
            throws IOException {
        InputStream es = conn.getErrorStream();
        if (es == null) {
            return getStreamAsString(conn.getInputStream(), charset, conn);
        } else {
            String msg = getStreamAsString(es, charset, conn);
            if (msg != null && msg.trim().length() > 0) {
                throw new IOException(conn.getResponseCode() + ":"
                        + conn.getResponseMessage());
            } else {
                return msg;
            }
        }
    }

    private static String getStreamAsString(InputStream stream, String charset,
                                            HttpURLConnection conn) throws IOException {
        try {
            Reader reader = new InputStreamReader(stream, charset);

            StringBuilder response = new StringBuilder();
            final char[] buff = new char[1024];
            int read = 0;
            while ((read = reader.read(buff)) > 0) {
                response.append(buff, 0, read);
            }

            return response.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public static String buildQuery(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }

        StringBuilder query = new StringBuilder();
        Set<Map.Entry<String, String>> entries = params.entrySet();
        boolean hasParam = false;

        for (Map.Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            if (hasParam) {
                query.append("&");
            } else {
                hasParam = true;
            }
            try {
                query.append(name).append("=")
                        .append(URLEncoder.encode(value, charset));
            } catch (UnsupportedEncodingException e) {
                String msg = "调用HttpUtils.buildQuery UnsupportedEncodingException";
                log.error(msg, e);
                throw new RuntimeException(msg + e.getMessage());
            }
        }
        return query.toString();
    }

    private class DefaultTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }
    }
}
