package com.pershyn.electronicshop.admincontroller;

import com.pershyn.electronicshop.model.News;
import com.pershyn.electronicshop.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller(value = "adminNewsController")
@RequestMapping(value = "/admin/news")
public class NewsController {

    private String addNewsView = "/admin/news/addNews";
    private String indexNewsView = "/admin/news/index";
    private String updateNewsView = "/admin/news/updateNews";

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(indexNewsView);
        List<News> news = new ArrayList<>(newsService.getNews(100));
        news.sort(Comparator.comparing(News::getId));
        modelAndView.addObject("news", news);
        return modelAndView;
    }

    @RequestMapping(value = "/addNews", method = RequestMethod.GET)
    public ModelAndView addNews(News news) {
        ModelAndView modelAndView = new ModelAndView(addNewsView);
        modelAndView.addObject("news", news);
        return modelAndView;
    }

    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    public ModelAndView addNews(@ModelAttribute News news,
                                RedirectAttributes redirectAttributes) {
//        System.out.println("ADD NEWS !!!");
        newsService.addNews(news);
        redirectAttributes.addFlashAttribute("success", "News has been added: " + news);
        return new ModelAndView("redirect: " + indexNewsView);
    }

    @RequestMapping(value = {"/updateNews/{id}", "/updateNews"}, method = RequestMethod.GET)
    public ModelAndView updateNews(@PathVariable("id") Integer id , RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView(updateNewsView);
        News news = newsService.getNewsById(id);
        modelAndView.addObject("news", news);
        return modelAndView;
    }

    @RequestMapping(value = {"/updateNews"}, method = RequestMethod.POST)
    public ModelAndView updateNews(@Valid @ModelAttribute News news,
                                   final BindingResult result,
                                   final ModelAndView modelAndView,
                                   RedirectAttributes redirectAttrs) {
        newsService.updateNews(news);
        redirectAttrs.addFlashAttribute("success", "News has been updated: " + news);
        return new ModelAndView("redirect:" + indexNewsView);
    }

    @RequestMapping(value = {"/deleteNews/{id}"}, method = RequestMethod.GET)
    public String deleteNews(@PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {
        News news = newsService.getNewsById(id);
        newsService.deleteNews(id);
        redirectAttrs.addFlashAttribute("success", "News has been deleted: " + news);
        return "redirect:" + indexNewsView;
    }
}
