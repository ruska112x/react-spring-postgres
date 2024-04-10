# Our project use FSD methodology

## Layers

src/app - настройки, стили и провайдеры для всего приложения

src/pages - композиционный слой для сборки полноценных страниц из сущностей, фич и виджетов

src/widgets - композиционный слой для соединения сущностей и фич в самостоятельные блоки (IssuesList, UserProfile)

src/features - взаимодействия с пользователем, действия, которые несут бизнес-ценность для пользователя (SendComment, AddToCart, UsersSearch)

src/entities - бизнес-сущности (User, Product, Order)

src/shared - переиспользуемый код, не имеющий отношения к специфике приложения (UIKit, libs, API)
