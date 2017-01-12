package edu.nyu.cs9053.homework8;

import java.util.*;


/**
 * Created by jay on 4/2/16.
 */
public abstract class AbstractMultimap <K,V> implements Multimap<K,V>{

    private final Map<K,Collection<V>> delegate;

    public AbstractMultimap (Map<K,Collection<V>> delegate){

        this.delegate= delegate;
    }

    @Override
    public int size(){

        return delegate.size();

    }

    @Override
    public boolean isEmpty(){

        return delegate.isEmpty();

    }

    @Override
    public boolean containsKey(Object key){

        if(delegate == null){

            throw new IllegalArgumentException("map is null");
        }

        else{

            return delegate.containsKey(key);
        }

    }

    @Override
    public boolean containsValue(Object value){

        if(delegate == null){

            throw new IllegalArgumentException("map is null");
        }

        else{

            for(Collection <V> v :delegate.values()){

                if(v.contains(value))
                    return true;
                }
            }
            return false;
        }

    @Override
    public Collection<V> remove(Object key){

        if(delegate == null){

            throw new IllegalArgumentException("map is null");
        }

        else{
            return delegate.remove(key);
        }

    }

    @Override
    public void clear(){

        if(delegate == null){

            throw new IllegalArgumentException("map is still null");
        }
        else{
            delegate.clear();
        }
    }

    @Override
    public Set<K> keySet(){

        return delegate.keySet();

    }

    @Override
    public Collection<V> get(Object key){

        return delegate.get(key);

    }

    @Override
    public Set<Entry<K, Collection<V>>> entrySet() {
        return delegate.entrySet();
    }

    @Override
    public Collection<Collection<V>> values() {

        Collection<Collection<V>> arrayList = new ArrayList<Collection<V>>();
        for(Collection<V> individualArrayLists : delegate.values()){

            arrayList.add(individualArrayLists);
        }
        return delegate.values();
    }




    @Override
    public Collection<V> getItems(K key) {
        if ( key ==null ) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        if(containsKey(key)) {
            return get(key);
        }
        return createCollection();
    }

    @Override
    public boolean putItem(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        Collection<V> list = get(key);
        if(list == null) {
            list = createCollection();
            put(key,list);
        }
        return list.add(value);
    }

    protected abstract Collection<V> createCollection();
}
