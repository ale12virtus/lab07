package it.unibo.inner.test.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private final T[] list;

    public IterableWithPolicyImpl(T[] elements) {
        this.list = elements;
    }

    public void setIterationPolicy(Predicate<T> filter) {}

    private class MyIterator implements java.util.Iterator<T> {
       
        private int current;

        public MyIterator() {
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return this.current < IterableWithPolicyImpl.this.list.length;
        }

        @Override
        public T next() {
            return IterableWithPolicyImpl.this.list[current++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.new MyIterator();
    }
}