package de.adventofcode.day6;

import de.adventofcode.utils.FileUtils;

public class Day6Main {

    public static void main(String[] args) {
        final StartOfPacketMarkerDetector startOfPacketMarkerDetector = new StartOfPacketMarkerDetector();
        final String input = FileUtils.readFileFromString("day6/input.txt");
        final Integer markerCompletedIndex = startOfPacketMarkerDetector.detectPacketMarkerCompletedIndex(input);

        System.out.println("Packet Marker completed index is " + markerCompletedIndex);

        final Integer messageMarkerCompletedIndex = startOfPacketMarkerDetector.detectMessageMarkerCompletedIndex(input);
        System.out.println("Message Marker completed index is " + messageMarkerCompletedIndex);
    }
}
