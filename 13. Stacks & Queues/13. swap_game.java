public class Main {
    
    public static class Car {
        int speed;
        String model;

        Car() {

        }

        Car(int speed,String model) {
            this.speed = speed;
            this.model = model;
        }

        void aboutMe() {
            System.out.println(speed + " " + model);
        }
    }

    public static void main(String[]args) {
        Car c1 = new Car(20,"xyz");

        Car c2 = new Car();
        c2.speed = 30;
        c2.model = "def";

        c1.aboutMe();
        c2.aboutMe();

        swap3(c1,c2);

        c1.aboutMe();
        c2.aboutMe();
    }

    public static void swap1(Car c1,Car c2) {
        Car t1 = c1;
        c1 = c2;
        c2 = t1;
    }

    public static void swap2(Car c1,Car c2) {
        Car t1 = c1;

        c1.speed = c2.speed;
        c1.model = c2.model;

        c2.speed = t1.speed;
        c2.model = t1.model;
    }

    public static void swap3(Car c1,Car c2) {
        Car t1 = new Car();
        t1.speed = c1.speed;
        t1.model = c1.model;

        c1.speed = c2.speed;
        c1.model = c2.model;

        c2.speed = t1.speed;
        c2.model = t1.model;
    }
}

