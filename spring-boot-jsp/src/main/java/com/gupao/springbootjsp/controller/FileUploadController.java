package com.gupao.springbootjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * @program: spring-boot-jsp
 * @description:upload
 * @author:Daniel.zhao
 * @create:2018-05-10 11:45
 **/
@Controller
public class FileUploadController {
    @RequestMapping(value="/toFileUpload",method = RequestMethod.GET)
    public String fileUpload(){
    return "fileUpload";
    }
    @RequestMapping(value="/uploads",method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletRequest request, MultipartFile[] file){
        try {

            //上传的目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //遍历文件数组，执行上传
            for (int i = 0; i < file.length; i++) {
                if (null != file[i]) {
                    //调用上传的方法
                    executeUpload(uploadDir, file[i]);
                }
            }
        }catch (Exception e){
            //打印错误的堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";

    }

private void executeUpload(String uploadDir,MultipartFile file)throws Exception{
//文件名字的后缀
    String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
    //上传文件名
    String fileName= UUID.randomUUID()+suffix;
    //服务器端保存的文件对象
    File serverFile=new File(uploadDir+fileName);
    //将上传的文件写入到服务器
    file.transferTo(serverFile);
}

}
