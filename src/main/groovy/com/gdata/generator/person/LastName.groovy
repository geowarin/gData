package com.gdata.generator.person

import com.gdata.generator.country.Country
import com.gdata.loader.LocalizedLoader
import com.google.inject.Inject

/**
 *
 * Date: 15/02/15
 * Time: 16:02
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class LastName {
    String lastName

    @Override
    public String toString() {
        lastName
    }

    static class Loader implements LocalizedLoader<LastName> {
        @Inject
        Loader(Country country) {
            loadData(country.locale, '/lastName.json')
        }
    }
}
