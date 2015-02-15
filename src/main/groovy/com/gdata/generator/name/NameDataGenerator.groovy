package com.gdata.generator.name

import com.gdata.generator.LocalizedGenerator

/**
 *
 * Date: 14/02/15
 * Time: 12:18
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class NameDataGenerator extends LocalizedGenerator<String> {

    @Override
    String generate() {
        return pickRandom()
    }
}
