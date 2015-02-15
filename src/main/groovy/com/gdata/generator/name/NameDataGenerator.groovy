package com.gdata.generator.name

import com.gdata.loader.LocalizedLoader
import com.gdata.generator.country.Country
import com.google.inject.Inject
import com.google.inject.Provider

/**
 *
 * Date: 14/02/15
 * Time: 12:18
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class NameDataGenerator implements LocalizedLoader<String>, Provider<String> {

    @Inject
    NameDataGenerator(Country country) {
        loadData(country)
    }

    @Override
    String get() {
        data
    }
}
