### Define Pivot Currency
> What if the link between 2 currencies round numbers ?
#### The amount could be slightly higher or lower than the initial one, if we convert back
```gherkin
Given two Currencies, A and B; and A got an amount
When we have a pivot currency
Then converting from A to B, and the B to A the amount is the same as the initial one
```
### Add an exchange rate
> What if there isn't any link between 2 currencies
#### Converting from or to an unknown currency is impossible
```gherkin
Given a currency with a rate
When we want to add or modify a currency
Then the bank is updated
```
### Convert a Money
> What if a bank consumer want to convert from A to B currency?
#### Being able to convert amount between currencies
```gherkin
Given a currency and the name of the currency we want to convert
When we want to evaluate client portfolios
Then we are able to convert money in any other currency
```


#### Correction
### Define Pivot Currency
```gherkin
- Pour tout taux de change  : port de la devise/pivot
- DP => obligatoire + immuable
- ER : taux de change + devise destination
```

### Add an exchange rate
```gherkin
- pas 2 taux pour une même devise
- pas de ER avec devise Pivot
```

### Convert a Money
```gherkin
- Pas ER aved devise => Erreur de la banque sauf devise -> devise
- Round tripping 2 devises => 1% montant initial
- Round tripping 1 devise=> égalité stricte
```