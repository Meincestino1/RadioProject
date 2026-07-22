package tests;

public class House {

    class Room {

        class Chair {

            class ChairBein {

                int weight = 5;

            }


        }

    }

    public static void main(String[] args) {

        Room.Chair.ChairBein chairBein = new House().new Room().new Chair().new ChairBein();
        System.out.println(chairBein.weight);
        
        House house = new House();


    }


}


