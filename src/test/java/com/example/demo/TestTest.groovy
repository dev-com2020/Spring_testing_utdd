import spock.lang.Specification

class TestTest extends Specification {

    def "should add two numbers"() {
        expect:
        Math.addExact(a, b) == result

        where:
        a  | b  || result
        1  | 2  || 3
        3  | 4  || 7
        -1 | 1  || 0
    }
    def taxService = new TaxService()

    @Unroll
    def "should calculate tax for amount #amount"() {
        expect:
        taxService.calculateTax(amount) == expectedTax

        where:
        amount | expectedTax
        100    | 20.0
        50     | 10.0
        200    | 40.0
    }

    def "should throw exception for negative amount"() {
        when:
        taxService.calculateTax(-10)

        then:
        thrown(IllegalArgumentException)
    }
    def "should check if repository method was called"() {
        given:
        userRepository.findByUsername("alice") >> new User("alice")

        when:
        userService.userExists("alice")

        then:
        1 * userRepository.findByUsername("alice") // Sprawdza, czy metoda została wywołana raz
    }
}
