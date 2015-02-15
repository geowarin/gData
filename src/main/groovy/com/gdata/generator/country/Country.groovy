package com.gdata.generator.country

import groovy.transform.ToString

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
}
