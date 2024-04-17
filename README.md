
# Android Studio Java Workshop

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
       android:text="Pokaż Toast" />
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
           String name = nameInput.getText().toString();
           if (!name.isEmpty()) {
               Toast.makeText(MainActivity.this, "Witaj, " + name + "!", Toast.LENGTH_SHORT).show();
           } else {
               nameInput.setError("Proszę wpisać imię");
           }
       }
   });
   ```

3. **Testowanie aplikacji:**
   - Ponownie uruchom aplikację i przetestuj działanie formularza wpisując swoje imię i klikając przycisk powitania.

Używając powyższych instrukcji, uczestnicy warsztatów będą mogli krok po kroku zbudować prostą aplikację interaktywną, która wprowadzi ich w świat programowania aplikacji mobilnych na Androida.

## Zadanie 3: Debuggowanie z bez emulatora
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
