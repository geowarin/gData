package com.gdata.loader

import com.gdata.generator.person.FirstName
import com.gdata.generator.person.Gender
import com.google.inject.Provider
import groovy.json.JsonSlurper
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FirstParam
import groovy.transform.stc.FromString

import javax.lang.model.element.TypeElement
import java.lang.reflect.TypeVariable

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
        Map<String, List<T>> allData = new JsonSlurper().parse(stream)
        List<T> localizedData = allData.get(locale.toString()) ?: allData.get('default')
        if (filter)
            localizedData = localizedData.findAll(filter)
        data = pickRandom(localizedData)
    }

    T get() {
        data
    }
}
