package com.javarush.test.level33.lesson15.big01.strategies;

public class OurHashMapStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;


    private int hash(Long k) {
        long h = k;
        h ^= (h >>> 20) ^ (h >>> 12);
        return (int)(h ^ (h >>> 7) ^ (h >>> 4));
    }

    private int indexFor(int hash, int length) {
        return hash % (length - 1);
    }

    private Entry getEntry(Long key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        Entry entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry;
            }
            entry = entry.next;
        }

        return null;
    }

    private void resize(int newCapacity) {
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    private void transfer(Entry[] newTable) {
        for (int i = 0; i < table.length; i++) {
            Entry entry = table[i];
            while (entry != null) {
                Entry next = entry.next;
                int newIndex = indexFor(entry.hash, newTable.length);
                entry.next = newTable[newIndex];
                newTable[newIndex] = entry;
                entry = next;
            }
        }
    }

    private void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, entry);
        if (size++ >= threshold)
            resize(2 * table.length);
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, entry);
        size++;
    }


    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < table.length; i++) {
            Entry entry = table[i];
            while (entry != null) {
                if (entry.value.equals(value)) return true;
                entry = entry.next;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        if (size == 0) {
            createEntry(hash, key, value, index);
            return;
        }

        Entry entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            Entry entry = table[i];
            while (entry != null) {
                if (entry.value.equals(value)) return entry.key;
                entry = entry.next;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null) return entry.value;
        return null;
    }
}
