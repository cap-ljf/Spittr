package com.jifang.spittr.web;

import com.jifang.spittr.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Set;

/**
 * author: jifang
 * date: 18-4-9 下午1:50
 */

@Controller
@ResponseBody
@RequestMapping("databind")
public class DataBindController {

    private static final Logger LOG = LoggerFactory.getLogger(DataBindController.class);

    /**
     * 1.基本类型
     *
     * @param count
     */
    @RequestMapping("/baseType.do")
    public String baseType(int count) {
        return String.valueOf(count);
    }

    /**
     * 2.包装类型
     *
     * @param count
     */
    @RequestMapping("wrappedType.do")
    public String wrappedType(Integer count) {
        return count.toString();
    }

    /**
     * 3.数组类型
     *
     * @param names
     * @return
     */
    @RequestMapping("array.do")
    public String array(String[] names) {
        StringBuilder builder = new StringBuilder();
        for (String name : names) {
            builder.append(name).append(" ");
        }
        return builder.toString();
    }

    /**
     * 4.自定义对象类型
     *
     * @param spitter
     * @return
     */
    @RequestMapping("object.do")
    public String object(@Valid Spitter spitter, Errors errors) {
        if (errors.hasErrors()) {
            return "输入有错误";
        }
        return spitter.toString();
    }

    /**
     * 5. 复合对象类型
     *
     * @param user
     * @return
     */
    @RequestMapping("composeObject.do")
    public String composeObject(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "输入有错误";
        }
        return user.toString();
    }

    /**
     * 6.List
     *
     * @param spitterListForm
     * @return
     */
    @RequestMapping("list.do")
    public String list(SpitterListForm spitterListForm) {
        return spitterListForm.toString();
    }

    /**
     * 7.Set
     *
     * @param spitterSetForm
     * @return
     */
    @RequestMapping("set.do")
    public String set(SpitterSetForm spitterSetForm) {
        return spitterSetForm.toString();
    }

    /**
     * 8.Map
     *
     * @param spitterMapForm
     * @return
     */
    @RequestMapping("map.do")
    public String map(SpitterMapForm spitterMapForm) {
        return spitterMapForm.toString();
    }


}
