package org.example;

import static org.example.Position.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Rover rover1 = new Rover(new Position(5,5,DIRECTION.E));
        System.out.println("Before: \nX: " + rover1.getPosition().getX() + "\nY: " +  rover1.getPosition().getY() + "\nFacing: " + rover1.getPosition().getFacing() );
        rover1.move(MOVEMENT_INSTRUCTION.M);
        System.out.println("After: \nX: " + rover1.getPosition().getX() + "\nY: " +  rover1.getPosition().getY() + "\nFacing: " + rover1.getPosition().getFacing() );

    }
    public static int test (String input){

        return 0;
    }

}
