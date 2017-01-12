package edu.nyu.cs9053.homework8;

import java.util.*;


/**
 * Created by jay on 4/2/16.
 */
public class TreeMapWithArrayList<K,V> extends AbstractMultimap<K,V> {

    private final TreeMap<K,Collection<V>> delegate;

    public TreeMapWithArrayList(TreeMap<K,Collection<V>> delegate){

        super(new TreeMap<K, Collection<V>>());
        this.delegate= delegate;
    }


    @Override
    protected Collection<V> createCollection() {
        return new ArrayList<>();
    }

    public void putAll(Map<? extends K, ? extends Collection<V>> map) {

        Set<? extends K> setOfKeys = map.keySet();
        for(K key : setOfKeys){
            this.delegate.put(key, (LinkedList<V>)map.get(key));
        }
    }

    public Collection<V> put(K key, Collection<V> value){

        LinkedList<V> anylist = (LinkedList<V>) get(key);
        if (null == anylist) {
            anylist = (LinkedList<V>) get(key);
            put(key, new LinkedList<V>());
        }
        else anylist.addAll(value);
        return delegate.put(key,new LinkedList<V>(value));
    }
}
