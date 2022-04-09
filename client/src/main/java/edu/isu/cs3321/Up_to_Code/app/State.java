package edu.isu.cs3321.Up_to_Code.app;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class State {
    private String name;
    private Integer stateOrder;
    private List<CheckListItem> checklist = new List<CheckListItem>() {
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
        public Iterator<CheckListItem> iterator() {
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
        public boolean add(CheckListItem checkListItem) {
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
        public boolean addAll(Collection<? extends CheckListItem> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends CheckListItem> c) {
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
        public CheckListItem get(int index) {
            return null;
        }

        @Override
        public CheckListItem set(int index, CheckListItem element) {
            return null;
        }

        @Override
        public void add(int index, CheckListItem element) {

        }

        @Override
        public CheckListItem remove(int index) {
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
        public ListIterator<CheckListItem> listIterator() {
            return null;
        }

        @Override
        public ListIterator<CheckListItem> listIterator(int index) {
            return null;
        }

        @Override
        public List<CheckListItem> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    public String getName() {
        return name;
    }

    public List<CheckListItem> getChecklist() {
        return checklist;
    }

    public Integer getStateOrder(){
        return stateOrder;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChecklist(List<CheckListItem> checklist) {
        this.checklist = checklist;
    }

    public void setStateOrder(Integer stateOrder){
        this.stateOrder = stateOrder;
    }

    public State(String name, Integer stateOrder){
        setName(name);
        setStateOrder(stateOrder);
    }

    public void addCheckListItem(CheckListItem item){
        checklist.add(item);
    }
}
