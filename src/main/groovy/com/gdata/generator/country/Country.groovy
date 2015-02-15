package com.gdata.generator.country

import com.gdata.loader.DataLoader

/**
 *
 * Date: 14/02/15
 * Time: 12:49
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class Country {
    String name
    Locale locale

    @Override
    String toString() {
        name
    }

    void setLocale(String lang) {
        this.locale = new Locale(lang)
    }

    static class Loader implements DataLoader<Country> {
        Loader() {
            loadData()
        }
    }
}
