package com.rejointech.Rejoinschool.controller;

import com.rejointech.Rejoinschool.model.Holidays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {
    @GetMapping("")
    public String displayHolidays(Model model){
        List<Holidays> holiday= Arrays.asList(
                new Holidays("17 feb 2020","diwali" , Holidays.Type.FESTIVAL),
                new Holidays("18 oct 2020","holi" , Holidays.Type.FESTIVAL),
                new Holidays("19 oct 2021","labor day" , Holidays.Type.FEDERAL),
                new Holidays("27 jan 2022","chatth" , Holidays.Type.FESTIVAL),
                new Holidays("21 nov 2023","bank" , Holidays.Type.FEDERAL),
                new Holidays("12 oct 2024","baishakhi" , Holidays.Type.FESTIVAL),
                new Holidays("13 dec 2020","mayday" , Holidays.Type.FEDERAL));

//                for(Holidays.Type type:Holidays.Type.values()){
//                    model.addAttribute(type.toString(),
//                            (holiday.stream().filter(holiday -> holiday.getType().equals(type))).collect(Collectors.toCollection((collec))))
//                }
                return "holidays.html";
    }
}
