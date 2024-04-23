
# Debugowanie Aplikacji Android w Android Studio

## Wprowadzenie
Ten dokument zawiera instrukcje dotyczące debugowania aplikacji mobilnych w środowisku Android Studio, używając do tego celu połączenia USB oraz WiFi. Poniższe kroki pomogą Ci skonfigurować i debugować Twoją aplikację bezpośrednio na fizycznym urządzeniu Android.

## Wymagania Wstępne
- Zainstalowane Android Studio.
- Zainstalowane sterowniki USB dla Twojego urządzenia Android (dla debugowania przez USB).
- Telefon z Androidem z włączoną opcją debugowania przez USB (opcje programisty).

## Krok 1: Włączanie Opcji Programisty i Debugowania przez USB
1. **Odblokuj opcje programisty**: Przejdź do `Ustawienia > O telefonie` i kliknij 7 razy w numer kompilacji, aby odblokować opcje programisty.
2. **Włącz debugowanie przez USB**: Przejdź do `Ustawienia > Opcje programisty` i włącz `Debugowanie przez USB`.

## Krok 2: Konfiguracja Android Studio
1. Podłącz telefon do komputera za pomocą kabla USB.
2. Otwórz Android Studio i załaduj swój projekt.
3. Sprawdź, czy Android Studio wykrywa Twoje urządzenie. Po otwarciu projektu i podłączeniu telefonu powinno się pojawić okno dialogowe na telefonie z pytaniem, czy zezwolić na debugowanie USB z tego komputera. Zatwierdź to.

## Krok 3: Debugowanie Aplikacji przez USB
1. Wybierz swoje urządzenie w menu rozwijanym w Android Studio (obok przycisku z zieloną strzałką).
2. Uruchom aplikację w trybie debugowania, klikając zieloną strzałkę obok nazwy Twojego urządzenia lub naciskając `Shift + F10`.
3. Użyj zakładek takich jak Logcat czy Debugger w Android Studio, aby obserwować logi i zmienne podczas działania aplikacji.

## Krok 4: Konfiguracja Debugowania przez WiFi (opcjonalnie)
1. Podłącz telefon do komputera przez USB i upewnij się, że debugowanie przez USB jest włączone.
2. Otwórz terminal w Android Studio (`View > Tool Windows > Terminal`).
3. Sprawdź połączenie urządzenia poleceniem:
   ```bash
   adb devices
   ```
4. Połącz się z urządzeniem przez WiFi wykonując:
   ```bash
   adb tcpip 5555
   ```
5. Odłącz urządzenie USB. Znajdź IP swojego urządzenia w `Ustawienia > O telefonie > Status > Adres IP`.
6. Podłącz ponownie do urządzenia przez WiFi poleceniem:
   ```bash
   adb connect [IP_URZĄDZENIA]:5555
   ```
7. Powtórz kroki z sekcji 3, wybierając swoje urządzenie z listy dostępnych urządzeń w Android Studio.
