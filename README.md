# FinalProject
Warsztaty z automatyzacji testów ZADANIA zaliczeniowe

Zadanie warsztatowe 1 - Selenium WebDriver + Cucumber

Utwórz użytkownika manualnie na stronie https://mystore-testlab.coderslab.pl.
Możesz wykorzystać tymczasowego maila do utworzenia użytkownika https://10minutemail.com/.
Napisz skrypt, który:

będzie logować się na tego stworzonego użytkownika,
wejdzie klikając w kafelek Addresses po zalogowaniu (adres, na którym powinniśmy się znaleźć to: https://mystore-testlab.coderslab.pl/index.php?controller=addresses ),
kliknie w + Create new address,
wypełni formularz New address - dane powinny być pobierane z tabeli Examples w Gherkinie (alias, address, city, zip/postal, code, country, phone),
sprawdzi czy dane w dodanym adresie są poprawne.

Dodatkowe kroki dla chętnych:

usunie powyższy adres klikając w "delete",
sprawdzi czy adres został usunięty.

Zadanie warsztatowe 2 (dowolny sposób)

Napisz skrypt, który:

zaloguje się na tego samego użytkownika z zadania 1,
wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
dodaj produkt do koszyka,
przejdzie do opcji - checkout,
potwierdzi address (możesz go dodać wcześniej ręcznie),
wybierze metodę odbioru - PrestaShop "pick up in store",
wybierze opcję płatności - Pay by Check,
kliknie na "order with an obligation to pay",
zrobi screenshot z potwierdzeniem zamówienia i kwotą.

Dodatkowe kroki dla chętnych:

Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
sprawdź czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.

Test automation tasks for passing course

 Task 1 - Selenium WebDriver + Cucumber

Create a user manually at https://mystore-testlab.coderslab.pl. You can use a temporary email to create the user https://10minutemail.com/. 
Write a script that:

will log in to this created user, 
will enter by clicking on Addresses tile after logging in (the address we should be at is: https://mystore-testlab.coderslab.pl/index.php?controller=addresses ), 
will click on + Create new address, 
will fill in New address form - data should be taken from Examples table in Gherkin (alias, address, city, zip/postal, code, country, phone), 
will check if data in added address is correct.

Additional steps for those who want to:

will delete the above address by clicking on "delete", will check if the address has been deleted.

Task 2 (any way)

Write a script that

logs in the same user from task 1, 
selects a Hummingbird Printed Sweater for purchase (extra option: check if the discount on it is 20%), 
selects a size M (extra option: make it so that you can parameterize the size and select S,M,L,XL), 
selects 5 pieces according to the parameter given in the test (extra option: make it so that you can parameterize the number of pieces), 
add the product to the cart, 
go to the option - checkout, 
confirm the address (you can add it manually beforehand), 
select the pickup method - PrestaShop "pick up in store", 
select the payment option - Pay by Check, 
click on "order with an obligation to pay", 
take a screenshot of the order confirmation and the amount.

Additional steps for those who want to:

Go to the order history and details (first click on the logged in user, then the tile), 
check if the order is listed with the status "Awaiting check payment" and the amount the same as on the order two steps earlier.

