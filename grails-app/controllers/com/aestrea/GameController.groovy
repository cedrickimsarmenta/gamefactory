package com.aestrea

class GameController {

    private static final Integer START_YEAR = 1920

    def index() {
        def model = [:]
        model.games = ["FLAMES", "FENG SHUI"]
        render view: '/game/index', model: model
    }

    def play = {
        if (params.game == 'FLAMES') {
            flames( params.firstPerson, params.secondPerson )
        } else if (params.game == 'FENG SHUI') {
            fengshui( params.birthYear )
        }
    }

    def flames( firstPerson, secondPerson) {
        def model = [:]

        def charArr1 = transformName firstPerson
        def charArr2 = transformName secondPerson

        for(int i=0; i < charArr1.length; i++) {
            for(int j=0; j < charArr2.length; j++) {
                if (charArr2[j] == charArr1[i]) {
                    charArr2[j] = charArr1[i] = "*"
                    break
                }
            }
        }

        firstPerson = charArr1.toString()
        secondPerson = charArr2.toString()

        int remaining = firstPerson.replace('*','').length() + secondPerson.replace('*','').length()



        String flamesRes
        if(remaining > 0) {
            switch (remaining % 6){
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
            flamesRes = message(code: 'flames.invalid')
        }

        def results = []
        results.add("First Name: ${firstPerson}")
        results.add("Second Name: ${secondPerson}")
        results.add("Remaining letters: ${remaining}")
        results.add("Result: ${flamesRes}")
        model.results = results
        model.game = 'FLAMES'

        render view: '/game/play', model: model

    }

    def fengshui( birthYear ) {
        def model = [:]
        int year = Integer.parseInt( birthYear )
        int startYear = START_YEAR
        int differenceYear = year - startYear

        String zodiac
        String element
        String message

        switch (differenceYear % 12) {
            case 0:
                zodiac = "Monkey"
                element = "Metal"
                message = "Quick-witted"
                break

            case 1:
                zodiac = "Rooster"
                element ="Metal"
                message = "Honest"
                break

            case 2:
                zodiac = "Dog"
                element ="Earth"
                message = "Loyal"
                break

            case 3:
                zodiac = "Pig"
                message = "Water"
                element = "Honorable"

                break

            case 4:
                zodiac = "Rat"
                message = "Intelligent"
                element ="Water"

                break

            case 5:
                zodiac = "Ox"
                message = "Loyal"
                element ="Earth"

                break

            case 6:
                zodiac = "Tiger"
                message = "Enthusiastic"
                element ="Wood"

                break

            case 7:
                zodiac = "Rabbit"
                element = "Wood"
                message = "TrustWorthy"
                break
            case 8:
                zodiac = "Dragon"
                message = "Lucky"
                element ="Earth"

                break
            case 9:

                zodiac = "Snake"
                message = "Philosopical"
                element ="Fire"

                break
            case 10:
                zodiac = "Horse"
                message = "Adaptable"
                element ="Fire"

                break

            case 11:
                zodiac = "Goat"
                message = "Tasteful"
                element ="Earth"

                break
        }

        def results = []
        results.add("Your zodiac: ${zodiac}")
        results.add("Element: ${element}")
        results.add("Characteristics: ${message}")
        results.add("Kung hei fat choi!")

        model.results = results
        model.game = 'FENG SHUI'

        render view: '/game/play', model: model
    }

    private transformName( name ){
        name.replace(' ','').toLowerCase().toCharArray()
    }

}
