package money_problem.domain;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static money_problem.domain.Currency.EUR;
import static money_problem.domain.Currency.USD;
import static org.assertj.core.api.Assertions.assertThat;

public class PortfolioTest {

    Bank bank = Bank.withExchangeRate(EUR, USD, 1.2);

    @Test
    @DisplayName("5 USD + 10 EUR = 17 USD")
    void shouldAdd() {
        //Arrange
        final Portfolio portfolio = new Portfolio();
        portfolio.add(5,EUR);
        portfolio.add(10, USD);

        //Act
        final double result = portfolio.evaluate(USD, bank);

        //Assert
        assertThat(result).isEqualTo(17);
    }

    @Test
    @DisplayName("should Be Evaluated To Zero When Empty")
    void evaluateEmptyPortfolio() {
        //Arrange
        final Portfolio portfolio = new Portfolio();

        //Act
        final double result = portfolio.evaluate(USD, bank);

        //Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("portfolio should be equal to portfolio")
    void portfolioEqualsPortfolio() {
        //Arrange
        final Portfolio portfolio = new Portfolio();
        portfolio.add(5, USD);

        //Act
        final double result = portfolio.evaluate(USD, bank);

        //Assert
        assertThat(result).isEqualTo(5);
    }
}
