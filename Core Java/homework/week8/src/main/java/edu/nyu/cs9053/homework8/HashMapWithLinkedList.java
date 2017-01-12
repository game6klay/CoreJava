package edu.nyu.cs9053.homework8;

import java.util.*;

/**
 * Created by jay on 4/2/16.
 */
public class HashMapWithLinkedList<K,V> extends AbstractMultimap<K,V> {

    private final HashMap<K,Collection<V>> delegate;

    public HashMapWithLinkedList(HashMap<K,Collection<V>> delegate){

        super(new HashMap<K, Collection<V>>());
        this.delegate= delegate;
    }



    @Override
    protected Collection<V> createCollection() {
        return new LinkedList<>();
    }

    /*public Collection<V> getItems(K key){

        List<V> anyList = new LinkedList<V>(getItems(key));
        anyList = delegate.get(key);
        return anyList;

    }*/

    public void putAll(Map<? extends K, ? extends Collection<V>> map) {

        Set<? extends K> setOfKeys = map.keySet();
        for(K key : setOfKeys){
            this.delegate.put(key, (LinkedList<V>)map.get(key));
        }
    }

    public Collection<V> put(K key, Collection<V> value){

        ArrayList<V> anylist = (ArrayList<V>) get(key);
        if (null == anylist) {
            anylist = (ArrayList<V>) get(key);
            put(key, new ArrayList<V>());
        }

        else anylist.addAll(value);
        return delegate.put(key,new LinkedList<V>(value));
    }


}
