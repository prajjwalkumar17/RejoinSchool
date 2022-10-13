package com.rejointech.Rejoinschool.controller;

import com.rejointech.Rejoinschool.model.Holidays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {
//    @GetMapping("/holidays")
//    public String displayHolidays(@RequestParam(required = false)boolean festival,
//                                  @RequestParam(required = false)boolean federal,Model model){
//        model.addAttribute("festival",festival);
//        model.addAttribute("federal",federal);
//        List<Holidays> holidays= Arrays.asList(
//                new Holidays("17 feb 2020","diwali" , Holidays.Type.FESTIVAL),
//                new Holidays("18 oct 2020","holi" , Holidays.Type.FESTIVAL),
//                new Holidays("19 oct 2021","labor day" , Holidays.Type.FEDERAL),
//                new Holidays("27 jan 2022","chatth" , Holidays.Type.FESTIVAL),
//                new Holidays("21 nov 2023","bank" , Holidays.Type.FEDERAL),
//                new Holidays("12 oct 2024","baishakhi" , Holidays.Type.FESTIVAL),
//                new Holidays("13 dec 2020","mayday" , Holidays.Type.FEDERAL));
//
//                for(Holidays.Type type:Holidays.Type.values()){
//                    model.addAttribute(type.toString(),
//                            (holidays.stream().filter(holiday -> holiday.getType().equals(type))).collect(Collectors.toList()));
//                }
//                return "holidays.html";
//    }
    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model){
        if(display!=null && display.equals("all")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        }
        else if(display!=null && display.equals("federal"))
            model.addAttribute("federal",true);
        else if(display!=null && display.equals("festival"))
            model.addAttribute("festival",true);
        List<Holidays> holidays= Arrays.asList(
                new Holidays("17 feb 2020","diwali" , Holidays.Type.FESTIVAL),
                new Holidays("18 oct 2020","holi" , Holidays.Type.FESTIVAL),
                new Holidays("19 oct 2021","labor day" , Holidays.Type.FEDERAL),
                new Holidays("27 jan 2022","chatth" , Holidays.Type.FESTIVAL),
                new Holidays("21 nov 2023","bank" , Holidays.Type.FEDERAL),
                new Holidays("12 oct 2024","baishakhi" , Holidays.Type.FESTIVAL),
                new Holidays("13 dec 2020","mayday" , Holidays.Type.FEDERAL));

                for(Holidays.Type type:Holidays.Type.values()){
                    model.addAttribute(type.toString(),
                            (holidays.stream().filter(holiday -> holiday.getType().equals(type))).collect(Collectors.toList()));
                }
                return "holidays.html";
    }
}
