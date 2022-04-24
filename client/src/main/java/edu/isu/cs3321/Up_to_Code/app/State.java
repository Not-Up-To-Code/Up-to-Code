
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

public class State {
    private String name;
    private int stateOrder;
    private List<CheckListItem> checklist = new ArrayList<>();

    public State() {

    }

    public String getName() {
        return name;
    }



    public int getStateOrder() {
        return stateOrder;
    }

    public void setStateOrder(int stateOrder) {
        this.stateOrder = stateOrder;
    }

    public List<CheckListItem> getChecklist() {
        return checklist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChecklist(List<CheckListItem> checklist) {
        this.checklist = checklist;
    }

    public State(String name,int stateOrder){
        setName(name);

        this.stateOrder = stateOrder;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", stateOrder=" + stateOrder +
                ", checklist=" + checklist +
                '}';
    }

    public void addCheckListItem(CheckListItem item){
        checklist.add(item);
    }
}
