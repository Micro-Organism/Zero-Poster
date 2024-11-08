package com.zero.poster.controller;

import com.zero.poster.service.PosterUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;

@RestController
public class PosterController {

    @RequestMapping(path = "/genPoster", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] genposterpng(HttpServletRequest request, HttpServletResponse response) {
        try {
            byte[] bytes = PosterUtil.test(); //获得图片的Byte[]
            OutputStream out = null;
            try {
                out = response.getOutputStream();
                out.write(bytes);   //打印图片
                out.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}