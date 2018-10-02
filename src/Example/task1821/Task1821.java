package Example.task1821;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/*
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

public class Task1821 {
    public static void main(String[] args) throws IOException {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();

        FileInputStream inFile = new FileInputStream(fileName);
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        while (inFile.available() > 0) {
            int oneByte = inFile.read();
            hashMap.merge(oneByte, 1, Integer::sum);
        }
        inFile.close();
        System.out.println("---------");
        hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByKey())
                .map(x -> (char) x.getKey().byteValue() + " " + x.getValue())
                .forEach(System.out::println);
//               .forEach((x -> {
//                   System.out.println((char) x.getKey().byteValue() + " " + x.getValue());
//               }));
        System.out.println("---------");
    }
}
