package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countClosedTiles = SIDE * SIDE;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private int score;
    private boolean isGameStopped;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 2;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");

            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }
    private void countMineNeighbors(){

        for (int i = 0; i < SIDE; i++){
            for (int j = 0; j < SIDE; j++){
                if (gameField[i][j].isMine){
                    continue;
                }
                List<GameObject> neighbors = getNeighbors(gameField[i][j]);
                for (GameObject cell: neighbors){
                    if (cell.isMine){
                        gameField[i][j].countMineNeighbors++;
                    }
                }
            }
        }


    }
    private void openTile(int x, int y){
        if (isGameStopped){
            return;
        }
        if (gameField[y][x].isFlag){
            return;
        }
        if (gameField[y][x].isOpen){
            return;
        }
        gameField[y][x].isOpen = true;
        countClosedTiles--;
        setCellColor(x, y, Color.GREEN);

        if (gameField[y][x].isMine) {
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
            return;
        }
        score = score + 5;
        setScore(score);

        if (gameField[y][x].countMineNeighbors == 0){
            setCellValue(x, y, "");
            for (GameObject neighbor: getNeighbors(gameField[y][x])){
                if (!neighbor.isOpen) {
                    openTile(neighbor.x, neighbor.y);
                }
            }
        }else {
            setCellNumber(x, y, gameField[y][x].countMineNeighbors);
        }
        if (!gameField[y][x].isMine && countClosedTiles == countMinesOnField){
            win();
        }
    }
    private void markTile(int x, int y){
        boolean isNotOpen = !gameField[y][x].isOpen;
        boolean isEnoughFlags = countFlags != 0;
        boolean hasFlag = gameField[y][x].isFlag;
        if (isGameStopped){
            return;
        }

        if (isNotOpen && isEnoughFlags && !hasFlag){
            gameField[y][x].isFlag = true;
            countFlags--;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.BEIGE);
        }
        if (isNotOpen && hasFlag){
            gameField[y][x].isFlag = false;
            countFlags++;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        }
    }
    private void win(){
       isGameStopped = true;
       showMessageDialog(Color.GREEN, "YOU WIN!", Color.GOLD, 80);
    }
    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.RED, "GAME OVER", Color.BLACK, 80);
    }
    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        score = 0;
        setScore(score);
        createGame();
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        super.onMouseRightClick(x, y);
        markTile(x, y);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        super.onMouseLeftClick(x, y);

        if (isGameStopped){
            restart();
        }else {
            openTile(x, y);
        }

    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }
}