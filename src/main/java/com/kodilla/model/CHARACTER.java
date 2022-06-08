package com.kodilla.model;

public enum CHARACTER {
    CHIRNO("resources/standl000chirno.png"),
    IKU("resources/standl000iku.png"),
    KOMACHI("resources/standl000komachi.png");
    public String urlCharacter;


    private CHARACTER(String urlCharacter){this.urlCharacter = urlCharacter;}

    public String getUrl() {return urlCharacter;}

}
