package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Serializable, Cloneable {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int)Math.max(16, collection.size()/.75f);
        map = new HashMap<>(capacity);
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    @Override
    public boolean isEmpty() {
        return map.keySet().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public void clear() {
        map.keySet().clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public Object clone() {
        AmigoSet<E> set = new AmigoSet<>();
        try {
            set.map.putAll(map);
            return set;
        }
        catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();

        objectOutputStream.writeInt(map.keySet().size());
        for (E e : map.keySet()) {
            objectOutputStream.writeObject(e);
        }

        objectOutputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        objectOutputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();

        Set<E> set = new HashSet<>();
        int size = objectInputStream.readInt();
        for (int i = 0; i < size; i++) {
            set.add((E)objectInputStream.readObject());
        }

        int capacity = (int)objectInputStream.readObject();
        float loadFactor = (float)objectInputStream.readObject();

        map = new HashMap<>(capacity, loadFactor);
        for (E e : set) {
            map.put(e, PRESENT);
        }
    }
}
