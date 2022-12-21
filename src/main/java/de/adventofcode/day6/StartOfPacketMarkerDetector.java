package de.adventofcode.day6;

public class StartOfPacketMarkerDetector {

    public static final int PACKET_MARKER_LENGTH = 4;
    public static final int MESSAGE_MARKER_LENGTH = 14;

    public Integer detectPacketMarkerCompletedIndex(String input) {
        return detectMarkerCompletedIndex(input, PACKET_MARKER_LENGTH);
    }

    public Integer detectMessageMarkerCompletedIndex(String input) {
        return detectMarkerCompletedIndex(input, MESSAGE_MARKER_LENGTH);
    }

    private Integer detectMarkerCompletedIndex(String input, Integer markerLength) {
        for (int i = 0; i < input.length() - markerLength; i++) {
            String subset = input.substring(i, i + markerLength);
            if (subset.chars().distinct().count() == markerLength) {
                return i + markerLength;
            }
        }

        return 0;
    }
}
