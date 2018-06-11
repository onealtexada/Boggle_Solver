package com.rstudio.domain.type;

public enum BoardSize {
    FourByFour("4x4"), FiveByFive("5x5"), SixBySix("6x6");
    
    private String webValue;
    
    BoardSize(String webValue) {
        this.webValue = webValue;
    }
    
    public String webValue() {
        return webValue;
    }
}
