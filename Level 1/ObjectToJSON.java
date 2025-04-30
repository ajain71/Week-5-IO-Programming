import org.json.JSONObject;

public class ObjectToJSON {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2020);
        JSONObject obj = new JSONObject();
        obj.put("make", car.make);
        obj.put("model", car.model);
        obj.put("year", car.year);
        System.out.println(obj.toString(2));
    }
}

class Car {
    String make;
    String model;
    int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
}
