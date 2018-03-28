package com.yyj.springbootuploaddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by 超级战机
 * 2018-03-28 21:34
 */

@Controller
@RequestMapping("/read")
public class ReadImgController {

    @GetMapping("/img/{type}/{name}")
    public void readImg(@PathVariable(value = "name")String name,
                        @PathVariable(value = "type")String type,
                        HttpServletResponse response) throws IOException {
        String path = "D:\\upload\\"+type+"\\"+name;
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        byte[] b = new byte[1024];
        int length = 0;
        while((length=inputStream.read(b))!=-1){
            out.write(b,0,length);
        }
        out.close();
        inputStream.close();
    }
}
