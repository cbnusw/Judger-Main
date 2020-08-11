package com.qt.submit;

import javax.validation.constraints.NotNull;

public class Submit {

    @NotNull
    private String language;

    @NotNull
    private String code;


    public String getLanguage(){
        return language;
    }

    public String getCode()
    {
        return code;
    }

    public Submit(@NotNull String language, @NotNull String code)
    {
        this.language=language;
        this.code=code;
    }



}
