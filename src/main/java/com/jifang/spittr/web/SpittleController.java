package com.jifang.spittr.web;

import com.jifang.spittr.data.SpittleRepository;
import com.jifang.spittr.exception.SpittleNotFoundException;
import com.jifang.spittr.model.Spittle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * author: jifang
 * date: 18-4-8 上午9:28
 */
@Controller
@RequestMapping("spittles")
public class SpittleController {

    private static final Logger LOG = LoggerFactory.getLogger(SpittleController.class);

    @Autowired
    private SpittleRepository spittleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String showSpittle(@RequestParam("spittle_id") long spittleId, Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId); //正常操作
//        Spittle spittle = null; //测试自定义异常状态码
        if (spittle == null) {
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }

    @RequestMapping("upload.do")
    public String upload(@RequestPart("profilePicture") MultipartFile profilePicture) throws IOException {
        File file = new File("/home/jifang/spittr/uploads/");
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        profilePicture.transferTo(new File("/home/jifang/spittr/uploads/" + profilePicture.getOriginalFilename()));
        return "home";
    }

}
