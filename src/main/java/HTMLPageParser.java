import java.io.*;

import org.apache.http.HttpEntity;
//import org.apache.http.HttpStatus;
import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.impl.DefaultHttpRequestFactory;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
//import sun.management.resources.agent;

import static java.lang.System.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HTMLPageParser {

    public static void main(String[] args) throws Exception{
	// write your code here
        Connect connect=new Connect(url,origin,url,user_agent);
        HttpResponse response=connect.httpClient.execute(connect.get);
        HttpEntity entity=response.getEntity();
        {InputStream in=entity.getContent();
            //InputStream in=null;
            //保存到本地
            SaveToLocal(in,filePath,"1.html");}
        String crsf=Get_crsf(in);
        if(!connect.SetBody(crsf,body)){
            System.exit(-1);
        }
        else {
            //HttpResponse
            response=connect.httpClient.execute(connect.post);
            String result = EntityUtils.toString(response.getEntity(),"UTF-8");
            while (response.getStatusLine().getStatusCode()==302)
            {
                response=connect.httpClient.execute(connect.post);
                result = EntityUtils.toString(response.getEntity(),"UTF-8");
            }
            //print_res(response);
            {
//                InputStream in2=response.getEntity().getContent();
//                SaveToLocal(in2,filePath,"2.html");
            }
            response=connect.httpClient.execute(connect.httpHost,new HttpGet("https://www.docdroid.net/cUX0hjn/arianne.docx"));
            {
                InputStream in=response.getEntity().getContent();
                SaveToLocal(in,filePath,"3.html");
            }
        }
    }

    private static String filePath = "E:\\wyc\\Documents\\程序\\Java\\webpage_catcher\\";
    private static String fileName="crawlPage.html";
    private static String url = "https://www.docdroid.net/cUX0hjn/password";
    private  static String origin="https://www.docdroid.net";
    private  static String user_agent="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36";
    private  static String body="{\"password\":\"Sunspear\",\"errors\":\"{errors:{}}\",\"busy\":\"true\",\"successful\":\"false\"}";

    private static void SaveToLocal(InputStream ins, String filePath, String fileName) throws IOException {
        File file=new File(filePath);
        if (!file.exists()){
            file.mkdirs();
        }
        DataOutputStream out=new DataOutputStream(new FileOutputStream(new File(filePath+fileName)));
        int result;
        while ((result=ins.read())!=-1){
            out.write(result);
        }
        ins.close();
        out.flush();
        out.close();
    }

    private static void print_res(HttpResponse res) throws Exception{
        System.out.println("状态码"+res.getStatusLine().getStatusCode());
        HttpEntity entity=res.getEntity();
        System.out.println(EntityUtils.toString(entity,"utf-8"));
    }

    private static String Get_crsf(InputStream in) {
        String str=(new Scanner(System.in)).nextLine();
        return str;
    }

    public static class Connect{
        public static HttpGet get;
        public static HttpPost post;
        public static CloseableHttpClient httpClient;
        public static HttpHost httpHost;

        public static void SetHttpClient(String u) throws Exception{

        }

        public Connect(String u,String o,String r,String ua) {
            String url=u;
            try {
                URL _url= new URL(u);
                httpHost=new HttpHost(_url.getHost(), _url.getPort(),"https");
            }catch (Exception e){
                //do nothing!!!
            }
            httpClient= HttpClients.createDefault();
            get = new HttpGet(url);
            post = new HttpPost(url);
            //设置请求头
            if(!SetPost(o,r,ua)){
                System.exit(-1);
            }
        }

        private boolean SetPost(String origin,String referer,String user_agent){
            //post.setHeader("User-Agent",user_agent);
            return SetPost(origin,referer);
        }

        private boolean SetPost(String origin,String referer){
            post.setHeader("Accept","*/*");
            post.setHeader("Origin",origin);
            post.setHeader("Referer",referer);
            post.setHeader("Sec-Fetch-Mode","cors");
            post.setHeader("Content-Type","application/json;charset=UTF-8");
            post.setHeader("X-Requested-With","XMLHttpRequest");
            post.setHeader("Host","www.docdroid.net");
//            post.setHeader("x-csrf-token",csrf);
//            post.setEntity(new StringEntity(body,"utf-8"));
            if(post.getHeaders("Origin").length>0){
                return true;
            }
            return false;
        }

        private boolean SetBody(String crsf,String body){
            post.setHeader("X-CSRF-TOKEN",crsf);
            //post.setHeader("X-Requested-With","XMLHttpRequest");
            StringEntity se=new StringEntity(body,"utf-8");
            se.setContentType("text/json");
            post.setEntity(se);
//            List<NameValuePair> nvps=new ArrayList<NameValuePair>();
//            nvps.add(new BasicNameValuePair("password","Sunspear"));
//            nvps.add(new BasicNameValuePair("errors","{errors:{}}"));
//            nvps.add(new BasicNameValuePair("busy","true"));
//            nvps.add(new BasicNameValuePair("successful","false"));
//            try {
//                post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
//            }catch (UnsupportedEncodingException e){
//                return false;
//            }

            if (post.getHeaders("X-CSRF-TOKEN").length>0) {
             return true;
            }
            return false;
        }
    }

}

