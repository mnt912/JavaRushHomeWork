package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"

    public static void main(String []args)
    {
        Map<String,String> map = new HashMap<>();

        map.put("height", "185");
        map.put(null, null);
        map.put(null, null);
        map.put(null, null);
        map.put("city3", null);
        map.put("city4", null);
        map.put("city5", null);
        map.put("name", "Ivanich");
        map.put("country", "Rashka");
        map.put("city", "Moscow");


        System.out.println(getCondition(map));
    }
*/
public class Solution
{

    public static StringBuilder getCondition(Map<String, String> params)
    {
        if (params == null) return null;
        if (params.isEmpty()) return new StringBuilder();

        StringBuilder result = new StringBuilder("");
        for (Map.Entry<String,String> entry : params.entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null || value == null)
                continue;
            result.append(key + " = '" + value + "' and ");
        }

        return new StringBuilder(result.substring(0,result.length()-5));
    }

}
