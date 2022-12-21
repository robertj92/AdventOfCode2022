package de.adventofcode.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartOfPacketMarkerDetectorTest {

    private final StartOfPacketMarkerDetector startOfPacketMarkerDetector = new StartOfPacketMarkerDetector();

    @Test
    public void testDetectMarkerCompleted() {
        var input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
        final Integer markerCompletedIndex = startOfPacketMarkerDetector.detectPacketMarkerCompletedIndex(input);

        assertEquals(7, markerCompletedIndex);
    }

    @Test
    public void testDetectMessageMarkerCompleted() {
        var input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
        final Integer markerCompletedIndex = startOfPacketMarkerDetector.detectMessageMarkerCompletedIndex(input);

        assertEquals(19, markerCompletedIndex);
    }
}