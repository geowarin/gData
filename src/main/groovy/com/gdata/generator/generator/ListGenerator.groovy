package com.gdata.generator.generator

import com.google.inject.Provider

/**
 *
 * Date: 15/02/15
 * Time: 17:31
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class ListGenerator implements Provider {
    ObjectGenerator generator
    private int min
    private int max

    ListGenerator(ObjectGenerator generator, int min, int max = min) {
        this.max = max
        this.min = min
        this.generator = generator
    }

    List get() {
        List result = []
        randomRange().times {
            result.push(generator.get())
        }
        result
    }

    int randomRange() {
        if (min == max)
            return min
        return new Random().nextInt(max - min + 1) + min
    }
}
