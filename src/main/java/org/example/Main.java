package org.example;

import static org.example.Input.InstructionInput.instructionInput;
import static org.example.Input.SetUpInput.setUpInput;
import static org.example.Rover.roverCount;
import static org.example.Rover.roverList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");




        setUpInput();
        if (roverCount != 0) {
            Rover rover1 = roverList.get(0);
            System.out.println("Before moves: " + rover1);
            instructionInput();
            System.out.println("After moves: " + rover1);
        }

/*
        Rover rover1 = new Rover(new Position(5,5,DIRECTION.E));
        System.out.println("Before: \nX: " + rover1.getPosition().getX() + "\nY: " +  rover1.getPosition().getY() + "\nFacing: " + rover1.getPosition().getFacing() );
        rover1.move(MOVEMENT_INSTRUCTION.M);
        rover1.rotate(ROTATE_INSTRUCTION.R);
        System.out.println("After: \nX: " + rover1.getPosition().getX() + "\nY: " +  rover1.getPosition().getY() + "\nFacing: " + rover1.getPosition().getFacing() );
*/

    }

}
