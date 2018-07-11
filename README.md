[![Build Status](https://travis-ci.com/TestowanieJAVA2017-2018Gr2/projekt2-ksarzynski.svg?token=g1UYpGUr6KGSuzHkqfYc&branch=master)](https://travis-ci.com/TestowanieJAVA2017-2018Gr2/projekt2-ksarzynski)

[![BCH compliance](https://bettercodehub.com/edge/badge/ksarzynski/test?branch=master)](https://bettercodehub.com/)

[![Maintainability](https://api.codeclimate.com/v1/badges/5ccd11e6a6436092112b/maintainability)](https://codeclimate.com/github/ksarzynski/test/maintainability)

# Testowanie aplikacji JAVA 2017-2018
## Projekt 2 (Maven, JUnit oraz atrapy) 

**Projekt 3** (16 pkt)

Jesteś deweloperem piszącym fragment (bardzo uproszczonej) aplikacji (tutaj klasy **Messenger**) wysyłającej komunikaty do serwera. Twoja klasa korzysta z implementacji interfejsu **MessageService**. Zadaniem twojej aplikacji (uwaga: często spotykane w praktyce) jest m.in. ukrywanie statusów oraz wyjątków generowanych przez wykorzystywane komponenty takie jak **MessageService**. Zgodnie z życzeniem klienta twoja metoda odpowiedzialna za wysyłanie komunikatów ma zwracać liczby:
- 0 gdy powodzenie
- 1 gdy występują problemy z wysłaniem
- 2 gdy adres serwera lub komunikat jest niewłaściwie zbudowany
Klasa **Messenger** powinna też dostarczać metodę do testowania połączenia z serwerem zwracającym
liczby:
- 0 w przypadku sukcesu
- 1 w przeciwnym przypadku
Szkielet systemu jest zaimplementowany w pliku **messenger.zip**.
Dokończ klasę **Messenger**, a następnie przy użyciu poznawanych technologii przeprowadź testy
jednostkowe w tzw. izolacji (czyli bez gotowej implementacji **MessageService**)

Pod ocenę będą brane pod uwagę następujące elementy:
- (0.5 pkt) Kompilacja i uruchomienie bezbłędne projektu + konfiguracja TravisCi.
- (2 pkt) Uwzględnienie powyższych wymagań.
- (3 pkt) Przypadki testowe (uwzględniające wyjątki).
- (3 pkt) Przetestowanie przy użyciu ręcznie stworzonych atrap (co najmniej 6 testów, różnych od pozostałych)
- (3 pkt) Przetestowanie przy użyciu Mockito (co najmniej 6 testów, różnych od pozostałych).
- (3 pkt) Przetestowanie przy użyciu EasyMock (co najmniej 6 testów, różnych od pozostałych).
- (0.5 pkt) Pokrycie kodu (w przypadku ręcznie stworzonych atrap).
- (1 pkt) Styl kodu.

Ponadto, jako punkty dodatkowe będą brane następujące elementy: 
- (1 pkt) Użycie różnych rodzaji atrap.
- (1 pkt) Wynik z portalu BetterCodeHub.
- (2 pkt) Inne technologie dotyczące atrap, nie pokazywane na zajęciach (co najmniej po 5 testów każda z nich).
- (1 pkt) Integracja repozytorium z dowolnym serwisem.
- (1 pkt) Użycie JUnit5.

Ponadto pod ocenę jest brane również: (Brak tych elementów: -1 pkt za podpunkt od obowiązkowej
punktacji zadania!)
- Historia projektu w repozytorium.
- Różnorodne asercje (co najmniej 5 różnych).
- Struktura projektu.
