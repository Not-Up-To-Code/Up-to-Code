package edu.isu.cs3321.Up_to_Code.app;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Alpha {
    private String alpha;
    private String briefDesc;
    private String detailedDesc;
    private String color;
    private List<State> states = new List<State>(){

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<State> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(State state) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends State> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends State> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public State get(int index) {
            return null;
        }

        @Override
        public State set(int index, State element) {
            return null;
        }

        @Override
        public void add(int index, State element) {

        }

        @Override
        public State remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<State> listIterator() {
            return null;
        }

        @Override
        public ListIterator<State> listIterator(int index) {
            return null;
        }

        @Override
        public List<State> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

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

    public Alpha(String alpha, String briefDesc, String detailedDesc, String color){
        setAlpha(alpha);
        setBriefDesc(briefDesc);
        setDetailedDesc(detailedDesc);
        setColor(color);

    }

    public void addState(State state){
        this.states.add(state);
    }
}
