package co.develhope.crudexemple.Repository;


//import co.develhope.crudexemple.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CarRepository<Car> extends JpaRepository<Car, Integer> {
    boolean existsById();
}
