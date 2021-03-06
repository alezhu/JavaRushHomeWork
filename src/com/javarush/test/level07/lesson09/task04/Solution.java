package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лира"); //1
        list.add("лоза"); //2
        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list)
    {
        //add your code here -  добавь код тут
        for (int i = list.size() - 1; i >= 0; i--)
        {
            String str = list.get(i);
            int flag;
            flag = 0;
            for (int j = str.length() - 1; j >= 0 && flag != 3; j--)
            {
                char с = str.charAt(j);
                switch (с)
                {
                    case 'р':
                        flag |= 1;
                        break;
                    case 'л':
                        flag |= 2;
                        break;
                }
            }
            switch (flag)
            {
                case 1:
                    list.remove(i);
                    break;
                case 2:
                    list.add(i + 1, str);
                    break;
            }
        }
        return list;
    }
}