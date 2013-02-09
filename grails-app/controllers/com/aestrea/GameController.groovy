package com.aestrea

class GameController {

    private static final int FENGSHUI_REFERENCE_YEAR = 1920

    def index() {
        def model = [:]

        model.games = ["FLAMES", "FENG SHUI"]

        render view: '/game/index', model: model
    }

    def play() {


        if (params.game == 'FLAMES') {
            playFlames()

        } else if (params.game == 'FENG SHUI') {
            playFengShui()
        }


    }

    private void playFengShui() {
        def model =[:]
        int birthYear = Integer.parseInt(params.year)
        int differenceYear = birthYear - FENGSHUI_REFERENCE_YEAR
        def zodiac = ChineseZodiac.values()[ differenceYear%12 ]

        def results = []
        results << "Your zodiac: ${zodiac.name}"
        results << "Element: ${zodiac.element}"
        results << "Characteristics: ${zodiac.message}"
        results << "Kung hei fat choi!"

        model.results = results
        model.game = params.game

        render view: '/game/play', model: model
    }

    private void playFlames() {
        def model =[:]
        String firstName = params.firstName
        String secondName = params.secondName

        List firstNameCharacters = firstName.collect{ it }
        List secondNameCharacters = secondName.collect{ it }

        int remaining = ((firstNameCharacters + secondNameCharacters).unique() - firstNameCharacters.intersect( secondNameCharacters )).size()

        String flamesRes
        if (remaining > 0) {
            switch (remaining % 6) {
                case 0:
                    flamesRes = "S - Sweet"
                    break
                case 1:
                    flamesRes = "F - Friends"
                    break
                case 2:
                    flamesRes = "L - Love"
                    break
                case 3:
                    flamesRes = "A - Angry"
                    break
                case 4:
                    flamesRes = "M - Marriage"
                    break
                case 5:
                    flamesRes = "E - Enemy"
                    break
            }
        } else {
            flamesRes = "Cannot flames! All the letters of the two names matched! Either the names are ambigrams of each other or " +
                    "you tried to flames with the same person. How vain. ewe!"
        }


        def results = []
        results << "First Name: ${firstName}"
        results << "Second Name: ${secondName}"
        results << "Remaining letters: ${remaining}"
        results << "Result: ${flamesRes}"
        model.results = results
        model.game = params.game

        render view: '/game/play', model: model
    }

}

public enum ChineseZodiac {

    MONKEY( 'Monkey', 'Metal', 'Quick-witted' ),
    ROOSTER( 'Rooster', 'Metal', 'Honest' ),
    DOG( 'Dog', 'Earth', 'Loyal' ),
    PIG( 'Pig', 'Water', 'Honorable' ),
    RAT( 'Rat', 'Water', 'Intelligent' ),
    OX( 'Ox', 'Earth', 'Loyal' ),
    TIGER( 'Tiger', 'Wood', 'Enthusiastic' ),
    RABBIT( 'Rabbit', 'Wood', 'TrustWorthy' ),
    DRAGON( 'Dragon', 'Earth', 'Lucky' ),
    SNAKE( 'Snake', 'Fire', 'Philosophical' ),
    HORSE( 'Horse', 'Fire', 'Adaptable' ),
    GOAT( 'Goat', 'Earth', 'Tasteful' )

    String name, element, message

    private ChineseZodiac( name, element, message ){
        this.name = name
        this.element = element
        this.message = message
    }

    String toString(){
        "${name} ${element} ${message}"
    }

}