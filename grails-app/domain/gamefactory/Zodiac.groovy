package gamefactory

class Zodiac {

    String name
    String element
    String message

    static constraints = {
        name nullable: false
        element nullable: true
        message nullable: true
    }

    String toString() {
        name
    }
}
