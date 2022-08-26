package co.develhope.crudexemple.Controller;


//import co.develhope.crudexemple.Model.Car;
import co.develhope.crudexemple.Model.Car;
import co.develhope.crudexemple.Repository.CarRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    // create a new Car
    @PostMapping("/insertNewCar")
    public void insertNewCar(@RequestBody Car newCar) {
        carRepository.save(newCar);
    }

    // return a list of all the Cars
    /*
    Chiedo a carRepository di trovare l'elenco di tutte le macchine e lo restituisco
     */
    @GetMapping("listAllCars")
    public List<Car> listAllCars() {
        return carRepository.findAll();
    }

    // return a single Car - if the id is not in the db (use existsById()), returns an empty Car
    @GetMapping("getCar")
    public Optional<Car> getCar(@RequestParam int id) {
        return carRepository.findById(id);
    }

    // updates the type of a specific Car, identified by id and passing a query param - if not present in the db, returns an empty Car
    @PutMapping("updateCarType")
    public void updateCarType(@RequestParam int id, @RequestParam String newType) {

        // prima di tutto prendo la macchina da modificare (findById)
        // la metto dentro un oggetto di tipo Optional: contiene la macchina se esiste, non contiene nulla altrimenti
        // praticamente Optional<Car> è un garage che può essere vuoto oppure no
        Optional<Car> optionalCarToBeUpdated = carRepository.findById(id);

        if(optionalCarToBeUpdated.isPresent()) {
            // se c'è una macchina nel garage (isPresent) allora prendila (get)
            Car carToBeUpdated = optionalCarToBeUpdated.get();
            // ora che abbiamo la macchina cambiamo il tipo usando il suo setter
            carToBeUpdated.setType(newType);
            // ora che abbiamo cambiato il tipo la salviamo di nuovo nel database
            carRepository.save(carToBeUpdated);
        }
    }

    // deletes a specific Car - if absent, the response will have a Conflict HTTP status
    @DeleteMapping("deleteCar")
    public void deleteCar(@RequestParam int id) {
        carRepository.deleteById(id);
    }

    //deletes all the Cars in the db
    @DeleteMapping("deleteAllCars")
    public void deleteAllCars() {
        carRepository.deleteAll();
    }

}
