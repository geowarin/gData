package com.gdata.generator

import com.gdata.generator.country.*
import com.gdata.generator.injection.DependsOn
import groovy.json.JsonSlurper

/**
 *
 * Date: 14/02/15
 * Time: 12:21
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@DependsOn(CountryDataGenerator)
abstract class LocalizedGenerator<T> extends Generator<T> {
    protected Country country
    protected List<T> data

    LocalizedGenerator(Country country) {
        this.country = country
        InputStream stream = this.getClass().getResourceAsStream('data.json')
        Map<String, List<T>> allData = new JsonSlurper().parse(stream)
        data = allData.get(country.locale.toString())
    }

    T pickRandom() {
        Collections.shuffle(data)
        data.first()
    }
}
