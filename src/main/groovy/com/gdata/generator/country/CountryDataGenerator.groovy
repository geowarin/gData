package com.gdata.generator.country

import com.gdata.generator.DataGenerator

/**
 *
 * Date: 14/02/15
 * Time: 12:18
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class CountryDataGenerator extends DataGenerator<Country> {

    @Override
    Country generate() {
        return pickRandom()
    }
}
