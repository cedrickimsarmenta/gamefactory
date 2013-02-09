import gamefactory.Zodiac

class BootStrap {

    def init = { servletContext ->

        def zodiacs = [
                ['Monkey',  'Metal',    'Quick-witted'],
                ['Rooster', 'Metal',    'Honest'],
                ['Dog',     'Earth',    'Loyal'],
                ['Pig',     'Water',    'Honorable'],
                ['Rat',     'Water',    'Intelligent'],
                ['Ox',      'Earth',    'Loyal'],
                ['Tiger',   'Wood',     'Enthusiastic'],
                ['Rabit',   'Wood',     'TrustWorthy'],
                ['Dragon',  'Earth',    'Lucky'],
                ['Snake',   'Fire',     'Philosophical'],
                ['Horse',   'Fire',     'Adaptable'],
                ['Goat',    'Earth',    'Tasteful']
        ]

        zodiacs.each {
            new Zodiac(
                name: it[0],
                element: it[1],
                message: it[2]
            ).save(failOnError: true)
        }

    }
    def destroy = {
    }
}
