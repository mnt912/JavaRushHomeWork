package com.javarush.test.level33.lesson10.bonus01;

/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:  toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of < and >]]></second>
    <!--it's a comment-->
    <second/>
</first>
*/
public class Solution {

    public static String toXmlWithComment(String xmlString, String tagName, String comment) {
        try {
            /*StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(obj, writer);*/

            StringBuilder stringBuilder = new StringBuilder(xmlString);
            String commentString = "<!--" + comment + "-->";
            int i = 0;
            while (i != -1) {
                i = stringBuilder.indexOf(tagName, i);
                stringBuilder.insert(--i, commentString);
                i += tagName.length();
            }

            return stringBuilder.toString();
        }
        catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<first>\n" +
                "    <second>some string</second>\n" +
                "    <second>some string</second>\n" +
                "    <second><![CDATA[need CDATA because of < and >]]></second>\n" +
                "    <second/>\n" +
                "</first>";

        System.out.println(toXmlWithComment(xmlString, "second", "it's a comment"));
    }
}
