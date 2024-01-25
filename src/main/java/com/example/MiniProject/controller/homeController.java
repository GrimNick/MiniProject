package com.example.MiniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class homeController {

    @GetMapping("/")
    public String index() {
        return "index"; // Return the name of your index.html file
    }

    @GetMapping("/signUp")
    public String signUpForm() {
        return "signUp"; // Return the name of your signup.html file
    }
    @GetMapping("/property-details")
    public String getPropertyDetailsPage() {
        return "property-details"; // Return the name of your signup.html file
    }




//    @PostMapping("/submit")
//    public String submitData(String propertyType, String budget, String location,int ropani,int aana,int paisa,int daam, RedirectAttributes redirectAttributes) {
//        System.out.println("Received Property Type: " + propertyType);
//        System.out.println("Received Budget: " + budget);
//        System.out.println("Received Location: " + location);
//        System.out.println("Received Area: " + ropani + " Ropani, " + aana + " Aana, " + paisa + " Paisa, " + daam + " Daam");
//
//        // Logic
//
//        // Use RedirectAttributes to pass attributes to the redirected page
//        redirectAttributes.addFlashAttribute("selectedPropertyType", propertyType);
//        redirectAttributes.addFlashAttribute("budget", budget);
//        redirectAttributes.addFlashAttribute("location", location);
//
//        // Add area attributes
//        redirectAttributes.addFlashAttribute("ropani", ropani);
//        redirectAttributes.addFlashAttribute("aana", aana);
//        redirectAttributes.addFlashAttribute("paisa", paisa);
//        redirectAttributes.addFlashAttribute("daam", daam);
//
//        return "redirect:/displayPage";
//    }
//
//    @RequestMapping("/displayPage")
//    public String displayPage(@ModelAttribute("selectedPropertyType") String selectedPropertyType,
//                              @ModelAttribute("budget") String budget,
//                              @ModelAttribute("location") String location,
//                              @ModelAttribute("ropani") int ropani,
//                              @ModelAttribute("aana") int aana,
//                              @ModelAttribute("paisa") int paisa,
//                              @ModelAttribute("daam") int daam,
//                              Model model) {
//        model.addAttribute("selectedPropertyType", selectedPropertyType);
//        model.addAttribute("budget", budget);
//        model.addAttribute("location", location);
//        model.addAttribute("ropani", ropani);
//        model.addAttribute("aana", aana);
//        model.addAttribute("paisa", paisa);
//        model.addAttribute("daam", daam);
//
//        return "DisplayPage";
//    }
}

