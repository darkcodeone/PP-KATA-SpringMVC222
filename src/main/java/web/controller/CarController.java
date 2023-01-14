package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {


    private CarService carService;

    public CarController(CarService carDao) {
        this.carService = carDao;
    }

    @GetMapping("")
    public String getCarList(Model model) {

        model.addAttribute("car", carService.getCarList());
        return "cars";

    }

    @GetMapping(value = "/{index}")
    public String getCarId(@PathVariable("index") int index, Model model) {
        if (index >= 5) {
            model.addAttribute("car", carService.getCarList());
        } else {
            model.addAttribute("car", carService.getCarById(index));
        }
        return "cars";
    }
}
