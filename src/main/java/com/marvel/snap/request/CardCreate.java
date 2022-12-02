package com.marvel.snap.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardCreate {

    private String korName;
    private String engName;
    private int cost;
    private int power;
    private int series;

    @Builder
    public CardCreate(String korName, String engName, int cost, int power, int series) {
        this.korName = korName;
        this.engName = engName;
        this.cost = cost;
        this.power = power;
        this.series = series;
    }
}
