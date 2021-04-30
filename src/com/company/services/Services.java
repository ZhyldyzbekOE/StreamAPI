package com.company.services;
import com.company.enums.AbonentStatus;
import com.company.models.People;
import com.company.models.Person;
import java.util.*;
import java.util.stream.Collectors;

public class Services {

    List<Person> personList = new ArrayList<>();

    public void createPerson() {
        Person stalin = new Person("Аскар", AbonentStatus.ACTIVE, 21);
        Person lenin = new Person("Бекмырза", AbonentStatus.ACTIVE, 9);
        Person brezhnev = new Person("Элина", AbonentStatus.ACTIVE, 220);
        Person yeltsin = new Person("Алина", AbonentStatus.ACTIVE, 100);
        Person zhyldyzbek = new Person("Жылдызбек", AbonentStatus.ACTIVE, 85);
        Person gorbachev = new Person("Светлана", AbonentStatus.ACTIVE, 15);
        Person malinkov = new Person("Жунуш", AbonentStatus.INACTIVE, 23);
        Person khrushchev = new Person("Мырза", AbonentStatus.INACTIVE, 2);
        Person akaev = new Person("Ислам", AbonentStatus.INACTIVE, 22);
        personList.add(khrushchev);
        personList.add(stalin);
        personList.add(lenin);
        personList.add(brezhnev);
        personList.add(yeltsin);
        personList.add(zhyldyzbek);
        personList.add(gorbachev);
        personList.add(malinkov);
        personList.add(akaev);
        System.out.println("----------------Работа с map, filter------------------");

        System.out.println("----------------Полный список---------------- ");
        for (Person item : personList) {
            System.out.println(item.getName() + " - " + item.getMoneyOnPhone() + " - " + item.getAbonentStatus());
        }
        System.out.print("\n");
        System.out.println("----------------После фильтра----------------");
        System.out.println("Фильтр проходил на основе баланса на телефоне > 20" +
                ". Статус абонента ACTIVE: ");

        List<Person> personListFilterMap = personList.stream()
                .filter(person -> person.getMoneyOnPhone() >= 20)
                .filter(person -> person.getAbonentStatus() == AbonentStatus.ACTIVE)
                .collect(Collectors.toList());

        for (Person item : personListFilterMap) {
            System.out.println(item.getName() + " - " + item.getMoneyOnPhone() + " - " + item.getAbonentStatus());
        }
        System.out.print("\n");
        System.out.println("----------------Всем нашим активным абонентам к балансу +50----------------");
        List<Double> personMoney = personListFilterMap.stream()
                .map(person -> person.getMoneyOnPhone() + 50)
                .collect(Collectors.toList());
        long counter = personMoney.stream()
                .count();

        Map<String, Double> personDoubleMap = new LinkedHashMap<>();

        for (int i = 0; i < personListFilterMap.size(); i++) {
            personDoubleMap.put(personListFilterMap.get(i).getName(), personMoney.get(i));
        }

        for (Map.Entry entry : personDoubleMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("-----Количество активных абонентов: " + counter);
        System.out.print("\n");
        System.out.println("----------------Сортировка по статусу и средств на балансе, использование методов sorted(), skip() && limit()----------------");
        System.out.println("*****Метод sorted был реализован через интерфейс Comarable<Person>*****");
        List<Person> personListSortedLimitSkip = personList.stream()
                .skip(2)
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
        personListSortedLimitSkip.forEach(person -> System.out.println(person));
        System.out.print("\n");
        System.out.println("----------------Работа с anyMatch------------------");
        boolean anyMatch = personList.stream()
                .anyMatch(person -> person.getAbonentStatus().equals(AbonentStatus.GOLD) || person.getMoneyOnPhone() > 200);

        if (!anyMatch) {
            System.out.println("-----Абонентов со статусом GOLD или балансом больше 200 нет!-----");
        } else {
            System.out.println("-----Абоненты со статусом GOLD или балансом больше 200-----");
            for (Person p : personList) {
                if (p.getAbonentStatus().equals(AbonentStatus.GOLD) || p.getMoneyOnPhone() > 200) {
                    System.out.println("Имя абонента: " + p.getName() + ". Статус: " + p.getAbonentStatus() + ". Баланс: " + p.getMoneyOnPhone());
                }
            }
        }
        System.out.print("\n");
        System.out.println("----------------Работа с noneMatch------------------");
        boolean noneMatch = personList.stream()
                .noneMatch(person -> person.getAbonentStatus().equals(AbonentStatus.GOLD));
        if (noneMatch) {
            System.out.println("Абоненты со статусом GOLD в базе отсуствуют!");
        } else {
            System.out.println("Абоненты со статусом GOLD");
            for (Person p : personList) {
                if (p.getAbonentStatus().equals(AbonentStatus.GOLD)) {
                    System.out.println("Имя абонента: " + p.getName() + ". Статус: " + p.getAbonentStatus() + ". Баланс: " + p.getMoneyOnPhone());
                }
            }
        }
        System.out.print("\n");
        System.out.println("----------------Работа с методом findFirst----------------");
        Optional<Person> personOptional = personList.stream()
                .filter(person -> person.getMoneyOnPhone()<10)
                .findFirst();
        boolean personOpt = personOptional.isPresent();
        if (personOpt) {
            Person person = personOptional.get();
            System.out.println(person);
            if (person.getMoneyOnPhone() < 10) {
                System.out.println("-----Уважаемый абонент " + person.getName() + ", ваш баланс менее 10 сом. ------\n" +
                        "-----Пополните баланс, чтобы оставаться на связи или наберите *105# -----");
            }
        } else {
            System.out.println("Результат запроса не выполнен, нет элементов!");
        }
        System.out.print("\n");
        System.out.println("----------------Работа с flatMap, distinct, allMatch------------------");
        List<People> peoples = new ArrayList<>();
        People stalin1 = new People("Айбек", AbonentStatus.ACTIVE, List.of("MI", "Apple"));
        People lenin1 = new People("Жунуш", AbonentStatus.ACTIVE, List.of("ASUS", "Fly"));
        People brezhnev1 = new People("Аскар", AbonentStatus.ACTIVE, List.of("Huawei", "Iphone"));
        People yeltsin1 = new People("Элина", AbonentStatus.ACTIVE, List.of("Lenovo", "Meizu"));
        People zhyldyzbek1 = new People("Жылдызбек", AbonentStatus.ACTIVE, List.of("MI", "Iphone"));
        peoples.add(stalin1);
        peoples.add(lenin1);
        peoples.add(brezhnev1);
        peoples.add(yeltsin1);
        peoples.add(zhyldyzbek1);

        System.out.println("Все марки телефонов заменены на их числовую длинну");
        List<String> ownersTelephones = peoples.stream()
                .flatMap(people -> people.getAbonentTelephones().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(ownersTelephones);

        List<Integer> list = ownersTelephones.stream()
                .map(i -> i.length())
                .collect(Collectors.toList());
        System.out.println(list);

        List<String> ownTels = peoples.stream()
                .flatMap(people -> people.getAbonentTelephones().stream())
                .collect(Collectors.toList());



        boolean allMatch = ownTels.stream()
                .allMatch(tel -> tel.equals("Mi"));
        if (!allMatch){
            System.out.println("----------Не все телефоны в базе MI----------");
        }
        System.out.print("\n");
        System.out.println("----------Работа с max------------");
        System.out.println("***Абонент с высоким балансом***");
        Optional<Person> optionalPerson = personList.stream()
                .max(Comparator.comparing(Person::getMoneyOnPhone));
        Person personGetMoney = optionalPerson.get();
        System.out.println(personGetMoney);
    }
}
