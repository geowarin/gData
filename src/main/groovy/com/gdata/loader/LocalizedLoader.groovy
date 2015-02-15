package com.gdata.loader

import com.google.inject.Provider
import groovy.json.JsonSlurper

/**
 *
 * Date: 14/02/15
 * Time: 12:21
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
trait LocalizedLoader<T> implements Randomized<T>, Provider<T> {
    protected T data

    void loadData(Locale locale, String dataPath) {
        InputStream stream = this.getClass().getResourceAsStream(dataPath)
        Map<String, List<T>> allData = new JsonSlurper().parse(stream)
        List<T> localizedData = allData.get(locale.toString()) ?: allData.get('default')
        data = pickRandom(localizedData)
    }

    T get() {
        data
    }
}
