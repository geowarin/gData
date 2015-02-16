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
        loadData(locale, dataPath, null)
    }

    void loadData(Locale locale, String dataPath, Closure filter) {
        InputStream stream = this.getClass().getResourceAsStream(dataPath)
        Map allData = new JsonSlurper().parse(stream)
        List localizedData = allData[locale.toString()] ?: allData['default']
        if (filter) {
            Class generic = getClass().genericInterfaces[0].actualTypeArguments[0]
            localizedData = localizedData.findAll { filter.call(generic.newInstance(it)) }
        }
        data = pickRandom(localizedData)
    }

    T get() {
        data
    }
}
