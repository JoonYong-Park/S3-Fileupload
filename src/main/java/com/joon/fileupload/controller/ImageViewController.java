package com.joon.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImageViewController {

  @GetMapping("/view-image")
  public String viewImage(@RequestParam("url") String imageUrl, Model model) {
    model.addAttribute("imageUrl", imageUrl);
    return "image-view";
  }
}
