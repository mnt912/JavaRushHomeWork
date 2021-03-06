package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by Administator on 07.11.2015.
 */
public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";

    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException {
        Document document = getDocument();

        Element original = document.getElementsByClass("template").first();
        Element template = original.clone();
        template.removeClass("template").addClass("vacancy").removeAttr("style");

        document.getElementsByAttributeValue("class", "vacancy").remove();

        for (Vacancy vacancy : vacancies) {
            Element vac = template.clone();
            vac.getElementsByAttributeValue("class", "city").get(0).text(vacancy.getCity());
            vac.getElementsByAttributeValue("class", "companyName").get(0).text(vacancy.getCompanyName());
            vac.getElementsByAttributeValue("class", "salary").get(0).text(vacancy.getSalary());
            vac.getElementsByAttribute("href").get(0).attr("href", vacancy.getUrl()).text(vacancy.getTitle());
            original.before(vac.outerHtml());
        }
        return document.html();
    }

    private void updateFile(String string) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(filePath));
        printWriter.write(string);
        printWriter.close();
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
