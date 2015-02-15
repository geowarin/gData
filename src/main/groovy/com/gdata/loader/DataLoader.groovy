package com.gdata.loader

import groovy.json.JsonSlurper

/**
 *
 * Date: 14/02/15
 * Time: 12:21
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
abstract trait DataLoader<T> implements Randomized<T> {
    protected T data

    void loadData() {
        InputStream stream = this.getClass().getResourceAsStream('data.json')
        List<T> json = new JsonSlurper().parse(stream)
        data = pickRandom(json)
    }

    T getData() {
        data
    }
}
