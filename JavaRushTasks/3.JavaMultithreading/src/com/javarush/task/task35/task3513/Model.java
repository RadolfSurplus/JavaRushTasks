package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    public int score, maxTile;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
        this.score = 0;
        this.maxTile = 2;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles != null && emptyTiles.size() != 0) {
            emptyTiles.get((int)(emptyTiles.size() * Math.random())).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        Tile swapValue;
        boolean isChanged = false;
        for (int i = FIELD_WIDTH - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (tiles[j].value == 0 && tiles[j + 1].value != 0) {
                    swapValue = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = swapValue;
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && tiles[i].value != 0) {
                tiles[i].value = tiles[i].value * 2;
                tiles[i + 1].value = 0;
                if (tiles[i].value > maxTile)
                    maxTile = tiles[i].value;
                score += tiles[i].value;
                isChanged = true;
            }
        }
        compressTiles(tiles);
        return isChanged;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new LinkedList<Tile>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }

    public void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] saveTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        int saveScore = score;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                saveTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(saveTiles);
        previousScores.push(saveScore);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            this.score = previousScores.pop();
            this.gameTiles = previousStates.pop();
        }
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value)
                    return true;
                if (gameTiles[j][i].value == gameTiles[j + 1][i].value)
                    return true;
            }
        }
        return false;
    }

    public boolean hasBoardChanged() {
        Tile[][] comparing = previousStates.peek();
        int afterTotal = 0;
        int beforeTotal = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                beforeTotal += gameTiles[i][j].value;
                afterTotal += comparing[i][j].value;
            }
        }
        return beforeTotal != afterTotal;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
        priorityQueue.add(getMoveEfficiency(this::left));
        priorityQueue.add(getMoveEfficiency(this::right));
        priorityQueue.add(getMoveEfficiency(this::up));
        priorityQueue.add(getMoveEfficiency(this::down));
        Move move = priorityQueue.peek().getMove();
        move.move();
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged())
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();
        return moveEfficiency;
    }

    public void randomMove() {
        switch (((int) (Math.random() * 100)) % 4) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public void rotateMatrix() {
        Tile swapValue;
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                swapValue = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[j][FIELD_WIDTH - 1 - i];
                gameTiles[j][FIELD_WIDTH - 1 - i] = gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j];
                gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j] = gameTiles[FIELD_WIDTH - 1 - j][i];
                gameTiles[FIELD_WIDTH - 1 - j][i] = swapValue;
            }
        }
    }

    public void left() {
        boolean isChanged = false;
        if (isSaveNeeded)
            saveState(gameTiles);
        for (int i = 0; i < FIELD_WIDTH; i++) {
            isChanged = (compressTiles(gameTiles[i]) && mergeTiles(gameTiles[i]));
        }
        if (isChanged = true) {
            addTile();
            isSaveNeeded = true;
        }
    }

    public void up() {
        saveState(gameTiles);
        rotateMatrix();
        left();
        rotateMatrix();
        rotateMatrix();
        rotateMatrix();
    }

    public void right() {
        saveState(gameTiles);
        rotateMatrix();
        rotateMatrix();
        left();
        rotateMatrix();
        rotateMatrix();
    }

    public void down() {
        saveState(gameTiles);
        rotateMatrix();
        rotateMatrix();
        rotateMatrix();
        left();
        rotateMatrix();
    }
}
