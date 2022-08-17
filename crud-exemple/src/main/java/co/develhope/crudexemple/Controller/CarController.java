package co.develhope.crudexemple.Controller;


//import co.develhope.crudexemple.Model.Car;
import co.develhope.crudexemple.Repository.CarRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping
    public <Car> void createCar(@RequestBody Car car) {
        carRepository.save(car);
    }

    @GetMapping
    public <Car> List<Car> get() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    public boolean existsById(CarRepository id) {

        if (entityInformation.getIdAttribute() == null) {
            return findById(id).isPresent();
        }

        return false;
    }
}



//    File file = new File(UPLOADED_FOLDER, merchant_id.toString() + "/merchant_logo.png");
//    final HttpHeaders headers = new HttpHeaders();
//    headers.setContentType(MediaType.IMAGE_PNG);
//
//    if (!file.exists()) {
//        return new ResponseEntity<byte[]>(headers,HttpStatus.NOT_FOUND);
//    }else{
//        InputStream in = FileUtils.openInputStream(file);
//        return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
//    }