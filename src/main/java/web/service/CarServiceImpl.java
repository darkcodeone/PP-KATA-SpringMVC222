package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;
import web.dao.CarDao;
import web.dao.CarDaoImpl;

import java.util.List;
@Component
public class CarServiceImpl implements CarService {
   private CarDao carDao = new CarDaoImpl();
    @Override
    public List<Car> getCarList() {
        return carDao.getCarList();
    }

    @Override
    public List<Car> getCarById(int index) {
        return carDao.getCarById(index);
    }
}
