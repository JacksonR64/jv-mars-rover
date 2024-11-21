package org.example.instructions;

import org.example.enums.INSTRUCTION;

import java.util.ArrayList;
import java.util.List;

public class InstructionsLog {
    // TODO: Better utilise in other methods
    public static final List<List<INSTRUCTION>> instructionsLog = new ArrayList<>();

    public static void addInstructions(List<INSTRUCTION> instructions) {
        instructionsLog.add(new ArrayList<>(instructions)); // Ensure a new copy is added
    }

    public static List<INSTRUCTION> getLast() {
        if (instructionsLog.isEmpty()) return null;
        return instructionsLog.getLast();
    }

    public static List<List<INSTRUCTION>> getFullLog() {
        return List.copyOf(instructionsLog); // Prevent external modification
    }
}
