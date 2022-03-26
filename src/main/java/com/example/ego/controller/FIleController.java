//package com.example.ego.controller;
//
//import cn.hutool.core.io.FileUtil;
//import cn.hutool.core.util.IdUtil;
//import cn.hutool.core.util.StrUtil;
//import com.example.ego.common.util.Result;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//import java.util.List;
//
//@RestController
//@RequestMapping("/files")
//public class FIleController {
//    @Value("${server.port}")
//    private String port;
//
//    private static final String ip = "http://localhost";
//
//    @PostMapping("/upload")
//    public Result<?> upload(MultipartFile file) throws IOException {
//        String originalFilename = file.getOriginalFilename();
//        //定义文件的唯一标识,可以解决相同名字文件覆盖的问题
//        String flag = IdUtil.fastSimpleUUID();
//        String rootFilePath = System.getProperty("user.dir");   //获取当前工程路径
//        String filePath = rootFilePath + "ego/src/main/resources/files/" + flag + "_" + originalFilename;
//
//        FileUtil.writeBytes(file.getBytes(),filePath);
//
//        return Result.success(ip + ":" + port + "/files/" + flag); //data 返回下载链接
//    }
//
//    @GetMapping("/{flag}")
//    public void getFiles(HttpServletResponse response, @PathVariable String flag){  //flag == 文件专属前缀
//        OutputStream os; //输出流对象
//        String basePath = System.getProperty("user.dir") + "ego/src/main/resources/static/files/"; //根路径
//        List<String> fileNames = FileUtil.listFileNames(basePath); //所有文件名
//        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse(""); //查找包含 flag 的文件
//
//        try{
//            if(StrUtil.isNotEmpty(fileName)){
//                response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
//                response.setContentType("application/octet-stream");
//                byte[] bytes = FileUtil.readBytes(basePath + fileName);
//                os = response.getOutputStream();
//                os.write(bytes);
//                os.flush();
//                os.close();
//            }
//        } catch(Exception e){
//            System.out.println("文件下载失败");
//        }
//    }
//}
