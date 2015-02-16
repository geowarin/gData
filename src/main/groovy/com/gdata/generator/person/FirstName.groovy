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
class FirstName {
    String firstName
    String sex

    @Override
    public String toString() {
        firstName
    }

    static class Loader implements LocalizedLoader<FirstName> {
        @Inject
        Loader(Country country) {
            loadData(country.locale, '/firstName.json')
        }
    }
}
