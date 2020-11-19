package com.qt.login;

import com.qt.domain.user.User;
import com.qt.repository.UserRepository;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class LoginService {
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserRepository userRepository;
    private static final String LOGIN_AUTH_SERVER_URL="https://swauth.cbnu.ac.kr/local/login";
    private static final String VALID_AUTH_SERVER_URL="https://swauth.cbnu.ac.kr/valid";
    public String check(String no, String pw){
        //아이디, 패스워드가 맞는지 확인(토큰을 성공적으로 가져오면 로그인성공)
       String token=getUserToken(no,pw);
       if(token=="" || token=="execption") return "로그인 실패";

       //토큰을이용해 유저정보가져오기
       String userInfo=getUserInfo(token);

       //json 파싱
       JSONObject jsonObject=new JSONObject(userInfo);
       String role=jsonObject.getJSONObject("data").getJSONArray("roles").get(0).toString();
       System.out.println("role: "+role);

       User user=userRepository.findByUserId(no);
       //기존회원이아니라면 user테이블에 저장
       if(user==null) {
           user = new User(no);
           userRepository.save(user);

       }
        return "로그인 성공";


    }
    //로그인한 유저의 토큰가져오기
    public String getUserToken(String no, String pw){
        try {
            URL url=new URL(LOGIN_AUTH_SERVER_URL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);

            OutputStreamWriter wr=new OutputStreamWriter(con.getOutputStream());
            String data="no="+no +"&password="+pw;
            wr.write(data);
            wr.flush();

            //응답
            StringBuilder sb=new StringBuilder();
            if(con.getResponseCode()== HttpURLConnection.HTTP_OK){
                BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
                String line;
                while((line=br.readLine())!=null){
                    sb.append(line).append("\n");
                }
                br.close();
                System.out.println(sb.toString());

                //JSON파싱: 토큰정보얻어옴
                JSONObject jsonObject=new JSONObject(sb.toString());
                String token=jsonObject.getString("data");
                System.out.println("token: "+token);
                return token;


            }else{
                System.out.println(con.getResponseMessage());
                return "";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "execption";
        }
    }

    //토큰으로 사용자정보 가져오기
    public String getUserInfo(String token){
        try {
        URL url=new URL(VALID_AUTH_SERVER_URL);
        HttpURLConnection con= (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("x-access-token",token);
        int responseCode=con.getResponseCode();
        BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        StringBuilder sb=new StringBuilder();
        while((line=br.readLine())!=null){
                sb.append(line);
            }
        br.close();
        System.out.println(sb);
        return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "exception";
        }
    }
}
