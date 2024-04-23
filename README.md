
# Android Studio Java Workshop

## Część Teoretyczna

W tej sekcji znajdziesz linki do materiałów teoretycznych, które pomogą Ci zrozumieć podstawy oraz zaawansowane techniki używane podczas tworzenia aplikacji na Androida. Zawiera ona zarówno źródła zewnętrzne, jak i prezentacje przygotowane specjalnie na te warsztaty.

### Źródła
- [Dokumentacja Android Developer](https://developer.android.com/docs) - Oficjalna dokumentacja dla twórców aplikacji na Androida, zawierająca szczegółowe informacje na temat API, komponentów aplikacji, narzędzi i najlepszych praktyk.
- [Java Fundamentals for Android Development](https://www.youtube.com/watch?v=fis26HvvDII&t=38425s&pp=ygUfYW5kcm9pZCBkZXZlbG9wbWVudCBmdWxsIGNvdXJzZQ%3D%3D) - Podstawy języka Java, niezbędne do pracy na Android Studio.

### Prezentacja
- [Link do naszej prezentacji](https://www.canva.com/design/DAGCTSXFJ_A/fRDTx5flctrrd0Pt1fJSpw/view?utm_content=DAGCTSXFJ_A&utm_campaign=designshare&utm_medium=link&utm_source=editor) - Zachęcamy do zajrzenia ponownie dla osób z ulotną pamięcią.
### Dodatkowe Materiały
- [Android Design Guidelines](https://material.io/design) - Wytyczne projektowania dla aplikacji Android, które pomagają tworzyć estetyczne i funkcjonalne interfejsy użytkownika.

Zachęcamy do zapoznania się z tymi materiałami przed rozpoczęciem praktycznej części warsztatów.

## Część Praktyczna

## Zadanie 1: Prosta aplikacja z przyciskiem

**Cel:** Nauka podstaw interakcji z użytkownikiem poprzez przycisk i obsługę zdarzeń w języku Java.

### Kroki:
1. **Dodaj przycisk do layoutu:**
   - Otwórz plik `activity_main.xml`.
   - Użyj poniższego kodu XML, aby dodać przycisk do layoutu:
   ```xml
   <Button
       android:id="@+id/button_toast"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="Twoje imie i Nazwisko" />
   ```

2. **Ustawienie OnClickListener:**
   - Przejdź do pliku `MainActivity.java`.
   - Znajdź metodę `onCreate` i dodaj do niej poniższy kod:
   ```java
   Button button = findViewById(R.id.button_toast);
   button.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_SHORT).show();
       }
   });
   ```

3. **Uruchomienie aplikacji:**
   - Kliknij 'Run' (zielony trójkąt) w Android Studio, aby uruchomić aplikację.
   - Kiedy aplikacja się uruchomi, kliknij przycisk i obserwuj pojawiający się komunikat Toast.
  
4. **Jako wykonanie zadania prześlij zrzut ekranu na UPELu z przyciskiem wyświetlającym twoje imię i nazwisko**

## Zadanie 2: Aplikacja z prostym formularzem

**Cel:** Nauczenie podstawowych elementów interfejsu użytkownika oraz gromadzenie danych wejściowych.

### Kroki:
1. **Dodanie EditText i przycisku do layoutu:**
   - W pliku `activity_main.xml`, umieść `EditText` i przycisk poniżej wcześniej dodanego przycisku Toast:
   ```xml
   <EditText
       android:id="@+id/editText_name"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:hint="Wpisz swoje imię" />
   
   <Button
       android:id="@+id/button_greet"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="Powitaj" />
   ```

2. **Obsługa kliknięcia przycisku powitania:**
   - W `MainActivity.java`, dodaj nowy `OnClickListener` dla przycisku powitania:
   ```java
   Button greetButton = findViewById(R.id.button_greet);
   final EditText nameInput = findViewById(R.id.editText_name);
   
   greetButton.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           String name = ###################### // tu wpisz brakującą część kodu
           if (!name.isEmpty()) {
               Toast.makeText(MainActivity.this, "Witaj, " + name + "!", Toast.LENGTH_SHORT).show();
           } else {
               nameInput.setError("Proszę wpisać imię");
           }
       }
   });
   ```

3. **Testowanie aplikacji:(Dodatkowe)**
   - Ponownie uruchom aplikację i przetestuj działanie formularza wpisując swoje imię i klikając przycisk powitania.

4. **Jako wykonanie zadania prześlij zrzut ekranu na UPELu gdzie na ekratnie aplikacja wyświetli po wpisaniu w pole tekstowe twój numer indeksu**

## Zadanie 3: Debuggowanie bez emulatora

**Cel:** Nauczenie się debugowania aplikacji Android bezpośrednio na fizycznym urządzeniu za pomocą połączenia USB lub WiFi.

### Kroki:
1. **Włączenie opcji programisty i debugowania przez USB:**
   - Na urządzeniu Android przejdź do `Ustawienia > O telefonie` i kliknij 7 razy w numer kompilacji, aby odblokować opcje programisty.
   - Włącz `Debugowanie przez USB` w `Ustawienia > Opcje programisty`.

2. **Konfiguracja Android Studio:**
   - Podłącz telefon do komputera za pomocą kabla USB.
   - Otwórz Android Studio i załaduj swój projekt.
   - Upewnij się, że Android Studio wykrywa Twoje urządzenie. Po podłączeniu telefonu powinno pojawić się okno dialogowe z pytaniem, czy zezwolić na debugowanie USB z tego komputera.

3. **Debugowanie aplikacji przez USB:**
   - Wybierz swoje urządzenie z listy dostępnych urządzeń w Android Studio (menu rozwijane obok przycisku z zieloną strzałką).
   - Uruchom aplikację w trybie debugowania, klikając zieloną strzałkę obok nazwy Twojego urządzenia lub naciskając `Shift + F10`.
   - Użyj narzędzi takich jak Logcat czy Debugger w Android Studio, aby śledzić logi i zmienne.

4. **Konfiguracja debugowania przez WiFi (opcjonalnie):**
   - W terminalu Android Studio (`View > Tool Windows > Terminal`) wykonaj polecenie `adb devices` aby sprawdzić połączenie.
   - Przełącz urządzenie na połączenie przez WiFi za pomocą polecenia `adb tcpip 5555`.
   - Odłącz urządzenie USB. Znajdź IP urządzenia w `Ustawienia > O telefonie > Status > Adres IP` i połącz z urządzeniem przez WiFi wykonując `adb connect [IP_URZĄDZENIA]:5555`.
   - Powtórz kroki debugowania z użyciem połączenia WiFi.

### Testowanie aplikacji:
   - Po skonfigurowaniu urządzenia, uruchom aplikację w trybie debugowania, obserwując jak aplikacja zachowuje się na fizycznym urządzeniu.
   - Sprawdź reakcje aplikacji na interakcje użytkownika i potencjalne błędy w działaniu.


