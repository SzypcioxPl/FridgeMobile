
# Android Studio Java Workshop

## Zadanie 2: Prosta aplikacja z przyciskiem

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

## Zadanie 3: Aplikacja z prostym formularzem

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
