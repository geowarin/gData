package com.gdata.generator.person

import com.google.inject.*

/**
 *
 * Date: 15/02/15
 * Time: 16:02
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class Email {
    String email

    @Override
    public String toString() {
        email
    }

    static class Loader implements Provider<Email> {
        String email

        @Inject
        Loader(FirstName firstName, LastName lastName) {
            email = "${firstName.firstName.toLowerCase()}.${lastName.lastName.toLowerCase()}@gmail.com"
        }

        @Override
        Email get() {
            new Email(email: email)
        }
    }
}
