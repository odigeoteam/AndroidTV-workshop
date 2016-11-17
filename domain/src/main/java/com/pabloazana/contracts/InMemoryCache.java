package com.pabloazana.contracts;

public interface InMemoryCache<T> {

    T getObjects();
    void setObjects(T objects);


}
