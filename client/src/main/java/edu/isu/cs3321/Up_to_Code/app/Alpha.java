// MIT License

// Copyright (c) 2022 Thomas Evans, Benjamin Keninger, Sina Khajeh Pour, Braxton Soto

// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package edu.isu.cs3321.Up_to_Code.app;

import java.util.*;

public class Alpha {
    private String alpha;
    private String briefDesc;
    private String detailedDesc;
    private String color;
    private boolean isCompetency;
    private int id;
    private List<State> states = new ArrayList<>();

    public Alpha() {

    }

    public String getAlpha() {
        return alpha;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public String getDetailedDesc() {
        return detailedDesc;
    }

    public String getColor() {
        return color;
    }

    public List<State> getStates() {
        return states;
    }

    public int getId() {
        return id;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public void setDetailedDesc(String detailedDesc) {
        this.detailedDesc = detailedDesc;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public boolean isCompetency() {
        return isCompetency;
    }

    public void setCompetency(boolean competency) {
        isCompetency = competency;
    }

    public Alpha(String alpha, String briefDesc, String detailedDesc, String color,boolean isCompetency){
        setAlpha(alpha);
        setBriefDesc(briefDesc);
        setDetailedDesc(detailedDesc);
        setColor(color);
        this.states = states;
        this.isCompetency = isCompetency;


    }

    @Override
    public String toString() {
        return "Alpha{" +
                "alpha='" + alpha + '\'' +
                ", briefDesc='" + briefDesc + '\'' +
                ", detailedDesc='" + detailedDesc + '\'' +
                ", color='" + color + '\'' +
                ", isCompetency=" + isCompetency +
                ", id=" + id +
                ", states=" + states +
                '}';
    }

    public void addState(State state){
        this.states.add(state);
    }
}
