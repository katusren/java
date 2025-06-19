package kr.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MoisCrawler {

    public static void main(String[] args) {

        String url = "https://www.mois.go.kr/frt/bbs/type010/commonSelectBoardList.do?bbsId=BBSMSTR_000000000008";
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .get();

            Elements rows = doc.select(".table_style1.mobile tbody tr");

            if (rows.isEmpty()) {
                System.out.println("페이지를 찾을 수 없습니다");
            } else {
                for (Element row : rows) {
                    Element titleEle = row.selectFirst("td.l a");
                    Element departmentEle = row.selectFirst("td:nth-child(4)");
                    Element dateEle = row.selectFirst("td:nth-child(5)");

                    String title = titleEle.text();
                    String depart = departmentEle.text();
                    String date = dateEle.text();

                    System.out.println("제목: " + title);
                    System.out.println("담당부서: " + depart + " | 게시일: " + date);
                    System.out.println("\n====================================");
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
