package com.kitri.springbasicboot.project.rsp_game;

public class Count {
    int winCount;
    int loseCount;
    int drawCount;

    public Count(int winCount, int loseCount, int drawCount) {
        this.winCount = winCount;
        this.loseCount = loseCount;
        this.drawCount = drawCount;
    }

    public Count() {

    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public void setDrawCount(int drawCount) {
        this.drawCount = drawCount;
    }
}
