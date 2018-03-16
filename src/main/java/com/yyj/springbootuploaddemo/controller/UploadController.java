package com.yyj.springbootuploaddemo.controller;

import com.yyj.springbootuploaddemo.VO.ResultVO;
import com.yyj.springbootuploaddemo.utils.ResultVOUtil;
import com.yyj.springbootuploaddemo.utils.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 八哥
 * @computer：Administrator
 * @create 2018-03-16 上午 11:06
 */
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    @PostMapping("/img/{type}")
    private ResultVO<Map<String,String>> uploadFile(@RequestParam("key") String key,
                                                HttpServletRequest request,
                                                @PathVariable String type,
                                                MultipartFile file){
        Map<String,String> map = new HashMap<>();
        //线上path
        /*String path = request.getSession().getServletContext()
                .getRealPath("\\upload\\" +type+"\\");*/
        //测试path
        String path = "D:\\upload\\"+type;
        log.info("path={}",path);
        log.info("filename={}",file.getOriginalFilename());
        //调用upload utils
        String src = UploadUtil.uploadFile(file,path);
        if (src!=null){
            map.put("src",src);
            return ResultVOUtil.success(map);
        }else {
            return ResultVOUtil.error(100,"上传失败");
        }

    }
}
