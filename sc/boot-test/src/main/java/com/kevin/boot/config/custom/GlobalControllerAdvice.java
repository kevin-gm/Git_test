package com.kevin.boot.config.custom;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局 controller层建言
 * Created by Administrator on 2016/12/23 0023.
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    /**
     * 全局异常处理
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        //error 为配置的异常页面，可以根据系统情况修改
        ModelAndView modelAndView = new ModelAndView("error");
        //页面指定需要显示的异常内容，可以根据系统情况修改
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    /**
     * 可以全局使用的额外信息
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    /**
     * 通过InitBinder 定制 WebDataBinder
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }
}