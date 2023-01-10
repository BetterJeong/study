package Service;

import model.Block;
import model.BlockType;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameManager {

    private static final GameManager gm = new GameManager();
    private User user;
    private int MAX_X_SIZE = 10;
    private int MAX_Y_SIZE = 20;
    private Block[][] map;
    private boolean[][] check;
    private Block nextBlock;
    private int nowX;
    private int nowY;
    private ArrayList<HashMap<Integer, Integer>> success;

    public GameManager() {
        // 값 초기화
        map = new Block[MAX_X_SIZE][MAX_Y_SIZE];
        check = new boolean[MAX_X_SIZE][MAX_Y_SIZE];
        user = new User();
        nextBlock = new Block();
        nowX = 5;
        nowY = 1;
        success = new ArrayList<>();

        // 맵 초기화
        for (int i = 0; i < MAX_X_SIZE; i++) {
            for (int j = 0; j < MAX_Y_SIZE; j++) {
                map[i][j] = new Block();
                check[i][j] = false;
            }
        }
    }

    public static GameManager getGm() {
        return gm;
    }

    public boolean isGameEnd() {    // 게임이 끝났는지 확인
        boolean b = false;

        // 끝 줄에 블럭이 있으면 true
        for (int i = 0; i < MAX_X_SIZE; i++) {
            if (check[i][0]) {
                b = true;
            }
        }

        return b;
    }

    public boolean isDropped() {    // 바닥에 닿았는지 확인
        boolean b = false;

        // 맨 아래칸이거나 아래 칸에 블럭이 있으면 true
        if (nowY == MAX_Y_SIZE-2 || check[nowX][nowY+1]) {
            countScore();
            check[nowX][nowY] = true;
            b = true;
        }

        return b;
    }

    public void generateBlock() {   // 첫 위치에 랜덤 블럭 타입 지정
        nowX = 5;
        nowY = 0;

        // 다음 블럭이 없으면 랜덤 타입 지정
        if (nextBlock.getBlockType() == BlockType.NONE) {
            map[nowX][nowY].setBlockType(getRandomBlockType());
        }
        else {  // 다음 블럭이 있으면 타입 가져오기
            map[nowX][nowY] = nextBlock;
        }
        // 새로 다음 블럭 타입 지정
        nextBlock.setBlockType(getRandomBlockType());
    }

    public boolean isKey() {    // 키 입력을 받아도 되는지 여부
        boolean b = false;

        if (!isDropped()) {
            b = true;
        }

        return b;
    }

    public boolean isDown() {   // 블럭이 아래로 내려가고 있는지 여부
        boolean b = false;

        if (nowY < MAX_Y_SIZE-2) {
            b = true;
        }

        return b;
    }

    public void moveDown() {    // 아래로 한 칸 이동
        BlockType b = map[nowX][nowY].getBlockType();   // 현재 블럭 타입 저장

        map[nowX][nowY].setBlockType(BlockType.NONE);   // 현재 블럭 지우기
        map[nowX][++nowY].setBlockType(b);  // 블럭 이동
    }

    public void moveLeft() {    // 왼쪽 한 칸 이동
        if (nowX > 0) {
            BlockType b = map[nowX][nowY].getBlockType();   // 현재 블럭 타입 저장

            map[nowX][nowY].setBlockType(BlockType.NONE);   // 현재 블럭 지우기
            map[--nowX][nowY].setBlockType(b);  // 블럭 이동
        }
    }

    public void moveRight() {   // 오른쪽 한 칸 이동
        if (nowX < MAX_X_SIZE-1) {
            BlockType b = map[nowX][nowY].getBlockType();   // 현재 블럭 타입 저장

            map[nowX][nowY].setBlockType(BlockType.NONE);   // 현재 블럭 지우기
            map[++nowX][nowY].setBlockType(b);  // 블럭 이동
        }
    }

    public void moveImmediately() { // 바로 땅에 떨어지기
        for (int i = 0; i < MAX_Y_SIZE - 1; i++) {
            if (i == MAX_Y_SIZE - 2 || check[nowX][i+1] == true) {
                check[nowX][i] = true;  // 땅에 블록 설치

                BlockType b = map[nowX][nowY].getBlockType();   // 현재 블럭 타입 저장
                map[nowX][nowY].setBlockType(BlockType.NONE);   // 현재 블럭 지우기
                map[nowX][i].setBlockType(b);  // 블럭 이동

                break;
            }
        }
    }

    public BlockType getRandomBlockType() { // 랜덤 블럭 반환
        return BlockType.values()[new Random().nextInt(BlockType.values().length-1)+1];
    }

    public int getMAX_X_SIZE() {
        return MAX_X_SIZE;
    }

    public int getMAX_Y_SIZE() {
        return MAX_Y_SIZE;
    }

    public Block[][] getMap() {
        return map;
    }

    public User getUser() {
        return user;
    }

    private void countScore() {
        for (int i = 2; i < MAX_X_SIZE - 2; i++) {
            for (int j = 2; j < MAX_Y_SIZE - 2; j++) {

            }
        }
    }
}
