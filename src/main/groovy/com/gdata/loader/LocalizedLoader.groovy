package com.gdata.loader

import com.gdata.generator.country.Country
import com.google.inject.Provider
import groovy.json.JsonSlurper

/**
 *
 * Date: 14/02/15
 * Time: 12:21
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
trait LocalizedLoader<T> implements Randomized<T>, Provider<T> {
    protected Country country
    protected T data

    void loadData(Country country) {
        this.country = country
        InputStream stream = this.getClass().getResourceAsStream('data.json')
        Map<String, List<T>> allData = new JsonSlurper().parse(stream)
        data = pickRandom(allData.get(country.locale.toString()))
    }

    T get() {
        data
    }
}
