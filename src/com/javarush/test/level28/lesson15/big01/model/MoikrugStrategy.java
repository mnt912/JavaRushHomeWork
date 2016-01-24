package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> list = new ArrayList<>();
        int pageNumber = 1;

        while (true) {
            try {
                Document doc = getDocument(searchString, pageNumber);
                Elements elements = doc.getElementsByClass("job");

                if (elements.isEmpty()) break;

                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();

                    vacancy.setTitle(element.getElementsByClass("title").text());
                    vacancy.setSiteName(doc.title());
                    vacancy.setSalary(element.getElementsByClass("count").text());
                    vacancy.setCity(element.getElementsByClass("location").text());
                    vacancy.setCompanyName(element.getElementsByClass("company_name").select("a[href]").text());
                    vacancy.setUrl(element.getElementsByClass("title").select("a").attr("abs:href"));

                    list.add(vacancy);
                }

                pageNumber++;
            } catch (IOException e) {

            }
        }

        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, page, searchString))
                .userAgent("Mozilla/5.0 (jsoup)").referrer("google.ru").get();
    }
}
