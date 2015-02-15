package com.gdata.loader

/**
 *
 * Date: 15/02/15
 * Time: 15:40
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
trait Randomized<T> {

    T pickRandom(List<T> data) {
        Collections.shuffle(data)
        data.first()
    }
}
