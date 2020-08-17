package com.qt.submit;

import lombok.Builder;

import javax.validation.constraints.NotNull;

public class Submit {

    @NotNull
    private String source;

    @NotNull
    private String language;

    @NotNull
    private String input;

    @NotNull
    private String answer;

    public String getLanguage(){
        return language;
    }

    public String getSource()
    {
        return source;
    }

    public String getInput()
    {
        return input;
    }

    public String getAnswer(){
        return answer;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Submit()
    {

    }

    @Builder
    public Submit(@NotNull String source, @NotNull String language,@NotNull String input, @NotNull String answer)
    {
        this.source=source;
        this.language=language;
        this.input=input;
        this.answer=answer;
    }



}
