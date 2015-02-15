package com.gdata.generator

import groovy.json.JsonSlurper

/**
 *
 * Date: 14/02/15
 * Time: 12:21
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
abstract class DataGenerator<T> extends Generator {
    protected List<T> data

    DataGenerator() {
        InputStream stream = this.getClass().getResourceAsStream('data.json')
        data = new JsonSlurper().parse(stream)
    }

    T pickRandom() {
        Collections.shuffle(data)
        data.first()
    }
}
