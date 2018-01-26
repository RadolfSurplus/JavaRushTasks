package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int score, numberOfEmptyTiles;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.score = score;
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    public int compareTo(MoveEfficiency that) {
        final int BEFORE_CHANGE = -1;
        final int EQUAL = 0;
        final int AFTER_CHANGE = 1;

        if (this == that) return EQUAL;
        if (this.numberOfEmptyTiles > that.numberOfEmptyTiles)
            return AFTER_CHANGE;
        if (this.numberOfEmptyTiles < that.numberOfEmptyTiles)
            return BEFORE_CHANGE;
        if (this.numberOfEmptyTiles == that.numberOfEmptyTiles) {
            if (this.score > that.score)
                return AFTER_CHANGE;
            if (this.score < that.score)
                return BEFORE_CHANGE;
        }
        return EQUAL;
    }
}
