package com.gdata.generator.person

import com.google.inject.Provider

/**
 *
 * Date: 16/02/15
 * Time: 14:05
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
enum Gender {
    MALE,
    FEMALE

    @Override
    String toString() {
        name().toLowerCase()[0]
    }

    static class Loader implements Provider<Gender> {

        @Override
        Gender get() {
            List genders = values()
            Collections.shuffle(genders)
            genders.first()
        }
    }
}