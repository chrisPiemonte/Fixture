package com.database.systems.fixture.common.entity.bean;

/**
 * Created by chris on 2/23/18.
 */
public class Stats {


    private int partita;
    private String settore;
    private long count;

   /* public Stats() {
    }
*/
    public Stats(int partita, String settore, int count) {

        this.partita = partita;
        this.settore = settore;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "partita=" + partita +
                ", settore='" + settore + '\'' +
                ", count=" + count +
                '}';
    }
}
