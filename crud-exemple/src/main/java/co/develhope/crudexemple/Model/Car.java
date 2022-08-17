package co.develhope.crudexemple.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "car")

public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String modelName;
    private String type;


    // private List<Cars> carsList;

    public Car(){}
    public Car(int id, String modelName, String type){
        this.id = id;
        this.modelName = modelName;
        this.type = type;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

