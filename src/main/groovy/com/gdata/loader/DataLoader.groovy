package com.gdata.loader

import com.google.inject.Provider
import groovy.json.JsonSlurper

/**
 *
 * Date: 14/02/15
 * Time: 12:21
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
abstract trait DataLoader<T> implements Randomized<T>, Provider<T> {
    protected T data

    void loadData(String dataPath) {
        InputStream stream = this.getClass().getResourceAsStream(dataPath)
        List<T> json = new JsonSlurper().parse(stream)
        data = pickRandom(json)
    }

    T get() {
        data
    }
}
