package com.aestrea

class GameController {

    def index() {
        def model = [:]

        model.games = ["FLAMES", "FENG SHUI"]

        render view: '/game/index', model: model
    }

    def play() {
        def model = [:]

        if (params.game == 'FLAMES') {
            String firstName = params.firstName
            String secondName = params.secondName

            def charArr1 = firstName.replace(' ','').toLowerCase().toCharArray()
            def charArr2 = secondName.replace(' ','').toLowerCase().toCharArray()

            for(int i=0; i<charArr1.length; i++) {
                for(int j=0; j<charArr2.length; j++) {
                    if (charArr2[j] == charArr1[i]) {
                        charArr2[j] = charArr1[i] = "*"
                        break
                    }
                }
            }


            firstName = charArr1.toString()
            secondName = charArr2.toString()

            int remaining = firstName.replace('*','').length() + secondName.replace('*','').length()

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
               flamesRes = "Cannot flames! All the letters of the two names matched! Either the names are ambigrams of each other or " +
                       "you tried to flames with the same person. How vain. ewe!"
           }


            def results = []
            results.add("First Name: ${firstName}")
            results.add("Second Name: ${secondName}")
            results.add("Remaining letters: ${remaining}")
            results.add("Result: ${flamesRes}")
            model.results = results
            model.game = 'FLAMES'

            render view: '/game/play', model: model

        } else if (params.game == 'FENG SHUI') {
            int year = Integer.parseInt(params.year)

            int sYear = 1920

            int dYear = year - sYear

            String zodiac

            String element

            String message

            switch (dYear % 12) {
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

            model.results = results
            model.game = 'FENG SHUI'

            render view: '/game/play', model: model

        }
    }
}
