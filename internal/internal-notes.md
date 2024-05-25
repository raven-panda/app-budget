# App Budget

## Base

Pour l'instant, juste gérer annuel OU mensuel pour tout les budgets
D'abord implémenter les fonctionnalités primaires et leurs tests, et ensuite on gèrera la sécurité.

## Back-end

### Structure BDD

Au niveau des tables :
- User
  - La connection se fera par l'email
- Preferences
  - Prefered color scheme
  - Préfère budget annuel/mensuel
  - Enregistrer si préfère pas voir avertissement quant à la modif
- Expense
- Expense Category
- Max Budget

### Structure API REST

```
fr.ravenpanda.hyperbudget
  +- HyperBudgetApp
  |
  +- /core
  |  +- /config
  |  |  +- ApiConfig
  |  |  +- SecurityConfig
  |  |
  |  +- service
  |  +- serializer
  |
  +- /user
  |  +- UserController
  |  +- UserService
  |  +- UserDto
  |  +- UserEntity
  |  +- UserRepository
  |
  +- /budget
  |  +- BudgetController
  |  +- BudgetService
  |  +- BudgetDto
  |  +- BudgetEntity
  |  +- BudgetRepository
  +- etc...
```

## Front-End

### Contraintes

- Mobile First
