# andersen-hw-contacts-recycler
6th homework. RecyclerView contacts list  

Для хранения данных контактов используется ViewModel в скоупе общей для фрагментов активити. При нажатии на элемент списка, первый фрагмет отправляет id элемента в активити с помощью Fragment Result API. Та в свою очередь запускает второй фрагмент, передавая id контакта в аргументы при инициализации в виде bundle. Второй фрагмент сравнивает элемент в списке контактов во viewmodel, фильтруя по пришедшему аргументу.  

Кастомный список заменен на RecyclerView. Загрузка изображений происходит в классе адаптера. Для каждого изображения генерируется своя сигнатура, чтобы Glide не выдавал одну и ту же картинку по одному url.  

На планшетах приложение работает в split-view режиме (на одном экране).  
