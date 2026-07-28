// package declaration removed to match expected default package

class Car{
    
    String name;
    int number;

    Car(String name, int number){
        this.name=name;
        this.number=number;

    }

    void CarName(){
        System.out.println(name);
    }
    void carNumber(){
        System.out.println(number);
    }

}

public class Main {
    
    public static void main(String args[]){
         
      Car a=new Car("Porche",4321);
      a.CarName();
      a.carNumber();

      Car a1=new Car("Mercedes",2221);
      a1.CarName();
      a1.carNumber();
    }
}
